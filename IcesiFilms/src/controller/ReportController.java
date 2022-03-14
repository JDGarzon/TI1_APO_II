package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ReportController {
	@FXML
	Label report;
	
	public void init(String report) {
		this.report.setText(report);
	}
}
