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
	private IMeasure pm = new ParetoMeasure();
	
	public ParetoSet(List<VectorCriteria> set) {
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

		while (true) {
			if (pm.isBetter(set.get(i), set.get(j))) {
				paretoSet.remove(set.get(j));
				if (j < set.size()-1) {
					j++;
					continue;
				} else {
					if (i < set.size() - 2) {
						i++;
						j = i+1;
						continue;
					}
					break;
				}
			} else {
				if (pm.isBetter(set.get(j), set.get(i))) {
					paretoSet.remove(set.get(i));
					if (i < set.size() - 2) {
						i++;
						j = i+1;
						continue;
					}
					break;
				} else {
					if (j < set.size()-1) {
						j++;
						continue;
					} else {
						if (i < set.size() - 2) {
							i++;
							j = i+1;
							continue;
						}
						break;
					}
				}
			}
		}
	}
}
