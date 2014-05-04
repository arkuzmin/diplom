package ru.arkuzmin.diplom.optimization.mco;

import java.util.List;

import ru.arkuzmin.diplom.optimization.common.Globals;
import ru.arkuzmin.diplom.optimization.math.dto.Boiler;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;

/**
 * Критерий КПД группы котлоагрегатов.
 * @author ArKuzmin
 *
 */
public class KPDTargetFunction implements ICriteriaTargetFunction {

	@Override
	public Criteria getValue(BoilerStation station) {
		if (station == null) {
			return null;
		}
		
		Criteria kpdCriteria = new Criteria(Globals.CR_NAME_KPD, CriteriaTarget.MAX);
		double num = 0.0;
		double den = 0.0;
		
		List<Boiler> boilers = station.getBoilers();
		for (Boiler b : boilers) {
			num += b.getKPD() * b.getQkbr();
			den += b.getQkbr();
		}
		
		double crValue = num / den;
		kpdCriteria.setValue(crValue);
		
		return kpdCriteria;
	}

}
