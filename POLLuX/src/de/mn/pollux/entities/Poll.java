package de.mn.pollux.entities;

import de.mn.vaf.entities.BaseEntity;

public class Poll extends BaseEntity {

	public static final String PROPERTY_TITLE = "title";
	public static final String PROPERTY_DESCRIPTION = "description";
	public static final String[] PROPERTIES = new String[] {PROPERTY_TITLE, PROPERTY_DESCRIPTION};
	
	public Poll() {
	}
	
	private String title;
	private String description;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
