package model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import Exceptions.OverexposedFunctionException;
import Exceptions.OverwriteException;


public class IcesiFilmsTest {
	
	private IcesiFilms icesiFilms;

	public void setupStage1() {
		icesiFilms = new IcesiFilms();
		
	}
	
	public void setupStage2() {
		setupStage1();
		String name = "Terminator";
		LocalDate date = LocalDate.of(2022, 04, 15);
		int hour = 3;
		int minute = 10;
		int hourDuration = 1;
		int minuteDuration = 00;
		int roomType = 1;
		int hourHand = 1;
		try {
			icesiFilms.registerfunction(name, date, hour, minute, hourDuration, minuteDuration, roomType, hourHand);
		}catch(Exception e) {
			fail("the exception should not be thrown");
		}
	}
	
	public void setupStage3() {
		setupStage2();
		String id = "2003";
		String name= "Pipe";
		int row = 2;
		int numChair = 5;
		int roomType = 1;
		int index = 0;
		try {
			icesiFilms.addCustomer(id, name, row, numChair, roomType, index);
		}catch(Exception e) {
			fail("the exception should not be thrown");
		}
	}
	
	@Test
	public void registerFunctionTest() {
		setupStage1();
		String name = "Terminator";
		LocalDate date = LocalDate.of(2022, 04, 15);
		int hour = 3;
		int minute = 10;
		int hourDuration = 1;
		int minuteDuration = 00;
		int roomType = 1;
		int hourHand = 0;
		
		try {
			icesiFilms.registerfunction(name, date, hour, minute, hourDuration, minuteDuration, roomType, hourHand);
		}catch(OverexposedFunctionException e) {
			fail("the exception should not be thrown");
		}catch(Exception e) {
			fail("the exception should not be thrown");
		}
		assertEquals("List size is not 1", 1, icesiFilms.getAmountFunctions());
	}
	
	@Test
	public void OverexposedFunctionExceptionTest() {
		setupStage2();
		String name = "Terminator";
		LocalDate date = LocalDate.of(2022, 04, 15);
		int hour = 3;
		int minute = 10;
		int hourDuration = 1;
		int minuteDuration = 00;
		int roomType = 1;
		int hourHand = 1;
		
		try {
			icesiFilms.registerfunction(name, date, hour, minute, hourDuration, minuteDuration, roomType, hourHand);
			fail("The exception wasn't thrown");
		}catch(OverexposedFunctionException e) {
			try {
				
			}catch(Exception k) {
				fail("the exception should not be thrown");
			}
		}catch(Exception e) {

		}
		assertEquals("List size is not 1", 1, icesiFilms.getAmountFunctions());
	}
	
	@Test
	public void registerCustomerTest() {
		setupStage2();
		String id = "2003";
		String name= "Pipe";
		int row = 2;
		int numChair = 5;
		int roomType = 1;
		int index = 0;
		Customer customer = new Customer(id, name);
		try {
			icesiFilms.addCustomer(id, name, row, numChair, roomType, index);
		}catch(OverwriteException e) {
			fail("the exception should not be thrown");
		}catch(Exception e) {
			fail("the exception should not be thrown");
		}
		assertEquals("Item was not added to the list", 1 ,icesiFilms.countCustomer(index, customer));
	}
	
	@Test
	public void OverWriteExceptionTest() {
		setupStage3();
		String id = "2004";
		String name= "Juan David";
		int row = 2;
		int numChair = 5;
		int roomType = 1;
		int index = 0;
		Customer customer = new Customer(id, name);
		try {
			icesiFilms.addCustomer(id, name, row, numChair, roomType, index);
			fail("The exception wasn't thrown");
		}catch(OverwriteException e) {
	
		}catch(Exception e) {
			
		}
		assertEquals("Item was added to the list",1 ,icesiFilms.countCustomer(index, customer));
	}
}
