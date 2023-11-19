package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.RiskReductionFour;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LogSceneController implements Initializable {

	private Stage stage;
	private Scene scene;
	private Parent root;
	private RiskReductionFour securityCheck = new RiskReductionFour();
	private double start;
	private double time;
	
	@FXML
	private Label clockTime;
	
	@FXML
	private Label clockStatus;
	
	@FXML
	private Rectangle rect;
	
	@FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;
    
    @FXML
    private TextField errorLabel;
    
    @FXML
    private ChoiceBox<String> projectChoice;
    
    @FXML
    private ChoiceBox<String> lifeCycleChoice;
    
    @FXML
    private ChoiceBox<String> effortChoice1;
    
    @FXML
    private ChoiceBox<String> effortChoice2;
    
    private String[] projectArr = {"Business Project", "Development Project"};
    private String[] lifeCycleArr = {"Planning", "Information Gathering", "Information Understanding", "verifying", "Outlining", "Drafting", "Finalizing", "Team Meeting", "Coach Meeting", "Stakeholder Meeting"};
    private String[] effortArr1 = {"Plans", "Deliverables", "Interruptions", "Defects", "Other"};
    private String[] effortArr2 = {"Project Plan", "Risk Management Plan", "Conceptual Design Plan", "Detailed Design Plan", "Implementation Plan"};
    
    public void switchToSignIn(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

    public void login(ActionEvent event) throws IOException {
        // Check if the username and password are "admin"
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        securityCheck.insert(username, password);

        if (securityCheck.search(username, password)) {
            // Successful login, switch to log editor
        	switchToConsoleScene(event);
        } else {
            // Invalid credentials, you can show an error message or handle it as needed
        	errorLabel.setVisible(true);
            
        }
    }
    public void switchToLogEditor(ActionEvent event) throws IOException {
    	  root = FXMLLoader.load(getClass().getResource("EffortLogEditorScene.fxml"));
    	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	  scene = new Scene(root);
    	  stage.setScene(scene);
    	  stage.show();
    }
    
    public void switchToDefectConsoleScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("DefectConsoleScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show(); 
	}

    public void switchToConsoleScene(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("ConsoleScene.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }

	public void switchToDefinitionsPageScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("DefinitionsPageScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void switchToLogsScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("LogsScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void startTime(ActionEvent event) throws IOException {
		start = System.currentTimeMillis();
		clockStatus.setText("Clock has Started");
		rect.setFill(Color.GREEN);
	}
	
	public void endTime(ActionEvent event) throws IOException {
		time = (System.currentTimeMillis() - start) / 1000;
		System.out.println(time);
		clockStatus.setText("Clock is Stopped");
		//clockTime.setText("This activity took " + time + " seconds");
		rect.setFill(Color.RED);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		projectChoice.getItems().addAll(projectArr);
		lifeCycleChoice.getItems().addAll(lifeCycleArr);
		effortChoice1.getItems().addAll(effortArr1);
		effortChoice2.getItems().addAll(effortArr2);
		rect.setFill(Color.RED);
	}
	
	
}
