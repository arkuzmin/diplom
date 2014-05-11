package ru.arkuzmin.diplom.optimization.mco;

import ru.arkuzmin.diplom.optimization.common.Globals;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;

/**
 * Критерий финансовых затрат.
 * @author ArKuzmin
 *
 */
public class MoneyConsumptionTargetFunction implements ICriteriaTargetFunction {

	private double gasCost;
	private double mazCost;
	
	public MoneyConsumptionTargetFunction(double gasCost, double mazCost) {
		this.gasCost = gasCost;
		this.mazCost = mazCost;
	}
	
	@Override
	public Criteria getValue(BoilerStation station) {
		
		if (station == null) {
			return null;
		}
		
		Criteria gasConsumption = (new GasConsumptionTargetFunction()).getValue(station);
		Criteria mazConsumption = (new MazConsumptionTargetFunction()).getValue(station);
		
		Criteria monConsumption = new Criteria(Globals.CR_NAME_MON_CONS, CriteriaTarget.MIN);
		double crValue = gasCost * gasConsumption.getValue() + mazCost * mazConsumption.getValue();
		
		monConsumption.setValue(crValue);
		return monConsumption;
	}

}
