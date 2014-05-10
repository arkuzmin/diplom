package ru.arkuzmin.diplom.optimization.ui;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import ru.arkuzmin.diplom.optimization.math.pareto.RelativeImportance;
import ru.arkuzmin.diplom.optimization.math.pareto.RelativeImportanceMessage;

public class RelativeImportanceManager {

	private RadioButton optGasRadio;
	private Slider optGasMazSl;
	private TextField optGasMazTxt;
	private Slider optGasFSl;
	private TextField optGasFTxt;
	private Slider optGasKPDSl;
	private TextField optGasKPDTxt;
	
	private RadioButton optMazRadio;
	private Slider optMazGasSl;
	private TextField optMazGasTxt;
	private Slider optMazFSl;
	private TextField optMazFTxt;
	private Slider optMazKPDSl;
	private TextField optMazKPDTxt;
	
	private RadioButton optFRadio;
	private Slider optFGasSl;
	private TextField optFGasTxt;
	private Slider optFMazSl;
	private TextField optFMazTxt;
	private Slider optFKPDSl;
	private TextField optFKPDTxt;
	
	private RadioButton optKPDRadio;
	private Slider optKPDGasSl;
	private TextField optKPDGasTxt;
	private Slider optKPDFSl;
	private TextField optKPDFTxt;
	private Slider optKPDMazSl;
	private TextField optKPDMazTxt;
	
	private CheckBox optRelImpChckBox;
	
	private BorderPane riPane;
	private Pane riGasPane;
	private Pane riMazPane;
	private Pane riFPane;
	private Pane riKPDPane;
	
	private double gmri;
	private double gfri;
	private double gkpdri;
	
	private double mgri;
	private double mfri;
	private double mkpdri;
	
	private double fgri;
	private double fmri;
	private double fkpdri;
	
	private double kpdgri;
	private double kpdmri;
	private double kpdfri;
	
	public RelativeImportanceManager(RadioButton optGasRadio, Slider optGasMazSl, TextField optGasMazTxt, Slider optGasFSl,	TextField optGasFTxt, Slider optGasKPDSl, TextField optGasKPDTxt, 
									 RadioButton optMazRadio, Slider optMazGasSl, TextField optMazGasTxt, Slider optMazFSl, TextField optMazFTxt, Slider optMazKPDSl, TextField optMazKPDTxt,
									 RadioButton optFRadio,	Slider optFGasSl, TextField optFGasTxt,	Slider optFMazSl, TextField optFMazTxt,	Slider optFKPDSl, TextField optFKPDTxt,									 	
									 RadioButton optKPDRadio, Slider optKPDGasSl, TextField optKPDGasTxt, Slider optKPDFSl,	TextField optKPDFTxt, Slider optKPDMazSl, TextField optKPDMazTxt,	
									 CheckBox optRelImpChckBox,	BorderPane riPane, Pane riGasPane, Pane riMazPane, Pane riFPane, Pane riKPDPane) {
	
		this.optGasRadio = optGasRadio;
		this.optGasMazSl = optGasMazSl;
		this.optGasMazTxt = optGasMazTxt;
		this.optGasFSl = optGasFSl;
		this.optGasFTxt = optGasFTxt;
		this.optGasKPDSl = optGasKPDSl;
		this.optGasKPDTxt = optGasKPDTxt;
		
		this.optMazRadio = optMazRadio;
		this.optMazGasSl = optMazGasSl;
		this.optMazGasTxt = optMazGasTxt;
		this.optMazFSl = optMazFSl;
		this.optMazFTxt = optMazFTxt;
		this.optMazKPDSl = optMazKPDSl;
		this.optMazKPDTxt = optMazKPDTxt;
		
		this.optKPDRadio = optKPDRadio;
		this.optKPDMazSl = optKPDMazSl;
		this.optKPDMazTxt = optKPDMazTxt;
		this.optKPDFSl = optKPDFSl;
		this.optKPDFTxt = optKPDFTxt;
		this.optKPDGasSl = optKPDGasSl;
		this.optKPDGasTxt = optKPDGasTxt;
		
		this.optFRadio = optFRadio;
		this.optFMazSl = optFMazSl;
		this.optFMazTxt = optFMazTxt;
		this.optFGasSl = optFGasSl;
		this.optFGasTxt = optFGasTxt;
		this.optFKPDSl = optFKPDSl;
		this.optFKPDTxt = optFKPDTxt;
		
		this.optRelImpChckBox = optRelImpChckBox;

		this.riPane = riPane;
		this.riGasPane = riGasPane;
		this.riMazPane = riMazPane;
		this.riFPane = riFPane;
		this.riKPDPane = riKPDPane;
		
		init();
		
	}
	
