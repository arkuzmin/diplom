package ru.arkuzmin.diplom.optimization.math.tpm;

import ru.arkuzmin.diplom.optimization.math.tpm.impl.VectorCriteria;

/**
 * Мера расстояния между векторными критериями.
 * @author ArKuzmin
 *
 */
public interface ILengthMeasure {
	
	/**
	 * Возвращает расстояние между векторными критериями.
	 * @param v1 - векторный критерий 1.
	 * @param v2 - векторный критерий 2.
	 * @return расстояние
	 */
	public double getDistance(VectorCriteria v1, VectorCriteria v2) throws IllegalArgumentException;
}
