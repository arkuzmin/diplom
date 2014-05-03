package ru.arkuzmin.diplom.optimization.ui.regression;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.ui.RectangleEdge;

import swing2swt.layout.BorderLayout;

public class SpiderComposite extends Composite {

	CategoryDataset dataset;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SpiderComposite(Composite parent, int style, CategoryDataset dataset) {
		super(parent, style);
		this.dataset = dataset;
		
		setLayout(new BorderLayout(0, 0));
		
		final JFreeChart chart = createChart("Operating Systems");  
		  
		new ChartComposite(parent, SWT.NONE, chart, true);  
	}
	
	private JFreeChart createChart(final String title) {  
		SpiderWebPlot localSpiderWebPlot = new SpiderWebPlot(dataset);
	    localSpiderWebPlot.setStartAngle(54.0D);
	    localSpiderWebPlot.setInteriorGap(0.4D);
	    localSpiderWebPlot.setToolTipGenerator(new StandardCategoryToolTipGenerator());
	    JFreeChart localJFreeChart = new JFreeChart("Spider Web Chart Demo 1", TextTitle.DEFAULT_FONT, localSpiderWebPlot, false);
	    LegendTitle localLegendTitle = new LegendTitle(localSpiderWebPlot);
	    localLegendTitle.setPosition(RectangleEdge.BOTTOM);
	    localJFreeChart.addSubtitle(localLegendTitle);
	    ChartUtilities.applyCurrentTheme(localJFreeChart);
	    return localJFreeChart;
	 }  

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
