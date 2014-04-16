package ru.arkuzmin.diplom.optimizatin.ui.viewpart;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.jfree.data.xy.XYDataset;

import ru.arkuzmin.diplom.optimization.ui.regression.RegressionSplineComposite;
import swing2swt.layout.BorderLayout;

public class RegressionViewPart extends ViewPart {

	private XYDataset dataset;
	
	public static final String ID = "ru.arkuzmin.diplom.optimizatin.ui.viewpart.RegressionViewPart"; //$NON-NLS-1$

	public static void main() {
		
	}
	
	public RegressionViewPart(XYDataset dataset) {
		this.dataset = dataset;
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new BorderLayout(0, 0));
		
		RegressionSplineComposite regressionSpline = new RegressionSplineComposite(container, SWT.NONE, dataset);
		regressionSpline.setLayoutData(BorderLayout.CENTER);

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
