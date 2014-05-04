package ru.arkuzmin.diplom.optimization.math.dto;

/**
 * Комбинация котлоагрегатов.
 * @author ArKuzmin
 *
 */
public class WorkMode {

	private BoilerStates[] states;
	
	public WorkMode(BoilerStates... states) {
		this.states = states;
	}
	
	public WorkMode(String mode) {
		this.states = new BoilerStates[mode.length()];
		for (int i = 0; i < mode.length(); i++) {
			char ch = mode.charAt(i);
			int chi = Integer.valueOf(String.valueOf(ch));
			BoilerStates bs = BoilerStates.get(chi);
			states[i] = bs;
		}
	}
	
	public BoilerStates getStateFor(int boiler) {
		return states[boiler];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (BoilerStates bs : states) {
			sb.append(bs).append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
