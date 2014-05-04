package ru.arkuzmin.diplom.optimization.mco;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ru.arkuzmin.diplom.optimization.WorkModeGenerator;
import ru.arkuzmin.diplom.optimization.common.Globals;
import ru.arkuzmin.diplom.optimization.math.dto.Boiler;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerWorkMaps;
import ru.arkuzmin.diplom.optimization.math.dto.Decision;
import ru.arkuzmin.diplom.optimization.math.dto.WorkMode;

/**
 * Метод прямых выборочных процедур с уменьшением интервала поиска.
 * @author ArKuzmin
 *
 */
public class DirectSamplingProcedures {
	
	private static final double E = 0.05; 
	private int P;
	private double eps;
	private ITargetFunction tf;
	
	private double z;
	private int p;
	private int q;
	private int Q;
	private double DK;
	BoilerStation station;
	
	BoilerStation stq;
	BoilerStation sta;
	
	
	public DirectSamplingProcedures(double DK, double gas_cost, double maz_cost, double eps, int P) {
		this.eps = eps;
		this.P = P;
		this.DK = DK;
		this.station = BoilerWorkMaps.getBoilerStation();
		this.tf = new BoilerTargetFunction(gas_cost, maz_cost);
		initQ();
	}
	
	private void initQ() {
		double z = 0.0;
		for (Boiler b : station.getBoilers()) {
			double zi = b.getMAX_DK() - b.getMIN_DK();
			if (zi > z) {
				z = zi;
			}
		}
		
		Q = (int) (Math.log(eps / z) / Math.log(1 - E));
	}
	
	private void resetParams() {
		p = 1;
		q = 1;
		z = 1;
		sta = null;
		stq = null;
	}
	
	/**
	 * Возвращает список решений многокритериальной задачи.
	 * @return
	 */
	public List<Decision> getDecision() {
		WorkModeGenerator wmg = new WorkModeGenerator(Globals.BOILERS_NUM);
		List<WorkMode> modes = wmg.getAllWorkModes();
		List<Decision> result = new LinkedList<Decision>();
		
		for (WorkMode mode : modes) {
			BoilerStation station = getBStationWithMode(mode);
			resetParams();
			step1(station);
			
			if (stq != null) {
				Decision d = new Decision(stq, tf.getCValues(stq), tf.getY(stq));
				result.add(d);
			}
		}
		
		return result;
		
	}
	
	private void step1(BoilerStation st0) {
		if (DecisionUtils.checkConfiguration(st0, DK)) {
			DecisionUtils.getPrimeDecision(st0, DK);
			sta = new BoilerStation(st0);
			stq = new BoilerStation(st0);
			step2();
		} else {
			return;
		}
	}
	
	/**
	 * Рандомный шаг.
	 * @param station
	 */
	private void step2() {
		BoilerStation st = new BoilerStation(stq);
		List<Boiler> stboilers = st.getWorkingBoilers();
		List<Boiler> boilers = stq.getWorkingBoilers();
		
		double sum = 0.0;
		// 1..n-1
		for (int i = 0; i < boilers.size() - 1; i++) {
			Boiler bq = boilers.get(i);
			Boiler bst = stboilers.get(i);
				
			double r = (new Random()).nextDouble() - 0.5;
			double dk = bq.getDK() + r * z * (bq.getMAX_DK() - bq.getMIN_DK());
			bst.setDK(dk < bq.getMIN_DK() ? bq.getMIN_DK() : 
					 (dk > bq.getMAX_DK() ? bq.getMAX_DK() : dk));
				
			sum += bst.getDK();
		}
		// n
		Boiler bstn = stboilers.get(stboilers.size() - 1);
		
		double dk = DK - sum;
		bstn.setDK(dk);
		step3(st);
	}
	
	private void step3(BoilerStation st) {
		Boiler bstn = st.getWorkingBoilers().get(st.getWorkingBoilers().size() - 1);
		if (bstn.getDK() > bstn.getMIN_DK() && bstn.getDK() < bstn.getMAX_DK()) {
			step4(st);
		// Отбрасываем данную конфигурацию
		} else {
			if (p < P) {
				p++;
				step2();
			} else {
				step5();
			}
		}
	}
	
	private void step4(BoilerStation st) {
		double stVal = tf.getY(st);
		double stqVal = tf.getY(sta);
		
		if (stVal < stqVal) {
			sta = new BoilerStation(st);
		}
		
		if (p < P) {
			p++;
			step2();
		} else {
			step5();
		}
	}
	
	private void step5() {
		if (q < Q) {
			stq = new BoilerStation(sta);
			z = z * (1 - eps);
			q++;
			step2();
		}
	}
	
	private BoilerStation getBStationWithMode(WorkMode mode) {
		BoilerStation bs = BoilerWorkMaps.getBoilerStation();
		List<Boiler> boilers = bs.getBoilers();
		
		for (int i = 0; i < boilers.size(); i++) {
			Boiler b = boilers.get(i);
			b.setState(mode.getStateFor(i));
		}
		
		return bs;
	}
	
}
