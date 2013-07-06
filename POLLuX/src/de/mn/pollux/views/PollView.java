package de.mn.pollux.views;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.mn.pollux.PolluxUI;
import de.mn.pollux.entities.Poll;
import de.mn.pollux.presenter.PollPresenter.Display;
import de.mn.vaf.util.Logger;

public class PollView extends CustomComponent implements Display {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private HorizontalLayout buttonLayout;
	@AutoGenerated
	private Button btClose;
	@AutoGenerated
	private TextArea taDescription;
	@AutoGenerated
	private TextField txTitle;
	
	private FieldGroup fieldGroup;
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PollView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		String username = ((PolluxUI)UI.getCurrent()).getModel().getUser().getUsername();
		
		bindFieldGroup();

	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("-1px");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(true);
		
		// top-level component properties
		setWidth("-1px");
		setHeight("-1px");
		
		// txTitle
		txTitle = new TextField();
		txTitle.setCaption("Titel");
		txTitle.setImmediate(false);
		txTitle.setWidth("-1px");
		txTitle.setHeight("-1px");
		mainLayout.addComponent(txTitle);
		
		// taDescription
		taDescription = new TextArea();
		taDescription.setCaption("Beschreibung");
		taDescription.setImmediate(false);
		taDescription.setWidth("-1px");
		taDescription.setHeight("-1px");
		mainLayout.addComponent(taDescription);
		
		// buttonLayout
		buttonLayout = buildButtonLayout();
		mainLayout.addComponent(buttonLayout);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildButtonLayout() {
		// common part: create layout
		buttonLayout = new HorizontalLayout();
		buttonLayout.setImmediate(false);
		buttonLayout.setWidth("-1px");
		buttonLayout.setHeight("-1px");
		buttonLayout.setMargin(true);
		buttonLayout.setSpacing(true);
		
		// btClose
		btClose = new Button();
		btClose.setCaption("Schlie�en");
		btClose.setImmediate(false);
		btClose.setWidth("-1px");
		btClose.setHeight("-1px");
		buttonLayout.addComponent(btClose);
		
		return buttonLayout;
	}

	private void bindFieldGroup() {
		fieldGroup =  new FieldGroup();
		
		fieldGroup.bind(txTitle, Poll.Property.title);
		fieldGroup.bind(taDescription, Poll.Property.description);
	}
	
	@Override
	public void showPoll(Poll poll) {
		BeanItem<Poll> beanItem = new BeanItem<Poll>(poll);
		fieldGroup.setItemDataSource(beanItem);
	}
	
	@Override
	public Poll getPoll() {
		
		try {
			// Aenderungen in Bean uebertragen
			fieldGroup.commit();
			Poll poll = ((BeanItem<Poll>)fieldGroup.getItemDataSource()).getBean();
			
			return poll;
		} catch (CommitException e) {
			Logger.log(e);
			throw new RuntimeException(e);
		}
	}
}
