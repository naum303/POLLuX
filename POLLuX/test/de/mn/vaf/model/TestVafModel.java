package de.mn.vaf.model;

import java.util.List;

import static org.hamcrest.core.IsNull.*;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNot.*;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.collection.IsEmptyCollection.*;
import org.junit.Assert;
import org.junit.Test;

import de.mn.pollux.entities.Poll;
import de.mn.pollux.model.PolluxModel;
import de.mn.vaf.entities.User;

public class TestVafModel {

	@Test
	public void testLoginUser_succes() {
		VafModel model = new VafModel();
		
		// Testaufruf
		boolean success = model.loginUser("bla", "bla");
		
		Assert.assertThat(success, is(equalTo(true)));
	}
	
	@Test
	public void testGetUser_WithLogin() {
		VafModel model = new VafModel();
		
		model.loginUser("bla", "bla");

		// Testaufruf
		User user = model.getUser();

		Assert.assertThat(user, is(notNullValue()));
	}

	@Test
	public void testGetUser_WithoutLogin() {
		VafModel model = new VafModel();
		
		// Testaufruf
		User user = model.getUser();

		Assert.assertThat(user, is(nullValue()));
	}

	@Test
	public void testLogout() {
		VafModel model = new VafModel();
		
		model.loginUser("bla", "bla");

		// Testaufruf
		model.logout();

		User user = model.getUser();

		Assert.assertThat(user, is(nullValue()));
	}

}
