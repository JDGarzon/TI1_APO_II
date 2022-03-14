package model;

import java.io.Serializable;
import java.time.LocalDate;

import Exceptions.OverexposedFunctionException;

public class Function implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private LocalDate date;
	private Cronos initialTime;
	private Cronos finalTime;

	public Function(String name, LocalDate date, Cronos initialTime, Cronos duration) throws Exception
	{
		this.setDate(date);
		this.setName(name);
		this.setInitialTime(initialTime);
		
		finalTime = initialTime.obtainFinalTime(duration);
	}

	public Cronos getInitialTime() {
		return initialTime;
	}
	public void setInitialTime(Cronos initialTime) {
		this.initialTime = initialTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Cronos getFinalTime() {
		return finalTime;
	}
	public void isOverexposed(Function compared) throws OverexposedFunctionException
	{
		if(initialTime.isBeforeThan(compared.getInitialTime()))
		{
			if(!(finalTime.isBeforeThan(compared.getInitialTime())))
			{
				throw new OverexposedFunctionException();
			}
		}
		else
		{
			if(!(compared.getFinalTime().isBeforeThan(initialTime)))
			{
				throw new OverexposedFunctionException();
			}
		}
	}
	
	public String toString() {
		String out=name+" - "+date.toString();
		return out;
	}
}
