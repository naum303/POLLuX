package de.mn.pollux.model;

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

public class TestPolluxModel {

	@Test
	public void testGetPolls() {
		
		PolluxModel model = new PolluxModel();
		
		// Testaufruf
		List<Poll> pollList = model.getPolls();
		
		Assert.assertThat("pollList", pollList, is(notNullValue()));
		Assert.assertThat("pollList", pollList, is(not(empty())));
	}

}
