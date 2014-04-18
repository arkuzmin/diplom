package ru.arkuzmin.diplom.optimization.ui.regression;

import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.function.PowerFunction2D;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.statistics.Regression;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.experimental.chart.swt.ChartComposite;

import swing2swt.layout.BorderLayout;

public class RegressionComposite  extends Composite {

	private final XYDataset dataset;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RegressionComposite(Composite parent, int style, XYDataset dataset) {
		super(parent, style);
		this.dataset = dataset;
		setLayout(new BorderLayout(0, 0));
		
		final JFreeChart chart = createChart("Operating Systems");  
		  
		new ChartComposite(parent, SWT.NONE, chart, true);  

	}
	
	private XYDataset createSampleData1()
	    {
	      XYSeries localXYSeries = new XYSeries("Series 1");
	      localXYSeries.add(2.0D, 56.270000000000003D);
	      localXYSeries.add(3.0D, 41.32D);
	      localXYSeries.add(4.0D, 31.449999999999999D);
	      localXYSeries.add(5.0D, 30.050000000000001D);
	      localXYSeries.add(6.0D, 24.690000000000001D);
	      localXYSeries.add(7.0D, 19.780000000000001D);
	      localXYSeries.add(8.0D, 20.940000000000001D);
	      localXYSeries.add(9.0D, 16.73D);
	      localXYSeries.add(10.0D, 14.210000000000001D);
	      localXYSeries.add(11.0D, 12.44D);
	      XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection(localXYSeries);
	      return localXYSeriesCollection;
	 }
	
	private JFreeChart createChart(final String title) {  
		  NumberAxis localNumberAxis1 = new NumberAxis("X");
	      localNumberAxis1.setAutoRangeIncludesZero(false);
	      NumberAxis localNumberAxis2 = new NumberAxis("Y");
	      localNumberAxis2.setAutoRangeIncludesZero(false);
	      
	      XYLineAndShapeRenderer localXYLineAndShapeRenderer1 = new XYLineAndShapeRenderer(false, true);
	      XYPlot localXYPlot = new XYPlot(dataset, localNumberAxis1, localNumberAxis2, localXYLineAndShapeRenderer1);
	      double[] arrayOfDouble = Regression.getPowerRegression(dataset, 0);
	      PowerFunction2D localPowerFunction2D = new PowerFunction2D(arrayOfDouble[0], arrayOfDouble[1]);
	     // XYDataset localXYDataset = DatasetUtilities.sampleFunction2D(localPowerFunction2D, 2.0D, 11.0D, 100, "Fitted Regression Line");
	      XYLineAndShapeRenderer localXYLineAndShapeRenderer2 = new XYLineAndShapeRenderer(true, false);
	      localXYLineAndShapeRenderer2.setSeriesPaint(0, Color.blue);
	     // localXYPlot.setDataset(1, localXYDataset);
	    //  localXYPlot.setRenderer(1, localXYLineAndShapeRenderer2);
	      JFreeChart localJFreeChart = new JFreeChart("Power Regression", JFreeChart.DEFAULT_TITLE_FONT, localXYPlot, true);
	      ChartUtilities.applyCurrentTheme(localJFreeChart);
	      return localJFreeChart;
	 }  

	/*
	 private XYDataset createSampleData()
	    {
	      XYSeries localXYSeries1 = new XYSeries("Series 1");
	      localXYSeries1.add(2.0D, 56.270000000000003D);
	      localXYSeries1.add(3.0D, 41.32D);
	      localXYSeries1.add(4.0D, 31.449999999999999D);
	      localXYSeries1.add(5.0D, 30.050000000000001D);
	      localXYSeries1.add(6.0D, 24.690000000000001D);
	      localXYSeries1.add(7.0D, 19.780000000000001D);
	      localXYSeries1.add(8.0D, 20.940000000000001D);
	      localXYSeries1.add(9.0D, 16.73D);
	      localXYSeries1.add(10.0D, 14.210000000000001D);
	      localXYSeries1.add(11.0D, 12.44D);
	      XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection(localXYSeries1);
	      XYSeries localXYSeries2 = new XYSeries("Series 2");
	      localXYSeries2.add(11.0D, 56.270000000000003D);
	      localXYSeries2.add(10.0D, 41.32D);
	      localXYSeries2.add(9.0D, 31.449999999999999D);
	      localXYSeries2.add(8.0D, 30.050000000000001D);
	      localXYSeries2.add(7.0D, 24.690000000000001D);
	      localXYSeries2.add(6.0D, 19.780000000000001D);
	      localXYSeries2.add(5.0D, 20.940000000000001D);
	      localXYSeries2.add(4.0D, 16.73D);
	      localXYSeries2.add(3.0D, 14.210000000000001D);
	      localXYSeries2.add(2.0D, 12.44D);
	      localXYSeriesCollection.addSeries(localXYSeries2);
	      return localXYSeriesCollection;
	    }
	
	*/

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}