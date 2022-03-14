package model;

import java.io.Serializable;

public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Chair[][] chairs;
	private Function function;
	private int rows;
	private int numChairs;
	public Room(int rows,int numChairs) {
		chairs=new Chair[rows][numChairs];
		this.rows=rows;
		this.numChairs=numChairs;
		int i;
		int j;
		for(i=0;i<rows;i++) {
			for(j=0;j<numChairs;j++) {
				chairs[i][j]=new Chair();
			}
		}
	}

	public Chair[][] getChairs() {
		return chairs;
	}
	
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
	
	public boolean[][] getChairsAviability(){
		boolean[][] chairsAviability= new boolean [rows][numChairs];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<numChairs;j++) {
				chairsAviability[i][j]=chairs[i][j].isAvaible();
			}
			
		}
		
		return chairsAviability;
	}
	
	public void addACustomer(String id,String name,int row,int numChair) {
		chairs[row][numChair].setCustomer(new Customer(id,name));
		chairs[row][numChair].setAvaible(true);
	}
	public String toString() {
		String out=function.toString();
		if(rows==IcesiFilms.ROWS_MIDDLE) {
			out+=" - Middle Room"+"\n";
			for(int i=0;i<rows;i++) {
				for(int j=0;j<numChairs;j++) {
					if(chairs[i][j].getCustomer()!=null) {
						out+=chairs[i][j].toString()+"\n";
					}
				}
			}
		}else if(rows==IcesiFilms.ROWS_MINI) {
			out+=" - Mini Room"+"\n";
			for(int i=0;i<rows;i++) {
				for(int j=0;j<numChairs;j++) {
					if(chairs[i][j].getCustomer()!=null) {
						out+=chairs[i][j].toString()+"\n";
					}
				}
			}
		}
		return out;
	}
	
	public int countCustomer(Customer customer) {
		int count = 0;
		for(int i = 0; i<chairs.length;i++) {
			for(int j = 0; j<chairs[0].length;j++) {
				if(chairs[i][j].getCustomer() != null) {
					count++;
				}
				
			}
		}	
		return count;
	}
}
