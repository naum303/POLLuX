package de.mn.vaf.views;

import com.vaadin.ui.Panel;

import de.mn.vaf.presenter.BasePresenter;

public abstract class BaseView extends Panel{

	private BasePresenter presenter;

	public BaseView(BasePresenter presenter) {
		this.presenter = presenter;
	}
	
	protected BasePresenter getPresenter() {
		return presenter;
	}
}
