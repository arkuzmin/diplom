package ru.arkuzmin.diplom.optimization.math.dto;

import java.util.List;

/**
 * Векторный критерий.
 * @author ArKuzmin
 *
 */
public class VectorCriteria {
	private final List<Criteria> vector;
	
	public VectorCriteria(List<Criteria> vector) {
		this.vector = vector;
	}
	
	public List<Criteria> getVector() {
		return vector;
	}
	
	public int getLenght() {
		return vector.size();
	}

	public Criteria getCr(int index) {
		return vector.get(index);
	}
	
	public double get(int index) {
		return vector.get(index).getValue();
	}
	
	public void setValues(double[] values) {
		if (values.length != vector.size()) {
			throw new IllegalArgumentException("Incorrect size! values num = " +  values.length
					+ " vector size = " + vector.size());
		}
		int i = 0;
		for (Criteria cr : vector) {
			cr.setValue(values[i]);
			i++;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (Criteria cr : vector) {
			sb.append(cr).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	
}
