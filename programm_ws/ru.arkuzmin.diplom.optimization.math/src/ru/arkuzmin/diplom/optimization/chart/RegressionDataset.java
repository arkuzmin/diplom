package ru.arkuzmin.diplom.optimization.chart;

import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;

import ru.arkuzmin.diplom.optimization.math.regression.CubicalRegressionFunction;

public class RegressionDataset extends AbstractXYDataset implements XYDataset {

	private final CubicalRegressionFunction regression;
	
	
	public RegressionDataset(final CubicalRegressionFunction regression) {
		this.regression = regression;
	}
	
	private static final long serialVersionUID = -5725699712220493194L;

	@Override
	public int getItemCount(int series) {
		return regression.getPointsNum();
	}

	@Override
	public Number getX(int series, int point) {
		return regression.getXForPoint(point);
	}

	@Override
	public Number getY(int series, int point) {
		if (series == 0) {
			return regression.getY(regression.getXForPoint(point));
		}
		return regression.getActualY(regression.getXForPoint(point));
	}

	@Override
	public int getSeriesCount() {
		return 2;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Comparable getSeriesKey(int series) {
		if (series == 0) {
			return "Реальные значения";
		}
		return "Аппроксимация";
	}
}
