package de.mn.vaf.model;

import java.io.Serializable;

import de.mn.vaf.entities.User;

public class VafModel implements Serializable{

  private User user;

  public boolean loginUser(String username, String password) {
  	
  	// TODO check login
  	boolean isValid = true;
//  	boolean isValid = username.equals("test@test.com")
//	&& password.equals("passw0rd");
  	
  	if (isValid) {
		// Store the current user in the service session
  		user = new User();
  		if (username == null || username.length() == 0) {
  			username = "Dummy";
  		}
  			
  		user.setUsername(username);
//		getSession().setAttribute("user", username);

  	} else {
  		
  	}
  	
  	return isValid;
  }

 public void logout() {
	// "Logout" the user
	//getSession().setAttribute("user", null);
  	user = null;

  }
  
  public User getUser() {
  	return user;
  	//return getSession().getAttribute("user");
  }

}
