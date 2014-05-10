package ru.arkuzmin.diplom.optimization.ui;

import java.util.List;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import ru.arkuzmin.diplom.optimization.common.Globals;
import ru.arkuzmin.diplom.optimization.math.dto.Boiler;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;
import ru.arkuzmin.diplom.optimization.math.dto.BoilerStation;
import ru.arkuzmin.diplom.optimization.math.dto.Criteria;
import ru.arkuzmin.diplom.optimization.math.dto.Decision;
import ru.arkuzmin.diplom.optimization.math.dto.VectorCriteria;
import ru.arkuzmin.diplom.optimization.math.utils.MathUtils;

public class DecisionManager {

	private Label bGasLbl;
	private Label bMazLbl;
	private Label FLbl;
	private Label KPDLbl;
	
	private Label b1DKLbl;
	private Label b1StateLbl;
	private Label b1FuelLbl;
	private Label b1PercLbl;
	
	private Label b2DKLbl;
	private Label b2StateLbl;
	private Label b2FuelLbl;
	private Label b2PercLbl;
	
	private Label b3DKLbl;
	private Label b3StateLbl;
	private Label b3FuelLbl;
	private Label b3PercLbl;
	
	private Label b4DKLbl;
	private Label b4StateLbl;
	private Label b4FuelLbl;
	private Label b4PercLbl;
	
	private Label b5DKLbl;
	private Label b5StateLbl;
	private Label b5FuelLbl;
	private Label b5PercLbl;
	
	private Label b6DKLbl;
	private Label b6StateLbl;
	private Label b6FuelLbl;
	private Label b6PercLbl;
	
	private ProgressBar b1Progress;
	private ProgressBar b2Progress;
	private ProgressBar b3Progress;
	private ProgressBar b4Progress;
	private ProgressBar b5Progress;
	private ProgressBar b6Progress;
	
	private Label commonDK;
	
	
	public DecisionManager(Label bGasLbl, Label bMazLbl, Label FLbl, Label KPDLbl,
						   Label b1DKLbl, Label b1StateLbl, Label b1FuelLbl, Label b1PercLbl,
						   Label b2DKLbl, Label b2StateLbl, Label b2FuelLbl, Label b2PercLbl,
						   Label b3DKLbl, Label b3StateLbl, Label b3FuelLbl, Label b3PercLbl,
						   Label b4DKLbl, Label b4StateLbl, Label b4FuelLbl, Label b4PercLbl,
						   Label b5DKLbl, Label b5StateLbl, Label b5FuelLbl, Label b5PercLbl,
						   Label b6DKLbl, Label b6StateLbl, Label b6FuelLbl, Label b6PercLbl,
						   ProgressBar b1Progress, ProgressBar b2Progress, ProgressBar b3Progress, ProgressBar b4Progress, ProgressBar b5Progress, ProgressBar b6Progress,
						   Label commonDK) {
		this.bGasLbl = bGasLbl;
		this.bMazLbl = bMazLbl;
		this.FLbl = FLbl;
		this.KPDLbl = KPDLbl;
		
		this.b1DKLbl = b1DKLbl;
		this.b1StateLbl = b1StateLbl;
		this.b1FuelLbl = b1FuelLbl;
		this.b1PercLbl = b1PercLbl;
		
		this.b2DKLbl = b2DKLbl;
		this.b2StateLbl = b2StateLbl;
		this.b2FuelLbl = b2FuelLbl;
		this.b2PercLbl = b2PercLbl;
		
		this.b3DKLbl = b3DKLbl;
		this.b3StateLbl = b3StateLbl;
		this.b3FuelLbl = b3FuelLbl;
		this.b3PercLbl = b3PercLbl;
		
		this.b4DKLbl = b4DKLbl;
		this.b4StateLbl = b4StateLbl;
		this.b4FuelLbl = b4FuelLbl;
		this.b4PercLbl = b4PercLbl;
		
		this.b5DKLbl = b5DKLbl;
		this.b5StateLbl = b5StateLbl;
		this.b5FuelLbl = b5FuelLbl;
		this.b5PercLbl = b5PercLbl;
		
		this.b6DKLbl = b6DKLbl;
		this.b6StateLbl = b6StateLbl;
		this.b6FuelLbl = b6FuelLbl;
		this.b6PercLbl = b6PercLbl;
		
		this.b1Progress = b1Progress;
		this.b2Progress = b2Progress;
		this.b3Progress = b3Progress;
		this.b4Progress = b4Progress;
		this.b5Progress = b5Progress;
		this.b6Progress = b6Progress;
		
		this.commonDK = commonDK;
	}
	
	private void initBoiler(Label state, Label DK, Label perc, Label fuel, ProgressBar progress, Boiler b) {
		DK.setText(String.valueOf(MathUtils.toInt(b.getDK())));
		state.setText(!BoilerStates.OFF.equals(b.getState()) ? "Вкл." : "Выкл.");
		fuel.setText(!(BoilerStates.OFF.equals(b.getState())) ? String.valueOf(b.getState()) : "-");
		perc.setText(String.valueOf(MathUtils.toInt(b.getDK() * 100.0 / b.getMAX_DK())) + "%");
		progress.setProgress(b.getDK() / b.getMAX_DK());
		progress.getStylesheets().add(RegressionPane.class.getResource(Globals.CSS_STYLES).toExternalForm());

		if (BoilerStates.ON_GAS.equals(b.getState())) {
			progress.getStyleClass().remove("maz-progress");
			progress.getStyleClass().add("gas-progress");
		} else if (BoilerStates.ON_MAZ.equals(b.getState())) {
			progress.getStyleClass().remove("gas-progress");
			progress.getStyleClass().add("maz-progress");
		}
	}
	
	public void setDecision(Decision d) {
		VectorCriteria vc = d.getVector();
		List<Criteria> list = vc.getVector();
		
		bGasLbl.setText(MathUtils.doubleToString(list.get(0).getValue(), 4));
		bMazLbl.setText(MathUtils.doubleToString(list.get(1).getValue(), 4));
		FLbl.setText(MathUtils.doubleToString(list.get(2).getValue(), 4));
		KPDLbl.setText(MathUtils.doubleToString(list.get(3).getValue(), 4));
		
		BoilerStation st = d.getStation();
		
		commonDK.setText(String.valueOf(MathUtils.toInt(st.getDK())));
		List<Boiler> boilers = st.getBoilers();

		Boiler b1 = boilers.get(0);
		initBoiler(b1StateLbl, b1DKLbl, b1PercLbl, b1FuelLbl, b1Progress, b1);
		
		Boiler b2 = boilers.get(1);
		initBoiler(b2StateLbl, b2DKLbl, b2PercLbl, b2FuelLbl, b2Progress, b2);
		
		Boiler b3 = boilers.get(2);
		initBoiler(b3StateLbl, b3DKLbl, b3PercLbl, b3FuelLbl, b3Progress, b3);
		
		Boiler b4 = boilers.get(3);
		initBoiler(b4StateLbl, b4DKLbl, b4PercLbl, b4FuelLbl, b4Progress, b4);
		
		Boiler b5 = boilers.get(4);
		initBoiler(b5StateLbl, b5DKLbl, b5PercLbl, b5FuelLbl, b5Progress, b5);
		
		Boiler b6 = boilers.get(5);
		initBoiler(b6StateLbl, b6DKLbl, b6PercLbl, b6FuelLbl, b6Progress, b6);
		
	}
}
