package ru.arkuzmin.diplom.optimizatin.ui.viewpart;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

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
		
		Composite top = new Composite(container, SWT.NONE);
		top.setLayout(new GridLayout(1, false));
		GridData gd_top = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
		gd_top.heightHint = 183;
		gd_top.widthHint = 271;
		top.setLayoutData(gd_top);

	}



	@Override
	public void setFocus() {
		// Set the focus
	}

}
