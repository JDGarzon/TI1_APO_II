package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import Exceptions.NoSenseTimeException;
import Exceptions.OverwriteException;

public class IcesiFilms implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Room> miniRoom;
	private ArrayList<Room> middleRoom;
	public static final int NUM_CHAIRS=7;
	public static final int ROWS_MIDDLE=6;
	public static final int ROWS_MINI=4;
	public IcesiFilms() {
		miniRoom =new ArrayList<> ();
		middleRoom=new ArrayList<> ();
	}
	public ArrayList<Room> getMiddleRoom() {
		return middleRoom;
	}
	public ArrayList<Room> getMiniRoom() {
		return miniRoom;
	}
	
	public int countCustomer(int i, Customer customer) {
		return middleRoom.get(i).countCustomer(customer);
	}
	
	public void addCustomer(String id,String name,int row,int numChair,int roomType,int index) throws Exception {
		Chair chairToAdd;
		if(roomType==1) {
			chairToAdd=middleRoom.get(index).getChairs()[row][numChair];
			if(chairToAdd.getCustomer()==null) {
				middleRoom.get(index).addACustomer(id, name, row, numChair);
			}else {
				throw new OverwriteException();
			}
		}else if(roomType==2) {
			chairToAdd=miniRoom.get(index).getChairs()[row][numChair];
			if(chairToAdd.getCustomer()==null) {
				miniRoom.get(index).addACustomer(id, name, row, numChair);
			}else {
				throw new OverwriteException();
			}
			
		}
	}
	public boolean [][] middleRoomAviability(int index){
		return middleRoom.get(index).getChairsAviability();
	}
	public boolean [][] miniRoomAviability(int index){
		boolean [][]  out=miniRoom.get(index).getChairsAviability();
		return out;
	}
	public boolean isFunctionMiddle(int index) {
		return middleRoom.get(index).getFunction()==null;
	}
	public boolean isFunctionMini(int index) {
		return miniRoom.get(index).getFunction()==null;
	}
	
	public int getAmountFunctions() {
		return miniRoom.size()+middleRoom.size();
	}
	
	
	public String[] getFunctionsNames(int type) {
		String[] names=null;
		int i;
		
		if(type==1) {
			names=new String[middleRoom.size()];
			for(i=0;i<middleRoom.size();i++) {
				names[i]=middleRoom.get(i).getFunction().getName();
			}
		}else if(type==2) {
			names=new String[miniRoom.size()];
			for(i=0;i<miniRoom.size();i++) {
				names[i]=miniRoom.get(i).getFunction().getName();
			}
		}
		return names;
	}
	
	public String report() {
		String out="";
		for(Room i:middleRoom) {
			out+=i.toString();
		}
		for(Room i:miniRoom) {
			out+=i.toString();
		}
		return out;
	}
	public void registerfunction(String name, LocalDate date, int hour,
			int minute, int hourD, int minuteD, int roomType, int hourHand) throws Exception
	{
		if(hour > 12 || minute >= 60 || hourD > 12 || minuteD >= 60 )
		{
			throw new NoSenseTimeException();
		}
		Cronos initialTime = new Cronos(hour, minute, hourHand);
		Cronos duration = new Cronos(hourD, minuteD, 0);
		
		Function toAdd = new Function(name, date, initialTime, duration);
		
		Function toCompare;
		
		if(roomType==1)		//Index = 1 MidleRoom; Index = 2 MiniRoom 
		{
			for(int i = 0; i < middleRoom.size(); i++)
			{
				toCompare = middleRoom.get(i).getFunction();
				
				if(toCompare.getDate().toString().equals(date.toString()))
				{
					toAdd.isOverexposed(toCompare);
				}
			}
			Room toAddR = new Room(ROWS_MIDDLE, NUM_CHAIRS);
			toAddR.setFunction(toAdd);
			middleRoom.add(toAddR);
			
		}
		else
		{
			for(int i = 0; i < miniRoom.size(); i++)
			{
				toCompare = miniRoom.get(i).getFunction();
					
				if(toCompare.getDate().toString().equals(date.toString()))
				{
					toAdd.isOverexposed(toCompare);
				}
			}
			Room toAddR = new Room(ROWS_MINI, NUM_CHAIRS);
			toAddR.setFunction(toAdd);
			miniRoom.add(toAddR);
		}
	}
	
	
}
