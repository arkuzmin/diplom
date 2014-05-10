package ru.arkuzmin.diplom.optimization.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerWorkMaps;
import ru.arkuzmin.diplom.optimization.math.dto.Decision;
import ru.arkuzmin.diplom.optimization.mco.MultiCriteriaOptimization;
import ru.arkuzmin.diplom.optimization.ui.BoilerPaneManager;
import ru.arkuzmin.diplom.optimization.ui.DecisionManager;
import ru.arkuzmin.diplom.optimization.ui.DecisionSearchTab;
import ru.arkuzmin.diplom.optimization.ui.RelativeImportanceManager;
import ru.arkuzmin.diplom.optimization.utils.UIManager;

import com.sun.javafx.scene.control.skin.ProgressIndicatorSkin;

public class MainViewController implements Initializable {

	private RelativeImportanceManager rim;
	
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
	
	@FXML
	Label bGasLbl;
	@FXML
	Label bMazLbl;
	@FXML
	Label FLbl;
	@FXML
	Label KPDLbl;
	
	@FXML 
	Label b1DKLbl;
	@FXML
	Label b1StateLbl;
	@FXML
	Label b1FuelLbl;
	@FXML
	Label b1PercLbl;
	
	@FXML 
	Label b2DKLbl;
	@FXML
	Label b2StateLbl;
	@FXML
	Label b2FuelLbl;
	@FXML
	Label b2PercLbl;
	
	@FXML 
	Label b3DKLbl;
	@FXML
	Label b3StateLbl;
	@FXML
	Label b3FuelLbl;
	@FXML
	Label b3PercLbl;
	
	@FXML 
	Label b4DKLbl;
	@FXML
	Label b4StateLbl;
	@FXML
	Label b4FuelLbl;
	@FXML
	Label b4PercLbl;
	
	@FXML 
	Label b5DKLbl;
	@FXML
	Label b5StateLbl;
	@FXML
	Label b5FuelLbl;
	@FXML
	Label b5PercLbl;
	
	@FXML 
	Label b6DKLbl;
	@FXML
	Label b6StateLbl;
	@FXML
	Label b6FuelLbl;
	@FXML
	Label b6PercLbl;
	
	@FXML 
	Tab decisionTab;
	
	@FXML 
	ProgressBar b1Progress;
	@FXML 
	ProgressBar b2Progress;
	@FXML 
	ProgressBar b3Progress;
	@FXML 
	ProgressBar b4Progress;
	@FXML 
	ProgressBar b5Progress;
	@FXML 
	ProgressBar b6Progress;
	
	@FXML
	Label commonDK;
	
	@FXML
	TabPane mainTabPane;
	
	@FXML
	Tab modeTab;
	
	@FXML
	Tab optTab;
	
	Tab dt;
	
	@FXML
	RadioButton optGasRadio;
	@FXML
	Slider optGasMazSl;
	@FXML
	TextField optGasMazTxt;
	@FXML
	Slider optGasFSl;
	@FXML
	TextField optGasFTxt;
	@FXML
	Slider optGasKPDSl;
	@FXML
	TextField optGasKPDTxt;
	
	@FXML
	RadioButton optMazRadio;
	@FXML
	Slider optMazGasSl;
	@FXML
	TextField optMazGasTxt;
	@FXML
	Slider optMazFSl;
	@FXML
	TextField optMazFTxt;
	@FXML
	Slider optMazKPDSl;
	@FXML
	TextField optMazKPDTxt;
	
	@FXML
	RadioButton optFRadio;
	@FXML
	Slider optFGasSl;
	@FXML
	TextField optFGasTxt;
	@FXML
	Slider optFMazSl;
	@FXML
	TextField optFMazTxt;
	@FXML
	Slider optFKPDSl;
	@FXML
	TextField optFKPDTxt;
	
	@FXML
	RadioButton optKPDRadio;
	@FXML
	Slider optKPDGasSl;
	@FXML
	TextField optKPDGasTxt;
	@FXML
	Slider optKPDFSl;
	@FXML
	TextField optKPDFTxt;
	@FXML
	Slider optKPDMazSl;
	@FXML
	TextField optKPDMazTxt;
	
