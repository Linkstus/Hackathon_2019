package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Main extends Application {
	//classes for the gui
	private Tab regular;
	private Tab whisper;
	private VBox chatFeatures;
	private Text message;
	private TextField userMessage;
	private TextArea chatWindow;
	private Button sendMessage;
	
	
	//classes for the chat 
	private Client client = new Client("local host", 49153);
	private static Server server = new Server();
	private static SERVER serverStatus = SERVER.OFF;
	
	
	private enum SERVER{
		ON, OFF;
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root = Panels();
			Scene scene = new Scene(root,500,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public TabPane Panels() {
		TabPane chatProgram = new TabPane();
		regular = new Tab("Chat");
		whisper = new Tab("Whisper");
		regularTabContruction();
		
		chatProgram.getTabs().add(regular);
		chatProgram.getTabs().add(whisper);
		
		regular.setContent(chatFeatures);
		
		
		
		return chatProgram;
		
	}
	
	public void regularTabContruction() {
		chatFeatures = new VBox();
		
		setTextMessage();
		setTextField();
		setButton();
		setTextArea();
		
		chatFeatures.getChildren().addAll(message, userMessage, sendMessage, chatWindow);
		
		
	}
	
	public void setTextMessage() {
		message = new Text("Enter Message: ");
	}
	
	public void setTextField() {
		userMessage = new TextField();
	}
	
	public void setButton() {
		sendMessage = new Button("Send Message");
	}
	
	public void setTextArea() {
		chatWindow = new TextArea();
		chatWindow.setEditable(false);
		if(serverStatus == SERVER.ON) {
			//enterName();
		}
	}
	
	
	
	public static void main(String[] args) {
		Thread serverThread = new Thread(new serverHandler());
		serverThread.run();
		if(server.getOnStatus() == 1) {
			serverStatus = SERVER.ON;
		}
		launch(args);
	}
}
