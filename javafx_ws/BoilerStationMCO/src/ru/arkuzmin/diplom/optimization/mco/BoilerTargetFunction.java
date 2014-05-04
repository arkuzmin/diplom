package ru.arkuzmin.diplom.optimization.mco;

import java.util.LinkedList;
import java.util.List;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

/**
 * Целевая фукнция для очереди котлоагрегатов.
 * @author ArKuzmin
 *
 */
public class BoilerTargetFunction implements ITargetFunction {

	private double gasCost;
	private double mazCost;
	
	public BoilerTargetFunction(double gasCost, double mazCost) {
		this.gasCost = gasCost;
		this.mazCost = mazCost;
	}
	
	@Override
	public double getY(BoilerStation station) {
		if (station == null) {
			throw new IllegalArgumentException("Illegal configuration!");
		}
		
		double result = 0.0;
		Criteria gasCons = (new GasConsumptionTargetFunction()).getValue(station);
		Criteria mazCons = (new MazConsumptionTargetFunction()).getValue(station);
		Criteria monCons = (new MoneyConsumptionTargetFunction(gasCost, mazCost)).getValue(station);
		Criteria kpd = (new KPDTargetFunction()).getValue(station);
		
		result += gasCons.getValue() + mazCons.getValue() + monCons.getValue() + (kpd.changeTarget()).getValue();
		
		return result;
	}

	@Override
	public VectorCriteria getCValues(BoilerStation station) {
		if (station == null) {
			throw new IllegalArgumentException("Illegal configuration!");
		}
		
		List<Criteria> vector = new LinkedList<Criteria>();
		
		vector.add((new GasConsumptionTargetFunction()).getValue(station));
		vector.add((new MazConsumptionTargetFunction()).getValue(station));
		vector.add((new MoneyConsumptionTargetFunction(gasCost, mazCost)).getValue(station));
		vector.add((new KPDTargetFunction()).getValue(station));
		
		VectorCriteria vc = new VectorCriteria(vector);
		
		return vc;
	}

}