	@FXML
	CheckBox optRelImpChckBox;
	
	@FXML 
	TextField optDKTxt;
	@FXML 
	TextField optGasCostTxt;
	@FXML 
	TextField optMazCostTxt;
	
	@FXML
	BorderPane riPane;
	
	@FXML
	Pane riGasPane;
	@FXML
	Pane riMazPane;
	@FXML
	Pane riFPane;
	@FXML
	Pane riKPDPane;
	
	
	public void solve() {
		logArea.clear();
		dt = new DecisionSearchTab();
		mainTabPane.getTabs().add(dt);
		mainTabPane.getSelectionModel().select(dt);
		modeTab.setDisable(true);
		optTab.setDisable(true);
		btnSolve.setDisable(true);
		chckFullLogging.setDisable(true);
		progress.setProgress(0.0);
		decisionTab.setDisable(true);
		
		double mult;
		double gcost = Double.parseDouble(optGasCostTxt.getText());
		double mcost = Double.parseDouble(optMazCostTxt.getText());
		double dk = Double.parseDouble(optDKTxt.getText());
		mult = mcost > gcost ? gcost : mcost;
		
		MultiCriteriaOptimization mco = new MultiCriteriaOptimization(rim.getRIMess(), gcost / mult, mcost / mult, dk);
		mco.setCostMult(mult);
		//MultiCriteriaOptimization mco = new MultiCriteriaOptimization(null, 1, 1.85, dk);

		UIManager uiManager = new UIManager(chckFullLogging.isSelected());
		uiManager.initLogArea(logArea);
		uiManager.initProgress(progress);
		
		mco.initUIManager(uiManager);
		mco.setPrecision(0.1, 50);
		
		DecisionManager dm = new DecisionManager(bGasLbl, bMazLbl, FLbl, KPDLbl, b1DKLbl, b1StateLbl, b1FuelLbl, b1PercLbl, b2DKLbl, b2StateLbl, b2FuelLbl, b2PercLbl, b3DKLbl, b3StateLbl, b3FuelLbl, b3PercLbl, b4DKLbl, b4StateLbl, b4FuelLbl, b4PercLbl, b5DKLbl, b5StateLbl, b5FuelLbl, b5PercLbl, b6DKLbl, b6StateLbl, b6FuelLbl, b6PercLbl, b1Progress, b2Progress, b3Progress, b4Progress, b5Progress, b6Progress, commonDK);
		Thread t = new Solver(mco, dm, decisionTab, mainTabPane);
		t.start();
	}
	
	class UIModifier extends Thread {
		private DecisionManager manager;
		private Decision d;
		
		public UIModifier (Decision d, DecisionManager manager) {
			this.d = d;
			this.manager = manager;
		}
		
		@Override
		public void run() {
			manager.setDecision(d);
			decisionTab.setDisable(false);
			mainTabPane.getSelectionModel().select(decisionTab);
			modeTab.setDisable(false);
			optTab.setDisable(false);
			btnSolve.setDisable(false);
			chckFullLogging.setDisable(false);
			mainTabPane.getTabs().remove(dt);
		}
	}
	
	class Solver extends Thread {
		
		private DecisionManager manager;
		private MultiCriteriaOptimization mco;

		public Solver (MultiCriteriaOptimization mco, DecisionManager manager, Tab decisionTab, TabPane mainTabPane) {
			this.mco = mco;
			this.manager = manager;
		}
		
		@Override
		public void run() {
			Decision d = mco.solve();
			Platform.runLater(new UIModifier(d, manager));	
		}
	}
	
	public void useRelativeImportance() {
		rim.useRelativeImportance();
	}
	
	public void useGasRI() {
		rim.useGasRI();
	}
	
	public void useMazRI() {
		rim.useMazRI();
	}
	
	public void useFRI() {
		rim.useFRI();
	}
	
	public void useKPDRI() {
		rim.useKPDRI();
	}
	
