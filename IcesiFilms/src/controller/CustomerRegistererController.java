package controller;
import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
public class CustomerRegistererController {
	@FXML
	TextField id;
	@FXML
	TextField name;
	@FXML
	private ComboBox<String> selectAFunction;
	@FXML
	private RadioButton mini;
	@FXML
	private RadioButton middle;
	private Main main;
	private int type;
	private int amountFunctions;
	@FXML
	public void rbMddle() {
		type=1;
		refresh();
	}
	@FXML
	public void rbMini() {
		type=2;
		refresh();
	}
	
	@FXML
	public void close() {
		
	}
	@FXML
	public void save() {
		if(middle.isSelected()||mini.isSelected()) {
			main.startCinemaHall(id.getText(), name.getText(),selectAFunction.getSelectionModel().getSelectedIndex(),type);
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No function selected");
			alert.setHeaderText("The function is not selected");
			alert.setContentText("Try to select a function");				
		
			alert.showAndWait();
		}
		
	}
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void refresh() {
		selectAFunction.getItems().clear();
		int i;
		String [] names=main.getFunctionsName(type);
		amountFunctions=names.length;
		for(i=0;i<amountFunctions;i++) {
			selectAFunction.getItems().add(names[i]);	
		}
	}
	
}
