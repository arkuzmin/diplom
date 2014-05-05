package ru.arkuzmin.diplom.optimization.mco;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.pareto.RelativeImportance;
import ru.arkuzmin.diplom.optimization.math.pareto.RelativeImportanceMessage;

public class MultiCriteriaOptimizationTest extends TestCase {

	private static final Logger logger = Logger.getLogger(MultiCriteriaOptimizationTest.class);
	
	@Test
	public void testMCO() {
		RelativeImportance ri = new RelativeImportance(0.7, 0, 1);
		RelativeImportance ri2 = new RelativeImportance(0.7, 0, 2);
		RelativeImportance ri3 = new RelativeImportance(0.7, 0, 3);
		List<RelativeImportance> koeffs = new LinkedList<RelativeImportance>();
		koeffs.add(ri);
		koeffs.add(ri2);
		koeffs.add(ri3);
		
		RelativeImportanceMessage rim = new RelativeImportanceMessage(koeffs);
		
		MultiCriteriaOptimization mco = new MultiCriteriaOptimization(rim, 1, 1.85, 638);
		mco.setPrecision(0.1, 50);
		logger.debug(mco.solve());
	}
}
