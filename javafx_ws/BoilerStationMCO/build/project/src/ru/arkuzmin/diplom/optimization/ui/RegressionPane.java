package ru.arkuzmin.diplom.optimization.ui;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import ru.arkuzmin.diplom.optimization.common.Globals;
import ru.arkuzmin.diplom.optimization.fx.FXUtils;
import ru.arkuzmin.diplom.optimization.fx.RegressionDTO;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;
import ru.arkuzmin.diplom.optimization.math.regression.IRegressionFunction;

public class RegressionPane extends BorderPane {

	FXUtils fxs;
	private String chartName;
	private String paneName;
	private String yLbl;
	private IRegressionFunction regression;
	
	public RegressionPane(IRegressionFunction regression, BoilerStates state, String chartName, String yLbl, String paneName)	{
		super();
		this.getStylesheets().add(RegressionPane.class.getResource(Globals.CSS_STYLES).toExternalForm());
		if (BoilerStates.ON_GAS.equals(state)) {
			getStyleClass().add("bordered-pane-gas");
		} else if (BoilerStates.ON_MAZ.equals(state)) {
			getStyleClass().add("bordered-pane-maz");
		}
		
		this.setPrefWidth(990);
		this.setPrefHeight(500);
		this.chartName = chartName;
		this.paneName = paneName;
		this.yLbl = yLbl;
		this.regression = regression;
		this.fxs = new FXUtils(regression);
		initPane();
	}
	
	private void initPane() {
		this.setRight(createChart());
		this.setCenter(createTableBPane());
		this.setTop(createPaneLbl());
		
		setMargin(this.getRight(), new Insets(10));
		setMargin(this.getTop(), new Insets(0, 0, 0, 10));

	}
	
	private Label createPaneLbl() {
		Label lbl = new Label();
		lbl.setText(paneName);
		lbl.setFont(new Font("System Bold", 12.0));
		lbl.setPrefHeight(15);
		return lbl;
	}
	
	private BorderPane createTableBPane() {
		BorderPane bPane = new BorderPane();
		bPane.setCenter(createTable());
		bPane.setBottom(createRegressionLbl());
		setMargin(bPane.getBottom(), new Insets(0, 0, 0, 10));
		setMargin(bPane.getCenter(), new Insets(10));
		return bPane;
	}
	
	private Label createRegressionLbl() {
		Label lbl = new Label();
		lbl.setText(regression.toString());
		lbl.setFont(new Font("System Bold", 12.0));
		lbl.setPrefHeight(15);
		return lbl;
	}
	
	@SuppressWarnings("unchecked")
	private TableView<RegressionDTO> createTable() {
		TableView<RegressionDTO> tableView = new TableView<RegressionDTO>();
		tableView.setItems(fxs.getTableData());
		TableColumn<RegressionDTO, Double> dkCol = new TableColumn<RegressionDTO, Double>("DK [т/час]");
		dkCol.setCellValueFactory(new PropertyValueFactory<RegressionDTO, Double>("x"));
		TableColumn<RegressionDTO, Double> yCol = new TableColumn<RegressionDTO, Double>(yLbl);
		yCol.setCellValueFactory(new PropertyValueFactory<RegressionDTO, Double>("y"));
		
		dkCol.prefWidthProperty().bind(tableView.widthProperty().divide(2.01));
		dkCol.setResizable(false);
		yCol.prefWidthProperty().bind(tableView.widthProperty().divide(2.01));
		yCol.setResizable(false);
		
		tableView.getColumns().addAll(dkCol, yCol);
		return tableView;
	}
	
	private LineChart<Number, Number> createChart() {
		final NumberAxis xAxis = fxs.getXAxis();
        final NumberAxis yAxis = fxs.getYAxis();

        yAxis.setLabel(yLbl);
        xAxis.setLabel("Паровая нагрузка на котел [т/час]");
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setAnimated(true);
        lineChart.setLegendSide(Side.RIGHT);
        lineChart.setLegendVisible(true);
        lineChart.setTitle(chartName);
        
        List<Series<Number, Number>> sList = fxs.getSeries();
        for (Series<Number, Number> s : sList) {
        	lineChart.getData().add(s);
        }
        
        return lineChart;
	}
}
