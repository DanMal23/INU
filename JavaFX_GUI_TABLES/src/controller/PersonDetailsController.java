package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Person;

public class PersonDetailsController implements Initializable {

	private Person selectedPerson;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label birthdayLabel;
	@FXML
	private Label ageLabel;
	@FXML
	private Button backButton;
	@FXML
	private Button closeButton;

	public void setPersonalData(Person person) {
		selectedPerson = person;
		firstNameLabel.setText(selectedPerson.getFirstName());
		lastNameLabel.setText(selectedPerson.getLastName());
		birthdayLabel.setText(selectedPerson.getBirthday().toString());
		ageLabel.setText(Integer.toString(selectedPerson.getAge()));

	}

	public void backToTable(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/PersonTableView.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@FXML
	void closeScene(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) { 
	}

}
