package ru.arkuzmin.diplom.optimization.math.pareto;

import java.util.LinkedList;
import java.util.List;

import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

/**
 * Множество парето-оптимальных векторов.
 * @author ArKuzmin
 *
 */
public class ParetoSet {
	private List<VectorCriteria> set;
	private List<VectorCriteria> paretoSet = new LinkedList<VectorCriteria>();
	
	private int i, j;
	private ParetoMeasure pm = new ParetoMeasure();
	
	public ParetoSet(List<VectorCriteria> set) {
		if (set == null || set.size() < 2) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		this.set = set;
	}
	
	public List<VectorCriteria> calculateParetoSet() {
		return paretoSet;
	}
	
	private void step1() {
		for (VectorCriteria vc : set) {
			paretoSet.add(vc);
		}
		i = 1;
		j = 2;
		step2();
	}
	
	private void step2() {
		
	}
	
}
