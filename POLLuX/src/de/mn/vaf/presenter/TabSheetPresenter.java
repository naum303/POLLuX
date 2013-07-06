package de.mn.vaf.presenter;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;

import de.mn.vaf.VafUI;
import de.mn.vaf.views.TabSheetView;

public abstract class TabSheetPresenter extends BasePresenter {
	
	public interface Display extends BaseDisplay {
		
		public void openView(Object id, Component component, String caption );
	}

	

	public TabSheetPresenter(VafUI vafUI) {
		super(vafUI);
	}

	@Override
	protected BaseDisplay createDisplay() {
		TabSheetView view = new TabSheetView();
		//view.setPresenter(this);
		return view;
	}
	
	@Override
	public Display getDisplay() {
		return (Display) super.getDisplay();
	}

	public abstract TabSheetViewPresenter getOverviewPresenter();
	
	
	public void start() {
		
		TabSheetViewPresenter overviewPresenter = getOverviewPresenter();
		
		openView(overviewPresenter);
	}
	
	public void openView(TabSheetViewPresenter presenter) {
		
		presenter.updateDisplay();
		Component component = (Component) presenter.getDisplay();
//		component.setImmediate(false);
//		component.setWidth("100.0%");
//		component.setHeight("100.0%");

		getDisplay().openView("dummy", component, presenter.getTabSheetCaption());
		
	}
}
