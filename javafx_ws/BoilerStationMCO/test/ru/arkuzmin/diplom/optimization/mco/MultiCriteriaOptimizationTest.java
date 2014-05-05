package ru.arkuzmin.diplom.optimization.mco;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

public class MultiCriteriaOptimizationTest extends TestCase {

	private static final Logger logger = Logger.getLogger(MultiCriteriaOptimizationTest.class);
	
	@Test
	public void testMCO() {
		MultiCriteriaOptimization mco = new MultiCriteriaOptimization(null, 3500, 6500, 638);
		mco.setPrecision(0.1, 50);
		logger.debug(mco.solve());
	}
}
