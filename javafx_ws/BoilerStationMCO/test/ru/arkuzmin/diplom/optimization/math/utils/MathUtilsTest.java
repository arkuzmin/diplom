package ru.arkuzmin.diplom.optimization.math.utils;

import junit.framework.TestCase;

import org.junit.Test;

public class MathUtilsTest extends TestCase {

	@Test
	public void testOtherSystem() {
		assertEquals("222222", MathUtils.toOtherSystem(728, 3));
		assertEquals("10201", MathUtils.toOtherSystem(100,3));
		assertEquals("1", MathUtils.toOtherSystem(1,3));
		assertEquals("10", MathUtils.toOtherSystem(3,3));
		assertEquals("0", MathUtils.toOtherSystem(0,3));
	}
	
	@Test
	public void testToInt() {
		assertEquals(1, MathUtils.toInt(1.2));
		assertEquals(2, MathUtils.toInt(1.5));
		assertEquals(0, MathUtils.toInt(0.0));
		assertEquals(68, MathUtils.toInt(67.9));
	}
}
