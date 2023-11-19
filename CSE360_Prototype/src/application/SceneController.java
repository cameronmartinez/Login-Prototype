package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private RiskReductionFour securityCheck = new RiskReductionFour();
	private double start;
	private double time;
	
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;
    
    @FXML
    private TextField errorLabel;
    
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
	        
	        if (username != "") {
	        	switchToConsoleScene(event);
	        } else {
	            // Invalid credentials, you can show an error message or handle it as needed
	        	errorLabel.setVisible(true);
	            
	        }
	        /*securityCheck.insert(username, password);

	        if (securityCheck.search(username, password)) {
	            // Successful login, switch to log editor
	        	switchToConsoleScene(event);
	        } else {
	            // Invalid credentials, you can show an error message or handle it as needed
	        	errorLabel.setVisible(true);
	            
	        }*/
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
	}
	
	public void endTime(ActionEvent event) throws IOException {
		time = (System.currentTimeMillis() - start) / 1000;
		System.out.println(time);
	}
	
	
	//public void switchToEffortLogEditorScene(ActionEvent event)
	
}