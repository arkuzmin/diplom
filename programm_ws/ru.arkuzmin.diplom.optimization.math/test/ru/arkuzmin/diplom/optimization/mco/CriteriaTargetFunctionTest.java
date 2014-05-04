package ru.arkuzmin.diplom.optimization.mco;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.dto.Boiler;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;

public class CriteriaTargetFunctionTest extends TestCase {

	@Test
	public void testCriteria() {
		Boiler b1 = new Boiler(1, "K1", 90, 170).initCurrentState(100, BoilerStates.ON_GAS);
		Boiler b2 = new Boiler(2, "K2", 90, 170).initCurrentState(95, BoilerStates.ON_GAS);
		Boiler b3 = new Boiler(3, "K3", 90, 170).initCurrentState(90, BoilerStates.OFF);
		Boiler b4 = new Boiler(4, "K4", 130, 230);
		Boiler b5 = new Boiler(5, "K5", 130, 230);
		Boiler b6 = new Boiler(6, "K6", 130, 230);
		
		List<Boiler> boilers = new LinkedList<Boiler>();
		boilers.add(b1);
		boilers.add(b2);
		boilers.add(b3);
		boilers.add(b4);
		boilers.add(b5);
		boilers.add(b6);
		
		BoilerStation station = new BoilerStation(boilers);
		
		ICriteriaTargetFunction fun = new GasConsumptionTargetFunction();
		System.out.println("GAS: " + fun.getValue(station));
		
		fun = new MazConsumptionTargetFunction();
		System.out.println("MAZ: " + fun.getValue(station));
		
		fun = new MoneyConsumptionTargetFunction(1235, 3999);
		System.out.println("MON: " + fun.getValue(station));
		
		fun = new KPDTargetFunction();
		System.out.println("KPD: " + fun.getValue(station));
	}
}
