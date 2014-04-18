package ru.arkuzmin.diplom.optimization.math.regression;

import ru.arkuzmin.diplom.optimization.math.dto.BoilerStates;

public class BoilerRegressionFunction implements IBoilerRegressionFunction {

	IRegressionFunction gas = null;
	IRegressionFunction maz = null;
	
	public BoilerRegressionFunction(IRegressionFunction gas, IRegressionFunction maz) {
		this.gas = gas;
		this.maz = maz;
	}
	
	@Override
	public double getY(double x, BoilerStates state) {
		if (BoilerStates.ON_GAS.equals(state)) {
			return gas.getY(x);
		} else if (BoilerStates.ON_MAZ.equals(state)) {
			return maz.getY(x);
		}
		return 0.0;
	}

}
