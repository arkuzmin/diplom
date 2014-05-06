package ru.arkuzmin.diplom.optimization.ui;

import javafx.scene.layout.VBox;
import ru.arkuzmin.diplom.optimization.math.dto.Boiler;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;

public class BoilerPaneManager {
	
	// q2
	private static final String CHART_LBL_Q2 = "Зависимость q2 от паровой нагрузки";
	private static final String CHART_Y_Q2 = "q2 [%]";
	private static final String PANE_LBL_Q2_G = "Зависимость потерь тепла с уходящими газами (q2) от тепловой нагрузки на котел (DK) при работе на газе";
	private static final String PANE_LBL_Q2_M = "Зависимость потерь тепла с уходящими газами (q2) от тепловой нагрузки на котел (DK) при работе на мазуте";
	
	//q5
	private static final String CHART_LBL_Q5 = "Зависимость q5 от паровой нагрузки";
	private static final String CHART_Y_Q5 = "q5 [%]";
	private static final String PANE_LBL_Q5_G = "Зависимость потерь тепла за счет конвекции и излучения (q5) от тепловой нагрузки на котел (DK) при работе на газе";
	private static final String PANE_LBL_Q5_M = "Зависимость потерь тепла за счет конвекции и излучения (q5) от тепловой нагрузки на котел (DK) при работе на мазуте";
	
	//tyx
	private static final String CHART_LBL_TYX = "Зависимость Tyx. от паровой нагрузки";
	private static final String CHART_Y_TYX = "Tух. [oC]";
	private static final String PANE_LBL_TYX_G = "Зависимость температуры уходящих газов (Tух.) от тепловой нагрузки на котел (DK) при работе на газе";
	private static final String PANE_LBL_TYX_M = "Зависимость температуры уходящих газов (Tух.) от тепловой нагрузки на котел (DK) при работе на мазуте";
	
	//ayx
	private static final String CHART_LBL_AYX = "Зависимость Ayx. от паровой нагрузки";
	private static final String CHART_Y_AYX = "Aух.";
	private static final String PANE_LBL_AYX_G = "Зависимость коэффициента избытка воздуха в уходящих газах (Aух.) от тепловой нагрузки на котел (DK) при работе на газе";
	private static final String PANE_LBL_AYX_M = "Зависимость коэффициента избытка воздуха в уходящих газах (Aух.) от тепловой нагрузки на котел (DK) при работе на мазуте";
	
	//apc
	private static final String CHART_LBL_APC = "Зависимость Apc. от паровой нагрузки";
	private static final String CHART_Y_APC = "Apc.";
	private static final String PANE_LBL_APC_G = "Зависимость коэффициента избытка воздуха в режимном сечении (Apc.) от тепловой нагрузки на котел (DK) при работе на газе";
	private static final String PANE_LBL_APC_M = "Зависимость коэффициента избытка воздуха в режимном сечении (Apc.) от тепловой нагрузки на котел (DK) при работе на мазуте";
	
	public static void addBoilerInfo(Boiler b, VBox vbox) {
		vbox.getChildren().add(new RegressionPane(b.getQ2_regression().getRegressionFunction(BoilerStates.ON_GAS), BoilerStates.ON_GAS, CHART_LBL_Q2, CHART_Y_Q2, PANE_LBL_Q2_G));
		vbox.getChildren().add(new RegressionPane(b.getQ2_regression().getRegressionFunction(BoilerStates.ON_MAZ), BoilerStates.ON_MAZ, CHART_LBL_Q2, CHART_Y_Q2, PANE_LBL_Q2_M));
		
		//vbox.getChildren().add(new RegressionPane(b.getQ5_regression().getRegressionFunction(BoilerStates.ON_GAS), BoilerStates.ON_GAS, CHART_LBL_Q5, CHART_Y_Q5, PANE_LBL_Q5_G));
		//vbox.getChildren().add(new RegressionPane(b.getQ5_regression().getRegressionFunction(BoilerStates.ON_MAZ), BoilerStates.ON_MAZ, CHART_LBL_Q5, CHART_Y_Q5, PANE_LBL_Q5_M));
		/*
		vbox.getChildren().add(new RegressionPane(b.getTyx_regression().getRegressionFunction(BoilerStates.ON_GAS), BoilerStates.ON_GAS, CHART_LBL_TYX, CHART_Y_TYX, PANE_LBL_TYX_G));
		vbox.getChildren().add(new RegressionPane(b.getTyx_regression().getRegressionFunction(BoilerStates.ON_MAZ), BoilerStates.ON_MAZ, CHART_LBL_TYX, CHART_Y_TYX, PANE_LBL_TYX_M));
		
		vbox.getChildren().add(new RegressionPane(b.getAyx_regression().getRegressionFunction(BoilerStates.ON_GAS), BoilerStates.ON_GAS, CHART_LBL_AYX, CHART_Y_AYX, PANE_LBL_AYX_G));
		vbox.getChildren().add(new RegressionPane(b.getAyx_regression().getRegressionFunction(BoilerStates.ON_MAZ), BoilerStates.ON_MAZ, CHART_LBL_AYX, CHART_Y_AYX, PANE_LBL_AYX_M));
		
		vbox.getChildren().add(new RegressionPane(b.getApc_regression().getRegressionFunction(BoilerStates.ON_GAS), BoilerStates.ON_GAS, CHART_LBL_APC, CHART_Y_APC, PANE_LBL_APC_G));
		vbox.getChildren().add(new RegressionPane(b.getApc_regression().getRegressionFunction(BoilerStates.ON_MAZ), BoilerStates.ON_MAZ, CHART_LBL_APC, CHART_Y_APC, PANE_LBL_APC_M));
		*/
		vbox.setPrefHeight(700);
	}
	
}
