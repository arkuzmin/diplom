package ru.arkuzmin.diplom.optimization.math.pareto;

import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;
import ru.arkuzmin.diplom.optimization.math.tpm.TargetProgrammingMethod;

public class ParetoSetTest extends TestCase {
	
	@Test
	public void testParetoSet() {
		Criteria cr1 = new Criteria("1", CriteriaTarget.MIN).setValue(4);
		Criteria cr2 = new Criteria("2", CriteriaTarget.MIN).setValue(0);
		Criteria cr3 = new Criteria("3", CriteriaTarget.MIN).setValue(3);
		Criteria cr4 = new Criteria("4", CriteriaTarget.MAX).setValue(2);
		
		List<Criteria> list1 = new LinkedList<Criteria>();
		list1.add(cr1);
		list1.add(cr2);
		list1.add(cr3);
		list1.add(cr4);
		VectorCriteria vc1 = new VectorCriteria(list1);
		
		cr1 = new Criteria("1", CriteriaTarget.MIN).setValue(5);
		cr2 = new Criteria("2", CriteriaTarget.MIN).setValue(0);
		cr3 = new Criteria("3", CriteriaTarget.MIN).setValue(2);
		cr4 = new Criteria("4", CriteriaTarget.MAX).setValue(2);
		
		List<Criteria> list2 = new LinkedList<Criteria>();
		list2.add(cr1);
		list2.add(cr2);
		list2.add(cr3);
		list2.add(cr4);
		VectorCriteria vc2 = new VectorCriteria(list2);
		
		cr1 = new Criteria("1", CriteriaTarget.MIN).setValue(2);
		cr2 = new Criteria("2", CriteriaTarget.MIN).setValue(1);
		cr3 = new Criteria("3", CriteriaTarget.MIN).setValue(1);
		cr4 = new Criteria("4", CriteriaTarget.MAX).setValue(3);
		
		List<Criteria> list3 = new LinkedList<Criteria>();
		list3.add(cr1);
		list3.add(cr2);
		list3.add(cr3);
		list3.add(cr4);
		VectorCriteria vc3 = new VectorCriteria(list3);
		
		cr1 = new Criteria("1", CriteriaTarget.MIN).setValue(5);
		cr2 = new Criteria("2", CriteriaTarget.MIN).setValue(0);
		cr3 = new Criteria("3", CriteriaTarget.MIN).setValue(1);
		cr4 = new Criteria("4", CriteriaTarget.MAX).setValue(2);
		
		List<Criteria> list4 = new LinkedList<Criteria>();
		list4.add(cr1);
		list4.add(cr2);
		list4.add(cr3);
		list4.add(cr4);
		VectorCriteria vc4 = new VectorCriteria(list4);
		
		cr1 = new Criteria("1", CriteriaTarget.MIN).setValue(3);
		cr2 = new Criteria("2", CriteriaTarget.MIN).setValue(1);
		cr3 = new Criteria("3", CriteriaTarget.MIN).setValue(2);
		cr4 = new Criteria("4", CriteriaTarget.MAX).setValue(3);
		
		List<Criteria> list5 = new LinkedList<Criteria>();
		list5.add(cr1);
		list5.add(cr2);
		list5.add(cr3);
		list5.add(cr4);
		VectorCriteria vc5 = new VectorCriteria(list5);
		
		List<VectorCriteria> vlist = new LinkedList<VectorCriteria>();
		vlist.add(vc1);
		vlist.add(vc2);
		vlist.add(vc3);
		vlist.add(vc4);
		vlist.add(vc5);
		
		ParetoSet ps = new ParetoSet(vlist);
		List<VectorCriteria> res = ps.calculateParetoSet();
		
		assertEquals(3, res.size());
		
		for (VectorCriteria v : res) {
			System.out.println(v);
		}
		
		cr1 = (new Criteria("Расход газа", CriteriaTarget.MIN)).setValue(0);
		cr2 = (new Criteria("Расход мазута", CriteriaTarget.MIN)).setValue(0);
		cr3 = (new Criteria("Финансовые затраты", CriteriaTarget.MIN)).setValue(0);
		cr4 = (new Criteria("КПД", CriteriaTarget.MAX)).setValue(0);
		
		List<Criteria> list6 = new LinkedList<Criteria>();
		list6.add(cr1);
		list6.add(cr2);
		list6.add(cr3);
		list6.add(cr4);
		
		VectorCriteria vc6 = new VectorCriteria(list6);
		
		TargetProgrammingMethod tpm = new TargetProgrammingMethod(res, vc6);
		System.out.println("----------------------");
		System.out.println(tpm.getOptVector());
	}

}
