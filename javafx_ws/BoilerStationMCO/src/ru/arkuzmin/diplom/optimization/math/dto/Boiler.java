package ru.arkuzmin.diplom.optimization.math.dto;

import org.apache.log4j.Logger;

import ru.arkuzmin.diplom.optimization.math.regression.IBoilerRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.IRegressionFunction;

/** 
 * Котлоагрегат.
 * @author ArKuzmin
 *
 */
@SuppressWarnings("unused")
public class Boiler {
	
	private static final Logger logger = Logger.getLogger(Boiler.class);
	
	private boolean initialized1 = false;
	
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
	private IBoilerRegressionFunction q2_regression = null;
	// Потеря тепла в окружающую среду за счет конвекции и излучения
	private IBoilerRegressionFunction q5_regression = null;
	// Температура уходящих газов
	private IBoilerRegressionFunction tyx_regression = null;
	// Коэффициент избытка воздуха в уходящих газах
	private IBoilerRegressionFunction ayx_regression = null;
	// Коэффициент избытка воздуха в режимном сечении
	private IBoilerRegressionFunction apc_regression = null;
	
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
	
	public void init(IBoilerRegressionFunction q2_regression,
					 IBoilerRegressionFunction q5_regression,
					 IBoilerRegressionFunction tyx_regression,
					 IBoilerRegressionFunction ayx_regression,
					 IBoilerRegressionFunction apc_regression) {
		
		this.q2_regression = q2_regression;
		this.q5_regression = q5_regression;
		this.tyx_regression = tyx_regression;
		this.ayx_regression = ayx_regression;
		this.apc_regression = apc_regression;
		
		this.initialized1 = true;
	}
	
	private boolean checkInitialized1() {
		return initialized1;
	}
	
	private void checkInitialized() {
		if (!(checkInitialized1())) {
			throw new IllegalStateException("The Boiler is not initialized with regressions!");
		}
	}
	
	public BoilerStates getState() {
		checkInitialized();
		return state;
	}
	public double getMIN_DK() {
		return MIN_DK;
	}
	public double getMAX_DK() {
		return MAX_DK;
	}
	public double getDK() {
		checkInitialized();
		return DK;
	}

	private double getQ3() {
		return q3;
	}
	private double getQ4() {
		return q4;
	}
	private double getQhp() {
		if (BoilerStates.ON_GAS.equals(getState())) {
			Qhp = 8440;
		} else if (BoilerStates.ON_MAZ.equals(getState())) {
			Qhp = 9300;
		}
		return Qhp;
	}
	
