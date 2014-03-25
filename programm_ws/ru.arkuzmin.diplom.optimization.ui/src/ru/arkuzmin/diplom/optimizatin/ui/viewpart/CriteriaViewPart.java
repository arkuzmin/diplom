package ru.arkuzmin.diplom.optimizatin.ui.viewpart;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class CriteriaViewPart extends ViewPart {

	public static final String ID = "ru.arkuzmin.diplom.optimizatin.ui.viewpart.CriteriaViewPart"; //$NON-NLS-1$

	public CriteriaViewPart() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout gl_container = new GridLayout(1, false);
		gl_container.marginHeight = 0;
		gl_container.marginWidth = 0;
		container.setLayout(gl_container);
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		GridData gd_composite = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_composite.heightHint = 70;
		gd_composite.widthHint = 271;
		composite.setLayoutData(gd_composite);
		
		Composite composite_1 = new Composite(container, SWT.NONE);
		GridData gd_composite_1 = new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1);
		gd_composite_1.widthHint = -16;
		composite_1.setLayoutData(gd_composite_1);

	}



	@Override
	public void setFocus() {
		// Set the focus
	}

}
