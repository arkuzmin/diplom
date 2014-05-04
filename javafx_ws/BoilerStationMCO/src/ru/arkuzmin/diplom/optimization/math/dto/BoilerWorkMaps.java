package ru.arkuzmin.diplom.optimization.math.dto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ru.arkuzmin.diplom.optimization.math.regression.BoilerRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.CubicalRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.IBoilerRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.IRegressionFunction;

/**
 * Режимные карты котлов.
 * @author ArKuzmin
 *
 */
public class BoilerWorkMaps {
	
	/**
	 * Имена котлов.
	 */
	private static final String K1_NAME = "Котел К-1";
	private static final String K2_NAME = "Котел К-2";
	private static final String K3_NAME = "Котел К-3";
	private static final String K4_NAME = "Котел К-4";
	private static final String K5_NAME = "Котел К-5";
	private static final String K6_NAME = "Котел К-6";
	
	/**
	 * Ключи для режимной карты.
	 */
	private static final String KEY_G_X = "GX";
	private static final String KEY_M_X = "MX";
	private static final String KEY_Q2_G_Y = "Q2GY";
	private static final String KEY_Q2_M_Y = "Q2MY";
	
	private static final String KEY_Q5_G_Y = "Q5GY";
	private static final String KEY_Q5_M_Y = "Q5MY";
	
	private static final String KEY_TYX_G_Y = "TYXGY";
	private static final String KEY_TYX_M_Y = "TYXMY";
	
	private static final String KEY_AYX_G_Y = "AYXGY";
	private static final String KEY_AYX_M_Y = "AYXMY";
	
	private static final String KEY_APC_G_Y = "APCGY";
	private static final String KEY_APC_M_Y = "APCMY";
	
	/**
	 * Режимная карта.
	 */
	private static Map<String, double[]> rMap;
	
	static {
		rMap = new HashMap<String, double[]>();
	}
	
	private static String getKey(int boilerNum, String rKey) {
		StringBuilder sb = new StringBuilder("");
		sb.append(boilerNum)
		  .append("_")
		  .append(rKey);
		
		return sb.toString();
	}
	
	/**
	 * Начальная инициализация регрессионных зависимостей.
	 */
	private static void initDefaultRegressions() {
		// init K1
		rMap.put(getKey(1, KEY_G_X), new double[] {90, 110, 130, 150, 170});
		rMap.put(getKey(1, KEY_Q2_G_Y), new double[] {6.08, 6.05, 6.1, 6.1, 6.15});
		rMap.put(getKey(1, KEY_G_X), new double[] {90, 110, 130, 150, 170});
		rMap.put(getKey(1, KEY_Q5_G_Y), new double[] {});
	}
	
	
	private static void initBoiler(Boiler b) {
		
		// q2 regression
		double[] xg = rMap.get(getKey(b.getNumber(), KEY_G_X));
		double[] xm = rMap.get(getKey(b.getNumber(), KEY_M_X));
		double[] yg = rMap.get(getKey(b.getNumber(), KEY_Q2_G_Y));
		double[] ym = rMap.get(getKey(b.getNumber(), KEY_Q2_M_Y));
		IRegressionFunction rg = new CubicalRegressionFunction(xg, yg);
		IRegressionFunction rm = new CubicalRegressionFunction(xm, ym);
		IBoilerRegressionFunction bq2 = new BoilerRegressionFunction(rg, rm);
		
		// q5 regression
		xg = rMap.get(getKey(b.getNumber(), KEY_G_X));
		xm = rMap.get(getKey(b.getNumber(), KEY_M_X));
		yg = rMap.get(getKey(b.getNumber(), KEY_Q5_G_Y));
		ym = rMap.get(getKey(b.getNumber(), KEY_Q5_M_Y));
		rg = new CubicalRegressionFunction(xg, yg);
		rm = new CubicalRegressionFunction(xm, ym);
		IBoilerRegressionFunction bq5 = new BoilerRegressionFunction(rg, rm);
		
		// tyx regression
		xg = rMap.get(getKey(b.getNumber(), KEY_G_X));
		xm = rMap.get(getKey(b.getNumber(), KEY_M_X));
		yg = rMap.get(getKey(b.getNumber(), KEY_TYX_G_Y));
		ym = rMap.get(getKey(b.getNumber(), KEY_TYX_M_Y));
		rg = new CubicalRegressionFunction(xg, yg);
		rm = new CubicalRegressionFunction(xm, ym);
		IBoilerRegressionFunction btyx = new BoilerRegressionFunction(rg, rm);
		
		// ayx regression
		xg = rMap.get(getKey(b.getNumber(), KEY_G_X));
		xm = rMap.get(getKey(b.getNumber(), KEY_M_X));
		yg = rMap.get(getKey(b.getNumber(), KEY_AYX_G_Y));
		ym = rMap.get(getKey(b.getNumber(), KEY_AYX_M_Y));
		rg = new CubicalRegressionFunction(xg, yg);
		rm = new CubicalRegressionFunction(xm, ym);
		IBoilerRegressionFunction bayx = new BoilerRegressionFunction(rg, rm);
	
		// apc regression
		xg = rMap.get(getKey(b.getNumber(), KEY_G_X));
		xm = rMap.get(getKey(b.getNumber(), KEY_M_X));
		yg = rMap.get(getKey(b.getNumber(), KEY_APC_G_Y));
		ym = rMap.get(getKey(b.getNumber(), KEY_APC_M_Y));
		rg = new CubicalRegressionFunction(xg, yg);
		rm = new CubicalRegressionFunction(xm, ym);
		IBoilerRegressionFunction bapc = new BoilerRegressionFunction(rg, rm);
		
		// init
		b.init(bq2, bq5, btyx, bayx, bapc);
	}
	
	/**
	 * Возвращает конфигурацию котла 1.
	 * @return
	 */
	public static Boiler getB1() {
		Boiler b = new Boiler(1, K1_NAME, 90, 170);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 2.
	 * @return
	 */
	public static Boiler getB2() {
		Boiler b = new Boiler(2, K2_NAME, 90, 170);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 3.
	 * @return
	 */
	public static Boiler getB3() {
		Boiler b = new Boiler(3, K3_NAME, 90, 170);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 4.
	 * @return
	 */
	public static Boiler getB4() {
		Boiler b = new Boiler(4, K4_NAME, 130, 230);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 5.
	 * @return
	 */
	public static Boiler getB5() {
		Boiler b = new Boiler(5, K5_NAME, 130, 230);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 6.
	 * @return
	 */
	public static Boiler getB6() {
		Boiler b = new Boiler(6, K6_NAME, 130, 230);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию очереди котлоагрегатов.
	 * @return
	 */
	public static BoilerStation getBoilerStation() {
		List<Boiler> boilers = new LinkedList<Boiler>();
		
		boilers.add(getB1());
		boilers.add(getB2());
		boilers.add(getB3());
		boilers.add(getB4());
		boilers.add(getB5());
		boilers.add(getB6());
		
		BoilerStation bs = new BoilerStation(boilers);
		return bs;
	}
}
