package de.mn.vaf;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import de.mn.vaf.model.VafModel;
import de.mn.vaf.views.LoginView;
import de.mn.vaf.views.MainView;

public abstract class VafUI extends UI {
	
    private static final long serialVersionUID = 511085335415683713L;
    
    Navigator  navigator;
    VafModel vafModel;
  
    protected abstract VafModel createModel();
    
    public VafModel getModel() {
    	if (vafModel == null) {
  		vafModel = createModel();
  	}
    	return vafModel;
    }        
    
    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("POLLuX");
        
        // Create a navigator to control the views
        navigator = new Navigator(this, this);
        
        // Create and register the views
//        navigator.addView("", new StartView());
//        navigator.addView(MAINVIEW, new MainView());
        
        
        //
        // The initial log view where the user can login to the application
        //
        getNavigator().addView(LoginView.NAME, LoginView.class);

        //
        // Add the main view of the application
        //
        getNavigator().addView(MainView.NAME, MainView.class);
                       
        //
        // We use a view change handler to ensure the user is always redirected
        // to the login view if the user is not logged in.
        //
        getNavigator().addViewChangeListener(new ViewChangeListener() {
            
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                
                // Check if a user has logged in
                boolean isLoggedIn = getModel().getUser() != null;
                boolean isLoginView = event.getNewView() instanceof LoginView;

                if (!isLoggedIn && !isLoginView) {
                    // Redirect to login view always if a user has not yet
                    // logged in
                    getNavigator().navigateTo(LoginView.NAME);
                    return false;

                } else if (isLoggedIn && isLoginView) {
                    // If someone tries to access to login view while logged in,
                    // then cancel
                    return false;
                }

                return true;
            }
            
            @Override
            public void afterViewChange(ViewChangeEvent event) {
                
            }
        });
        
    }
    
     
 }
