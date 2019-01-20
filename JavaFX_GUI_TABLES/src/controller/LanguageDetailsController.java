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
import model.Language;

public class LanguageDetailsController implements Initializable {

	private Language selectedLanguage;

	@FXML
	private Label languageNameLabel;
	@FXML
	private Label yearLabel;
	@FXML
	private Label developerNameLabel;

	@FXML
	private Button backButton;
	@FXML
	private Button closeButton;

	public void setLanguageData(Language language) {
		selectedLanguage = language;
		languageNameLabel.setText(selectedLanguage.getLanguageName());
		yearLabel.setText(selectedLanguage.getYear());
		developerNameLabel.setText(selectedLanguage.getDeveloperName());
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