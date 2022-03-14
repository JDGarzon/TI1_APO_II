package model;

import java.io.Serializable;

public abstract class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	
	public User(String id) {
		this.id=id;
	}
	
	public String getId() {
		return id;
	}
}
