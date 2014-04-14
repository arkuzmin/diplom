package ru.arkuzmin.diplom.optimization.math.tpm.impl;

/**
 * Критерий оптимизации.
 * @author ArKuzmin
 *
 */
public class Criteria {
	private final String name;
	private double value;
	private CriteriaTarget target;
	
	public Criteria(final String name, CriteriaTarget target) {
		this.name = name;
		this.target = target;
	}
	
	public String getName() {
		return name;
	}
	
	public CriteriaTarget getTarget() {
		return target;
	}
	
	public double getValue() {
		return value;
	}
	
	public static enum CriteriaTarget {
		MIN,
		MAX
	}
	
	public Criteria changeTarget() {
		this.value *= -1;
		if (CriteriaTarget.MIN.equals(this.target)) {
			this.target = CriteriaTarget.MAX;
		} else {
			this.target = CriteriaTarget.MIN;
		}
		return this;
	}
}
