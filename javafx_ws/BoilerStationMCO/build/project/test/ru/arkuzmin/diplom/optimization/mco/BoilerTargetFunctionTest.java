package ru.arkuzmin.diplom.optimization.mco;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.dto.Boiler;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerWorkMaps;

public class BoilerTargetFunctionTest extends TestCase {
	
	private static final Logger logger = Logger.getLogger(BoilerTargetFunction.class);
	
	@Test
	public void testBoilerTargetFunction() {
		BoilerTargetFunction btf = new BoilerTargetFunction(4500, 12999);
		
		Boiler b1 = BoilerWorkMaps.getB1().initCurrentState(100, BoilerStates.ON_GAS);
		Boiler b2 = BoilerWorkMaps.getB2().initCurrentState(95, BoilerStates.ON_GAS);
		Boiler b3 = BoilerWorkMaps.getB3().initCurrentState(90, BoilerStates.ON_GAS);
		Boiler b4 = BoilerWorkMaps.getB4().initCurrentState(230, BoilerStates.ON_GAS);
		Boiler b5 = BoilerWorkMaps.getB5().initCurrentState(225, BoilerStates.ON_GAS);
		Boiler b6 = BoilerWorkMaps.getB6().initCurrentState(230, BoilerStates.ON_GAS);
		
		List<Boiler> boilers = new LinkedList<Boiler>();
		boilers.add(b1);
		boilers.add(b2);
		boilers.add(b3);
		boilers.add(b4);
		boilers.add(b5);
		boilers.add(b6);
		
		BoilerStation station = new BoilerStation(boilers);
		
		logger.debug(btf.getY(station));
		logger.debug(btf.getCValues(station));
	}
}
