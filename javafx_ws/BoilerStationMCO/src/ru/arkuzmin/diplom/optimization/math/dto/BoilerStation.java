package ru.arkuzmin.diplom.optimization.math.dto;

import java.util.LinkedList;
import java.util.List;

/**
 * Очередь котельного отделения.
 * @author ArKuzmin
 *
 */
public class BoilerStation {
	
	private List<Boiler> boilers;
	
	public BoilerStation(BoilerStation other) {
		this.boilers = BoilerWorkMaps.getBoilerStation().getBoilers();
		List<Boiler> otherList = other.getBoilers();
		
		for (int i = 0; i < otherList.size(); i++) {
			Boiler otherB = otherList.get(i);
			Boiler b = boilers.get(i);
			
			b.setDK(otherB.getDK());
			b.setState(otherB.getState());	
		}
	}
	
	public BoilerStation(List<Boiler> boilers) {
		this.boilers = boilers;
	}

	/**
	 * Возвращает список работающих котлов.
	 * @return
	 */
	public List<Boiler> getWorkingBoilers() {
		List<Boiler> working = new LinkedList<Boiler>();
		for (Boiler b : boilers) {
			if (!BoilerStates.OFF.equals(b.getState())) {
				working.add(b);
			}
		}
		return working;
	}
	
	public List<Boiler> getBoilers() {
		return boilers;
	}
	
	/**
	 * Общая нагрузка очереди.
	 * @return
	 */
	public double getDK() {
		double DK = 0.0;
		for (Boiler b : boilers) {
			DK += b.getDK();
		}
		return DK;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (Boiler b : boilers) {
			sb.append(b)
			  .append("\n-----------------\n");
		}
		sb.append("Общая нагрузка очереди: ").append(getDK()).append("\n");
		return sb.toString();
	}
	
	public String deepToString() {
		StringBuilder sb = new StringBuilder("");;
		for (Boiler b : boilers) {
			sb.append(b.deepToString())
			  .append("\n-----------------\n");
		}
		sb.append("Общая нагрузка очереди: ").append(getDK()).append("\n");
		return sb.toString();
	}
}
