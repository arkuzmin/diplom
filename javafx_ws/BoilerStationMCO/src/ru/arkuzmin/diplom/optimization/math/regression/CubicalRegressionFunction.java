package ru.arkuzmin.diplom.optimization.math.regression;

import java.util.HashMap;
import java.util.Map;

/**
 * Полином 3 степени.
 * @author ArKuzmin
 *
 */
public class CubicalRegressionFunction implements IRegressionFunction {

	private static final String PARAMS_EXCEPTION = "X and Y arrays must be the same size!";
	private static final int DEGREE = 3;
	private PolynomialRegression regression;
	
	private Map<Double, Double> XY_map;
	
	private double[] points;
	
	
	/**
	 * Коэффициенты регрессионного полинома 3-ей степени.
	 */
	private double a0_cf;
	private double a1_cf;
	private double a2_cf;
	private double a3_cf;
	
	/**
	 * Строит регрессионный полином 3 степени на основе переданных значений.
	 * @param x
	 * @param y
	 */
	public CubicalRegressionFunction (double[] x, double[] y) {
		if (x == null || y == null || (x.length != y.length)) {
			throw new IllegalArgumentException(PARAMS_EXCEPTION);
		}
		initXYMap(x, y);
		this.points = x;
		computeRegressionCoefficients(x, y);
	}
	
	/**
	 * Вычисление коэффициентов полинома.
	 * @param x
	 * @param y
	 */
	private void computeRegressionCoefficients(double[] x, double[] y) {
		regression = new PolynomialRegression(x, y, DEGREE);
		double[] coeffs = regression.getCoefficients();
		if (coeffs != null && coeffs.length == 4) {
			a0_cf = coeffs[0];
			a1_cf = coeffs[1];
			a2_cf = coeffs[2];
			a3_cf = coeffs[3];
		}
	}
	
	private void initXYMap(double[] x, double[] y) {
		this.XY_map = new HashMap<Double, Double>();
		for (int i = 0; i < x.length; i++) {
			this.XY_map.put(x[i], y[i]);
		}
	}
	
	/**
	 * Возвращает значение полинома 3 степени.
	 */
	@Override
	public double getY(double x) {
		Double result = XY_map.get(x);
		if (result != null) {
			return result;
		}
		
		return x*x*x*a0_cf + x*x*a1_cf + x*a2_cf + a3_cf;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("f(x) = ")
		  .append(a0_cf).append("(x^3)")
		  .append(a1_cf > 0 ? "+" : "")
		  .append(a1_cf).append("(x^2)")
		  .append(a2_cf > 0 ? "+" : "")
		  .append(a2_cf).append("(x)")
		  .append(a3_cf > 0 ? "+" : "")
		  .append(a3_cf);
		
		return sb.toString();
	}

	@Override
	public double getActualY(double x) {
		return x*x*x*a0_cf + x*x*a1_cf + x*a2_cf + a3_cf;
	}

	@Override
	public int getPointsNum() {
		return points.length;
	}

	@Override
	public double getXForPoint(int point) {
		return points[point];
	}
}
