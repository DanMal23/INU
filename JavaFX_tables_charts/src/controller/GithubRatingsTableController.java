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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import model.GithubUsersRatings;

public class GithubRatingsTableController implements Initializable {

	@FXML
	private TableView<GithubUsersRatings> tableView;
	@FXML
	private TableColumn<GithubUsersRatings, String> languageNameColumn;
	@FXML
	private TableColumn<GithubUsersRatings, Double> percentColumn;
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
		GithubUsersRatings languageSelected = tableView.getSelectionModel().getSelectedItem();
		languageSelected.setLanguageName(editedCell.getNewValue().toString());
	}

	public void changePercentCellEvent(CellEditEvent editedCell) {
		GithubUsersRatings percentSelected = tableView.getSelectionModel().getSelectedItem();
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
		loader.setLocation(getClass().getResource("/view/GithubRatingsBarchart.fxml"));
		Parent tableViewParent = loader.load();
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		languageNameColumn.setCellValueFactory(new PropertyValueFactory<GithubUsersRatings, String>("languageName"));
		percentColumn.setCellValueFactory(new PropertyValueFactory<GithubUsersRatings, Double>("percent"));

		tableView.setItems(getRatingsData());
		tableView.setEditable(true);

		languageNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		percentColumn.setCellFactory(
				TextFieldTableCell.<GithubUsersRatings, Double>forTableColumn(new DoubleStringConverter()));

		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	public void deleteButton() {
		ObservableList<GithubUsersRatings> selectedRows, allRatings;
		allRatings = tableView.getItems();
		selectedRows = tableView.getSelectionModel().getSelectedItems();
		for (GithubUsersRatings r : selectedRows) {
			allRatings.remove(r);
		}
	}

	public void newLanguageButton() {
		GithubUsersRatings newLanguage = new GithubUsersRatings(languageNameTextField.getText(),
				Double.parseDouble(percentTextField.getText()));

		tableView.getItems().add(newLanguage);
	}

	public ObservableList<GithubUsersRatings> getRatingsData() {
		ObservableList<GithubUsersRatings> ratings = FXCollections.observableArrayList();
		ratings.add(new GithubUsersRatings("JavaScript", 22.63));
		ratings.add(new GithubUsersRatings("Python", 14.75));
		ratings.add(new GithubUsersRatings("Java", 14.01));
		ratings.add(new GithubUsersRatings("C++", 8.45));
		ratings.add(new GithubUsersRatings("C", 6.03));
		ratings.add(new GithubUsersRatings("PHP", 5.85));
		ratings.add(new GithubUsersRatings("C#", 5.03));
		ratings.add(new GithubUsersRatings("Shell", 4.85));
		ratings.add(new GithubUsersRatings("Go", 4.10));
		ratings.add(new GithubUsersRatings("TypeScript", 3.89));

		return ratings;
	}

	@FXML
	void closeScene(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}

}
