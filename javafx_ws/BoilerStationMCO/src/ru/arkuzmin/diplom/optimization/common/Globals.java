package ru.arkuzmin.diplom.optimization.common;

/**
 * Глобальные константы.
 * @author ArKuzmin
 *
 */
public interface Globals {
	
	/**
	 * Имена котлов.
	 */
	public static final String K1_NAME = "Котел К-1";
	public static final String K2_NAME = "Котел К-2";
	public static final String K3_NAME = "Котел К-3";
	public static final String K4_NAME = "Котел К-4";
	public static final String K5_NAME = "Котел К-5";
	public static final String K6_NAME = "Котел К-6";
	
	/**
	 * Количество котлоагрегатов в очереди.
	 */
	public static final int BOILERS_NUM = 6;
	
	/**
	 * Названия критериев.
	 */
	public static final String CR_NAME_G_CONS = "Расход газа";
	public static final String CR_NAME_M_CONS = "Расход мазута";
	public static final String CR_NAME_MON_CONS = "Финансовые затраты";
	public static final String CR_NAME_KPD = "КПД группы котлоагрегатов";
	
	/**
	 * CSS
	 */
	public static final String CSS_STYLES = "/ru/arkuzmin/diplom/optimization/ui/css/styles.css";
}