	private void init() {
		optRelImpChckBox.setSelected(false);
		riPane.setDisable(true);
		riGasPane.setDisable(false);
		riMazPane.setDisable(true);
		riFPane.setDisable(true);
		riKPDPane.setDisable(true);
	}
	
	private void selectGasRadio() {
		optGasRadio.setSelected(true);
		riGasPane.setDisable(false);
		
		optMazRadio.setSelected(false);
		riMazPane.setDisable(true);
		optFRadio.setSelected(false);
		riFPane.setDisable(true);
		optKPDRadio.setSelected(false);
		riKPDPane.setDisable(true);
	}
	
	private void selectMazRadio() {
		optMazRadio.setSelected(true);
		riMazPane.setDisable(false);
		
		optGasRadio.setSelected(false);
		riGasPane.setDisable(true);
		optFRadio.setSelected(false);
		riFPane.setDisable(true);
		optKPDRadio.setSelected(false);
		riKPDPane.setDisable(true);
	}
	
	private void selectFRadio() {
		optFRadio.setSelected(true);
		riFPane.setDisable(false);
		
		optGasRadio.setSelected(false);
		riGasPane.setDisable(true);
		optMazRadio.setSelected(false);
		riMazPane.setDisable(true);
		optKPDRadio.setSelected(false);
		riKPDPane.setDisable(true);
	}
	
	private void selectKPDRadio() {
		optKPDRadio.setSelected(true);
		riKPDPane.setDisable(false);
		
		optGasRadio.setSelected(false);
		riGasPane.setDisable(true);
		optFRadio.setSelected(false);
		riFPane.setDisable(true);
		optMazRadio.setSelected(false);
		riMazPane.setDisable(true);
	}
	
	public void useGasRI() {
		selectGasRadio();
	}
	
	public void useMazRI() {
		selectMazRadio();
	}
	
	public void useKPDRI() {
		selectKPDRadio();
	}
	
	public void useFRI() {
		selectFRadio();
	}
	
	public void setGasMazRiTxt() {
		optGasMazSl.setValue(Double.valueOf(optGasMazTxt.getText()));
		gmri = Double.valueOf(optGasMazTxt.getText());
	}
	public void setGasMazRiSl() {
		optGasMazTxt.setText(String.valueOf(optGasMazSl.getValue()));
		gmri = optGasMazSl.getValue();
	}
	public void setGasFRiTxt() {
		optGasFSl.setValue(Double.valueOf(optGasFTxt.getText()));
		gfri = Double.valueOf(optGasFTxt.getText());
	}
	public void setGasFRiSl() {
		optGasFTxt.setText(String.valueOf(optGasFSl.getValue()));
		gfri = optGasFSl.getValue();
	}
	public void setGasKPDRiTxt() {
		optGasKPDSl.setValue(Double.valueOf(optGasKPDTxt.getText()));
		gkpdri = Double.valueOf(optGasKPDTxt.getText());
	}
	public void setGasKPDRiSl() {
		optGasKPDTxt.setText(String.valueOf(optGasKPDSl.getValue()));
		gkpdri = optGasKPDSl.getValue();
	}
	
	//
	public void setMazGasRiTxt() {
		optMazGasSl.setValue(Double.valueOf(optMazGasTxt.getText()));
		mgri = Double.valueOf(optMazGasTxt.getText());
	}
	public void setMazGasRiSl() {
		optMazGasTxt.setText(String.valueOf(optMazGasSl.getValue()));
		mgri = optMazGasSl.getValue();
	}
	public void setMazFRiTxt() {
		optMazFSl.setValue(Double.valueOf(optMazFTxt.getText()));
		mfri = Double.valueOf(optMazFTxt.getText());
	}
	public void setMazFRiSl() {
		optMazFTxt.setText(String.valueOf(optMazFSl.getValue()));
		mfri = optMazFSl.getValue();
	}
	public void setMazKPDRiTxt() {
		optMazKPDSl.setValue(Double.valueOf(optMazKPDTxt.getText()));
		mkpdri = Double.valueOf(optMazKPDTxt.getText());
	}
	public void setMazKPDRiSl() {
		optMazKPDTxt.setText(String.valueOf(optMazKPDSl.getValue()));
		mkpdri = optMazKPDSl.getValue();
	}
	
