package ru.arkuzmin.diplom.optimization.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ru.arkuzmin.diplom.optimization.mco.MultiCriteriaOptimization;
import ru.arkuzmin.diplom.optimization.utils.UIManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;

public class MainViewController implements Initializable {

	@FXML
	ProgressIndicator progress;
	
	@FXML
	Button btnSolve;
	
	@FXML
	TextArea logArea;
	
	@FXML
	CheckBox chckFullLogging;
	
	
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
	}

}
