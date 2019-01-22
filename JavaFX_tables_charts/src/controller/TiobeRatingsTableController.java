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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import model.TiobeRatings;

public class TiobeRatingsTableController implements Initializable {

	@FXML
	private TableView<TiobeRatings> jtableView;
	@FXML
	private TableView<TiobeRatings> ptableView;
	@FXML
	private TableView<TiobeRatings> ctableView;
	@FXML
	private TableColumn<TiobeRatings, Integer> yearJColumn;
	@FXML
	private TableColumn<TiobeRatings, Double> percentJColumn;
	@FXML
	private TableColumn<TiobeRatings, Integer> yearPColumn;
	@FXML
	private TableColumn<TiobeRatings, Double> percentPColumn;
	@FXML
	private TableColumn<TiobeRatings, Integer> yearCColumn;
	@FXML
	private TableColumn<TiobeRatings, Double> percentCColumn;
	@FXML
	private Button linechartViewButton;

	public void clickedTable() {
		this.linechartViewButton.setDisable(false);
	}

	public void changeYearCellEvent(CellEditEvent editedCell) {
		TiobeRatings yearSelected = jtableView.getSelectionModel().getSelectedItem();
		yearSelected.setYear(Integer.parseInt(editedCell.getNewValue().toString()));
	}

	public void changePercentCellEvent(CellEditEvent editedCell) {
		TiobeRatings percentSelected = jtableView.getSelectionModel().getSelectedItem();
		percentSelected.setPercent(Double.parseDouble(editedCell.getNewValue().toString()));
	}

	public void backToMain(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/FXMLDocument.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	public void goToLinechartView(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/TiobeRatingsLinechart.fxml"));
		Parent tableViewParent = loader.load();
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		yearJColumn.setCellValueFactory(new PropertyValueFactory<TiobeRatings, Integer>("year"));
		percentJColumn.setCellValueFactory(new PropertyValueFactory<TiobeRatings, Double>("percent"));
		yearPColumn.setCellValueFactory(new PropertyValueFactory<TiobeRatings, Integer>("year"));
		percentPColumn.setCellValueFactory(new PropertyValueFactory<TiobeRatings, Double>("percent"));
		yearCColumn.setCellValueFactory(new PropertyValueFactory<TiobeRatings, Integer>("year"));
		percentCColumn.setCellValueFactory(new PropertyValueFactory<TiobeRatings, Double>("percent"));

		jtableView.setItems(getJavaRatingsData());
		ptableView.setItems(getPythonRatingsData());
		ctableView.setItems(getCPlusPlusRatingsData());
		jtableView.setEditable(true);

		yearJColumn
				.setCellFactory(TextFieldTableCell.<TiobeRatings, Integer>forTableColumn(new IntegerStringConverter()));
		percentJColumn
				.setCellFactory(TextFieldTableCell.<TiobeRatings, Double>forTableColumn(new DoubleStringConverter()));
		yearPColumn
				.setCellFactory(TextFieldTableCell.<TiobeRatings, Integer>forTableColumn(new IntegerStringConverter()));
		percentPColumn
				.setCellFactory(TextFieldTableCell.<TiobeRatings, Double>forTableColumn(new DoubleStringConverter()));
		yearCColumn
				.setCellFactory(TextFieldTableCell.<TiobeRatings, Integer>forTableColumn(new IntegerStringConverter()));
		percentCColumn
				.setCellFactory(TextFieldTableCell.<TiobeRatings, Double>forTableColumn(new DoubleStringConverter()));

		jtableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ptableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ctableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

//Java
	public ObservableList<TiobeRatings> getJavaRatingsData() {
		ObservableList<TiobeRatings> jratings = FXCollections.observableArrayList();
		jratings.add(new TiobeRatings(2002, 24.2)); // January
		jratings.add(new TiobeRatings(2003, 24.23));
		jratings.add(new TiobeRatings(2004, 23.6));
		jratings.add(new TiobeRatings(2005, 17.5));
		jratings.add(new TiobeRatings(2006, 22.2));
		jratings.add(new TiobeRatings(2007, 19.2));
		jratings.add(new TiobeRatings(2008, 20.8));
		jratings.add(new TiobeRatings(2009, 19.0));
		jratings.add(new TiobeRatings(2010, 17.5));
		jratings.add(new TiobeRatings(2011, 17.7));
		jratings.add(new TiobeRatings(2012, 17.5));
		jratings.add(new TiobeRatings(2013, 17.8));
		jratings.add(new TiobeRatings(2014, 16.5));
		jratings.add(new TiobeRatings(2015, 15.5));
		jratings.add(new TiobeRatings(2016, 21.5));
		jratings.add(new TiobeRatings(2017, 17.2));
		jratings.add(new TiobeRatings(2018, 14.2));
		jratings.add(new TiobeRatings(2019, 17.0));

		return jratings;
	}

//Python
	public ObservableList<TiobeRatings> getPythonRatingsData() {
		ObservableList<TiobeRatings> pratings = FXCollections.observableArrayList();
		pratings.add(new TiobeRatings(2002, 1.04));
		pratings.add(new TiobeRatings(2003, 1.00));
		pratings.add(new TiobeRatings(2004, 1.12));
		pratings.add(new TiobeRatings(2005, 5.2));
		pratings.add(new TiobeRatings(2006, 2.6));
		pratings.add(new TiobeRatings(2007, 3.5));
		pratings.add(new TiobeRatings(2008, 5.53));
		pratings.add(new TiobeRatings(2009, 4.73));
		pratings.add(new TiobeRatings(2010, 4.45));
		pratings.add(new TiobeRatings(2011, 3.21));
		pratings.add(new TiobeRatings(2012, 3.2));
		pratings.add(new TiobeRatings(2013, 4.17));
		pratings.add(new TiobeRatings(2014, 2.37));
		pratings.add(new TiobeRatings(2015, 2.6));
		pratings.add(new TiobeRatings(2016, 3.85));
		pratings.add(new TiobeRatings(2017, 4.00));
		pratings.add(new TiobeRatings(2018, 4.67));
		pratings.add(new TiobeRatings(2019, 8.3));

		return pratings;
	}

// C++
	public ObservableList<TiobeRatings> getCPlusPlusRatingsData() {
		ObservableList<TiobeRatings> cratings = FXCollections.observableArrayList();
		cratings.add(new TiobeRatings(2002, 15.00));
		cratings.add(new TiobeRatings(2003, 13.2));
		cratings.add(new TiobeRatings(2004, 14.63));
		cratings.add(new TiobeRatings(2005, 11.92));
		cratings.add(new TiobeRatings(2006, 11.34));
		cratings.add(new TiobeRatings(2007, 10.42));
		cratings.add(new TiobeRatings(2008, 8.73));
		cratings.add(new TiobeRatings(2009, 10.11));
		cratings.add(new TiobeRatings(2010, 9.7));
		cratings.add(new TiobeRatings(2011, 7.83));
		cratings.add(new TiobeRatings(2012, 8.00));
		cratings.add(new TiobeRatings(2013, 9.14));
		cratings.add(new TiobeRatings(2014, 7.56));
		cratings.add(new TiobeRatings(2015, 6.00));
		cratings.add(new TiobeRatings(2016, 6.91));
		cratings.add(new TiobeRatings(2017, 6.3));
		cratings.add(new TiobeRatings(2018, 5.6));
		cratings.add(new TiobeRatings(2019, 8.16));

		return cratings;
	}

	@FXML
	void closeScene(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}

}
