package ru.arkuzmin.diplom.optimization.math.pareto;

import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

public class ParetoMeasure implements IMeasure {

	@Override
	public boolean isBetter(Criteria cr1, Criteria cr2) {
		if (CriteriaTarget.MIN.equals(cr1.getTarget())) {
			cr1.changeTarget();
		}
		if (CriteriaTarget.MIN.equals(cr2.getTarget())) {
			cr2.changeTarget();
		}
		return cr1.getValue() >= cr2.getValue();
	}

	@Override
	public boolean isBetter(VectorCriteria vc1, VectorCriteria vc2) {
		boolean res = true;
		for (int i = 0; i < vc1.getLenght(); i++) {
			if (!isBetter(vc1.getCr(i), vc2.getCr(i))) {
				res = false;
				break;
			}
		}
		return res;
	}

}
