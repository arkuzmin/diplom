package ru.arkuzmin.diplom.optimization.math.regression;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;

/**
 * Регрессионный полином для разных режимов работы котла.
 * @author ArKuzmin
 *
 */
public interface IBoilerRegressionFunction {
	
	/**
	 * Возвращает значение регрессионного полинома.
	 * @param x
	 * @return
	 */
	public double getY(double x, BoilerStates state);
}
