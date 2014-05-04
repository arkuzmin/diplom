package ru.arkuzmin.diplom.optimization.mco;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.Decision;

public class DirectSamplingProceduresTest extends TestCase {

	//private static final Logger logger = Logger.getLogger(DirectSamplingProceduresTest.class);
	
	@Test
	public void testMCO() {
		DirectSamplingProcedures dsp = new DirectSamplingProcedures(690, 1500, 7894, 0.1, 50);
		List<Decision> result = dsp.getDecision();
		
		assertTrue(result.size() <= 729);
		for (Decision d : result) {
			BoilerStation st = d.getStation();
			assertEquals(690.0, st.getDK());
		}
	}
}
