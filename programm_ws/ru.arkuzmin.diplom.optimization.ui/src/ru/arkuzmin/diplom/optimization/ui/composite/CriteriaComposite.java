package ru.arkuzmin.diplom.optimization.ui.composite;

import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class CriteriaComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CriteriaComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new BorderLayout(0, 0));
		
		Group group = new Group(this, SWT.NONE);
		group.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		group.setText("Критерии оптимизации");
		group.setLayoutData(BorderLayout.CENTER);
		FillLayout fl_group = new FillLayout(SWT.VERTICAL);
		fl_group.marginHeight = 5;
		fl_group.marginWidth = 5;
		group.setLayout(fl_group);
		
		Group group_1 = new Group(group, SWT.NONE);
		group_1.setText("Минимизировать значения");
		FillLayout fl_group_1 = new FillLayout(SWT.VERTICAL);
		fl_group_1.marginWidth = 5;
		fl_group_1.marginHeight = 5;
		group_1.setLayout(fl_group_1);
		
		Button button = new Button(group_1, SWT.CHECK);
		button.setText("Расход газа");
		
		Button button_1 = new Button(group_1, SWT.CHECK);
		button_1.setText("Расход мазута");
		
		Button button_2 = new Button(group_1, SWT.CHECK);
		button_2.setText("Финансовые затраты на используемое топливо");
		
		Group group_2 = new Group(group, SWT.NONE);
		group_2.setText("Максимизировать значения");
		FillLayout fl_group_2 = new FillLayout(SWT.VERTICAL);
		fl_group_2.marginHeight = 5;
		fl_group_2.marginWidth = 5;
		group_2.setLayout(fl_group_2);
		
		Button button_3 = new Button(group_2, SWT.CHECK);
		button_3.setText("КПД котельного отделения");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
