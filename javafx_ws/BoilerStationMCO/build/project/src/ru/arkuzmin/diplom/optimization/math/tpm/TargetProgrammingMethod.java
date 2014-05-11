package ru.arkuzmin.diplom.optimization.math.tpm;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

/**
 * Выбор оптимального решения методом целевого программирования
 * @author ArKuzmin
 *
 */
public class TargetProgrammingMethod {
	
	private final List<VectorCriteria> vectors;
	private final VectorCriteria ideal;
	
	public TargetProgrammingMethod(final List<VectorCriteria> vectors, final VectorCriteria ideal) {
		if (vectors == null || ideal == null || vectors.size() == 0) {
			throw new IllegalArgumentException("Incorrect parameters!");
		}
		this.vectors = vectors;
		this.ideal = ideal;
		
		init();
	}
	
	private void init() {
		for (VectorCriteria vc : vectors) {
			List<Criteria> critList =  vc.getVector();
			for (Criteria cr : critList) {
				if (CriteriaTarget.MIN.equals(cr.getTarget())) {
					cr.changeTarget();
				}
			}
		}
	}
	
	/**
	 * Возвращает оптимальный векторый критерий.
	 * @return
	 */
	public VectorCriteria getOptVector() {
		Map<Double, VectorCriteria> map = new LinkedHashMap<Double, VectorCriteria>();
		ILengthMeasure lm = new QuadraticLengthMeasure();
		
		for (VectorCriteria vc : vectors) {
			map.put(lm.getDistance(vc, ideal), vc);
		}
		
		SortedSet<Double> ss = new TreeSet<Double>(map.keySet());
	
		return map.get(ss.first());
	}
}
