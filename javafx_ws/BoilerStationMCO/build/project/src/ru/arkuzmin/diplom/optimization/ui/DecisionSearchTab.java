package ru.arkuzmin.diplom.optimization.ui;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class DecisionSearchTab extends Tab {

	public DecisionSearchTab() {
		super();
		this.setContent(getPane());
		this.setText("Поиск решения");	
	}
	
	private Pane getPane() {
		Pane p = new Pane();
		p.setPrefWidth(1000);
		p.setPrefHeight(445);
		p.getChildren().add(getProgressInd());
		p.getChildren().add(getLbl());
		
		return p;
	}
	
	private Label getLbl() {
		Label lbl = new Label();
		lbl.setText("Поиск решения...");
		lbl.setFont(new Font("System Bold", 16));
		lbl.setLayoutX(437);
		lbl.setLayoutY(211);
		
		return lbl;
	}
	
	private ProgressIndicator getProgressInd() {
		ProgressIndicator pi = new ProgressIndicator(-0.3);
		pi.setPrefHeight(350);
		pi.setPrefWidth(350);
		pi.setLayoutX(325);
		pi.setLayoutY(48);
		return pi;
	}
}
