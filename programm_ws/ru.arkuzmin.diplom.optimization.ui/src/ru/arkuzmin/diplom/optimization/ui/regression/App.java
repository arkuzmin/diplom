package ru.arkuzmin.diplom.optimization.ui.regression;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import ru.arkuzmin.diplom.optimization.chart.DatasetUtils;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria.CriteriaTarget;
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
		
		//RegressionSplineComposite regressionSplineComposite = new RegressionSplineComposite(shell, SWT.NONE, new RegressionDataset(new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{8.38, 7.94, 9, 7.55, 8})));
		//RegressionComposite regressionSplineComposite = new RegressionComposite(shell, SWT.NONE, new RegressionDataset(new CubicalRegressionFunction(new double[]{110, 130, 150, 170, 190, 210}, new double[]{172, 174, 176, 178, 180, 183})));
		SpiderComposite regressionSplineComposite = new SpiderComposite(shell, SWT.NONE, DatasetUtils.createSpiderDataset(getSampleVCList()));
		regressionSplineComposite.setLayoutData(BorderLayout.CENTER);

	}
	
	private List<VectorCriteria> getSampleVCList() {
		List<VectorCriteria> list = new LinkedList<VectorCriteria>();
		
		//--
		List<Criteria> clist = new LinkedList<Criteria>();
		Criteria c1 = new Criteria("Расход газа", CriteriaTarget.MIN).setValue(16);
		Criteria c2 = new Criteria("Расход мазута", CriteriaTarget.MIN).setValue(19);
		Criteria c3 = new Criteria("Фин. затраты", CriteriaTarget.MIN).setValue(34);
		Criteria c4 = new Criteria("КПД", CriteriaTarget.MAX).setValue(90);
		clist.add(c1);
		clist.add(c2);
		clist.add(c3);
		clist.add(c4);
		
		VectorCriteria vc = new VectorCriteria(clist);
		list.add(vc);
		
		//--
		clist = new LinkedList<Criteria>();
		c1 = new Criteria("Расход газа", CriteriaTarget.MIN).setValue(17);
		c2 = new Criteria("Расход мазута", CriteriaTarget.MIN).setValue(19.4);
		c3 = new Criteria("Фин. затраты", CriteriaTarget.MIN).setValue(38);
		c4 = new Criteria("КПД", CriteriaTarget.MAX).setValue(97);
		clist.add(c1);
		clist.add(c2);
		clist.add(c3);
		clist.add(c4);
		
		vc = new VectorCriteria(clist);
		list.add(vc);
		
		//--
		clist = new LinkedList<Criteria>();
		c1 = new Criteria("Расход газа", CriteriaTarget.MIN).setValue(12);
		c2 = new Criteria("Расход мазута", CriteriaTarget.MIN).setValue(14.4);
		c3 = new Criteria("Фин. затраты", CriteriaTarget.MIN).setValue(67);
		c4 = new Criteria("КПД", CriteriaTarget.MAX).setValue(87);
		clist.add(c1);
		clist.add(c2);
		clist.add(c3);
		clist.add(c4);
		
		vc = new VectorCriteria(clist);
		list.add(vc);
		
		//--
		clist = new LinkedList<Criteria>();
		c1 = new Criteria("Расход газа", CriteriaTarget.MIN).setValue(17);
		c2 = new Criteria("Расход мазута", CriteriaTarget.MIN).setValue(13.4);
		c3 = new Criteria("Фин. затраты", CriteriaTarget.MIN).setValue(66);
		c4 = new Criteria("КПД", CriteriaTarget.MAX).setValue(87);
		clist.add(c1);
		clist.add(c2);
		clist.add(c3);
		clist.add(c4);
		
		vc = new VectorCriteria(clist);
		list.add(vc);
		
		return list;
	}
	
}
