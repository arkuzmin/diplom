package ru.arkuzmin.diplom.optimization.fx;

import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import ru.arkuzmin.diplom.optimization.math.regression.IRegressionFunction;

/**
 * Адаптер для графиков javaFX.
 * @author ArKuzmin
 *
 */
public class FXUtils {

	IRegressionFunction regression;
	
	public FXUtils(IRegressionFunction regression) {
		this.regression = regression;
	}
	
	public ObservableList<RegressionDTO> getTableData() {
		ObservableList<RegressionDTO> list = FXCollections.observableArrayList();
		for (int i = 0; i < regression.getPointsNum(); i++) {
			double x = regression.getXForPoint(i);
			double y = regression.getY(x);
			RegressionDTO rdto = new RegressionDTO(x, y);
			list.add(rdto);
		}
		return list;
	}
	
	public NumberAxis getYAxis() {
		double max = 0.0;
		double min = regression.getActualY(regression.getXForPoint(0));
		for (int i = 0; i < regression.getPointsNum(); i++) {
			double y = regression.getY(regression.getXForPoint(i));
			double ay = regression.getActualY(regression.getXForPoint(i));
			if (y > max) {
				max = y;
			}
			if (ay > max) {
				max = ay;
			}
			if (y < min) {
				min = y;
			}
			if (ay < min) {
				min = ay;
			}
		}
		double step;
		if (max - min <= 0.001) {
			step = max / regression.getPointsNum();
		} else {
			step = (max - min) / (double)(2 * regression.getPointsNum());
		}
		
		NumberAxis yAxis = new NumberAxis(min - step, max + step, step);
		return yAxis;
	}
	
	public NumberAxis getXAxis() {
		double max = 0.0;
		double min = regression.getXForPoint(0);
		for (int i = 0; i < regression.getPointsNum(); i++) {
			double x = regression.getXForPoint(i);
			if (x > max) {
				max = x;
			}
			if (x < min) {
				min = x;
			}
		}
		double step = (max - min) / (double)(2 * regression.getPointsNum());
		NumberAxis xAxis = new NumberAxis(min - step, max + step, step);
		return xAxis;
	}
	
	public List<Series<Number, Number>> getSeries() {
		Series<Number, Number> actual = new Series<Number, Number>();
		actual.setName("Реальные значения");
		Series<Number, Number> interp = new Series<Number, Number>();
		interp.setName("Интерполяция");
		
		List<Series<Number, Number>> sList = new LinkedList<Series<Number, Number>>();
		sList.add(actual);
		sList.add(interp);
		
		for (int i = 0; i < regression.getPointsNum(); i++) {
			double x = regression.getXForPoint(i);
			double actY = regression.getActualY(x);
			double y = regression.getY(x);
			
			actual.getData().add(new XYChart.Data<Number,Number>(x, y));
			interp.getData().add(new XYChart.Data<Number,Number>(x, actY));
		}
		
		return sList;
	}
}
