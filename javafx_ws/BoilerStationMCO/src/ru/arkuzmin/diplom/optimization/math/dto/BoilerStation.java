package ru.arkuzmin.diplom.optimization.math.dto;

import java.util.List;

/**
 * Очередь котельного отделения.
 * @author ArKuzmin
 *
 */
public class BoilerStation {
	
	private List<Boiler> boilers;
	
	public BoilerStation(List<Boiler> boilers) {
		this.boilers = boilers;
	}

	public List<Boiler> getBoilers() {
		return boilers;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (Boiler b : boilers) {
			sb.append(b)
			  .append("\n-----------------\n");
		}
		return sb.toString();
	}
}
