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
import model.LinuxDistro;

public class LinuxDistroDetailsController implements Initializable {

	private LinuxDistro selectedDistro;

	@FXML
	private Label distroNameLabel;
	@FXML
	private Label yearLabel;
	@FXML
	private Label developerNameLabel;

	@FXML
	private Button backButton;
	@FXML
	private Button closeButton;

	public void setDistroData(LinuxDistro distro) {
		selectedDistro = distro;
		distroNameLabel.setText(selectedDistro.getDistroName());
		yearLabel.setText(selectedDistro.getYear());
		developerNameLabel.setText(selectedDistro.getDeveloperName());
	}

	public void backToTable(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/DistroTableView.fxml"));
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
