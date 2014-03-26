package ru.arkuzmin.diplom.optimizatin.ui.viewpart;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

public class ExpertViewPart extends ViewPart {

	public static final String ID = "ru.arkuzmin.diplom.optimizatin.ui.viewpart.ExpertViewPart"; //$NON-NLS-1$
	private Text text;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	private Label lblNewLabel_4;
	private Label lblNewLabel_5;
	private Label lblNewLabel_6;
	private Label lblNewLabel_7;
	private Combo combo_1;
	private Combo combo_2;
	private Combo combo;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Combo combo_3;
	private Combo combo_4;
	private Combo combo_5;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private ControlDecoration controlDecoration;

	public ExpertViewPart() {
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
		text.setText("Задайте коэффициенты относительной важности критериев в таблице ниже");
		text.setEnabled(false);
		text.setEditable(false);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		Composite composite_1 = new Composite(container, SWT.NONE);
		composite_1.setLayout(new GridLayout(1, true));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1));
		
		Group group = new Group(composite_1, SWT.SHADOW_ETCHED_IN);
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		group.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		group.setText("Коэффициенты относительной важности\r\n");
		GridLayout gl_group = new GridLayout(5, true);
		gl_group.marginTop = 5;
		gl_group.marginRight = 5;
		gl_group.marginLeft = 5;
		gl_group.marginBottom = 5;
		group.setLayout(gl_group);
		new Label(group, SWT.NONE);
		
		lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblNewLabel.setText("Расх. газа");
		
		controlDecoration = new ControlDecoration(lblNewLabel, SWT.LEFT | SWT.TOP);
		controlDecoration.setImage(SWTResourceManager.getImage(ExpertViewPart.class, "/org/eclipse/jface/fieldassist/images/contassist_ovr.gif"));
		controlDecoration.setDescriptionText("Some description");
		
		lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1));
		lblNewLabel_1.setText("Расх. мазута");
		
		lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1));
		lblNewLabel_2.setText("Фин. затраты");
		
		lblNewLabel_3 = new Label(group, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1));
		lblNewLabel_3.setText("КПД");
		
		lblNewLabel_4 = new Label(group, SWT.NONE);
		lblNewLabel_4.setImage(null);
		lblNewLabel_4.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		lblNewLabel_4.setText("Расх. газа");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setEditable(false);
		text_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		combo_1 = new Combo(group, SWT.NONE);
		combo_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		combo_2 = new Combo(group, SWT.NONE);
		combo_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		combo = new Combo(group, SWT.NONE);
		combo.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		lblNewLabel_5 = new Label(group, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		lblNewLabel_5.setText("Расх. мазута");
		
		text_5 = new Text(group, SWT.BORDER);
		text_5.setEditable(false);
		text_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setEditable(false);
		text_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		combo_3 = new Combo(group, SWT.NONE);
		combo_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		combo_4 = new Combo(group, SWT.NONE);
		combo_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		lblNewLabel_6 = new Label(group, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		lblNewLabel_6.setText("Фин. затраты");
		
		text_6 = new Text(group, SWT.BORDER);
		text_6.setEditable(false);
		text_6.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		text_7 = new Text(group, SWT.BORDER);
		text_7.setEditable(false);
		text_7.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.setEditable(false);
		text_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		combo_5 = new Combo(group, SWT.NONE);
		combo_5.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		lblNewLabel_7 = new Label(group, SWT.NONE);
		lblNewLabel_7.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		lblNewLabel_7.setText("КПД");
		
		text_8 = new Text(group, SWT.BORDER);
		text_8.setEditable(false);
		text_8.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		text_9 = new Text(group, SWT.BORDER);
		text_9.setEditable(false);
		text_9.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		text_10 = new Text(group, SWT.BORDER);
		text_10.setEditable(false);
		text_10.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		
		text_4 = new Text(group, SWT.BORDER);
		text_4.setEditable(false);
		text_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));

	}



	@Override
	public void setFocus() {
		// Set the focus
	}
}
