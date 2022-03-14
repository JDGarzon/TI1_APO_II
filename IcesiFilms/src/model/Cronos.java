package model;

import java.io.Serializable;

import Exceptions.NoSenseTimeException;
import Exceptions.OverexposedFunctionException;

public class Cronos implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hour;
	private int minute;
	
	public Cronos(int hour, int minute, int hourHand)
	{
		this.hour=hour;
		this.minute=minute;
		
		if(hourHand == 1)
		{
			this.hour += 12;
		}
	}

	public Cronos obtainFinalTime(Cronos toAdd) throws Exception
	{	
		Cronos finalTime = new Cronos(0, 0, 0);
		
		int hourToAdd = toAdd.getHour();
		int minuteToAdd = toAdd.getMinute();
		
		int finalHour = hour+hourToAdd;
		int finalMinute = minute+minuteToAdd;
		
		if(finalMinute >= 60)
		{
			finalMinute -= 60;
			finalHour++;
		}
		
		if(finalHour >= 24)
		{
			throw new NoSenseTimeException();
		}
		
		finalTime.setHour(finalHour);
		finalTime.setMinute(finalMinute);
		
		return finalTime;
	}
	
	public boolean isBeforeThan(Cronos compared) throws OverexposedFunctionException
	{
		boolean output = false; //output = before; !output = later
		
		if(compared.getHour() > hour)
		{
			output = true;
		}
		else if(compared.getHour() == hour)
		{
			if(compared.getMinute() > minute)
			{
				output = true;
			}
			else if(compared.getMinute() > minute)
			{
				throw new OverexposedFunctionException();
			}
		}
		
		return output;
	}
	
	public int getHour()
	{
		return hour;
	}

	public int getMinute() {
		return minute;
	}
	
	public void setHour(int hour)
	{
		this.hour = hour;
	}
	
	public void setMinute(int minute)
	{
		this.minute = minute;
	}
}
