package ru.arkuzmin.diplom.optimization.ui.regression;

import java.awt.Color;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.ui.RectangleInsets;

import swing2swt.layout.BorderLayout;

public class RegressionSplineComposite extends Composite {

	private final XYDataset dataset;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RegressionSplineComposite(Composite parent, int style, XYDataset dataset) {
		super(parent, style);
		this.dataset = dataset;
		setLayout(new BorderLayout(0, 0));
		
		final JFreeChart chart = createChart("Operating Systems");  
		  
		new ChartComposite(parent, SWT.NONE, chart, true);  

	}
	
	
	private JFreeChart createChart(final String title) {  
		  NumberAxis localNumberAxis1 = new NumberAxis("X");
	      localNumberAxis1.setAutoRangeIncludesZero(false);
	      NumberAxis localNumberAxis2 = new NumberAxis("Y");
	      localNumberAxis2.setAutoRangeIncludesZero(false);
	      XYSplineRenderer localXYSplineRenderer = new XYSplineRenderer();
	      XYPlot localXYPlot = new XYPlot(dataset, localNumberAxis1, localNumberAxis2, localXYSplineRenderer);
	      
	      localXYPlot.setBackgroundPaint(Color.lightGray);
	      localXYPlot.setDomainGridlinePaint(Color.white);
	      localXYPlot.setRangeGridlinePaint(Color.white);
	      localXYPlot.setAxisOffset(new RectangleInsets(4.0D, 4.0D, 4.0D, 4.0D));
	      
	      JFreeChart localJFreeChart = new JFreeChart("XYSplineRenderer", JFreeChart.DEFAULT_TITLE_FONT, localXYPlot, true);
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
