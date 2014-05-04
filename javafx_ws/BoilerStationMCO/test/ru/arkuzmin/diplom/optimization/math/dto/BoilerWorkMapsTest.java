package ru.arkuzmin.diplom.optimization.math.dto;

import junit.framework.TestCase;

import org.junit.Test;

public class BoilerWorkMapsTest extends TestCase {

	@Test
	public void testWorkMaps() {
		Boiler b1 = BoilerWorkMaps.getB1();
		System.out.println(b1);
	}
}
