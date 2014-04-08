package ru.arkuzmin.diplom.optimization;

import ru.arkuzmin.diplom.optimization.math.regression.CubicalRegressionFunction;

public class Test {
	public static void main(String[] args) {
		CubicalRegressionFunction cf = new CubicalRegressionFunction(new double[]{ 90, 110, 130, 150, 170}, new double[]{ 6.08, 6.05, 6.1, 6.1, 6.15 });
		System.out.println(cf.getY(170));
	}
}
