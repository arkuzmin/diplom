package ru.arkuzmin.diplom.optimization.math.dto;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BoilerTest extends TestCase {
	
	private static final Logger logger = Logger.getLogger(BoilerTest.class);
	
	@Test
	public void testBoiler() {
	/*	BoilerStation bs = BoilerWorkMaps.getBoilerStation();
		bs.getBoilers().get(5).initCurrentState(219, BoilerStates.OFF);
		bs.getBoilers().get(4).initCurrentState(219, BoilerStates.OFF);
		bs.getBoilers().get(3).initCurrentState(183, BoilerStates.ON_GAS);
		bs.getBoilers().get(2).initCurrentState(0, BoilerStates.OFF);
		bs.getBoilers().get(1).initCurrentState(0, BoilerStates.OFF);
		bs.getBoilers().get(0).initCurrentState(0, BoilerStates.OFF);
		
		double gas = 0.0;
		for (int i = 0; i < 6; i++) {
			if (!BoilerStates.OFF.equals(bs.getBoilers().get(i).getState())) {
				gas += bs.getBoilers().get(i).getB();
			}
		}
		
		logger.debug(bs);
		logger.debug(gas);
		
	}*/
		
		Boiler b4 = BoilerWorkMaps.getB4();
		
		double[] values = new double[] {130, 141, 183, 198, 200};
		b4.setState(BoilerStates.ON_GAS);
		for (double d : values) {
			b4.setDK(d);
			logger.debug("" + d + " : " + b4.getB());
		}
	}
}
