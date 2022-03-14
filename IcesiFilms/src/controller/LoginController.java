package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import list.EmployeeList;
import Exceptions.IdNotFoundException;
import application.*;

public class LoginController {
	
	private EmployeeList employees;
	
	private Main main;

	@FXML
	private Button enterButton;
	
	@FXML
	private TextField iDField;

	@FXML
	public void login() throws IdNotFoundException
	{
		employees = new EmployeeList();
		String enteredId = iDField.getText();
		
		try
		{
			employees.validate(enteredId);
			main.showMenu();
		}
		catch(IdNotFoundException e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			alert.setHeaderText("ID not found");
			alert.setContentText("Try another");				
		
			alert.showAndWait();
		}
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setIdField(String id) {
		iDField.setText(id);
	}
	
	public TextField getIdField() {
		return iDField;
	}
	
}
