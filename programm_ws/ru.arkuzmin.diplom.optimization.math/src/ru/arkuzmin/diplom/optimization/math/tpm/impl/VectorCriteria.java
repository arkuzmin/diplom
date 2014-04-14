package ru.arkuzmin.diplom.optimization.math.tpm.impl;

/**
 * Векторный критерий.
 * @author ArKuzmin
 *
 */
public class VectorCriteria {
	private final double[] values;
	
	public VectorCriteria(double[] values) {
		this.values = values;
	}
	
	public double[] getValues() {
		return values;
	}
	
	public int getLenght() {
		return values.length;
	}

	public double get(int index) {
		return values[index];
	}
	
}
