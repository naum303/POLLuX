package de.mn.pollux;

import de.mn.pollux.model.PolluxModel;
import de.mn.vaf.VafUI;
import de.mn.vaf.model.VafModel;

public class PolluxUI extends VafUI {

  PolluxModel polluxModel;
  
  @Override
  protected VafModel createModel() {
  	return new PolluxModel();
  }
  
  public PolluxModel getModel() {
  	return (PolluxModel) super.getModel();
  }
  
}
