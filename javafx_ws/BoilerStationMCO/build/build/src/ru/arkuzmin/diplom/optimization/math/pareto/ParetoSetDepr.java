package ru.arkuzmin.diplom.optimization.math.pareto;

import java.util.LinkedList;
import java.util.List;

import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

/**
 * Множество парето-оптимальных векторов.
 * @author ArKuzmin
 *
 */
@Deprecated
public class ParetoSetDepr {
	private List<VectorCriteria> set;
	private List<VectorCriteria> paretoSet = new LinkedList<VectorCriteria>();
	
	private int i, j;
	private IMeasure pm = new ParetoMeasure();
	
	public ParetoSetDepr(List<VectorCriteria> set) {
		if (set == null || set.size() < 2) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		this.set = set;
		for (VectorCriteria vc : set) {
			paretoSet.add(vc);
		}
	}
	
	public List<VectorCriteria> calculateParetoSet() {
		step1();
		return paretoSet;
	}
	
	private void step1() {
		i = 0;
		j = 1;
		step2();
	}
	
	private void step2() {
		if (pm.isBetter(set.get(i), set.get(j))) {
			step3();
		} else {
			step5();
		}
	}
	
	private void step3() {
		paretoSet.remove(set.get(j));
		step4();
	}
	
	private void step4() {
		if (j < set.size()-1) {
			j++;
			step2();
		} else {
			step7();
		}
	}
	
	private void step5() {
		if (pm.isBetter(set.get(j), set.get(i))) {
			step6();
		} else {
			step4();
		}
	}
	
	private void step6() {
		paretoSet.remove(set.get(i));
		step7();
	}
	
	private void step7() {
		if (i < set.size() - 2) {
			i++;
			j = i+1;
			step2();
		}
	}
}
