package ru.arkuzmin.diplom.optimization.math.dto;

import junit.framework.TestCase;

import org.junit.Test;

import ru.arkuzmin.diplom.optimization.math.regression.BoilerRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.CubicalRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.IBoilerRegressionFunction;
import ru.arkuzmin.diplom.optimization.math.regression.IRegressionFunction;

public class BoilerTest extends TestCase {
	
	@Test
	public void testBoiler() {
		Boiler b = new Boiler(1, "K1", 90, 170);
		IRegressionFunction q2_regression = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{6.08, 6.05, 6.1, 6.1, 6.15});
		IRegressionFunction q2_regressionm = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{8.38, 7.94, 7.64, 7.55, 7.67});
		IBoilerRegressionFunction bq2 = new BoilerRegressionFunction(q2_regression, q2_regressionm);
		
		IRegressionFunction q5_regression = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{1.19, 0.97, 0.82, 0.72, 0.63});
		IRegressionFunction q5_regressionm = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{1.19, 0.97, 0.83, 0.71, 0.63});
		IBoilerRegressionFunction bq5 = new BoilerRegressionFunction(q5_regression, q5_regressionm);
		
		IRegressionFunction tyx_regression = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{150, 152, 154, 155, 156});
		IRegressionFunction tyx_regressionm = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{175, 176, 178, 181, 186});
		IBoilerRegressionFunction btyx = new BoilerRegressionFunction(tyx_regression, tyx_regressionm);
		
		IRegressionFunction ayx_regression = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{1.24, 1.23, 1.22, 1.21, 1.21});
		IRegressionFunction ayx_regressionm = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{1.53, 1.43, 1.37, 1.33, 1.30});
		IBoilerRegressionFunction bayx = new BoilerRegressionFunction(ayx_regression, ayx_regressionm);
		
		IRegressionFunction apc_regression = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{1.12, 1.12, 1.12, 1.12, 1.12});
		IRegressionFunction apc_regressionm = new CubicalRegressionFunction(new double[]{90, 110, 130, 150, 170}, new double[]{1.39, 1.31, 1.25, 1.22, 1.2});
		IBoilerRegressionFunction bapc = new BoilerRegressionFunction(apc_regression, apc_regressionm);
		
		b.init(bq2, bq5, btyx, bayx, bapc);
		b.initCurrentState(100, BoilerStates.ON_MAZ);
		
		System.out.println(b.getB());
		System.out.println(b.getKPD());
		System.out.println(b.getQpp());
		System.out.println("-----------");
		
		b.initCurrentState(100, BoilerStates.ON_GAS);
		
		System.out.println(b.getB());
		System.out.println(b.getKPD());
		System.out.println(b.getQpp());
		
	}
	
}
