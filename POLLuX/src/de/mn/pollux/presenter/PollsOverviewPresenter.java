package de.mn.pollux.presenter;

import java.util.List;

import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import de.mn.pollux.PolluxUI;
import de.mn.pollux.entities.Poll;
import de.mn.pollux.model.PolluxModel;
import de.mn.pollux.views.PollsOverviewView;
import de.mn.vaf.presenter.BaseDisplay;
import de.mn.vaf.presenter.TabSheetPresenter;
import de.mn.vaf.presenter.TabSheetViewPresenter;

public class PollsOverviewPresenter extends TabSheetViewPresenter {

	public interface Display extends BaseDisplay {
		public Poll getSelectedPoll();
		public void updatePollsTable(List<Poll> pollList);
//		public void setAbstimmungContainer(AbstimmungContainer abstimmungContainer);
	}
	
	public PollsOverviewPresenter(PolluxUI polluxUI, TabSheetPresenter tabSheetPresenter) {
		super(polluxUI, tabSheetPresenter);
	}
	
	@Override
	protected PolluxUI getVafUI() {
		return (PolluxUI) super.getVafUI();
	}
	
	@Override
	public Display getDisplay() {
		return (Display) super.getDisplay();
	}
	
	@Override
	protected BaseDisplay createDisplay() {
		
		// TODO dies ist die einzige Stelle, wo der Presenter 
		// die echte View kennt -> in Config verlagern
		PollsOverviewView view = new PollsOverviewView();
		view.setPresenter(this);
		return view;
	}
	
	public void handleNewPollEvent() {
//		getApplication().showPollEditView(new Abstimmung());
		
		Notification.show("Not yet implemented", Notification.Type.HUMANIZED_MESSAGE);
	}
	
	public void handleGotoPollEvent() {
		Poll poll = getDisplay().getSelectedPoll();
		
		if (poll == null) {
			// TODO allgemeinen Service anbieten
			Notification.show("Nothing selected!", Notification.Type.HUMANIZED_MESSAGE);
		} else {
			openView(new PollPresenter((PolluxUI) UI.getCurrent(), getTabSheetPresenter(), poll) );
//			getPollsView().openView("id", 
//									new PollView(), 
//									poll.getTitle());
		}
		
	}

	public void handleDeletePollEvent() {
		Notification.show("Not yet implemented", Notification.Type.HUMANIZED_MESSAGE);	
	}

	@Override
	public String getTabSheetCaption() {
		return "Übersicht";
	}
	
	@Override
	public void updateDisplay() {
		
		// TODO updateDisplay() in Oberklasse aufnehmen
		
		// TODO Abhaengigkeiten setzen und nicht ueber ThreadLocal holen
		PolluxModel model = ((PolluxUI)UI.getCurrent()).getModel();
		List<Poll> pollList = model.getPolls();
		getDisplay().updatePollsTable(pollList);

		
//		getDisplay().setAbstimmungContainer(getApplication().getDataSource());
	}


}
