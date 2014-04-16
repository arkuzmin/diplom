package ru.arkuzmin.diplom.optimization.math.tmp;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;
import ru.arkuzmin.diplom.optimization.math.tpm.ILengthMeasure;
import ru.arkuzmin.diplom.optimization.math.tpm.QuadraticLengthMeasure;

public class QuadraticLengthMeasureTest extends TestCase {
	
	@Test
	public void testLengthMeasure() {
		ILengthMeasure lm = new QuadraticLengthMeasure();
		
		Criteria cr1 = (new Criteria("Расход газа", CriteriaTarget.MIN)).setValue(1);
		Criteria cr2 = (new Criteria("Расход мазута", CriteriaTarget.MIN)).setValue(2);
		Criteria cr3 = (new Criteria("Финансовые затраты", CriteriaTarget.MIN)).setValue(3);
		Criteria cr4 = (new Criteria("КПД", CriteriaTarget.MAX)).setValue(4);
		
		List<Criteria> list1 = new LinkedList<Criteria>();
		list1.add(cr1);
		list1.add(cr2);
		list1.add(cr3);
		list1.add(cr4);
		
		VectorCriteria vc1 = new VectorCriteria(list1);
		
		cr1 = (new Criteria("Расход газа", CriteriaTarget.MIN)).setValue(1);
		cr2 = (new Criteria("Расход мазута", CriteriaTarget.MIN)).setValue(2);
		cr3 = (new Criteria("Финансовые затраты", CriteriaTarget.MIN)).setValue(3);
		cr4 = (new Criteria("КПД", CriteriaTarget.MAX)).setValue(4);
		
		List<Criteria> list2 = new LinkedList<Criteria>();
		list2.add(cr1);
		list2.add(cr2);
		list2.add(cr3);
		list2.add(cr4);
		
		VectorCriteria vc2 = new VectorCriteria(list2);
		
		assertEquals(0.0, lm.getDistance(vc1, vc2));
		
		vc2.setValues(new double[]{0, 0, 0, 0});
		
		assertEquals(30.0, lm.getDistance(vc1, vc2));
	}
}
