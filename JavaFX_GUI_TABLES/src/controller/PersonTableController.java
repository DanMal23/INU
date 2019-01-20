package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import model.Person;

public class PersonTableController implements Initializable {

	@FXML
	private TableView<Person> tableView;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;
	@FXML
	private TableColumn<Person, LocalDate> birthdayColumn;

	@FXML
	private TextField firstNameTextField;
	@FXML
	private TextField lastNameTextField;
	@FXML
	private DatePicker birthdayDatePicker;

	@FXML
	private Button detailedPersonViewButton;

	public void changeFirstNameCellEvent(CellEditEvent editedCell) // double click and edit cell
	{
		Person personSelected = tableView.getSelectionModel().getSelectedItem();
		personSelected.setFirstName(editedCell.getNewValue().toString());
	}

	public void clickedTable() {
		this.detailedPersonViewButton.setDisable(false);
	}

	public void changeLastNameCellEvent(CellEditEvent editedCell) {
		Person personSelected = tableView.getSelectionModel().getSelectedItem();
		personSelected.setLastName(editedCell.getNewValue().toString());
	}

	public void backToMain(ActionEvent event) throws IOException // changing to tableView
	{
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void changeSceneToDetailedPersonView(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/PersonDetails.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);
		PersonDetailsController controller = loader.getController();
		controller.setPersonalData(tableView.getSelectionModel().getSelectedItem());

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		birthdayColumn.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));

		tableView.setItems(getDevelopers());

		tableView.setEditable(true);
		firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		this.detailedPersonViewButton.setDisable(true);
	}

	public void deleteButton() {
		ObservableList<Person> selectedRows, developers;
		developers = tableView.getItems();
		selectedRows = tableView.getSelectionModel().getSelectedItems();
		for (Person dev : selectedRows) {
			developers.remove(dev);
		}
	}

	public void newPersonButton() {
		Person newPerson = new Person(firstNameTextField.getText(), lastNameTextField.getText(),
				birthdayDatePicker.getValue());

		tableView.getItems().add(newPerson);
	}

	public ObservableList<Person> getDevelopers() {
		ObservableList<Person> developers = FXCollections.observableArrayList();
		developers.add(new Person("James", "Goslig", LocalDate.of(1955, Month.MAY, 19)));
		developers.add(new Person("Bjarne", "Stroustrup", LocalDate.of(1950, Month.DECEMBER, 30)));
		developers.add(new Person("Yukihiro", "Matsumoto", LocalDate.of(1965, Month.APRIL, 14)));
		developers.add(new Person("Linus", "Torvalds", LocalDate.of(1969, Month.DECEMBER, 28)));
		developers.add(new Person("Marc", "Ewing", LocalDate.of(1969, Month.MAY, 9)));
		developers.add(new Person("Mark", "Shuttleworth", LocalDate.of(1973, Month.SEPTEMBER, 18)));

		return developers;
	}

	@FXML
	void closeScene(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}
}
