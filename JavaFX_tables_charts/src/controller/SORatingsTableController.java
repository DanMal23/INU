package controller;

import javafx.fxml.Initializable;
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
import javafx.util.converter.DoubleStringConverter;
import model.SORatings;

public class SORatingsTableController implements Initializable {

	@FXML
	private TableView<SORatings> tableView;
	@FXML
	private TableColumn<SORatings, String> languageNameColumn;
	@FXML
	private TableColumn<SORatings, Double> percentColumn;
	@FXML
	private TextField languageNameTextField;
	@FXML
	private TextField percentTextField;
	@FXML
	private Button barchartViewButton;

	public void clickedTable() {
		this.barchartViewButton.setDisable(false);
	}

	public void changeLanguageNameCellEvent(CellEditEvent editedCell) {
		SORatings languageSelected = tableView.getSelectionModel().getSelectedItem();
		languageSelected.setLanguageName(editedCell.getNewValue().toString());
	}

	public void changePercentCellEvent(CellEditEvent editedCell) {
		SORatings percentSelected = tableView.getSelectionModel().getSelectedItem();
		percentSelected.setPercent(Double.parseDouble(editedCell.getNewValue().toString()));
	}

	public void backToMain(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void goToBarchartView(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/SORatingsBarchart.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

//		SORatingsBarchartController controller = loader.getController();
//		controller.setLanguageData(tableView.getSelectionModel().getSelectedItem());

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		languageNameColumn.setCellValueFactory(new PropertyValueFactory<SORatings, String>("languageName"));
		percentColumn.setCellValueFactory(new PropertyValueFactory<SORatings, Double>("percent"));

		tableView.setItems(getRatingsData());
		tableView.setEditable(true);

		languageNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		percentColumn.setCellFactory(TextFieldTableCell.<SORatings, Double>forTableColumn(new DoubleStringConverter()));

		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		// this.barchartViewButton.setDisable(true);
	}

	public void deleteButton() {
		ObservableList<SORatings> selectedRows, allRatings;
		allRatings = tableView.getItems();
		selectedRows = tableView.getSelectionModel().getSelectedItems();
		for (SORatings r : selectedRows) {
			allRatings.remove(r);
		}
	}

	public void newLanguageButton() {
		SORatings newLanguage = new SORatings(languageNameTextField.getText(),
				Double.parseDouble(percentTextField.getText()));

		tableView.getItems().add(newLanguage);
	}

	public ObservableList<SORatings> getRatingsData() {
		ObservableList<SORatings> ratings = FXCollections.observableArrayList();
		ratings.add(new SORatings("JavaScript", 69.8));
		ratings.add(new SORatings("HTML", 68.5));
		ratings.add(new SORatings("CSS", 65.1));
		ratings.add(new SORatings("SQL", 57.0));
		ratings.add(new SORatings("Java", 45.3));
		ratings.add(new SORatings("Bash/Shell", 39.8));
		ratings.add(new SORatings("Python", 38.8));
		ratings.add(new SORatings("C#", 34.4));
		ratings.add(new SORatings("PHP", 30.7));
		ratings.add(new SORatings("C++", 25.4));
		ratings.add(new SORatings("C", 23.0));
		ratings.add(new SORatings("TypeScript", 17.4));
		ratings.add(new SORatings("Ruby", 10.1));
		ratings.add(new SORatings("Swift", 8.1));
		ratings.add(new SORatings("Assembly", 7.4));
		ratings.add(new SORatings("Go", 7.1));

		return ratings;
	}

	@FXML
	void closeScene(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}
}
