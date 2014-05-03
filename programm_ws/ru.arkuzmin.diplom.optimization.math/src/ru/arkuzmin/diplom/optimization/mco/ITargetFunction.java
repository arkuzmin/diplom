package ru.arkuzmin.diplom.optimization.mco;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;

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
	public double getY(double... x);
	
	/**
	 * Возвращает значение критериев при заданных переменных xi.
	 * @param x
	 * @return
	 */
	public Criteria[] getCValues(double... x);
}
