package ru.arkuzmin.diplom.optimization;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import ru.arkuzmin.diplom.optimizatin.ui.viewpart.CriteriaViewPart;
import ru.arkuzmin.diplom.optimizatin.ui.viewpart.ExpertViewPart;
import ru.arkuzmin.diplom.optimizatin.ui.viewpart.RegressionViewPart;
import ru.arkuzmin.diplom.optimization.chart.RegressionDataset;
import ru.arkuzmin.diplom.optimization.math.regression.CubicalRegressionFunction;

public class Perspective implements IPerspectiveFactory {

	/**
	 * The ID of the perspective as specified in the extension.
	 */
	public static final String ID = "ru.arkuzmin.diplom.optimization.perspective";

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		
		layout.addStandaloneView(NavigationView.ID,  false, IPageLayout.LEFT, 0.25f, editorArea);
		IFolderLayout folder = layout.createFolder("messages", IPageLayout.TOP, 0.5f, editorArea);
		folder.addPlaceholder(CriteriaViewPart.ID + ":*");
		folder.addView(CriteriaViewPart.ID);
		folder.addPlaceholder(ExpertViewPart.ID + ":*");
		folder.addView(ExpertViewPart.ID);
		layout.getViewLayout(NavigationView.ID).setCloseable(false);
		
		
		//RegressionViewPart vp = new RegressionViewPart(new RegressionDataset(new CubicalRegressionFunction(new double[]{110, 130, 150, 170, 190, 210}, new double[]{172, 174, 176, 178, 180, 183})));
		
	}
}
