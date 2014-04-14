package ru.arkuzmin.diplom.optimization.math.dto;

import ru.arkuzmin.diplom.optimization.math.regression.CubicalRegressionFunction;

/** 
 * Котлоагрегат.
 * @author ArKuzmin
 *
 */
public class Boiler {
	/** 
	 * Текущее состояние котла.
	 */
	private BoilerStates state;
	/**
	 * Нижняя граница допустимой паровой нагрузки.
	 */
	private final double MIN_DK;
	/**
	 * Верхняя граница допустимой паровой нагрузки.
	 */
	private final double MAX_DK;
	/**
	 * Текущая паропроизводительность котла.
	 */
	private double DK;
	/**
	 * Номер котла.
	 */
	private final int number;
	/**
	 * Название котла.
	 */
	private final String name;
	
	/**
	 * Регрессионные полиномы.
	 */
	// Потеря тепла с уходящими газами
	private CubicalRegressionFunction q2_regression = null;
	// Потеря тепла в окружающую среду за счет конвекции и излучения
	private CubicalRegressionFunction q5_regression = null;
	// Температура уходящих газов
	private CubicalRegressionFunction tyx_regression = null;
	// Коэффициент избытка воздуха в уходящих газах
	private CubicalRegressionFunction ayx_regression = null;
	// Коэффициент избытка воздуха в режимном сечении
	private CubicalRegressionFunction apc_regression = null;
	
	private double q2;
	private double q5;
	private double tyx;
	private double ayx;
	private double apc;
	
	/**
	 * Параметры - константы.
	 */
	// Потери тепла с химическим недожогом топлива
	private final double q3 = 0.0;
	// Потери тепла от механической неполноты сгорания топлива
	private final double q4 = 0.0;
	// Низшая теплота сгорания топлива
	private double Qhp;
	// Влажность топлива на рабочую массу 
	private double Wp;
	// Объемная теплоемкость воздуха
	private final double Cv = 0.317;
	// Теоритически объем сухого воздуха, необходимый для полного сгорания топлива
	private final double v0 = 10.42;
	// Температура воздуха после воздухоподогревателей 
	private double tkf2;
	// Температура поступающего в топку котла мазута 
	private final double tml = 110;
	// Удельный расход пара на распыливание мазута
	private final double d = 0.02;
	// Теплосодержание пара, поступающего на распыливание
	private final double i_f = 699.1;
	//Теплосодержание пара при давлении и температуре уходящих газов
	private final double i_h = 600;
	// Температура воздуха на всосе дутьевого вентилятора
	private final double txv = 30;
	// Поправка на изменение температуры воздуха в вентиляторах за счет его сжатия
	private final double d_tdv = 0;
	// Норма присосов в топку
	private final double d_aht = 0.5;
	// Норма присосов в газовый тракт 
	private double d_ah;
	// Теплосодержание (энтальпия) перегретого пара
	private final double i_pv = 814.97;
	// Теплосодержание (энтальпия) питательной воды
	private final double i_nv = 220;
	// Теплосодержание (энтальпия) котловой воды
	private final double i_kv = 334.2;
	
	/**
	 * Конструктор
	 * @param number - номер котла
	 * @param name - имя котла
	 * @param MIN_DK - нижняя граница паровой нагрузки
	 * @param MAX_DK - верхняя граница паровой нагрузки
	 */
	public Boiler (final int number, final String name, 
			       final double MIN_DK, final double MAX_DK) {
		this.number = number;
		this.name = name;
		this.MIN_DK = MIN_DK;
		this.MAX_DK = MAX_DK;
	}
	
	
	public BoilerStates getState() {
		return state;
	}
	public double getMIN_DK() {
		return MIN_DK;
	}
	public double getMAX_DK() {
		return MAX_DK;
	}
	public double getDK() {
		return DK;
	}

	public double getQ3() {
		return q3;
	}
	public double getQ4() {
		return q4;
	}
	public double getQhp() {
		if (BoilerStates.ON_GAS.equals(getState())) {
			Qhp = 8440;
		} else if (BoilerStates.ON_MAZ.equals(getState())) {
			Qhp = 9300;
		}
		return Qhp;
	}
	
	public double getWp() {
		if (BoilerStates.ON_GAS.equals(getState())) {
			Wp = 0.0;
		} else if (BoilerStates.ON_MAZ.equals(getState())) {
			Wp = 15;
		}
		return Wp;
	}
	public double getCv() {
		return Cv;
	}
	public double getV0() {
		return v0;
	}
	public double getTkf2() {
		if (BoilerStates.ON_GAS.equals(getState())) {
			tkf2 = 30;
		} else if (BoilerStates.ON_MAZ.equals(getState())) {
			tkf2 = 80;
		}
		return tkf2;
	}
	public double getTml() {
		return tml;
	}
	public double getD() {
		return d;
	}
	public double getI_f() {
		return i_f;
	}
	public double getI_h() {
		return i_h;
	}
	public double getTxv() {
		return txv;
	}
	public double getD_tdv() {
		return d_tdv;
	}
	public double getD_aht() {
		return d_aht;
	}
	public double getD_ah() {
		if (getDK() != 0) {
			if (getDK() <= 210) {
				d_ah = 0.1;
			} else {
				d_ah = 0.25;
			}
		}
		return d_ah;
	}
	public double getI_pv() {
		return i_pv;
	}
	public double getI_nv() {
		return i_nv;
	}
	public double getI_kv() {
		return i_kv;
	}


	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}


	public double getQ2() {
		
		return q2;
	}


	public double getQ5() {
		return q5;
	}

	public double getTyx() {
		return tyx;
	}

	public double getAyx() {
		return ayx;
	}

	public double getApc() {
		return apc;
	}
	
}
