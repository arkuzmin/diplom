package ru.arkuzmin.diplom.optimizatin.ui.viewpart;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

public class CriteriaViewPart extends ViewPart {

	public static final String ID = "ru.arkuzmin.diplom.optimizatin.ui.viewpart.CriteriaViewPart"; //$NON-NLS-1$
	private Text text;
	private Button crit_kpd;
	private Button crit_money;
	private Button crit_maz;
	private Button crit_gas;

	public CriteriaViewPart() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_composite.heightHint = 75;
		composite.setLayoutData(gd_composite);
		
		text = new Text(composite, SWT.BORDER);
		text.setText("Выберите критерии, по которым будет проводиться оптимизация.\r\n");
		text.setEnabled(false);
		text.setEditable(false);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Composite composite_1 = new Composite(container, SWT.NONE);
		FillLayout fl_composite_1 = new FillLayout(SWT.VERTICAL);
		fl_composite_1.marginWidth = 5;
		composite_1.setLayout(fl_composite_1);
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
		Group group = new Group(composite_1, SWT.NONE);
		group.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		group.setText("Минимизировать значения");
		FillLayout fl_group = new FillLayout(SWT.VERTICAL);
		fl_group.marginWidth = 5;
		fl_group.marginHeight = 5;
		group.setLayout(fl_group);
		
		crit_gas = new Button(group, SWT.CHECK);
		crit_gas.setText("Расход газа");
		
		crit_maz = new Button(group, SWT.CHECK);
		crit_maz.setText("Расход жидкого топлива (мазута)");
		
		crit_money = new Button(group, SWT.CHECK);
		crit_money.setText("Финансовые затраты на используемое топливо");
		
		Group group_1 = new Group(composite_1, SWT.NONE);
		group_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		group_1.setText("Максимизировать значения");
		FillLayout fl_group_1 = new FillLayout(SWT.VERTICAL);
		fl_group_1.marginHeight = 5;
		fl_group_1.marginWidth = 5;
		group_1.setLayout(fl_group_1);
		
		crit_kpd = new Button(group_1, SWT.CHECK);
		crit_kpd.setText("КПД группы котлоагрегатов");

	}



	@Override
	public void setFocus() {
		// Set the focus
	}
}
