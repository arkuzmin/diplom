package ru.arkuzmin.diplom.optimization.math.regression;

import junit.framework.TestCase;

import org.junit.Test;

public class CubicalRegressionFunctionTest extends TestCase {

	@Test
	public void testRegression() {
		IRegressionFunction rf = new CubicalRegressionFunction(new double[]{110, 130, 150, 170, 190, 210}, new double[]{172, 174, 176, 178, 180, 183});
		assertEquals(172.0, rf.getY(110));
		assertEquals(178.0, rf.getY(170));
	}
}
