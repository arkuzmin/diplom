package ru.arkuzmin.diplom.optimization.math.dto;

/**
 * Возможные состояния котла.
 * @author ArKuzmin
 *
 */
public enum BoilerStates {
	OFF(0), 
	ON_GAS(1),
	ON_MAZ(2);
	
	private int state;
	
	BoilerStates(int state) {
		this.state = state;
	}
	
	public int getState() {
		return state;
	}

}
