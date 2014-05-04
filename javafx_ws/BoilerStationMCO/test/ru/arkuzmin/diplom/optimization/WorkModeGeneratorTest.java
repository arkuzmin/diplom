package ru.arkuzmin.diplom.optimization;

import junit.framework.TestCase;

import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.dto.WorkMode;

public class WorkModeGeneratorTest extends TestCase {
	
	@Test
	public void testWMG() {
		WorkModeGenerator wmg = new WorkModeGenerator(6);
		assertEquals(729, wmg.getAllWorkModes().size());
		
		for (WorkMode wm : wmg.getAllWorkModes()) {
			System.out.println(wm);
		}
	}
}
