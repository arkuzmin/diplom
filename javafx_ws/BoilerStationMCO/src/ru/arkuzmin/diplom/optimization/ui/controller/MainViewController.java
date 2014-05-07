package ru.arkuzmin.diplom.optimization.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerWorkMaps;
import ru.arkuzmin.diplom.optimization.mco.MultiCriteriaOptimization;
import ru.arkuzmin.diplom.optimization.ui.BoilerPaneManager;
import ru.arkuzmin.diplom.optimization.utils.UIManager;

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
	
	// b1
	@FXML
	TextField b1DKMin;
	@FXML
	TextField b1DKMax;
	@FXML
	VBox b1q2VBox;
	@FXML
	VBox b1q5VBox;
	@FXML
	VBox b1tyxVBox;
	@FXML
	VBox b1ayxVBox;
	@FXML
	VBox b1apcVBox;
	
	// b2
	@FXML
	TextField b2DKMin;
	@FXML
	TextField b2DKMax;
	@FXML
	VBox b2q2VBox;
	@FXML
	VBox b2q5VBox;
	@FXML
	VBox b2tyxVBox;
	@FXML
	VBox b2ayxVBox;
	@FXML
	VBox b2apcVBox;
	
	// b3
	@FXML
	TextField b3DKMin;
	@FXML
	TextField b3DKMax;
	@FXML
	VBox b3q2VBox;
	@FXML
	VBox b3q5VBox;
	@FXML
	VBox b3tyxVBox;
	@FXML
	VBox b3ayxVBox;
	@FXML
	VBox b3apcVBox;
	
	// b4
	@FXML
	TextField b4DKMin;
	@FXML
	TextField b4DKMax;
	@FXML
	VBox b4q2VBox;
	@FXML
	VBox b4q5VBox;
	@FXML
	VBox b4tyxVBox;
	@FXML
	VBox b4ayxVBox;
	@FXML
	VBox b4apcVBox;
	
	// b5
	@FXML
	TextField b5DKMin;
	@FXML
	TextField b5DKMax;
	@FXML
	VBox b5q2VBox;
	@FXML
	VBox b5q5VBox;
	@FXML
	VBox b5tyxVBox;
	@FXML
	VBox b5ayxVBox;
	@FXML
	VBox b5apcVBox;
	
	// b6
	@FXML
	TextField b6DKMin;
	@FXML
	TextField b6DKMax;
	@FXML
	VBox b6q2VBox;
	@FXML
	VBox b6q5VBox;
	@FXML
	VBox b6tyxVBox;
	@FXML
	VBox b6ayxVBox;
	@FXML
	VBox b6apcVBox;
	
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
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB1(), b1DKMin, b1DKMax, b1q2VBox, b1q5VBox, b1tyxVBox, b1ayxVBox, b1apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB2(), b2DKMin, b2DKMax, b2q2VBox, b2q5VBox, b2tyxVBox, b2ayxVBox, b2apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB3(), b3DKMin, b3DKMax, b3q2VBox, b3q5VBox, b3tyxVBox, b3ayxVBox, b3apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB4(), b4DKMin, b4DKMax, b4q2VBox, b4q5VBox, b4tyxVBox, b4ayxVBox, b4apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB5(), b5DKMin, b5DKMax, b5q2VBox, b5q5VBox, b5tyxVBox, b5ayxVBox, b5apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB6(), b6DKMin, b6DKMax, b6q2VBox, b6q5VBox, b6tyxVBox, b6ayxVBox, b6apcVBox);
	}

}
