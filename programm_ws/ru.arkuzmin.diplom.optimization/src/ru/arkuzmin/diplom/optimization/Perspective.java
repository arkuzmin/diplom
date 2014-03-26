package ru.arkuzmin.diplom.optimization;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import ru.arkuzmin.diplom.optimizatin.ui.viewpart.CriteriaViewPart;

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
		
		layout.getViewLayout(NavigationView.ID).setCloseable(false);
	}
}
