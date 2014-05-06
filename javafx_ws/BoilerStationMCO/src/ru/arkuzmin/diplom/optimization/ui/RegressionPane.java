package ru.arkuzmin.diplom.optimization.ui;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import ru.arkuzmin.diplom.optimization.fx.FXUtils;
import ru.arkuzmin.diplom.optimization.fx.RegressionDTO;
import ru.arkuzmin.diplom.optimization.math.regression.IRegressionFunction;

public class RegressionPane extends BorderPane {

	FXUtils fxs;
	private String chartName;
	private String yLbl;
	
	public RegressionPane(IRegressionFunction regression, String chartName, String yLbl)	{
		super();
		this.setPrefWidth(990);
		this.setPrefHeight(300);
		this.chartName = chartName;
		this.yLbl = yLbl;
		this.fxs = new FXUtils(regression);
		initPane();
	}
	
	private void initPane() {
		this.setRight(createChart(yLbl, chartName));
		this.setLeft(createTable());
		setMargin(this.getLeft(), new Insets(10));
		setMargin(this.getRight(), new Insets(10));
		//setMargin(this.getCenter(), new Insets(10));
	}
	
	private TableView<RegressionDTO> createTable() {
		TableView<RegressionDTO> tableView = new TableView();
		tableView.setItems(fxs.getTableData());
		TableColumn<RegressionDTO, Double> dkCol = new TableColumn<RegressionDTO, Double>("DK [т/час]");
		dkCol.setCellValueFactory(new PropertyValueFactory<RegressionDTO, Double>("x"));
		TableColumn<RegressionDTO, Double> yCol = new TableColumn<RegressionDTO, Double>("y");
		yCol.setCellValueFactory(new PropertyValueFactory<RegressionDTO, Double>("y"));
		tableView.getColumns().addAll(dkCol, yCol);
		tableView.setPrefWidth(150);
		return tableView;
	}
	
	private LineChart<Number, Number> createChart(String yLbl, String chartName) {
		final NumberAxis xAxis = fxs.getXAxis();
        final NumberAxis yAxis = fxs.getYAxis();

        yAxis.setLabel(yLbl);
        xAxis.setLabel("Паровая нагрузка на котел [т/час]");
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setAnimated(true);
        lineChart.setLegendSide(Side.BOTTOM);
        lineChart.setLegendVisible(true);
        lineChart.setTitle(chartName);
        
        List<Series<Number, Number>> sList = fxs.getSeries();
        for (Series<Number, Number> s : sList) {
        	lineChart.getData().add(s);
        }
        
        return lineChart;
	}
}
