package ru.arkuzmin.diplom.optimization.math.dto;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

import ru.arkuzmin.diplom.optimization.mco.GasConsumptionTargetFunction;
import ru.arkuzmin.diplom.optimization.mco.KPDTargetFunction;
import ru.arkuzmin.diplom.optimization.mco.MoneyConsumptionTargetFunction;

public class BoilerTest extends TestCase {
	
	private static final Logger logger = Logger.getLogger(BoilerTest.class);
	
	@Test
	public void testBoiler() {
		BoilerStation bs = BoilerWorkMaps.getBoilerStation();
		bs.getBoilers().get(5).initCurrentState(219, BoilerStates.ON_GAS);
		bs.getBoilers().get(4).initCurrentState(219, BoilerStates.ON_GAS);
		bs.getBoilers().get(3).initCurrentState(200, BoilerStates.ON_GAS);
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
		GasConsumptionTargetFunction gc = new GasConsumptionTargetFunction();
		logger.debug(gc.getValue(bs));
		KPDTargetFunction kc = new KPDTargetFunction();
		logger.debug(kc.getValue(bs));
		MoneyConsumptionTargetFunction mc = new MoneyConsumptionTargetFunction(3482, 6500);
		logger.debug(mc.getValue(bs));
		
		/*
		Boiler b = BoilerWorkMaps.getB6();
		
		double[] values = new double[] {130, 140, 189, 219};
		b.setState(BoilerStates.ON_GAS);
		for (double d : values) {
			b.setDK(d);
			logger.debug("" + d + " : " + b.getB());
		}*/
	}
}