	public void setGasMazRiTxt() {
		rim.setGasMazRiTxt();
	}
	public void setGasMazRiSl() {
		rim.setGasMazRiSl();
	}
	public void setGasFRiTxt() {
		rim.setGasFRiTxt();
	}
	public void setGasFRiSl() {
		rim.setGasFRiSl();
	}
	public void setGasKPDRiTxt() {
		rim.setGasKPDRiTxt();
	}
	public void setGasKPDRiSl() {
		rim.setGasKPDRiSl();
	}
	
	//
	public void setMazGasRiTxt() {
		rim.setMazGasRiTxt();
	}
	public void setMazGasRiSl() {
		rim.setMazGasRiSl();
	}
	public void setMazFRiTxt() {
		rim.setMazFRiTxt();
	}
	public void setMazFRiSl() {
		rim.setMazFRiSl();
	}
	public void setMazKPDRiTxt() {
		rim.setMazKPDRiTxt();
	}
	public void setMazKPDRiSl() {
		rim.setMazKPDRiSl();
	}
	
	//
	public void setFMazRiTxt() {
		rim.setFMazRiTxt();
	}
	public void setFMazRiSl() {
		rim.setFMazRiSl();
	}
	public void setFGasRiTxt() {
		rim.setFGasRiTxt();
	}
	public void setFGasRiSl() {
		rim.setFGasRiSl();
	}
	public void setFKPDRiTxt() {
		rim.setFKPDRiTxt();
	}
	public void setFKPDRiSl() {
		rim.setFKPDRiSl();
	}
	
	//
	public void setKPDMazRiTxt() {
		rim.setKPDMazRiTxt();
	}
	public void setKPDMazRiSl() {
		rim.setKPDMazRiSl();
	}
	public void setKPDFRiTxt() {
		rim.setKPDFRiTxt();
	}
	public void setKPDFRiSl() {
		rim.setKPDFRiSl();
	}
	public void setKPDGasRiTxt() {
		rim.setKPDGasRiTxt();
	}
	public void setKPDGasRiSl() {
		rim.setKPDGasRiSl();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB1(), b1DKMin, b1DKMax, b1q2VBox, b1q5VBox, b1tyxVBox, b1ayxVBox, b1apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB2(), b2DKMin, b2DKMax, b2q2VBox, b2q5VBox, b2tyxVBox, b2ayxVBox, b2apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB3(), b3DKMin, b3DKMax, b3q2VBox, b3q5VBox, b3tyxVBox, b3ayxVBox, b3apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB4(), b4DKMin, b4DKMax, b4q2VBox, b4q5VBox, b4tyxVBox, b4ayxVBox, b4apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB5(), b5DKMin, b5DKMax, b5q2VBox, b5q5VBox, b5tyxVBox, b5ayxVBox, b5apcVBox);
		BoilerPaneManager.addBoilerInfo(BoilerWorkMaps.getB6(), b6DKMin, b6DKMax, b6q2VBox, b6q5VBox, b6tyxVBox, b6ayxVBox, b6apcVBox);
	
		ProgressIndicatorSkin indicatorSkin = new ProgressIndicatorSkin(progress);
		final Text text = (Text) indicatorSkin.lookup(".percentage");
		progress.progressProperty().addListener(new ChangeListener<Number>() {
		    @Override
		    public void changed(ObservableValue<? extends Number> ov, Number t, Number newValue) {
		        // If progress is 100% then show Text
		        if (newValue.doubleValue() >= 1) {
		            // This text replaces "Done"
		            text.setText("Решение найдено!");
		        }
		    }
		});
		progress.skinProperty().set(indicatorSkin);
		
		rim = new RelativeImportanceManager(optGasRadio, optGasMazSl, optGasMazTxt, optGasFSl, optGasFTxt, optGasKPDSl, optGasKPDTxt, optMazRadio, optMazGasSl, optMazGasTxt, optMazFSl, optMazFTxt, optMazKPDSl, optMazKPDTxt, optFRadio, optFGasSl, optFGasTxt, optFMazSl, optFMazTxt, optFKPDSl, optFKPDTxt, optKPDRadio, optKPDGasSl, optKPDGasTxt, optKPDFSl, optKPDFTxt, optKPDMazSl, optKPDMazTxt, optRelImpChckBox, riPane, riGasPane, riMazPane, riFPane, riKPDPane);
	}

}
