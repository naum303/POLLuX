package de.mn.vaf.entities;

import java.io.Serializable;

public class BaseEntity implements Serializable {

	private long id;
	
	public BaseEntity() {
		id = EntityIdGenerator.getNextId();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
