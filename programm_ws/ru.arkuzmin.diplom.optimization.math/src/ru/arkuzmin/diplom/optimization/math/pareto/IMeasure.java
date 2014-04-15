package ru.arkuzmin.diplom.optimization.math.pareto;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

/**
 * Мера сравнения критериев.
 * @author ArKuzmin
 *
 */
public interface IMeasure {

	/**
	 * true - если первый критерий лучше второго.
	 * @param cr1
	 * @param cr2
	 * @return
	 */
	public boolean isBetter(Criteria cr1, Criteria cr2);
	
	
	/**
	 * true - если первый векторный критерий лучше вторго.
	 * @param vc1
	 * @param vc2
	 * @return
	 */
	public boolean isBetter(VectorCriteria vc1, VectorCriteria vc2);
}
