package ru.arkuzmin.diplom.optimization.mco;

import java.util.LinkedList;
import java.util.List;

import ru.arkuzmin.diplom.optimization.math.dto.Boiler;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;

/**
 * Реализация метода по выбору начального решения.
 * @author ArKuzmin
 *
 */
public class DecisionUtils {

	/**
	 * Выполняет проверку допустимости заданной конфигурации.
	 * @param station
	 * @param DK
	 * @return
	 */
	public static boolean checkConfiguration(BoilerStation station, double DK) {
		List<Boiler> boilers = station.getBoilers();
		double min = 0.0;
		double max = 0.0;
		
		for (Boiler b : boilers) {
			if (!BoilerStates.OFF.equals(b.getState())) {
				min += b.getMIN_DK();
				max += b.getMAX_DK();
			}
		}
		
		return (min <= DK) && (DK <= max);
	}
	
	/**
	 * Возвращает начальное решение для заданной конфигурации котлоагрегатов.
	 * @param station
	 * @param DK
	 * @return
	 */
	public static void getPrimeDecision(BoilerStation station, double DK) {
		List<Boiler> working = new LinkedList<Boiler>();
		List<Boiler> boilers = station.getBoilers();
		for (Boiler b : boilers) {
			if (!BoilerStates.OFF.equals(b.getState())) {
				working.add(b);
			}
		}
		
		step123(working, DK);
	}
	
	private static boolean checkDK(Boiler b, double dk) {
		return (dk >= b.getMIN_DK() && dk <= b.getMAX_DK());
	}
	
	private static void step123(List<Boiler> boilers, double DK) {
		double sum = 0.0;
		// 1..n-1
		for (int i = 0; i < boilers.size() - 1; i++) {
			Boiler b = boilers.get(i);
			double dk = (b.getMIN_DK() + b.getMAX_DK()) / 2;
			b.setDK(dk);
			sum += dk;
		}
		// n
		Boiler b = boilers.get(boilers.size() - 1);
		double dk = DK - sum;
		b.setDK(dk);
		
		if (checkDK(b, dk)) {
			return;
		}
		
		step4(boilers);
	}
	
	private static void step4(List<Boiler> boilers) {
		Boiler bn = boilers.get(boilers.size() - 1);
		
		if (bn.getDK() > 0) {
			step5(boilers);
		} else {
			step8(boilers);
		}
	}
	
	private static void step5(List<Boiler> boilers) {
		Boiler bn = boilers.get(boilers.size() - 1);
		
		if (bn.getDK() > bn.getMAX_DK()) {
			step6(boilers);
		} else if (bn.getDK() < bn.getMIN_DK()) {
			step7(boilers);
		}
	}
	
	private static void step6(List<Boiler> boilers) {
		Boiler bn = boilers.get(boilers.size() - 1);
		
		double p = bn.getDK() - bn.getMAX_DK();
		bn.setDK(bn.getMAX_DK());
		
		int i = boilers.size() - 2;
		while (i >= 0) {
			Boiler bi = boilers.get(i);
			bi.setDK(bi.getDK() + p);
			
			if (bi.getDK() > bi.getMAX_DK()) {
				p = bi.getDK() - bi.getMAX_DK();
				bi.setDK(bi.getMAX_DK());
				i--;
			} else {
				break;
			}
		}
	}
	
	private static void step7(List<Boiler> boilers) {
		Boiler bn = boilers.get(boilers.size() - 1);
		
		double p = bn.getMIN_DK() - bn.getDK();
		bn.setDK(bn.getMIN_DK());
		
		int i = boilers.size() - 2;
		while (i >= 0) {
			Boiler bi = boilers.get(i);
			bi.setDK(bi.getDK() - p);
			
			if (bi.getDK() < bi.getMIN_DK()) {
				p = bi.getMIN_DK() - bi.getDK();
				bi.setDK(bi.getMIN_DK());
				i--;
			} else {
				break;
			}
		}
	}
	
	private static void step8(List<Boiler> boilers) {
		Boiler bn = boilers.get(boilers.size() - 1);
		
		double p = bn.getDK() - bn.getMIN_DK();
		bn.setDK(bn.getMIN_DK());
		
		int i = boilers.size() - 2;
		while (i >= 0) {
			Boiler bi = boilers.get(i);
			bi.setDK(bi.getDK() + p);
			
			if (bi.getDK() < bi.getMIN_DK()) {
				p = bi.getDK() - bi.getMIN_DK();
				bi.setDK(bi.getMIN_DK());
				i--;
			} else {
				break;
			}
		}
	}
}
