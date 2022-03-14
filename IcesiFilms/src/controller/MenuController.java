package controller;

import application.Main;
import javafx.fxml.FXML;

public class MenuController {
	
	Main main;
	@FXML
	public void close() {
		main.returnToMenu();
	}
	@FXML
	public void openRegisterPeople() {
		main.startCustomerR();
	}
	@FXML
	public void openRegisterFunction()
	{
		main.registerFunction();
	}
	
	public void setMain(Main main) {
		this.main=main;
	}
	@FXML
	public void report() {
		main.report();
	}
}
