package de.mn.vaf.entities;

public class EntityIdGenerator {

	private static long maxId=0l;
	
	public static long getNextId() {
		maxId++;
		return maxId;
	}

}
