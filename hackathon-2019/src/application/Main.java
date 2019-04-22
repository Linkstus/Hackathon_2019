package application;
	
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {
	
	public VBox loginscreen;
	public Button login;
	public Button signUp;
			
	public Text emails;
	public TextField email;
	public Text passWord;
	public TextField pWord;
	public Text username;
	public TextField user;
	public Stage blank;
	public Tab home;
	public Tab quickView;
	public Tab makeEvent;
	public Tab settings;
	public ArrayList<event> alE = new ArrayList<event>();
	public int item = 0;
	
	users james = new users("James", "Soccerjn@gmail.com", "3Wg546f9");
	users carson = new users("Carson", "carsodavis@gvsu.edu", " 123abc456");
	
	event even;
	users u;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = loginPanel();
			Scene scene = new Scene(root,375,667); 
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			blank = primaryStage;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public BorderPane loginPanel() {
		BorderPane root = new BorderPane();
		
		root.setCenter(loginScreen());
		
		return root;
	}
	
	public VBox loginScreen() {
		VBox loginscreen = new VBox();
		
		login = new Button("login");
		signUp = new Button("SignUp");
				
		emails = new Text("Email");
		emails.setFill(Color.ANTIQUEWHITE);
		email = new TextField();
		passWord = new Text("Password");
		passWord.setFill(Color.ANTIQUEWHITE);
		pWord = new TextField();
		
		username = new Text("Username:");
		user = new TextField();
		
		username.setVisible(false);
		user.setVisible(false);
		
		EventHandler<ActionEvent> loginEvent = new EventHandler<ActionEvent>() {
			@Override
			//ToDo: set up an error if there is no email associated
			public void handle(ActionEvent e) {
				String eMail = email.getText();
				System.out.println(eMail);
				String password = pWord.getText();
				System.out.println(password);
				blank.hide();
				mainWorkWindow();
			}
		};
		
		login.setOnAction(loginEvent);
		
		EventHandler<ActionEvent> signup = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				hideL();
				showL();
				
				signUpWindow();
				
			}
		};
		signUp.setOnAction(signup);
		
		loginscreen.getChildren().addAll(emails, email,passWord, pWord, username, user, login, signUp);
		
		return loginscreen;
	}
	
	public void signUpWindow() {
		emails.setText("Username:");
		passWord.setText("Email:");
		username.setText("Password:");
		
		EventHandler<ActionEvent> credintails = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				blank.hide();
				mainWorkWindow();
			}
		};
		
		signUp.setOnAction(credintails);
		
	}
	
	public void hideL() {
		login.setVisible(false);
		
	}
	
	public void showL() {
		username.setVisible(true);
		user.setVisible(true);
	}
	
	public void mainWorkWindow() {
		try {
			Stage secondaryStage = new Stage();
			BorderPane sRoot = tabbedSection();
			Scene newWindow = new Scene(sRoot,375,667); 
			newWindow.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			secondaryStage.setScene(newWindow);
			secondaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public BorderPane tabbedSection() {
		BorderPane bp = new BorderPane();
		HBox tabs = new HBox();
		TabPane tp = new TabPane();
		
		home = new Tab("home");
		quickView = new Tab("quickView");
		makeEvent = new Tab("Make Event");
		settings = new Tab("Settings");
		
		tp.getTabs().addAll(home, quickView, makeEvent);
		
		bp.setTop(tp);
		
		home.setContent(homeItems());
		
		makeEvent.setContent(eventItems());
		
		quickView.setContent(quickItems());
		
		return bp;
	}
	
	public GridPane homeItems(){
		GridPane gp = new GridPane();
		HBox hb1 = new HBox();
		hb1.getStyleClass().add("HBox");
		
		even = new event("Feeding the Homeless", "04/14/2095", carson, "Meeting at food Kitchen to help feed homeless, come help the homeless");
		alE.add(even);
		
		even = new event("Cleaning the Street", "2/9/19", carson, "Meeting at North Street at 4pm. Main supplies supplied");
		alE.add(even);
		
		/*TextArea tfA = new TextArea();
		tfA.setEditable(true);
		tfA.setWrapText(true);
		
		for(int i = 0; i < alE.size(); i++) {
			tfA.setText(alE.get(i).toString());
		}*/
		
		hb1.setPadding(new Insets(15, 5, 15, 0));
		hb1.setSpacing(0);
		
		
		Text e1 = new Text("Feeding the Homeless     ");
		Text e1_2 = new Text("Carson     ");
		Text e1_3 = new Text("Meeting at food kitchen to help feed homeless, come help the homeless");
		e1.setFill(Color.ANTIQUEWHITE);
		e1_2.setFill(Color.ANTIQUEWHITE);
		e1_3.setFill(Color.ANTIQUEWHITE);

		e1_3.setWrappingWidth(180);
		
		
		hb1.getChildren().addAll(e1, e1_2, e1_3);
		
		gp.add(hb1, 0,  0);
		
		HBox hb2 = new HBox();
		hb2.setPadding(new Insets(15, 5, 15, 0));
		hb2.setSpacing(0);
		hb2.getStyleClass().add("HBox");
		
		
		
		Text e2 = new Text("Cleaning the Street    ");
		Text e2_2 = new Text("Carson     ");
		Text e2_3 = new Text("Meeting at North Street at 4pm. Main supplies supplied");
		e2.setFill(Color.ANTIQUEWHITE);
		e2_2.setFill(Color.ANTIQUEWHITE);
		e2_3.setFill(Color.ANTIQUEWHITE);

		e2_3.setWrappingWidth(180);
		
		hb2.getChildren().addAll(e2, e2_2, e2_3);
		
		gp.add(hb2, 0, 6);
		
		HBox hb3 = new HBox();
		hb3.setPadding(new Insets(15, 5, 15, 0));
		hb3.setSpacing(0);
		hb3.getStyleClass().add("HBox");
		
		Text e3 = new Text("Teaching Children    ");
		Text e3_2 = new Text("Johnnie    ");
		Text e3_3 = new Text("Working with Boys and Girls club, to help get more teachers to help teach kids in the afternoon");;
		e3.setFill(Color.ANTIQUEWHITE);
		e3_2.setFill(Color.ANTIQUEWHITE);
		e3_3.setFill(Color.ANTIQUEWHITE);

		e3_3.setWrappingWidth(180);
		
		hb3.getChildren().addAll(e3, e3_2, e3_3);
	
		gp.add(hb3,  0,  12);
		
		return gp;
	}
	
	public GridPane eventItems() {
		GridPane gp = new GridPane();
		
		VBox vb = new VBox();
		
		Text user = new Text("Title");
		TextField tfU = new TextField();
		Text date = new Text("Date");
		TextField tfD = new TextField();
		Text descpt = new Text("Description");
		TextArea tfA = new TextArea();
		
		Button event = new Button("Create");
		
		vb.getChildren().addAll(user, tfU, date, tfD, descpt, tfA, event);
		
		
		EventHandler<ActionEvent> eventHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				u = new users("Carson", "carsodavis@vsu.edu", "123abc456");
				
				even = new event(tfU.getText(), tfD.getText(), u,  tfA.getText());
				
				tfU.setText("");
				tfD.setText("");
				tfA.setText("");
				
				alE.add(even);
				
				
			}
			
		};
		
		event.setOnAction(eventHandler);
		
		
		gp.add(vb,  0,  0);
		
		
		return gp;
	}
	
	public BorderPane quickItems() {
		BorderPane bp = new BorderPane();
		
		ArrayList<event> newList = new ArrayList<>(alE);
		
		Button b1 = new Button("Left");
		Button b2 = new Button("Right");
		TextArea tfA = new TextArea();
		tfA.setEditable(false);
		tfA.setWrapText(true);
		
		bp.setLeft(b1);
		bp.setRight(b2);
		bp.setCenter(tfA);
		
		tfA.setText(alE.get(item).toString());
		
		EventHandler<ActionEvent> rightEventHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(item == alE.size() - 1) {
					item = 0;
				}
				else {
					++item;
				}
				tfA.setText(alE.get(item).toString());
			}
		};
		
		EventHandler<ActionEvent> leftEventHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(item == 0) {
					item = alE.size() - 1;
				}else {
					--item;
				}
				
				tfA.setText(alE.get(item).toString());
			}
		};
		
		b1.setOnAction(leftEventHandler);
		b2.setOnAction(rightEventHandler);
		
		return bp;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
