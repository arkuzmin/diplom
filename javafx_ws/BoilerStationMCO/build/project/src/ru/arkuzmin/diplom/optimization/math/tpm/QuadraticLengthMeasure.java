package ru.arkuzmin.diplom.optimization.math.tpm;

import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;

public class QuadraticLengthMeasure implements ILengthMeasure {

	@Override
	public double getDistance(VectorCriteria v1, VectorCriteria v2) throws IllegalArgumentException {
		if (v1 == null || v2 == null || v1.getLenght() == 0|| v1.getLenght() != v2.getLenght()) {
			throw new IllegalArgumentException("The vectors must be not null and the same size!");
		}
		
		double s = 0.0;
		
		for (int i = 0; i < v1.getLenght(); i++) {
			s += (v1.get(i) - v2.get(i))*(v1.get(i) - v2.get(i));
		}
		
		return s;
	}
}
