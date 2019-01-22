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

public class GithubRatingsBarchartController implements Initializable {

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
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/GithubRatingsTableView.fxml"));
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
		set1.getData().add(new XYChart.Data<String, Double>("JavaScript", 22.63));
		set1.getData().add(new XYChart.Data<String, Double>("Python", 14.75));
		set1.getData().add(new XYChart.Data<String, Double>("Java", 14.01));
		set1.getData().add(new XYChart.Data<String, Double>("C++", 8.45));
		set1.getData().add(new XYChart.Data<String, Double>("C", 6.03));
		set1.getData().add(new XYChart.Data<String, Double>("PHP", 5.85));
		set1.getData().add(new XYChart.Data<String, Double>("C#", 5.03));
		set1.getData().add(new XYChart.Data<String, Double>("Shell", 4.85));
		set1.getData().add(new XYChart.Data<String, Double>("Go", 4.10));
		set1.getData().add(new XYChart.Data<String, Double>("TypeScript", 3.89));

		barChart.getData().addAll(set1);
	}

}