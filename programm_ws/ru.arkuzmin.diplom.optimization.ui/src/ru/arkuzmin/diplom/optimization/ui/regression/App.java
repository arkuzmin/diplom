package ru.arkuzmin.diplom.optimization.ui.regression;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import ru.arkuzmin.diplom.optimization.chart.RegressionDataset;
import ru.arkuzmin.diplom.optimization.math.regression.CubicalRegressionFunction;
import swing2swt.layout.BorderLayout;

public class App {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			App window = new App();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(new BorderLayout(0, 0));
		
		RegressionSplineComposite regressionSplineComposite = new RegressionSplineComposite(shell, SWT.NONE, new RegressionDataset(new CubicalRegressionFunction(new double[]{110, 130, 150, 170, 190, 210}, new double[]{172, 174, 176, 178, 180, 183})));
		regressionSplineComposite.setLayoutData(BorderLayout.CENTER);

	}
}
