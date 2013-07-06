package de.mn.vaf.presenter;

import de.mn.vaf.VafUI;

public abstract class TabSheetViewPresenter extends BasePresenter {
	
	private final TabSheetPresenter tabSheetPresenter;

	public TabSheetViewPresenter(VafUI vafUI, TabSheetPresenter tabSheetPresenter) {
		super(vafUI);
		this.tabSheetPresenter = tabSheetPresenter;
	}

	public abstract String getTabSheetCaption();

	protected void openView(TabSheetViewPresenter presenter) {
		tabSheetPresenter.openView(presenter);
	}
	
	protected TabSheetPresenter getTabSheetPresenter() {
		return tabSheetPresenter;
	}
	
}
