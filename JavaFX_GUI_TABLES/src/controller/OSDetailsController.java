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
import model.OS;

public class OSDetailsController implements Initializable {

	private OS selectedOS;

	@FXML
	private Label osNameLabel;
	@FXML
	private Label yearLabel;
	@FXML
	private Label developerNameLabel;
	@FXML
	private Button backButton;
	@FXML
	private Button closeButton;

	public void setOSData(OS os) {
		selectedOS = os;
		osNameLabel.setText(selectedOS.getOsName());
		yearLabel.setText(selectedOS.getYear());
		developerNameLabel.setText(selectedOS.getDeveloperName());
	}

	public void backToTable(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/OSTableView.fxml"));
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
