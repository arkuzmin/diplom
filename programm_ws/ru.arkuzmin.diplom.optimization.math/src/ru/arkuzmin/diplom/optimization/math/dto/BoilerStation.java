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
}
