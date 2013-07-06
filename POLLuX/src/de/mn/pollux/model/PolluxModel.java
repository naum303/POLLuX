package de.mn.pollux.model;

import java.util.ArrayList;
import java.util.List;

import de.mn.pollux.entities.Poll;
import de.mn.vaf.entities.User;
import de.mn.vaf.model.VafModel;

public class PolluxModel extends VafModel {

   private List<Poll> pollList;

   public PolluxModel() {
	
	   initPollList();
   }
   
   private void initPollList() {
	   
	   pollList = new ArrayList<Poll>();
	   
	   for (int i = 0; i < 10; i++) {
		   Poll poll = new Poll();
		   poll.setTitle("Poll "+i);
		   poll.setDescription("blabla "+i);
		   pollList.add(poll);
	   }
   }
   
   public List<Poll> getPolls() {
	   
	   if (pollList == null) {
		   // TODO hier die Poll fuer den aktuellen User ermitteln
		   initPollList();
	   }
	   
	   List<Poll> copyList = new ArrayList<Poll>(pollList.size());
	   copyList.addAll(pollList);
	   
	   return copyList;
   }
   
 
    
    
}
