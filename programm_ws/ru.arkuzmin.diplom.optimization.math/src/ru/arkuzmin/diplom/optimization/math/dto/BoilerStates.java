package ru.arkuzmin.diplom.optimization.math.dto;

/**
 * Возможные состояния котла.
 * @author ArKuzmin
 *
 */
public enum BoilerStates {
	UNKNOWN(-1, "Не определено"),
	OFF(0, "Выключен"), 
	ON_GAS(1, "Работает на газе"),
	ON_MAZ(2, "Работает на мазуте");
	
	private int state;
	private String name;
	
	BoilerStates(int state, String name) {
		this.state = state;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getState() {
		return state;
	}

}