	//
	public void setFGasRiTxt() {
		optFGasSl.setValue(Double.valueOf(optFGasTxt.getText()));
		fgri = Double.valueOf(optFGasTxt.getText());
	}
	public void setFGasRiSl() {
		optFGasTxt.setText(String.valueOf(optFGasSl.getValue()));
		fgri = optFGasSl.getValue();
	}
	public void setFMazRiTxt() {
		optFMazSl.setValue(Double.valueOf(optFMazTxt.getText()));
		fmri = Double.valueOf(optFMazTxt.getText());
	}
	public void setFMazRiSl() {
		optFMazTxt.setText(String.valueOf(optFMazSl.getValue()));
		fmri = optFMazSl.getValue();
	}
	public void setFKPDRiTxt() {
		optFKPDSl.setValue(Double.valueOf(optFKPDTxt.getText()));
		fkpdri = Double.valueOf(optFKPDTxt.getText());
	}
	public void setFKPDRiSl() {
		optFKPDTxt.setText(String.valueOf(optFKPDSl.getValue()));
		fkpdri = optFKPDSl.getValue();
	}
	
	//
	public void setKPDGasRiTxt() {
		optKPDGasSl.setValue(Double.valueOf(optKPDGasTxt.getText()));
		kpdgri = Double.valueOf(optKPDGasTxt.getText());
	}
	public void setKPDGasRiSl() {
		optKPDGasTxt.setText(String.valueOf(optKPDGasSl.getValue()));
		kpdgri = optKPDGasSl.getValue();
	}
	public void setKPDFRiTxt() {
		optKPDFSl.setValue(Double.valueOf(optKPDFTxt.getText()));
		kpdfri = Double.valueOf(optKPDFTxt.getText());
	}
	public void setKPDFRiSl() {
		optKPDFTxt.setText(String.valueOf(optKPDFSl.getValue()));
		kpdfri = optKPDFSl.getValue();
	}
	public void setKPDMazRiTxt() {
		optKPDMazSl.setValue(Double.valueOf(optKPDMazTxt.getText()));
		kpdmri = Double.valueOf(optKPDMazTxt.getText());
	}
	public void setKPDMazRiSl() {
		optKPDMazTxt.setText(String.valueOf(optKPDMazSl.getValue()));
		kpdmri = optKPDMazSl.getValue();
	}
	
	public void useRelativeImportance() {
		if (optRelImpChckBox.isSelected()) {
			riPane.setDisable(false);
		} else {
			riPane.setDisable(true);
		}
	}
	
	public RelativeImportanceMessage getRIMess() {
		if (!optRelImpChckBox.isSelected()) {
			return null;
		}
		
		List<RelativeImportance> koeffs = new LinkedList<RelativeImportance>();
		
		if (optGasRadio.isSelected()) {
			RelativeImportance ri1 = new RelativeImportance(gmri / 100, 0, 1);
			RelativeImportance ri2 = new RelativeImportance(gfri / 100, 0, 2);
			RelativeImportance ri3 = new RelativeImportance(gkpdri / 100, 0, 3);
			koeffs.add(ri1);
			koeffs.add(ri2);
			koeffs.add(ri3);
		} else if (optMazRadio.isSelected()) {
			RelativeImportance ri1 = new RelativeImportance(mgri / 100, 1, 0);
			RelativeImportance ri2 = new RelativeImportance(mfri / 100, 1, 2);
			RelativeImportance ri3 = new RelativeImportance(mkpdri / 100, 1, 3);
			koeffs.add(ri1);
			koeffs.add(ri2);
			koeffs.add(ri3);
		} else if (optFRadio.isSelected()) {
			RelativeImportance ri1 = new RelativeImportance(fgri / 100, 2, 0);
			RelativeImportance ri2 = new RelativeImportance(fmri / 100, 2, 1);
			RelativeImportance ri3 = new RelativeImportance(fkpdri / 100, 2, 3);
			koeffs.add(ri1);
			koeffs.add(ri2);
			koeffs.add(ri3);
		} else if (optKPDRadio.isSelected()) {
			RelativeImportance ri1 = new RelativeImportance(kpdgri / 100, 3, 0);
			RelativeImportance ri2 = new RelativeImportance(kpdmri / 100, 3, 1);
			RelativeImportance ri3 = new RelativeImportance(kpdfri / 100, 3, 2);
			koeffs.add(ri1);
			koeffs.add(ri2);
			koeffs.add(ri3);
		}
		
		RelativeImportanceMessage rim = new RelativeImportanceMessage(koeffs);
		return rim;
	}
	
}
