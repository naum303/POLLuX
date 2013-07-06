package de.mn.vaf.presenter;

import java.io.Serializable;

import de.mn.vaf.VafUI;

public abstract class BasePresenter implements Serializable {

	
	private VafUI vafUI;
	private BaseDisplay baseDisplay;

	public BasePresenter(VafUI vafUI) {
		this.vafUI= vafUI;
	}
	
	protected VafUI getVafUI() {
		return vafUI;
	}
		
	public BaseDisplay getDisplay() {
		if (baseDisplay == null) {
			baseDisplay = createDisplay();
			
		}
		return baseDisplay;
	}
	
	public void setDisplay(BaseDisplay display) {
		baseDisplay = display;
	}
	
	protected abstract BaseDisplay createDisplay();
	
	public abstract void updateDisplay();
}
