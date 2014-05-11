package ru.arkuzmin.diplom.optimization.math.regression;

/**
 * Регрессионный полином.
 * @author ArKuzmin
 *
 */
public interface IRegressionFunction {
	
	/**
	 * Возвращает значение регрессионного полинома.
	 * @param x
	 * @return
	 */
	public double getY(double x);
	
	/**
	 * Значение регрессионного полинома по построенной функции.
	 * @param x
	 * @return
	 */
	public double getActualY(double x);
	
	/**
	 * Возвращает число точек в полиноме.
	 * @return
	 */
	public int getPointsNum();
	
	/**
	 * Возвращает значение x для этой точки.
	 * @param point
	 * @return
	 */
	public double getXForPoint(int point);
}
