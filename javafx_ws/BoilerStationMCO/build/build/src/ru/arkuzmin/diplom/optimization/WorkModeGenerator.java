package ru.arkuzmin.diplom.optimization;

import java.util.LinkedList;
import java.util.List;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;
import ru.arkuzmin.diplom.optimization.math.dto.WorkMode;
import ru.arkuzmin.diplom.optimization.math.utils.MathUtils;

/**
 * Генератор всех возможных режимов работы.
 * @author ArKuzmin
 *
 */
public class WorkModeGenerator {

	private int boilerNum;
	
	public WorkModeGenerator(int boilerNum) {
		this.boilerNum = boilerNum;
	}
	
	/**
	 * Возвращает список всех возможных состояний котлоагрегатов.
	 * @return
	 */
	public List<WorkMode> getAllWorkModes() {
		List<WorkMode> wml = new LinkedList<WorkMode>();
		List<String> modes = generateModes();
		
		for (String mode : modes) {
			WorkMode wm = new WorkMode(mode);
			wml.add(wm);
		}
		
		return wml;
	}

	private List<String> generateModes() {
		List<String> modes = new LinkedList<String>();
		
		int stateNum  = BoilerStates.values().length - 1;
		int max = 1;
		for (int i = 0; i < boilerNum; i++) {
			max *= stateNum;
		}
		
		for (int i = 0; i < max; i++) {
			String modeStr = getModeString(MathUtils.toOtherSystem(i, stateNum));
			modes.add(modeStr);
		}
		
		return modes;
	}
	
	
	private String getModeString(String mode) {
		StringBuilder sb = new StringBuilder("");
		if (mode.length() <  boilerNum) {
			int nCount = boilerNum - mode.length();
			for (int i = 0; i < nCount; i++) {
				sb.append("0");
			}
		}
		
		sb.append(mode);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		WorkModeGenerator wmg = new WorkModeGenerator(6);
		List<String> l = wmg.generateModes();
		for (String s : l) {
			System.out.println(s);
		}
	}
}
