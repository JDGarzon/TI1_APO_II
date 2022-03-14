package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import controller.*;

import controller.LoginController;
import controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.*;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private Stage currentStage;
	private IcesiFilms cinema;
	public Main() {
		cinema = new IcesiFilms();
	}
	@Override
	public void start(Stage primaryStage) {
		deserialize();
		try {
			showLogin();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void serialize() {
		File file = new File("IcesiFilmsFile.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cinema);
			System.out.print("IcesiFilms has been serialized");
			oos.close();
			fos.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deserialize() {
		File file = new File("IcesiFilmsFile.txt");
		
		
		try {
			FileInputStream fis = new FileInputStream(file);
			
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			cinema = (IcesiFilms) ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void showLogin()
	{
		try {
			BorderPane root;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Login.fxml"));
			root = (BorderPane)loader.load();
			
			LoginController controller = loader.getController();
			controller.setMain(this);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			currentStage = stage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showMenu()
	{
		try {
			BorderPane root;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Menu.fxml"));
			root = (BorderPane)loader.load();
			
			MenuController controllerz = loader.getController();
			controllerz.setMain(this);
			
			Scene scene= new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			currentStage.setScene(scene);
			currentStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void startCinemaHall(String id,String name,int indexRoom,int type) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/CinemaHall.fxml"));
			BorderPane newRoot = (BorderPane)loader.load();
			BorderPane root = (BorderPane) currentStage.getScene().getRoot();
			CinemaHallController controller = loader.getController();
			controller.setMain(this);
			controller.init(id,name,indexRoom,type);
			controller.refresh();
			root.setCenter(newRoot);
			currentStage.setHeight(400);
			currentStage.setWidth(620);
			currentStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void registerFunction()
	{
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/FunctionRegister.fxml"));
			
			BorderPane newRoot = (BorderPane)loader.load();
			
			BorderPane root = (BorderPane) currentStage.getScene().getRoot();
			
			FunctionRegisterController controller = loader.getController();
			controller.setMain(this);
			root.setCenter(newRoot);
			currentStage.setHeight(350);
			currentStage.setWidth(300);
			currentStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean[][] getChairsAviabilityMiddle(int index) {
		return cinema.middleRoomAviability(index);
	}
	public boolean[][] getChairsAviabilityMini(int index) {
		return cinema.miniRoomAviability(index);
	}
	public boolean isFunctionMiddle(int index) {
		return cinema.isFunctionMiddle(index);
	}
	public boolean isFunctionMini(int index) {
		return cinema.isFunctionMiddle(index);
	}
	public void addCustomer(String id,String nam,int row,int numChair,int type,int index) throws Exception {
		cinema.addCustomer(id, nam, row, numChair, type,index);
	}
	public void returnToMenu() {
		serialize();
		currentStage.close();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Menu.fxml"));
			BorderPane root = (BorderPane)loader.load();
			currentStage=new Stage();
			MenuController controller = loader.getController();
			controller.setMain(this);
			Scene scene = new Scene(root,300,350);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			currentStage.setScene(scene);
			currentStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void startCustomerR() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/CustomerRegister.fxml"));
			BorderPane newRoot = (BorderPane)loader.load();
			BorderPane root = (BorderPane) currentStage.getScene().getRoot();
			CustomerRegistererController controller = loader.getController();
			controller.setMain(this);
			root.setCenter(newRoot);
			currentStage.setHeight(350);
			currentStage.setWidth(300);
			currentStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addFunction(String name, LocalDate date, int hour, int minute,
			int hourD, int minuteD, int index, int hourHand) throws Exception 
	{
		cinema.registerfunction(name, date, hour, minute, hourD, minuteD, index, hourHand);
	}
	
	public int getAmountFunctions() {
		return cinema.getAmountFunctions();
	}
	public String[] getFunctionsName(int type) {
		
		return cinema.getFunctionsNames(type);
	}
	public void report() 
	{
		{
			try 
			{
			BorderPane root;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Report.fxml"));
			root = (BorderPane)loader.load();
			
			ReportController controller = loader.getController();
			String report=cinema.report();
			
			controller.init(report);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("../ui/application.css").toExternalForm());
			
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
			} catch(Exception e) 
			{
				e.printStackTrace();
			}
		
		}
	}
}
