package ru.arkuzmin.diplom.optimization.mco;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
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
	
	private double eps = 0.1;
	private int P = 50;
	
	public MultiCriteriaOptimization(RelativeImportanceMessage rim, double gas_cost, double maz_cost, double DK) {
		this.rim = rim;
		this.gas_cost = gas_cost;
		this.maz_cost = maz_cost;
		this.DK = DK;
	}
	
	public void initProgress(ProgressIndicator progress) {
		this.uiManager.initProgress(progress);
	}
	
	public void initLogArea(TextArea logArea) {
		this.uiManager.initLogArea(logArea);
	}
	
	public void setPrecision(double eps, int P) {
		this.eps = eps;
		this.P = P;
	}
	
	/**
	 * Возвращает решение многокритериальной задачи.
	 * @return
	 */
	public Decision solve() {
		uiManager.logToUI("Начало оптимизации...");
		uiManager.logToUI("Поиск множества решений...");
		// Находим множество решений
		List<Decision> dSet = findDecisionSet();
		uiManager.logToUI("Вычисление множества Парето...");
		// Вычисляем множество Парето
		dSet = calculateParetoSet(dSet);
		uiManager.logToUI("Сужение множества Парето...");
		// Выполняем сужение множества Парето
		dSet = narrowParetoSet(dSet);
		// Находим решение методом целевого программирования
		uiManager.logToUI("Метод целевого программирования...");
		uiManager.allDone();
		return getTPMDecision(dSet);
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
