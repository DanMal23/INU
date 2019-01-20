package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import model.LinuxDistro;

public class LinuxDistroTableController implements Initializable {

	@FXML
	private TableView<LinuxDistro> tableView;
	@FXML
	private TableColumn<LinuxDistro, String> distroNameColumn;
	@FXML
	private TableColumn<LinuxDistro, String> yearColumn;
	@FXML
	private TableColumn<LinuxDistro, String> developerNameColumn;

	@FXML
	private TextField distroNameTextField;
	@FXML
	private TextField yearTextField;
	@FXML
	private TextField developerNameTextField;

	@FXML
	private Button detailedDistroViewButton;

	public void clickedTable() {
		this.detailedDistroViewButton.setDisable(false);
	}

	public void changeDistroNameCellEvent(CellEditEvent editedCell) {
		LinuxDistro distroSelected = tableView.getSelectionModel().getSelectedItem();
		distroSelected.setDistroName(editedCell.getNewValue().toString());
	}

	public void changeYearCellEvent(CellEditEvent editedCell) {
		LinuxDistro distroSelected = tableView.getSelectionModel().getSelectedItem();
		distroSelected.setYear(editedCell.getNewValue().toString());
	}

	public void changeDevNameCellEvent(CellEditEvent editedCell) {
		LinuxDistro distroSelected = tableView.getSelectionModel().getSelectedItem();
		distroSelected.setDistroName(editedCell.getNewValue().toString());
	}

	public void backToMain(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void changeSceneToDetailedDistroView(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/DistroDetails.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		LinuxDistroDetailsController controller = loader.getController();
		controller.setDistroData(tableView.getSelectionModel().getSelectedItem());

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		distroNameColumn.setCellValueFactory(new PropertyValueFactory<LinuxDistro, String>("distroName"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<LinuxDistro, String>("year"));
		developerNameColumn.setCellValueFactory(new PropertyValueFactory<LinuxDistro, String>("developerName"));

		tableView.setItems(getLinuxDistros());
		tableView.setEditable(true);

		distroNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		developerNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.detailedDistroViewButton.setDisable(true);
	}

	public void deleteButton() {
		ObservableList<LinuxDistro> selectedRows, allDistros;
		allDistros = tableView.getItems();
		selectedRows = tableView.getSelectionModel().getSelectedItems();
		for (LinuxDistro distro : selectedRows) {
			allDistros.remove(distro);
		}
	}

	public void newDistroButton() {
		LinuxDistro newDistro = new LinuxDistro(distroNameTextField.getText(), yearTextField.getText(),
				developerNameTextField.getText());

		tableView.getItems().add(newDistro);
	}

	public ObservableList<LinuxDistro> getLinuxDistros() {
		ObservableList<LinuxDistro> distros = FXCollections.observableArrayList();
		distros.add(new LinuxDistro("Arch Linux", "2002", "Aaron Griffin and others"));
		distros.add(new LinuxDistro("Qubec OS", "2003", "Invisible Things Lab"));
		distros.add(new LinuxDistro("Ubuntu", "2004", "Canonical Ltd., Ubuntu community"));
		distros.add(new LinuxDistro("Manjaro", "2012", "Guillaume Benoit, Philip Müller"));
		distros.add(new LinuxDistro("CentOS", "2003", "The CentOS Project (affiliated with Red Hat"));
		distros.add(new LinuxDistro("Slackware", "1993", "Patrick Volkerding"));
		distros.add(new LinuxDistro("Xandros", "2001", "Xandros Incorporated"));
		distros.add(new LinuxDistro("Zenwalk", "2004", "Jean-Philippe Guillemin"));
		distros.add(new LinuxDistro("Zorin", "2009", "Zorin Group"));
		distros.add(new LinuxDistro("Debian", "1993", "The Debian Project started by Ian Murdock"));

		return distros;
	}

	@FXML
	void closeScene(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}
}