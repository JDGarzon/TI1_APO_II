package model;

import java.io.Serializable;

public class Chair implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean avaible;
	private Customer customer;
	public Chair() {
		avaible=false;
		setCustomer(null);
	}

	public boolean isAvaible() {
		return avaible;
	}

	public void setAvaible(boolean avaible) {
		this.avaible = avaible;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String toString() {
		String out="";
		if(customer!=null) {
			out=customer.toString();
		}
		return out;
	}
}
