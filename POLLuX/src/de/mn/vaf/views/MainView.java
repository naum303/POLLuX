package de.mn.vaf.views;

import java.util.HashMap;
import java.util.Map;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import de.mn.pollux.PolluxUI;
import de.mn.pollux.presenter.PollsTabSheetPresenter;
import de.mn.vaf.VafUI;
import de.mn.vaf.presenter.TabSheetPresenter;


public class MainView extends VerticalLayout implements View {
    private static final long serialVersionUID = -3398565663865641952L;
    Panel panel;

	public static final String NAME = "MainView";
	
	private enum ContentViewName { POLLS, USER };
	private Map<ContentViewName, Component> contentViewMap = new HashMap<ContentViewName, Component>(); 
	
    // Menu navigation button listener
    class ButtonListener implements Button.ClickListener {
        private static final long serialVersionUID = -4941184695301907995L;

        ContentViewName contenView;
        public ButtonListener(ContentViewName contenView) {
            this.contenView = contenView;
        }

        @Override
        public void buttonClick(ClickEvent event) {
            // Navigate to a specific state
        	getUI().getNavigator().navigateTo(NAME + "/" + contenView);
        }
    }

    public MainView() {
        setSizeFull();
        
        // Layout with menu on left and view area on right
        HorizontalLayout hLayout = new HorizontalLayout();
        hLayout.setSizeFull();

        // Have a menu on the left side of the screen
        Panel menu = new Panel("Menu");
        menu.setHeight("100%");
        menu.setWidth(null);
        VerticalLayout menuContent = new VerticalLayout();
        menuContent.addComponent(new Button("Polls",
                  new ButtonListener(ContentViewName.POLLS)));
        menuContent.addComponent(new Button("User",
                  new ButtonListener(ContentViewName.USER)));
        menuContent.setWidth(null);
        menuContent.setMargin(true);
        menu.setContent(menuContent);
        hLayout.addComponent(menu);

        // A panel that contains a content area on right
        panel = new Panel("View");
        panel.setSizeFull();
        hLayout.addComponent(panel);
        hLayout.setExpandRatio(panel, 1.0f);

        addComponent(hLayout);
        setExpandRatio(hLayout, 1.0f);
        
        // Allow going back to the start
        Button logout = new Button("Logout",
                   new Button.ClickListener() {
            private static final long serialVersionUID = -1809072471885383781L;

            @Override
            public void buttonClick(ClickEvent event) {
            	
            	((PolluxUI)getUI()).getModel().logout();

    			// Refresh this view, should redirect to login view
    			getUI().getNavigator().navigateTo(NAME);
            }
        });
        addComponent(logout);
    }        
    
    @Override
    public void enter(ViewChangeEvent event) {
        VerticalLayout panelContent = new VerticalLayout();
        panelContent.setSizeFull();
        panelContent.setMargin(true);
        panel.setContent(panelContent); // Also clears

        if (event.getParameters() == null
            || event.getParameters().isEmpty()) {
            panelContent.addComponent(getContentView(ContentViewName.POLLS));
            return;
        }

        ContentViewName contenViewName = ContentViewName.valueOf(event.getParameters());
        panelContent.addComponent(getContentView(contenViewName));
        
        // Display the fragment parameters
//        Label watching = new Label(
//            "You are currently watching a " +
//            event.getParameters());
//        watching.setSizeUndefined();
//        panelContent.addComponent(watching);
//        panelContent.setComponentAlignment(watching,
//            Alignment.MIDDLE_CENTER);
//        
//        // Some other content
//        Embedded pic = new Embedded(null,
//            new ThemeResource("img/" + event.getParameters() +
//                              "-128px.png"));
////        Label pic = new Label(event.getParameters());
//        panelContent.addComponent(pic);
//        
//        panelContent.setExpandRatio(pic, 1.0f);
//        panelContent.setComponentAlignment(pic,
//                Alignment.MIDDLE_CENTER);
//
//        Label back = new Label("And the " +
//            event.getParameters() + " is watching you");
//        back.setSizeUndefined();
//        panelContent.addComponent(back);
//        panelContent.setComponentAlignment(back,
//            Alignment.MIDDLE_CENTER);
    }
    
    private CustomComponent getContentView(ContentViewName contentViewName) {
    	
    	Component contentView = contentViewMap.get(contentViewName);
    	
    	if (contentView == null) {
    	
    		switch (contentViewName) {
    		case POLLS:
    			TabSheetPresenter tabSheetPresenter = new PollsTabSheetPresenter((VafUI) getUI());
    			tabSheetPresenter.start();
    			contentView = (Component) tabSheetPresenter.getDisplay();
    			break;
    		case USER:
    			contentView = new UserView();
    			break;

    		default:
    			break;
    		}
    		contentViewMap.put(contentViewName, contentView);
    	}
    	return (CustomComponent) contentView;
    }
}
