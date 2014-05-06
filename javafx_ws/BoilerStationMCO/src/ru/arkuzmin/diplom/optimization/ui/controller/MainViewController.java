package ru.arkuzmin.diplom.optimization.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerWorkMaps;
import ru.arkuzmin.diplom.optimization.mco.MultiCriteriaOptimization;
import ru.arkuzmin.diplom.optimization.ui.RegressionPane;
import ru.arkuzmin.diplom.optimization.utils.UIManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {

	@FXML
	ProgressIndicator progress;
	
	@FXML
	Button btnSolve;
	
	@FXML
	TextArea logArea;
	
	@FXML
	CheckBox chckFullLogging;
	
	@FXML 
	BorderPane b1q2Border;
	
	@FXML
	VBox b1VBox;
	
	
	public void solve() {
		MultiCriteriaOptimization mco = new MultiCriteriaOptimization(null, 1, 1.85, 638);
		UIManager uiManager = new UIManager(chckFullLogging.isSelected());
		uiManager.initLogArea(logArea);
		uiManager.initProgress(progress);
		
		mco.initUIManager(uiManager);
		mco.setPrecision(0.1, 50);
		Thread t = new Solver(mco);
		t.start();
	}
	
	class Solver extends Thread {
		
		private MultiCriteriaOptimization mco;
		
		public Solver (MultiCriteriaOptimization mco) {
			this.mco = mco;
		}
		
		@Override
		public void run() {
			mco.solve();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		b1VBox.getChildren().add(new RegressionPane(BoilerWorkMaps.getB1().getQ2_regression().getRegressionFunction(BoilerStates.ON_GAS), "Зависимость q2 от паровой нагрузки", "q2 [%]"));
	}

}
