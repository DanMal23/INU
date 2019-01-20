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
import model.Language;

public class LanguageTableController implements Initializable {

	@FXML
	private TableView<Language> tableView;
	@FXML
	private TableColumn<Language, String> languageNameColumn;
	@FXML
	private TableColumn<Language, String> yearColumn;
	@FXML
	private TableColumn<Language, String> developerNameColumn;

	@FXML
	private TextField languageNameTextField;
	@FXML
	private TextField yearTextField;
	@FXML
	private TextField developerNameTextField;

	@FXML
	private Button detailedLanguageViewButton;

	public void clickedTable() {
		this.detailedLanguageViewButton.setDisable(false);
	}

	public void changeLgNameCellEvent(CellEditEvent editedCell) {
		Language languageSelected = tableView.getSelectionModel().getSelectedItem();
		languageSelected.setLanguageName(editedCell.getNewValue().toString());
	}

	public void changeYearCellEvent(CellEditEvent editedCell) {
		Language languageSelected = tableView.getSelectionModel().getSelectedItem();
		languageSelected.setYear(editedCell.getNewValue().toString());
	}

	public void changeDevNameCellEvent(CellEditEvent editedCell) {
		Language languageSelected = tableView.getSelectionModel().getSelectedItem();
		languageSelected.setLanguageName(editedCell.getNewValue().toString());
	}

	public void backToMain(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	public void changeSceneToDetailedLanguageView(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/LanguageDetails.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		LanguageDetailsController controller = loader.getController();
		controller.setLanguageData(tableView.getSelectionModel().getSelectedItem());

		// This line gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.setScene(tableViewScene);
		window.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		languageNameColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("languageName"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("year"));
		developerNameColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("developerName"));

		tableView.setItems(getLanguages());
		tableView.setEditable(true);

		languageNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		developerNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.detailedLanguageViewButton.setDisable(true);
	}

	public void deleteButton() {
		ObservableList<Language> selectedRows, pgrLgs;
		pgrLgs = tableView.getItems();
		selectedRows = tableView.getSelectionModel().getSelectedItems();
		for (Language language : selectedRows) {
			pgrLgs.remove(language);
		}
	}

	public void newLanguageButton() {
		Language newLanguage = new Language(languageNameTextField.getText(), yearTextField.getText(),
				developerNameTextField.getText());

		tableView.getItems().add(newLanguage);
	}

	public ObservableList<Language> getLanguages() {
		ObservableList<Language> languages = FXCollections.observableArrayList();
		languages.add(new Language("Java", "1995", "James Gosling"));
		languages.add(new Language("PHP", "1995", "Rasmus Lerdorf"));
		languages.add(new Language("C++", "1985", "Bjarne Stroustrup"));
		languages.add(new Language("C", "1972", "Dennis Ritchie"));
		languages.add(new Language("Ruby", "1995", "Yukihiro Matsumoto"));
		languages.add(new Language("JS", "1995", "Brendan Eich"));
		languages.add(new Language("Lisp", "1958", "John McCarthy"));
		languages.add(new Language("Perl", "1987", "Larry Wall"));
		languages.add(new Language("Rust", "2010", "Graydon Hoare"));

		return languages;
	}

	@FXML
	void closeScene(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}
}
