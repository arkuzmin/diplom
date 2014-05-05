package ru.arkuzmin.diplom.optimization.math.pareto;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;

public class RelativeImportanceMessageTest extends TestCase {

	@Test
	public void testImportanceMessage() {
		Criteria cr1 = new Criteria("1", CriteriaTarget.MAX).setValue(0);
		Criteria cr2 = new Criteria("2", CriteriaTarget.MAX).setValue(-100);
		Criteria cr3 = new Criteria("3", CriteriaTarget.MAX).setValue(-300);
		Criteria cr4 = new Criteria("4", CriteriaTarget.MAX).setValue(92.3);
		
		List<Criteria> list1 = new LinkedList<Criteria>();
		list1.add(cr1);
		list1.add(cr2);
		list1.add(cr3);
		list1.add(cr4);
		VectorCriteria vc1 = new VectorCriteria(list1);
		
		RelativeImportance ri = new RelativeImportance(0.8, 0, 1);
		RelativeImportance ri2 = new RelativeImportance(0.8, 0, 2);
		
		List<RelativeImportance> riList = new LinkedList<RelativeImportance>();
		riList.add(ri);
		riList.add(ri2);
		//riList.add(ri3);
		
		RelativeImportanceMessage rim = new RelativeImportanceMessage(riList);
		System.out.println(rim);
		System.out.println("-----------");
		System.out.println(rim.getNewVCriteria(vc1));
	}
}
