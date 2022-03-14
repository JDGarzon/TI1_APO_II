package controller;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class CinemaHallController {
	private Main main;
	String name;
	String id;
	int row;
	int numChair;
	int type;
	int indexRoom;
	Button[][] buttonCollectionMn;
	Button[][] buttonCollectionMd;
	
	@FXML
	Button button00;	
	@FXML
	Button button01;
	@FXML
	Button button02;
	@FXML
	Button button03;
	@FXML
	Button button04;
	@FXML
	Button button05;
	@FXML
	Button button06;
	@FXML
	Button button10;
	@FXML
	Button button11;
	@FXML
	Button button12;
	@FXML
	Button button13;
	@FXML
	Button button14;
	@FXML
	Button button15;
	@FXML
	Button button16;
	@FXML
	Button button20;
	@FXML
	Button button21;
	@FXML
	Button button22;
	@FXML
	Button button23;
	@FXML
	Button button24;
	@FXML
	Button button25;
	@FXML
	Button button26;
	@FXML
	Button button30;
	@FXML
	Button button31;
	@FXML
	Button button32;
	@FXML
	Button button33;
	@FXML
	Button button34;
	@FXML
	Button button35;
	@FXML
	Button button36;
	@FXML
	Button button00M;
	@FXML
	Button button01M;
	@FXML
	Button button02M;
	@FXML
	Button button03M;
	@FXML
	Button button04M;
	@FXML
	Button button05M;
	@FXML
	Button button06M;
	@FXML
	Button button10M;
	@FXML
	Button button11M;
	@FXML
	Button button12M;
	@FXML
	Button button13M;
	@FXML
	Button button14M;
	@FXML
	Button button15M;
	@FXML
	Button button16M;
	@FXML
	Button button20M;
	@FXML
	Button button21M;
	@FXML
	Button button22M;
	@FXML
	Button button23M;
	@FXML
	Button button24M;
	@FXML
	Button button25M;
	@FXML
	Button button26M;
	@FXML
	Button button30M;
	@FXML
	Button button31M;
	@FXML
	Button button32M;
	@FXML
	Button button33M;
	@FXML
	Button button34M;
	@FXML
	Button button35M;
	@FXML
	Button button36M;
	@FXML
	Button button40M;
	@FXML
	Button button41M;
	@FXML
	Button button42M;
	@FXML
	Button button43M;
	@FXML
	Button button44M;
	@FXML
	Button button45M;
	@FXML
	Button button46M;
	@FXML
	Button button50M;
	@FXML
	Button button51M;
	@FXML
	Button button52M;
	@FXML
	Button button53M;
	@FXML
	Button button54M;
	@FXML
	Button button55M;
	@FXML
	Button button56M;
	
	EventHandler<ActionEvent>[][] eventsMn;
	EventHandler<ActionEvent>[][] eventsMd;
	
	@SuppressWarnings("unchecked")
	public void init(String id,String name,int indexRoom,int indexType) {
		buttonCollectionMn=new Button[4][7];
		buttonCollectionMd=new Button[6][7];
		eventsMn=new EventHandler [4][7];
		eventsMd=new EventHandler[6][7];
		buttonCollectionMn[0][0]=button00;
		buttonCollectionMn[0][1]=button01;
		buttonCollectionMn[0][2]=button02;
		buttonCollectionMn[0][3]=button03;
		buttonCollectionMn[0][4]=button04;
		buttonCollectionMn[0][5]=button05;
		buttonCollectionMn[0][6]=button06;
		buttonCollectionMn[1][0]=button10;
		buttonCollectionMn[1][1]=button11;
		buttonCollectionMn[1][2]=button12;
		buttonCollectionMn[1][3]=button13;
		buttonCollectionMn[1][4]=button14;
		buttonCollectionMn[1][5]=button15;
		buttonCollectionMn[1][6]=button16;
		buttonCollectionMn[2][0]=button20;
		buttonCollectionMn[2][1]=button21;
		buttonCollectionMn[2][2]=button22;
		buttonCollectionMn[2][3]=button23;
		buttonCollectionMn[2][4]=button24;
		buttonCollectionMn[2][5]=button25;
		buttonCollectionMn[2][6]=button26;
		buttonCollectionMn[3][0]=button30;
		buttonCollectionMn[3][1]=button31;
		buttonCollectionMn[3][2]=button32;
		buttonCollectionMn[3][3]=button33;
		buttonCollectionMn[3][4]=button34;
		buttonCollectionMn[3][5]=button35;
		buttonCollectionMn[3][6]=button36;
		buttonCollectionMd[0][0]=button00M;
		buttonCollectionMd[0][1]=button01M;
		buttonCollectionMd[0][2]=button02M;
		buttonCollectionMd[0][3]=button03M;
		buttonCollectionMd[0][4]=button04M;
		buttonCollectionMd[0][5]=button05M;
		buttonCollectionMd[0][6]=button06M;
		buttonCollectionMd[1][0]=button10M;
		buttonCollectionMd[1][1]=button11M;
		buttonCollectionMd[1][2]=button12M;
		buttonCollectionMd[1][3]=button13M;
		buttonCollectionMd[1][4]=button14M;
		buttonCollectionMd[1][5]=button15M;
		buttonCollectionMd[1][6]=button16M;
		buttonCollectionMd[2][0]=button20M;
		buttonCollectionMd[2][1]=button21M;
		buttonCollectionMd[2][2]=button22M;
		buttonCollectionMd[2][3]=button23M;
		buttonCollectionMd[2][4]=button24M;
		buttonCollectionMd[2][5]=button25M;
		buttonCollectionMd[2][6]=button26M;
		buttonCollectionMd[3][0]=button30M;
		buttonCollectionMd[3][1]=button31M;
		buttonCollectionMd[3][2]=button32M;
		buttonCollectionMd[3][3]=button33M;
		buttonCollectionMd[3][4]=button34M;
		buttonCollectionMd[3][5]=button35M;
		buttonCollectionMd[3][6]=button36M;
		buttonCollectionMd[4][0]=button40M;
		buttonCollectionMd[4][1]=button41M;
		buttonCollectionMd[4][2]=button42M;
		buttonCollectionMd[4][3]=button43M;
		buttonCollectionMd[4][4]=button44M;
		buttonCollectionMd[4][5]=button45M;
		buttonCollectionMd[4][6]=button46M;
		buttonCollectionMd[5][0]=button50M;
		buttonCollectionMd[5][1]=button51M;
		buttonCollectionMd[5][2]=button52M;
		buttonCollectionMd[5][3]=button53M;
		buttonCollectionMd[5][4]=button54M;
		buttonCollectionMd[5][5]=button55M;
		buttonCollectionMd[5][6]=button56M;
		eventsMn[0][0]= e->{
			row=0;
			numChair=0;
			type=2;
			select();
		};
		eventsMn[0][1]= e->{
			row=0;
			numChair=1;
			type=2;
			select();
		};
		eventsMn[0][2]= e->{
			row=0;
			numChair=2;
			type=2;
			select();
		};
		eventsMn[0][3]= e->{
			row=0;
			numChair=3;
			type=2;
			select();
		};
		eventsMn[0][4]= e->{
			row=0;
			numChair=4;
			type=2;
			select();
		};
		eventsMn[0][5]= e->{
			row=0;
			numChair=5;
			type=2;
			select();
		};
		eventsMn[0][6]= e->{
			row=0;
			numChair=6;
			type=2;
			select();
		};
		eventsMn[1][0]= e->{
			row=1;
			numChair=0;
			type=2;
			select();
		};
		eventsMn[1][1]= e->{
			row=1;
			numChair=1;
			type=2;
			select();
		};
		eventsMn[1][2]= e->{
			row=1;
			numChair=2;
			type=2;
			select();
		};
		eventsMn[1][3]= e->{
			row=1;
			numChair=3;
			type=2;
			select();
		};
		eventsMn[1][4]= e->{
			row=1;
			numChair=4;
			type=2;
			select();
		};
		eventsMn[1][5]= e->{
			row=1;
			numChair=5;
			type=2;
			select();
		};
		eventsMn[1][6]= e->{
			row=1;
			numChair=6;
			type=2;
			select();
		};
		eventsMn[2][0]= e->{
			row=2;
			numChair=0;
			type=2;
			select();
		};
		eventsMn[2][1]= e->{
			row=2;
			numChair=1;
			type=2;
			select();
		};
		eventsMn[2][2]= e->{
			row=2;
			numChair=2;
			type=2;
			select();
		};
		eventsMn[2][3]= e->{
			row=2;
			numChair=3;
			type=2;
			select();
		};
		eventsMn[2][4]= e->{
			row=2;
			numChair=4;
			type=2;
			select();
		};
		eventsMn[2][5]= e->{
			row=2;
			numChair=5;
			type=2;
			select();
		};
		eventsMn[2][6]= e->{
			row=2;
			numChair=6;
			type=2;
			select();
		};
		eventsMn[3][0]= e->{
			row=3;
			numChair=0;
			type=2;
			select();
		};
		eventsMn[3][1]= e->{
			row=3;
			numChair=1;
			type=2;
			select();
		};
		eventsMn[3][2]= e->{
			row=3;
			numChair=2;
			type=2;
			select();
		};
		eventsMn[3][3]= e->{
			row=3;
			numChair=3;
			type=2;
			select();
		};
		eventsMn[3][4]= e->{
			row=3;
			numChair=4;
			type=2;
			select();
		};
		eventsMn[3][5]= e->{
			row=3;
			numChair=5;
			type=2;
			select();
		};
		eventsMn[3][6]= e->{
			row=3;
			numChair=6;
			type=2;
			select();
		};
		
		eventsMd[0][0]=e->{
			row=0;
			numChair=0;
			type=1;
			select();
		};
		eventsMd[0][1]=e->{
			row=0;
			numChair=1;
			type=1;
			select();
		};
		eventsMd[0][2]=e->{
			row=0;
			numChair=2;
			type=1;
			select();
		};
		eventsMd[0][3]=e->{
			row=0;
			numChair=3;
			type=1;
			select();
		};
		eventsMd[0][4]=e->{
			row=0;
			numChair=4;
			type=1;
			select();
		};
		eventsMd[0][5]=e->{
			row=0;
			numChair=5;
			type=1;
			select();
		};
		eventsMd[0][6]=e->{
			row=0;
			numChair=6;
			type=1;
			select();
		};
		eventsMd[1][0]=e->{
			row=1;
			numChair=0;
			type=1;
			select();
		};
		eventsMd[1][1]=e->{
			row=1;
			numChair=1;
			type=1;
			select();
		};
		eventsMd[1][2]=e->{
			row=1;
			numChair=2;
			type=1;
			select();
		};
		eventsMd[1][3]=e->{
			row=1;
			numChair=3;
			type=1;
			select();
		};
		eventsMd[1][4]=e->{
			row=1;
			numChair=4;
			type=1;
			select();
		};
		eventsMd[1][5]=e->{
			row=1;
			numChair=5;
			type=1;
			select();
		};
		eventsMd[1][6]=e->{
			row=1;
			numChair=6;
			type=1;
			select();
		};
		eventsMd[2][0]=e->{
			row=2;
			numChair=0;
			type=1;
			select();
		};
		eventsMd[2][1]=e->{
			row=2;
			numChair=1;
			type=1;
			select();
		};
		eventsMd[2][2]=e->{
			row=2;
			numChair=2;
			type=1;
			select();
		};
		eventsMd[2][3]=e->{
			row=2;
			numChair=3;
			type=1;
			select();
		};
		eventsMd[2][4]=e->{
			row=2;
			numChair=4;
			type=1;
			select();
		};
		eventsMd[2][5]=e->{
			row=2;
			numChair=5;
			type=1;
			select();
		};
		eventsMd[2][6]=e->{
			row=2;
			numChair=6;
			type=1;
			select();
		};
		eventsMd[3][0]=e->{
			row=3;
			numChair=0;
			type=1;
			select();
		};
		eventsMd[3][1]=e->{
			row=3;
			numChair=1;
			type=1;
			select();
		};
		eventsMd[3][2]=e->{
			row=3;
			numChair=2;
			type=1;
			select();
		};
		eventsMd[3][3]=e->{
			row=3;
			numChair=3;
			type=1;
			select();
		};
		eventsMd[3][4]=e->{
			row=3;
			numChair=4;
			type=1;
			select();
		};
		eventsMd[3][5]=e->{
			row=3;
			numChair=5;
			type=1;
			select();
		};
		eventsMd[3][6]=e->{
			row=3;
			numChair=6;
			type=1;
			select();
		};
		eventsMd[4][0]=e->{
			row=4;
			numChair=0;
			type=1;
			select();
		};
		eventsMd[4][1]=e->{
			row=4;
			numChair=1;
			type=1;
			select();
		};
		eventsMd[4][2]=e->{
			row=4;
			numChair=2;
			type=1;
			select();
		};
		eventsMd[4][3]=e->{
			row=4;
			numChair=3;
			type=1;
			select();
		};
		eventsMd[4][4]=e->{
			row=4;
			numChair=4;
			type=1;
			select();
		};
		eventsMd[4][5]=e->{
			row=4;
			numChair=5;
			type=1;
			select();
		};
		eventsMd[4][6]=e->{
			row=4;
			numChair=6;
			type=1;
			select();
		};
		eventsMd[5][0]=e->{
			row=5;
			numChair=0;
			type=1;
			select();
		};
		eventsMd[5][1]=e->{
			row=5;
			numChair=1;
			type=1;
			select();
		};
		eventsMd[5][2]=e->{
			row=5;
			numChair=2;
			type=1;
			select();
		};
		eventsMd[5][3]=e->{
			row=5;
			numChair=3;
			type=1;
			select();
		};
		eventsMd[5][4]=e->{
			row=5;
			numChair=4;
			type=1;
			select();
		};
		eventsMd[5][5]=e->{
			row=5;
			numChair=5;
			type=1;
			select();
		};
		eventsMd[5][6]=e->{
			row=5;
			numChair=6;
			type=1;
			select();
		};
		assignActionToButton();
		this.id=id;
		this.name=name;
		this.indexRoom=indexRoom;
		this.type=indexType;
	}	
	public void refresh() {
		
		boolean [][] middle=new boolean[6][7];
		boolean [][] mini=new boolean[4][7];
		
		if(type==1) {
			middle=main.getChairsAviabilityMiddle(indexRoom);
		}
		if(type==2) {
			mini=main.getChairsAviabilityMini(indexRoom);
		}
		
		
		
		boolean isFunctionMd=main.isFunctionMiddle(indexRoom);
		boolean isFunctionMn=main.isFunctionMini(indexRoom);
	
		int i;
		int j;
		for(i=0;i<mini.length;i++) {
			for(j=0;j<mini[0].length;j++) {
				if(mini[i][j]||isFunctionMn) {	
					buttonCollectionMn[i][j].setStyle("-fx-base: #0000FF; -fx-background-radius: 0;");
					buttonCollectionMn[i][j].setDisable (true);
				}
				if(type==1) {
					buttonCollectionMn[i][j].setStyle("-fx-base: #0000FF; -fx-background-radius: 0;");
					buttonCollectionMn[i][j].setDisable (true);
				}
				
			}
		}
		for(i=0;i<middle.length;i++) {	
			for(j=0;j<middle[0].length;j++) {		
				if(middle[i][j]||isFunctionMd) {			
					buttonCollectionMd[i][j].setStyle("-fx-base: #0000FF; -fx-background-radius: 0;");
					buttonCollectionMd[i][j].setDisable (true);
				}
				if(type==2) {
					buttonCollectionMd[i][j].setStyle("-fx-base: #0000FF; -fx-background-radius: 0;");
					buttonCollectionMd[i][j].setDisable (true);
				}
				
			}
		}
		
		
		
	}
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void assignActionToButton() {
		int i;
		int j;
		for(i=0;i<4;i++) {
			for(j=0;j<7;j++) {
				buttonCollectionMn[i][j].setOnAction(eventsMn[i][j]);
				buttonCollectionMd[i][j].setOnAction(eventsMd[i][j] );
				
			}
		}
		for(i=4;i<6;i++) {
			for(j=0;j<7;j++) {
				buttonCollectionMd[i][j].setOnAction( eventsMd[i][j]);
				}
			}
	}
	
	public void select() {
		try {
			main.addCustomer(id, name, row, numChair,type,indexRoom);
			main.returnToMenu();
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Try to overWrite customer");
			alert.setHeaderText("This isn't allowed");
			alert.setContentText("");				
		
			alert.showAndWait();
		}
		refresh();
		
	}
	
	
}
