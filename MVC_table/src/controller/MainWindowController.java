package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Language;

public class MainWindowController {
	private Main main;
	private Stage primaryStage;

	private ObservableList<Language> lgList = FXCollections.observableArrayList();

	@FXML
	private AnchorPane pane;

	@FXML
	private TableView<Language> tableView;

	@FXML
	private TextField langTextfield;

	@FXML
	private TextField yearTextfield;

	@FXML
	private TextField devTextfield;

	@FXML
	private TableColumn<Language, String> pglgColumn;
	@FXML
	private TableColumn<Language, String> yearColumn;
	@FXML
	private TableColumn<Language, String> devColumn;
	@FXML
	private Button addButton;
	@FXML
	private Button clearButton;
	@FXML
	private Button closeButton;
	@FXML
	private Button deleteRowButton;

	public void setMain(Main main) {
		this.main = main;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void initialize() {
		pglgColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("programmingLanguage"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("year"));
		devColumn.setCellValueFactory(new PropertyValueFactory<Language, String>("developer"));

		tableView.getSelectionModel().selectedItemProperty().addListener((ov, oldVal, newVal) -> {
			System.out.println(newVal.getProgrammingLanguage() + " " + newVal.getYear());
		});

		tableView.setEditable(true); 
		pglgColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		yearColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		devColumn.setCellFactory(TextFieldTableCell.forTableColumn());

	}

	public void setTable() {
		lgList.add(new Language("Scala", "2004", "Martin Odersky"));
		lgList.add(new Language("Groovy", "2003", "James Strachan"));
		lgList.add(new Language("C#", "2000", "Microsoft"));
		lgList.add(new Language("Kotlin", "2001", "Jet Brains"));

		tableView.setItems(lgList);
	}

	@FXML
	void closeStage(ActionEvent event) {
		primaryStage.close();
	}

	@FXML
	void clearTextFieldsButton(ActionEvent event) {
		langTextfield.setText(null);
		yearTextfield.setText(null);
		devTextfield.setText(null);
	}

	@FXML
	void addToTableButton(ActionEvent event) {
		String lang = langTextfield.getText();
		String year = yearTextfield.getText();
		String dev = devTextfield.getText();

		lgList.add(new Language(lang, year, dev));
	}

	@FXML
	void pressEnter(KeyEvent event) {
		langTextfield.setOnAction(e -> yearTextfield.requestFocus());
		yearTextfield.setOnAction(e -> devTextfield.requestFocus());
	}

	@FXML
	void deleteRowButton(ActionEvent event) {
		Language selectedItem = tableView.getSelectionModel().getSelectedItem();
		tableView.getItems().remove(selectedItem);
	}

	public void changeLanguageNameCellEvent(CellEditEvent editedCell) {
		Language selected = tableView.getSelectionModel().getSelectedItem();
		selected.setProgrammingLanguage(editedCell.getNewValue().toString());
	}

	public void changeYearCellEvent(CellEditEvent editedCell) {
		Language selected = tableView.getSelectionModel().getSelectedItem();
		selected.setYear(editedCell.getNewValue().toString());
	}

	public void changeDeveloperCellEvent(CellEditEvent editedCell) {
		Language selected = tableView.getSelectionModel().getSelectedItem();
		selected.setDeveloper(editedCell.getNewValue().toString());
	}
}
