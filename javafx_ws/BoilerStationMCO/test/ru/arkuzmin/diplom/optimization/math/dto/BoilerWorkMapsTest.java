package ru.arkuzmin.diplom.optimization.math.dto;

import junit.framework.TestCase;

import org.junit.Test;

public class BoilerWorkMapsTest extends TestCase {

	@Test
	public void testWorkMaps() {
		Boiler b1 = BoilerWorkMaps.getB1();
		Boiler b2 = BoilerWorkMaps.getB2();
		Boiler b3 = BoilerWorkMaps.getB3();
		Boiler b4 = BoilerWorkMaps.getB4();
		Boiler b5 = BoilerWorkMaps.getB5();
		Boiler b6 = BoilerWorkMaps.getB6();
		
		System.out.println(b1);
		System.out.println("-----------");
		System.out.println(b2);
		System.out.println("-----------");
		System.out.println(b3);
		System.out.println("-----------");
		System.out.println(b4);
		System.out.println("-----------");
		System.out.println(b5);
		System.out.println("-----------");
		System.out.println(b6);
	}
}
