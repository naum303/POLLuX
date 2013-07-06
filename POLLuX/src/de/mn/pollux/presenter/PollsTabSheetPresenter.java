package de.mn.pollux.presenter;

import de.mn.pollux.PolluxUI;
import de.mn.vaf.VafUI;
import de.mn.vaf.presenter.TabSheetPresenter;
import de.mn.vaf.presenter.TabSheetViewPresenter;
import de.mn.vaf.util.Logger;

public class PollsTabSheetPresenter extends TabSheetPresenter {
	
	public PollsTabSheetPresenter(VafUI vafUI) {
		super(vafUI);
	}

	@Override
	protected PolluxUI getVafUI() {
		return (PolluxUI) super.getVafUI();
	}
	
	@Override
	public TabSheetViewPresenter getOverviewPresenter() {
		
		Logger.log("PollsOverviewPresenter wird neu erzeugt");
		
		return new PollsOverviewPresenter(getVafUI(), this);
	}

	@Override
	public void updateDisplay() {
	}

}
