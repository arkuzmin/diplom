package ru.arkuzmin.diplom.optimization.mco;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

/**
 * Целевая функция оптимизации.
 * @author ArKuzmin
 *
 */
public interface ITargetFunction {
	
	/**
	 * Возвращает значение целевой функции при заданных переменных xi.
	 * @param x
	 * @return
	 */
	public double getY(BoilerStation station);
	
	/**
	 * Возвращает значение критериев при заданных переменных xi.
	 * @param x
	 * @return
	 */
	public VectorCriteria getCValues(BoilerStation station);
}
