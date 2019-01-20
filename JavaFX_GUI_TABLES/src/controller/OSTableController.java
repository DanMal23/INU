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
import model.OS;

public class OSTableController implements Initializable {

	@FXML
	private TableView<OS> tableView;
	@FXML
	private TableColumn<OS, String> osNameColumn;
	@FXML
	private TableColumn<OS, String> yearColumn;
	@FXML
	private TableColumn<OS, String> developerNameColumn;

	@FXML
	private TextField osNameTextField;
	@FXML
	private TextField yearTextField;
	@FXML
	private TextField developerNameTextField;

	@FXML
	private Button detailedOSViewButton;

	public void clickedTable() {
		this.detailedOSViewButton.setDisable(false);
	}

	public void changeOSNameCellEvent(CellEditEvent editedCell) {
		OS osSelected = tableView.getSelectionModel().getSelectedItem();
		osSelected.setOsName(editedCell.getNewValue().toString());
	}

	public void changeYearCellEvent(CellEditEvent editedCell) {
		OS osSelected = tableView.getSelectionModel().getSelectedItem();
		osSelected.setYear(editedCell.getNewValue().toString());
	}

	public void changeDevNameCellEvent(CellEditEvent editedCell) {
		OS osSelected = tableView.getSelectionModel().getSelectedItem();
		osSelected.setOsName(editedCell.getNewValue().toString());
	}

	public void backToMain(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void changeSceneToDetailedOSView(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/OSDetails.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		OSDetailsController controller = loader.getController();
		controller.setOSData(tableView.getSelectionModel().getSelectedItem());

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		osNameColumn.setCellValueFactory(new PropertyValueFactory<OS, String>("osName"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<OS, String>("year"));
		developerNameColumn.setCellValueFactory(new PropertyValueFactory<OS, String>("developerName"));

		tableView.setItems(getOSes());
		tableView.setEditable(true);

		osNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		developerNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.detailedOSViewButton.setDisable(true);
	}

	public void deleteButton() {
		ObservableList<OS> selectedRows, allOSs;
		allOSs = tableView.getItems();
		selectedRows = tableView.getSelectionModel().getSelectedItems();
		for (OS os : selectedRows) {
			allOSs.remove(os);
		}
	}

	public void newOSButton() {
		OS newLanguage = new OS(osNameTextField.getText(), yearTextField.getText(), developerNameTextField.getText());

		tableView.getItems().add(newLanguage);
	}

	public ObservableList<OS> getOSes() {
		ObservableList<OS> oses = FXCollections.observableArrayList();
		oses.add(new OS("Android", "2008", "Google,Open Handset Alliance"));
		oses.add(new OS("Linux", "1991", "Linus Torvalds"));
		oses.add(new OS("LynxOS", "1986", "Lynx Software Technologies, Inc."));
		oses.add(new OS("macOS", "2001", "Apple Inc."));
		oses.add(new OS("MS-DOS", "1981", "Microsoft"));
		oses.add(new OS("Windows", "1985", "Microsoft"));
		oses.add(new OS("Atari DOS", "1979", "Atari, Inc., Atari Corporation"));
		oses.add(new OS("iOS", "2007", "Apple Inc."));
		oses.add(new OS("Unix", "1973", "Ken Thompson, Dennis Ritchie and others"));

		return oses;
	}

	@FXML
	void closeScene(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}
}
