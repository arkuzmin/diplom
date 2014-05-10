package ru.arkuzmin.diplom.optimization.mco;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.Decision;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;
import ru.arkuzmin.diplom.optimization.math.pareto.ParetoSet;
import ru.arkuzmin.diplom.optimization.math.pareto.RelativeImportanceMessage;
import ru.arkuzmin.diplom.optimization.math.tpm.TargetProgrammingMethod;
import ru.arkuzmin.diplom.optimization.utils.UIManager;

/**
 * Задача многокритериальной оптимизации.
 * @author ArKuzmin
 *
 */
public class MultiCriteriaOptimization {
	
	private UIManager uiManager = new UIManager(false);
	
	private RelativeImportanceMessage rim;
	private double maz_cost;
	private double gas_cost;
	private double DK;
	private double cost_mult = -1;
	
	private double eps = 0.1;
	private int P = 50;
	
	public MultiCriteriaOptimization(RelativeImportanceMessage rim, double gas_cost, double maz_cost, double DK) {
		this.rim = rim;
		this.gas_cost = gas_cost;
		this.maz_cost = maz_cost;
		this.DK = DK;
	}
	
	public void setCostMult(double cost_mult) {
		this.cost_mult = cost_mult;
	}
	
	public void initUIManager(UIManager uiManager) {
		this.uiManager = uiManager;
	}
	
	public void setPrecision(double eps, int P) {
		this.eps = eps;
		this.P = P;
	}
	
	private void logToUI(String msg) {
		if (uiManager != null) {
			uiManager.logToUI(msg);
		}
	}
	
	private void allDone() {
		if (uiManager != null) {
			uiManager.allDone();
		}
	}
	
	/**
	 * Возвращает решение многокритериальной задачи.
	 * @return
	 */
	public Decision solve() {
		logToUI("Начало оптимизации...");
		logToUI("Поиск множества решений...");
		// Находим множество решений
		List<Decision> dSet = findDecisionSet();
		logToUI("Вычисление множества Парето...");
		// Вычисляем множество Парето
		dSet = calculateParetoSet(dSet);
		logToUI("Сужение множества Парето...");
		// Выполняем сужение множества Парето
		dSet = narrowParetoSet(dSet);
		// Находим решение методом целевого программирования
		logToUI("Метод целевого программирования...");
		allDone();
		Decision d = getTPMDecision(dSet);
		if (cost_mult > 0) {
			Criteria cc = d.getVector().getCr(2);
			cc.setValue(cc.getValue() * cost_mult);
		}
		return d;
	}
	
	private void correctIdealVector(VectorCriteria ideal, VectorCriteria current) {
		List<Criteria> iV = ideal.getVector();
		List<Criteria> cV = current.getVector();
		for (int i = 0; i < cV.size(); i++) {
			Criteria cC = cV.get(i);
			Criteria iC = iV.get(i);
			if (cC.getValue() > iC.getValue()) {
				iC.setValue(cC.getValue());
			}
		}
	}
	
	private Decision getTPMDecision(List<Decision> pSet) {
		Map<VectorCriteria, Decision> map = new LinkedHashMap<VectorCriteria, Decision>();
		List<VectorCriteria> list = new LinkedList<VectorCriteria>();
		VectorCriteria ideal = null;
		
		for (Decision d : pSet) {
			VectorCriteria currVector = d.getCurrVector();
			if (ideal == null) {
				ideal = new VectorCriteria(currVector);
			}
			correctIdealVector(ideal, currVector);
			map.put(currVector, d);
			list.add(currVector);
		}
		
		TargetProgrammingMethod tpm = new TargetProgrammingMethod(list, ideal);
		VectorCriteria result = tpm.getOptVector();
		
		return map.get(result);
	}
	
	private List<Decision> narrowParetoSet(List<Decision> pSet) {
		if (rim == null) {
			return pSet;
		}
		// Пересчитываем векторные критерии в соответствии с коэф. отн. важности
		for (Decision d : pSet) {
			VectorCriteria currVc = d.getCurrVector();
			currVc = rim.getNewVCriteria(currVc);
		}
		// Вычисляем новое множество Парето
		return calculateParetoSet(pSet);
	}
	
	private List<Decision> calculateParetoSet(List<Decision> dSet) {
		Map<VectorCriteria, Decision> map = new LinkedHashMap<VectorCriteria, Decision>();
		List<VectorCriteria> list = new LinkedList<VectorCriteria>();
		List<Decision> result = new LinkedList<Decision>();
		
		for (Decision d : dSet) {
			map.put(d.getCurrVector(), d);
			list.add(d.getCurrVector());
		}
		
		ParetoSet ps = new ParetoSet(list);
		list = ps.calculateParetoSet();
		
		for (VectorCriteria vc : list) {
			result.add(map.get(vc));
		}
		
		return result;
		
	}
	
	private List<Decision> findDecisionSet() {
		DirectSamplingProcedures dsp = new DirectSamplingProcedures(DK, gas_cost, maz_cost, eps, P);
		dsp.initUIManager(uiManager);
		return dsp.getDecision();
	}
}
