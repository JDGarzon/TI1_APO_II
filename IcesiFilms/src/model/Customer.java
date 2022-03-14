package model;

import java.io.Serializable;

public class Customer extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public Customer(String id,String name) {
		super(id);
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name;
	}

}
