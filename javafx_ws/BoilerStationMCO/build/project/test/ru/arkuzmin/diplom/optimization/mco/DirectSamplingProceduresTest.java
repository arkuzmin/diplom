package ru.arkuzmin.diplom.optimization.mco;

import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.Decision;

public class DirectSamplingProceduresTest extends TestCase {

	private static final Logger logger = Logger.getLogger(DirectSamplingProceduresTest.class);
	
	@Test
	public void testMCO() {
		double DK = 690;
		DirectSamplingProcedures dsp = new DirectSamplingProcedures(DK, 1500, 7894, 0.1, 50);
		List<Decision> result = dsp.getDecision();
		
		assertTrue(result.size() <= 729);
		for (Decision d : result) {
			logger.debug(d);
			BoilerStation st = d.getStation();
			assertEquals(DK, st.getDK());
		}
	}
}
