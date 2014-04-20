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
		/*Boiler b = new Boiler(1, "K1", 90, 170);
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
		b.initCurrentState(170, BoilerStates.ON_GAS);
		
		System.out.println(b.getB());
		System.out.println(b.getKPD());
		//System.out.println(b.getQpp());
		System.out.println("-----------");
		
		b.initCurrentState(100, BoilerStates.ON_MAZ);
		
		System.out.println(b.getB());
		System.out.println(b.getKPD());
		//System.out.println(b.getQpp());*/
		
		Boiler b = new Boiler(5, "K5", 130, 230);
		IRegressionFunction q2_regression = new CubicalRegressionFunction(new double[]{130, 150, 170, 190, 210, 230}, new double[]{5.25, 5.23, 5.2, 5.23, 5.33, 5.42});
		IRegressionFunction q2_regressionm = new CubicalRegressionFunction(new double[]{170, 190, 210, 230}, new double[]{7.41, 6.79, 6.7, 6.5});
		IBoilerRegressionFunction bq2 = new BoilerRegressionFunction(q2_regression, q2_regressionm);
		
		IRegressionFunction q5_regression = new CubicalRegressionFunction(new double[]{130, 150, 170, 190, 210, 230}, new double[]{1.01, 0.87, 0.77, 0.57, 0.57, 0.57});
		IRegressionFunction q5_regressionm = new CubicalRegressionFunction(new double[]{170, 190, 210, 230}, new double[]{0.77, 0.69, 0.62, 0.57});
		IBoilerRegressionFunction bq5 = new BoilerRegressionFunction(q5_regression, q5_regressionm);
		
		IRegressionFunction tyx_regression = new CubicalRegressionFunction(new double[]{130, 150, 170, 190, 210, 230}, new double[]{138, 140, 141, 142, 143, 145});
		IRegressionFunction tyx_regressionm = new CubicalRegressionFunction(new double[]{170, 190, 210, 230}, new double[]{164, 165, 162, 162});
		IBoilerRegressionFunction btyx = new BoilerRegressionFunction(tyx_regression, tyx_regressionm);
		
		IRegressionFunction ayx_regression = new CubicalRegressionFunction(new double[]{130, 150, 170, 190, 210, 230}, new double[]{1.17, 1.14, 1.13, 1.12, 1.12, 1.12});
		IRegressionFunction ayx_regressionm = new CubicalRegressionFunction(new double[]{170, 190, 210, 230}, new double[]{1.54, 1.43, 1.43, 1.42});
		IBoilerRegressionFunction bayx = new BoilerRegressionFunction(ayx_regression, ayx_regressionm);
		
		IRegressionFunction apc_regression = new CubicalRegressionFunction(new double[]{130, 150, 170, 190, 210, 230}, new double[]{1.1, 1.07, 1.06, 1.05, 1.05, 1.05});
		IRegressionFunction apc_regressionm = new CubicalRegressionFunction(new double[]{170, 190, 210, 230}, new double[]{1.3, 1.19, 1.19, 1.19});
		IBoilerRegressionFunction bapc = new BoilerRegressionFunction(apc_regression, apc_regressionm);
		
		b.init(bq2, bq5, btyx, bayx, bapc);
		b.initCurrentState(183, BoilerStates.ON_GAS);
		
		System.out.println(b.getB());
		System.out.println(b.getKPD());
		//System.out.println(b.getQpp());
		System.out.println("-----------");
		
		b.initCurrentState(219, BoilerStates.ON_MAZ);
		
		System.out.println(b.getB());
		System.out.println(b.getKPD());
		
	}
	
}
