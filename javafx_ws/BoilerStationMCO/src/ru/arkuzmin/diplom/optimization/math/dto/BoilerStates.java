package ru.arkuzmin.diplom.optimization.math.dto;

/**
 * Возможные состояния котла.
 * @author ArKuzmin
 *
 */
public enum BoilerStates {
	UNKNOWN(-1, "Не определено", "НЕОПР."),
	OFF(0, "Выключен", "0"), 
	ON_GAS(1, "Работает на газе", "Г"),
	ON_MAZ(2, "Работает на мазуте", "М");
	
	private int state;
	private String name;
	private String str;
	
	BoilerStates(int state, String name, String str) {
		this.state = state;
		this.name = name;
		this.str = str;
	}
	
	public String getName() {
		return name;
	}
	
	public int getState() {
		return state;
	}
	
	public static BoilerStates get(int i) {
		for (BoilerStates bs : values()) {
			if (bs.state == i) {
				return bs;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return str;
	}

}
