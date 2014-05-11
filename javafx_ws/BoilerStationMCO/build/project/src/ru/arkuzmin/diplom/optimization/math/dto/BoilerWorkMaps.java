package ru.arkuzmin.diplom.optimization.math.dto;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import ru.arkuzmin.diplom.optimization.common.Globals;
import ru.arkuzmin.diplom.optimization.math.regression.BoilerRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.CubicalRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.IBoilerRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.IRegressionFunction;
import ru.arkuzmin.diplom.optimization.utils.PropertiesLoader;

/**
 * Режимные карты котлов.
 * @author ArKuzmin
 *
 */
public class BoilerWorkMaps {
	
	private static final Logger logger = Logger.getLogger(BoilerWorkMaps.class);
		
	/**
	 * Ключи для режимной карты.
	 */
	public static final String KEY_G_X = "GX";
	public static final String KEY_M_X = "MX";
	public static final String KEY_Q2_G_Y = "Q2GY";
	public static final String KEY_Q2_M_Y = "Q2MY";
	
	public static final String KEY_Q5_G_Y = "Q5GY";
	public static final String KEY_Q5_M_Y = "Q5MY";
	
	public static final String KEY_TYX_G_Y = "TYXGY";
	public static final String KEY_TYX_M_Y = "TYXMY";
	
	public static final String KEY_AYX_G_Y = "AYXGY";
	public static final String KEY_AYX_M_Y = "AYXMY";
	
	public static final String KEY_APC_G_Y = "APCGY";
	public static final String KEY_APC_M_Y = "APCMY";
	
	/**
	 * Режимная карта.
	 */
	private static Map<String, double[]> rMap;
	
	static {
		rMap = new HashMap<String, double[]>();
		initDefaultRegressions();
	}
	
	private static String getKey(int boilerNum, String rKey) {
		StringBuilder sb = new StringBuilder("");
		sb.append(boilerNum)
		  .append("_")
		  .append(rKey);
		
		return sb.toString();
	}

	private static double[] toDoubleArr(String[] arr) {
		if (arr == null) {
			return null;
		}
		
		try {
			double[] result = new double[arr.length];
			for (int i = 0; i < arr.length; i++) {
				result[i] = Double.parseDouble(arr[i]);
			}
			
			return result;
		} catch (NumberFormatException e) {
			logger.error(e);
			return null;
		}
	
	}
	
	/**
	 * Начальная инициализация регрессионных зависимостей.
	 */
	private static void initDefaultRegressions() {
		Properties bProps = PropertiesLoader.getBoilerCondMapProperties();
		
		for (int i = 1; i <= Globals.BOILERS_NUM; i++) {
			String[] bgx = bProps.getProperty(getKey(i, KEY_G_X)).split(",");
			String[] bgq2 = bProps.getProperty(getKey(i, KEY_Q2_G_Y)).split(",");
			String[] bgq5 = bProps.getProperty(getKey(i, KEY_Q5_G_Y)).split(",");
			String[] bgtyx = bProps.getProperty(getKey(i, KEY_TYX_G_Y)).split(",");
			String[] bgayx = bProps.getProperty(getKey(i, KEY_AYX_G_Y)).split(",");
			String[] bgapc = bProps.getProperty(getKey(i, KEY_APC_G_Y)).split(",");
			
			String[] bmx = bProps.getProperty(getKey(i, KEY_M_X)).split(",");
			String[] bmq2 = bProps.getProperty(getKey(i, KEY_Q2_M_Y)).split(",");
			String[] bmq5 = bProps.getProperty(getKey(i, KEY_Q5_M_Y)).split(",");
			String[] bmtyx = bProps.getProperty(getKey(i, KEY_TYX_M_Y)).split(",");
			String[] bmayx = bProps.getProperty(getKey(i, KEY_AYX_M_Y)).split(",");
			String[] bmapc = bProps.getProperty(getKey(i, KEY_APC_M_Y)).split(",");
			
			rMap.put(getKey(i, KEY_G_X), toDoubleArr(bgx));
			rMap.put(getKey(i, KEY_Q2_G_Y), toDoubleArr(bgq2));
			rMap.put(getKey(i, KEY_Q5_G_Y), toDoubleArr(bgq5));
			rMap.put(getKey(i, KEY_TYX_G_Y), toDoubleArr(bgtyx));
			rMap.put(getKey(i, KEY_AYX_G_Y), toDoubleArr(bgayx));
			rMap.put(getKey(i, KEY_APC_G_Y), toDoubleArr(bgapc));
			
			rMap.put(getKey(i, KEY_M_X), toDoubleArr(bmx));
			rMap.put(getKey(i, KEY_Q2_M_Y), toDoubleArr(bmq2));
			rMap.put(getKey(i, KEY_Q5_M_Y), toDoubleArr(bmq5));
			rMap.put(getKey(i, KEY_TYX_M_Y), toDoubleArr(bmtyx));
			rMap.put(getKey(i, KEY_AYX_M_Y), toDoubleArr(bmayx));
			rMap.put(getKey(i, KEY_APC_M_Y), toDoubleArr(bmapc));
		}
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
		Boiler b = new Boiler(1, Globals.K1_NAME, 90, 170);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 2.
	 * @return
	 */
	public static Boiler getB2() {
		Boiler b = new Boiler(2, Globals.K2_NAME, 90, 170);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 3.
	 * @return
	 */
	public static Boiler getB3() {
		Boiler b = new Boiler(3, Globals.K3_NAME, 90, 170);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 4.
	 * @return
	 */
	public static Boiler getB4() {
		Boiler b = new Boiler(4, Globals.K4_NAME, 130, 230);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 5.
	 * @return
	 */
	public static Boiler getB5() {
		Boiler b = new Boiler(5, Globals.K5_NAME, 130, 230);
		initBoiler(b);
		
		return b;
	}
	
	/**
	 * Возвращает конфигурацию котла 6.
	 * @return
	 */
	public static Boiler getB6() {
		Boiler b = new Boiler(6, Globals.K6_NAME, 130, 230);
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
	
	/**
	 * Сброс конфигурации котлоагрегатов к начальным значениям.
	 */
	public static void resetConfiguration() {
		initDefaultRegressions();
	}
	
	/**
	 * Установка новой конфигурации для котла.
	 * @param boilerNum - номер котла
	 * @param key - имя конфигурации
	 * @param values - значения
	 */
	public static void setConfiguration(int boilerNum, String key, double[] values) {
		rMap.put(getKey(boilerNum, key), values);
	}
}
