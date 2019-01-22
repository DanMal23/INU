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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SORatingsBarchartController implements Initializable {

	@FXML
	private Button backButton;
	@FXML
	private Button closeButton;
	@FXML
	private BarChart<String, Double> barChart;
	@FXML
	private CategoryAxis x;
	@FXML
	private NumberAxis y;

	public void backToTable(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/SORatingsTableView.fxml"));
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
		XYChart.Series<String, Double> set1 = new XYChart.Series<>();
		set1.getData().add(new XYChart.Data<String, Double>("JavaScript", 69.8));
		set1.getData().add(new XYChart.Data<String, Double>("HTML", 68.5));
		set1.getData().add(new XYChart.Data<String, Double>("CSS", 65.1));
		set1.getData().add(new XYChart.Data<String, Double>("SQL", 57.0));
		set1.getData().add(new XYChart.Data<String, Double>("Java", 45.3));
		set1.getData().add(new XYChart.Data<String, Double>("Bash/Shell", 39.8));
		set1.getData().add(new XYChart.Data<String, Double>("Python", 38.8));
		set1.getData().add(new XYChart.Data<String, Double>("C#", 34.4));
		set1.getData().add(new XYChart.Data<String, Double>("PHP", 30.7));
		set1.getData().add(new XYChart.Data<String, Double>("C++", 25.4));
		set1.getData().add(new XYChart.Data<String, Double>("C", 23.0));
		set1.getData().add(new XYChart.Data<String, Double>("TypeScript", 17.4));
		set1.getData().add(new XYChart.Data<String, Double>("Ruby", 10.1));
		set1.getData().add(new XYChart.Data<String, Double>("Swift", 8.1));
		set1.getData().add(new XYChart.Data<String, Double>("Assembly", 7.4));
		set1.getData().add(new XYChart.Data<String, Double>("Go", 7.1));

		barChart.getData().addAll(set1);
	}

}
