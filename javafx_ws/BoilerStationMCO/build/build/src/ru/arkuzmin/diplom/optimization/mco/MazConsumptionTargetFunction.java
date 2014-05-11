package ru.arkuzmin.diplom.optimization.mco;

import java.util.List;

import ru.arkuzmin.diplom.optimization.common.Globals;
import ru.arkuzmin.diplom.optimization.math.dto.Boiler;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;

/**
 * Критерий расхода мазута.
 * @author ArKuzmin
 *
 */
public class MazConsumptionTargetFunction implements ICriteriaTargetFunction {

	@Override
	public Criteria getValue(BoilerStation station) {
		if (station == null) {
			return null;
		}
		
		Criteria mazConsumption = new Criteria(Globals.CR_NAME_M_CONS, CriteriaTarget.MIN);
		double crValue = 0.0;
		
		List<Boiler> list = station.getBoilers();
		for (Boiler b : list) {
			if (BoilerStates.ON_MAZ.equals(b.getState())) {
				crValue += b.getB();
			}
		}
		
		mazConsumption.setValue(crValue);
		return mazConsumption;
	}
}
