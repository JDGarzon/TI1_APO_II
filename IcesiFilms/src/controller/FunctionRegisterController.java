package controller;

import application.Main;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.time.LocalDate;

import Exceptions.NoSenseTimeException;
import Exceptions.OverexposedFunctionException;

public class FunctionRegisterController {
	
	private Main main;
	private LocalDate dateSelected;

	@FXML
	private Button enterButton;
	@FXML
	private TextField filmeField;
	@FXML
	private TextField hourField;
	@FXML
	private TextField minuteField;
	@FXML
	private TextField hourFieldD;
	@FXML
	private TextField minuteFieldD;
	@FXML
	private DatePicker dateSelector;
	@FXML
	private ComboBox<String> amOrpm;
	@FXML
	private ComboBox<String> roomSelector;
	
	@FXML
	public void Create() throws Exception
	{		
		dateSelected = dateSelector.getValue();
		
		String filme = filmeField.getText();
		
		int index = roomSelector.getSelectionModel().getSelectedIndex()+1;
		
		int hourHand = amOrpm.getSelectionModel().getSelectedIndex();
		
		int hour = Integer.parseInt(hourField.getText(),10);
		
		int minute = Integer.parseInt(minuteField.getText(),10);
		
		int hourD = Integer.parseInt(hourFieldD.getText(),10);
		
		int minuteD = Integer.parseInt(minuteFieldD.getText(),10);
		
		try
		{
			main.addFunction(filme, dateSelected, hour, minute, hourD, minuteD, index, hourHand);
			main.returnToMenu();
		}
		catch(OverexposedFunctionException | NoSenseTimeException e)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error Dialog");
			
			if(e instanceof OverexposedFunctionException)
			{
				alert.setHeaderText("This time is already in use");
				alert.setContentText("Please try another");
			}
			else
			{
				alert.setHeaderText("Unvalid time paremeters");
				alert.setContentText("Write a valid parameters");
			}		
			alert.showAndWait();			
		}
	}
	
	public Main getMain()
	{
		return main;
	}

	public void setMain(Main main)
	{
		this.main = main;
	}

	public void initialize()
	{
		amOrpm.getItems().add("a.m");
		amOrpm.getItems().add("p.m");

		roomSelector.getItems().add("Medium room");
		roomSelector.getItems().add("Mini room");
	}
}