	private double getWp() {
		if (BoilerStates.ON_GAS.equals(getState())) {
			Wp = 0.0;
		} else if (BoilerStates.ON_MAZ.equals(getState())) {
			Wp = 15;
		}
		return Wp;
	}
	private double getCv() {
		return Cv;
	}
	private double getV0() {
		return v0;
	}
	private double getTkf2() {
		if (BoilerStates.ON_GAS.equals(getState())) {
			tkf2 = 30;
		} else if (BoilerStates.ON_MAZ.equals(getState())) {
			tkf2 = 80;
		}
		return tkf2;
	}
	private double getTml() {
		return tml;
	}
	private double getD() {
		return d;
	}
	private double getI_f() {
		return i_f;
	}
	private double getI_h() {
		return i_h;
	}
	private double getTxv() {
		return txv;
	}
	private double getD_tdv() {
		return d_tdv;
	}
	private double getD_aht() {
		return d_aht;
	}
	private double getD_ah() {
		if (getDK() != 0) {
			if (getDK() <= 210) {
				d_ah = 0.1;
			} else {
				d_ah = 0.25;
			}
		}
		return d_ah;
	}
	private double getI_pv() {
		return i_pv;
	}
	private double getI_nv() {
		return i_nv;
	}
	private double getI_kv() {
		return i_kv;
	}

	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}

	private double getQ2() {
		return q2_regression.getY(getDK(), state);
	}

	private double getQ5() {
		return q5_regression.getY(getDK(), state);
	}

	private double getTyx() {
		return tyx_regression.getY(getDK(), state);
	}

	private double getAyx() {
		return ayx_regression.getY(getDK(), state);
	}

	private double getApc() {
		return apc_regression.getY(getDK(), state);
	}
	
	/**
	 * Возвращает количество потребляемого данным котлом топлива при заданной конфигурации.
	 * @return
	 */
	public double getB() {
		checkInitialized();
		return (getQkbr() * getKo()) / (getQpp() * getKPD());
	}
	
	private double getKo() {
		return 100;
		//return 100000;
	}
	
	// Теплопроизводительность
	public double getQkbr() {
		double result = getDK()*(getI_pv() - getI_nv()) + 0.01*getDK()*(getI_kv() - getI_nv());
		logger.trace("Qkbr: " + result);
		return result;
	}
	
	// Располагаемое тепло
	public double getQpp() {
		double result = getQhp() + getQkf1() + getQtl1() + getQf1();
		logger.trace("Qpp: " + result);
		return result;
	}
	
	// Тепло, вносимое в котел воздухом
	private double getQkf1() {
		double result = getCv()*getV0()*getAvp1()*(getTkf2()-getTkf1());
		logger.trace("Qkf1: " + result);
		return result;
	}
	
	// Коэффициент избытка воздуха на входе в воздухоподогреватель
	private double getAvp1() {
		return getApc() - getD_at() + 0.85*getD_a();
	}
	
	// Нормативное значение присосов воздуха в топку
	private double getD_at() {
		return getD_aht() * (MAX_DK / getDK());
	}
	
	// Нормативное значение присосов воздуха в газовый тракт
	private double getD_a() {
		return getD_ah()*Math.sqrt(MAX_DK/getDK());
	}
	
	// Температура холодного воздуха
	private double getTkf1() {
		return getTxv() + getD_tdv();
	}
	
	// Тепло, вносимое в котел мазутом
	private double getQtl1() {
		double result;
		if (BoilerStates.ON_MAZ.equals(state)) {
			result =  (0.415 + 0.0006*getTml())*getTml();
		} else {
			result =  0.0;
		}
		logger.trace("Qtl1: " + result);
		return result;
	}
	
	// Тепло, вносимое в топку форсуночным паром
	private double getQf1() {
		double result =  getD()*(getI_f() - getI_h());
		logger.trace("Qf1: " + result);
		return result;
	}
	
	// КПД
	public double getKPD() {
		checkInitialized();
		return 100 - getQ2() - getQ3() - getQ4() - getQ5();
	}
	
	public Boiler initCurrentState(double DK, BoilerStates state) {
		this.DK = DK;
		this.state = state;
	
		return this;
	}
	
	public Boiler setDK(double DK) {
		this.DK = DK;
		return this;
	}
	
	public Boiler setState(BoilerStates state) {
		this.state = state;
		return this;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("<").append(number).append(">")
		  .append(": ").append(name).append("-")
		  .append("[").append(MIN_DK).append(";").append(MAX_DK).append("]\n")
		  .append("Состояние: ").append(state).append("\n")
		  .append("Текущая нагрузка: ").append(DK);
		return sb.toString();
	}
	
	public String deepToString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("<").append(number).append(">")
		  .append(": ").append(name).append("-")
		  .append("[").append(MIN_DK).append(";").append(MAX_DK).append("]\n");
		
		if (checkInitialized1()) {
			sb.append("\n")
			  .append("q2: ").append(q2_regression).append("\n")
			  .append("q5: ").append(q5_regression).append("\n")
			  .append("tyx: ").append(tyx_regression).append("\n")
			  .append("ayx: ").append(ayx_regression).append("\n")
			  .append("apc: ").append(apc_regression).append("\n");
			
		} 
		
		
		sb.append("Состояние: ").append(state).append("\n")
		  .append("Текущая нагрузка: ").append(DK);
		
		return sb.toString();
	}
}
