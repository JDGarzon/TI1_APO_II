package list;

import static org.junit.Assert.*;
import org.junit.Test;

import Exceptions.IdNotFoundException;

public class EmployeeListTest {

	private EmployeeList employees;
	
	public void setupStage1() {
		employees = new EmployeeList();
	}
	
	public void setupStage2() {
		employees = new EmployeeList();
		String id = "1234";
		employees.addEmployee(id);
	}
	
	@Test
	public void testAddElement() {
		setupStage1();
		String id = "1234";
		employees.addEmployee(id);
		assertTrue("Item was not added to the list", employees.searchId(id));
		assertEquals("List size is not 1", 1, employees.getEmployees().size());
	}
	
	@Test
	public void testValidateEmployeeTrue() {
		setupStage2();
		String id2 = "1234";
		try {
			employees.validate(id2);
			
		}catch(IdNotFoundException e) {
			fail("The exception wasn thrown");
		}
	}
	
	@Test
	public void testValidateEmployeeFalse() {
		setupStage2();
		String id2 = "5678";
		try {
			employees.validate(id2);
			fail("The exception wasn't thrown");
		}catch(IdNotFoundException e) {
			
		}
	}
}