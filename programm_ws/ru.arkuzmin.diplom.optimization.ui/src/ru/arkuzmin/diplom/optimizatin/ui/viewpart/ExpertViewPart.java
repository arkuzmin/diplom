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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class ExpertViewPart extends ViewPart {

	public static final String ID = "ru.arkuzmin.diplom.optimizatin.ui.viewpart.ExpertViewPart"; //$NON-NLS-1$
	private Text text;
	private Composite composite_2;
	private Text GG_txt;
	private Text MM_txt;
	private Text MonMon_txt;
	private Text KpdKpd_txt;
	private Text MG_txt;
	private Text MonG_txt;
	private Text MonM_txt;
	private Text KpdG_txt;
	private Text KpdM_txt;
	private Text KpdMon_txt;
	private Combo GM_combo;
	private Combo GMon_combo;
	private Combo GKpd_combo;
	private Combo MMon_combo;
	private Combo MKpd_combo;
	private Combo MonKpd_combo;

	private static final String[] items = new String[] {"0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9"};
	
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
		GridData gd_group = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_group.heightHint = 204;
		group.setLayoutData(gd_group);
		group.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		group.setText("Коэффициенты относительной важности\r\n");
		GridLayout gl_group = new GridLayout(1, true);
		gl_group.marginTop = 5;
		gl_group.marginRight = 5;
		gl_group.marginLeft = 5;
		gl_group.marginBottom = 5;
		group.setLayout(gl_group);
		
		composite_2 = new Composite(group, SWT.BORDER);
		composite_2.setLayout(new GridLayout(5, true));
		GridData gd_composite_2 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_composite_2.heightHint = 250;
		gd_composite_2.widthHint = 298;
		composite_2.setLayoutData(gd_composite_2);
		
		Label lblNewLabel = new Label(composite_2, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		
		Label lblNewLabel_1 = new Label(composite_2, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		lblNewLabel_1.setText("Газ");
		
		ControlDecoration controlDecoration = new ControlDecoration(lblNewLabel_1, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText("Величина расхода газа");
		
		Label lblNewLabel_2 = new Label(composite_2, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		lblNewLabel_2.setText("Мазут");
		
		ControlDecoration controlDecoration_1 = new ControlDecoration(lblNewLabel_2, SWT.LEFT | SWT.TOP);
		controlDecoration_1.setDescriptionText("Величина расхода мазута");
		
		Label lblNewLabel_3 = new Label(composite_2, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		lblNewLabel_3.setText("Финансы");
		
		ControlDecoration controlDecoration_2 = new ControlDecoration(lblNewLabel_3, SWT.LEFT | SWT.TOP);
		controlDecoration_2.setDescriptionText("Финансовые затраты на используемое топливо");
		
		Label lblNewLabel_4 = new Label(composite_2, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		lblNewLabel_4.setText("КПД");
		
		ControlDecoration controlDecoration_3 = new ControlDecoration(lblNewLabel_4, SWT.LEFT | SWT.TOP);
		controlDecoration_3.setDescriptionText("КПД группы котлоагрегатов");
		
		Label lblNewLabel_5 = new Label(composite_2, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		lblNewLabel_5.setText("Газ");
		
		ControlDecoration controlDecoration_4 = new ControlDecoration(lblNewLabel_5, SWT.RIGHT | SWT.TOP);
		controlDecoration_4.setDescriptionText("Величина расхода газа");
		
		GG_txt = new Text(composite_2, SWT.BORDER);
		GG_txt.setText("1.0");
		GG_txt.setEnabled(false);
		GG_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		GM_combo = new Combo(composite_2, SWT.NONE);
		GM_combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				selectTxt(GM_combo, MG_txt);
			}
		});
		GM_combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		GMon_combo = new Combo(composite_2, SWT.NONE);
		GMon_combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				selectTxt(GMon_combo, MonG_txt);
			}
		});
		GMon_combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		GKpd_combo = new Combo(composite_2, SWT.NONE);
		GKpd_combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				selectTxt(GKpd_combo, KpdG_txt);
			}
		});
		GKpd_combo.setSize(new Point(0, 10));
		GKpd_combo.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true, 1, 1));
		
		Label lblNewLabel_6 = new Label(composite_2, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		lblNewLabel_6.setText("Мазут");
		
		ControlDecoration controlDecoration_5 = new ControlDecoration(lblNewLabel_6, SWT.RIGHT | SWT.TOP);
		controlDecoration_5.setDescriptionText("Величина расхода мазута");
		
		MG_txt = new Text(composite_2, SWT.BORDER);
		MG_txt.setEnabled(false);
		MG_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		MM_txt = new Text(composite_2, SWT.BORDER);
		MM_txt.setText("1.0");
		MM_txt.setEnabled(false);
		MM_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		MMon_combo = new Combo(composite_2, SWT.NONE);
		MMon_combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				selectTxt(MMon_combo, MonM_txt);
			}
		});
		MMon_combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		MKpd_combo = new Combo(composite_2, SWT.NONE);
		MKpd_combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				selectTxt(MKpd_combo, KpdM_txt);
			}
		});
		MKpd_combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_7 = new Label(composite_2, SWT.NONE);
		lblNewLabel_7.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		lblNewLabel_7.setText("Финансы");
		
		ControlDecoration controlDecoration_6 = new ControlDecoration(lblNewLabel_7, SWT.RIGHT | SWT.TOP);
		controlDecoration_6.setDescriptionText("Финансовые затраты на используемое топливо");
		
		MonG_txt = new Text(composite_2, SWT.BORDER);
		MonG_txt.setEnabled(false);
		MonG_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		MonM_txt = new Text(composite_2, SWT.BORDER);
		MonM_txt.setEnabled(false);
		MonM_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		MonMon_txt = new Text(composite_2, SWT.BORDER);
		MonMon_txt.setText("1.0");
		MonMon_txt.setEnabled(false);
		MonMon_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		MonKpd_combo = new Combo(composite_2, SWT.NONE);
		MonKpd_combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				selectTxt(MonKpd_combo, KpdMon_txt);
			}
		});
		MonKpd_combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_8 = new Label(composite_2, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		lblNewLabel_8.setText("КПД");
		
		ControlDecoration controlDecoration_7 = new ControlDecoration(lblNewLabel_8, SWT.RIGHT | SWT.TOP);
		controlDecoration_7.setDescriptionText("КПД группы котлоагрегатов");
		
		KpdG_txt = new Text(composite_2, SWT.BORDER);
		KpdG_txt.setEnabled(false);
		KpdG_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		KpdM_txt = new Text(composite_2, SWT.BORDER);
		KpdM_txt.setEnabled(false);
		KpdM_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		KpdMon_txt = new Text(composite_2, SWT.BORDER);
		KpdMon_txt.setEnabled(false);
		KpdMon_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		KpdKpd_txt = new Text(composite_2, SWT.BORDER);
		KpdKpd_txt.setText("1.0");
		KpdKpd_txt.setEnabled(false);
		KpdKpd_txt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		initCombos();
		initTxts();

	}

	private void selectTxt(final Combo combo, final Text txt) {
		if (combo == null || txt == null || combo.getSelectionIndex() == -1) {
			return;
		}
		txt.setText(items[items.length - combo.getSelectionIndex() - 1]);	
	}
	
	private void initTxts() {
		MG_txt.setText("0.5");
		MonG_txt.setText("0.5");
		MonM_txt.setText("0.5");
		KpdG_txt.setText("0.5");
		KpdM_txt.setText("0.5");
		KpdMon_txt.setText("0.5");
	}
	
	private void initCombos() {
		GM_combo.setItems(items);
		GM_combo.select(4);
		
		GMon_combo.setItems(items);
		GMon_combo.select(4);
		
		GKpd_combo.setItems(items);
		GKpd_combo.select(4);
		
		MMon_combo.setItems(items);
		MMon_combo.select(4);
		
		MKpd_combo.setItems(items);
		MKpd_combo.select(4);
		
		MonKpd_combo.setItems(items);
		MonKpd_combo.select(4);
	}
	
	
	

	@Override
	public void setFocus() {
		// Set the focus
	}
}
