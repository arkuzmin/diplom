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

public class PrimeDecisionUtilsTest extends TestCase {

	private static final Logger logger = Logger.getLogger(PrimeDecisionUtilsTest.class);
	
	@Test
	public void testPrimeDecisionUtils() {
		Boiler b1 = BoilerWorkMaps.getB1().setState(BoilerStates.ON_MAZ);
		Boiler b2 = BoilerWorkMaps.getB2().setState(BoilerStates.OFF);
		Boiler b3 = BoilerWorkMaps.getB3().setState(BoilerStates.OFF);
		Boiler b4 = BoilerWorkMaps.getB4().setState(BoilerStates.OFF);
		Boiler b5 = BoilerWorkMaps.getB5().setState(BoilerStates.ON_MAZ);
		Boiler b6 = BoilerWorkMaps.getB6().setState(BoilerStates.OFF);
		
		List<Boiler> boilers = new LinkedList<Boiler>();
		boilers.add(b1);
		boilers.add(b2);
		boilers.add(b3);
		boilers.add(b4);
		boilers.add(b5);
		boilers.add(b6);
		
		BoilerStation station = new BoilerStation(boilers);
		DecisionUtils.getPrimeDecision(station, 244);
		
		logger.debug(station);
	
		assertTrue(DecisionUtils.checkConfiguration(station, 244));
		assertFalse(DecisionUtils.checkConfiguration(station, 190));
		assertFalse(DecisionUtils.checkConfiguration(station, 600));
	}
	
}
