package ru.arkuzmin.diplom.optimization.math.dto;

/**
 * Решение многокритериальной задачи.
 * @author ArKuzmin
 *
 */
public class Decision {
	
	private BoilerStation station;
	private VectorCriteria vector;
	private double targetValue;
	
	public Decision(BoilerStation station, VectorCriteria vector, double targetValue) {
		this.station = station;
		this.vector = vector;
		this.targetValue = targetValue;
	}
	
	public Decision() {
		
	}
	
	public BoilerStation getStation() {
		return station;
	}
	public void setStation(BoilerStation station) {
		this.station = station;
	}
	public VectorCriteria getVector() {
		return vector;
	}
	public void setVector(VectorCriteria vector) {
		this.vector = vector;
	}
	public double getTargetValue() {
		return targetValue;
	}
	public void setTargetValue(double targetValue) {
		this.targetValue = targetValue;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(station)
		  .append(vector)
		  .append("\n")
		  .append("Значение целевой функции: ").append(targetValue).append("\n");
		
		return sb.toString();
	}
}
