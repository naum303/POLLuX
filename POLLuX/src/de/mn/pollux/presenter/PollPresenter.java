package de.mn.pollux.presenter;

import de.mn.pollux.PolluxUI;
import de.mn.pollux.entities.Poll;
import de.mn.pollux.presenter.PollsOverviewPresenter.Display;
import de.mn.pollux.views.PollView;
import de.mn.vaf.presenter.BaseDisplay;
import de.mn.vaf.presenter.TabSheetPresenter;
import de.mn.vaf.presenter.TabSheetViewPresenter;

public class PollPresenter extends TabSheetViewPresenter {

	public interface Display extends BaseDisplay {
		public void showPoll(Poll poll);
		public Poll getPoll();
	}

	
	private final Poll poll;

	public PollPresenter(PolluxUI polluxUI, TabSheetPresenter tabSheetPresenter, Poll poll) {
		super(polluxUI, tabSheetPresenter);
		this.poll = poll;
		
	}

	@Override
	public String getTabSheetCaption() {
		return poll.getTitle();
	}

	@Override
	public Display getDisplay() {
		return (Display) super.getDisplay();
	}
	
	@Override
	protected BaseDisplay createDisplay() {
			
		// TODO dies ist die einzige Stelle, wo der Presenter 
		// die echte View kennt -> in Config verlagern
		PollView view = new PollView();
//		view.setPresenter(this);
		return view;
		
	}

	@Override
	public void updateDisplay() {
		getDisplay().showPoll(poll);
	}

}
