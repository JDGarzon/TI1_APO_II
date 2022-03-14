package list;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import Exceptions.IdNotFoundException;
import model.Employ;

public class EmployeeList implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Employ> employees;
	
	public EmployeeList() {
		employees = new ArrayList<>();
		loadEmployees();
	}
	
	
	
	public void loadEmployees(){
		try {
			File file = new File("EmployFile.txt");
			
			FileReader fr = new FileReader(file);
			
			BufferedReader input = new BufferedReader(fr);
			
			while (input.ready()) {
				
				String id = input.readLine();
				employees.add(new Employ(id));
			}
			
			input.close();
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addEmployee(String id) {
		employees.add(new Employ(id));
	}
	
	public ArrayList<Employ> getEmployees(){
		return employees;
	}
	
	public void validate(String iD) throws IdNotFoundException
	{
		boolean condition = searchId(iD);
		
		if(!condition)
		{
			throw new IdNotFoundException();
		}
	}
	
	public boolean searchId(String iD)
	{
		boolean condition = false;
		
		for (int i = 0; i < employees.size() && condition == false; i++)
		{
			if(iD.equals(employees.get(i).getId()))
			{
				condition = true;
			}
		}
		
		return condition;
	}
}
