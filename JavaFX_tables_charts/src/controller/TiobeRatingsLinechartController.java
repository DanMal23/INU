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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TiobeRatingsLinechartController implements Initializable {

	@FXML
	private NumberAxis xAxis;
	@FXML
	private NumberAxis yAxis;
	@FXML
	private Button backButton;
	@FXML
	private Button closeButton;
	@FXML
	private LineChart<Integer, Double> lineChart;

	public void backToTable(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/TiobeRatingsTableView.fxml"));
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
//		lineChart.getData().clear();
		// LineChart<Integer, Double> lineChart = new LineChart(x, y);

		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(2002);
		xAxis.setUpperBound(2019);
		// xAxis.setTickUnit(3);
		yAxis.setAutoRanging(false);
		yAxis.setLowerBound(0);
		yAxis.setUpperBound(30);

		XYChart.Series<Integer, Double> jset = new XYChart.Series<>();
		jset.setName("Java");

		jset.getData().add(new XYChart.Data<Integer, Double>(2002, 24.2));
		jset.getData().add(new XYChart.Data<Integer, Double>(2003, 24.23));
		jset.getData().add(new XYChart.Data<Integer, Double>(2004, 23.6));
		jset.getData().add(new XYChart.Data<Integer, Double>(2005, 17.5));
		jset.getData().add(new XYChart.Data<Integer, Double>(2006, 22.2));
		jset.getData().add(new XYChart.Data<Integer, Double>(2007, 19.2));
		jset.getData().add(new XYChart.Data<Integer, Double>(2008, 20.8));
		jset.getData().add(new XYChart.Data<Integer, Double>(2009, 19.0));
		jset.getData().add(new XYChart.Data<Integer, Double>(2010, 17.5));
		jset.getData().add(new XYChart.Data<Integer, Double>(2011, 17.7));
		jset.getData().add(new XYChart.Data<Integer, Double>(2012, 17.5));
		jset.getData().add(new XYChart.Data<Integer, Double>(2013, 17.8));
		jset.getData().add(new XYChart.Data<Integer, Double>(2014, 16.5));
		jset.getData().add(new XYChart.Data<Integer, Double>(2015, 15.5));
		jset.getData().add(new XYChart.Data<Integer, Double>(2016, 21.5));
		jset.getData().add(new XYChart.Data<Integer, Double>(2017, 17.2));
		jset.getData().add(new XYChart.Data<Integer, Double>(2018, 14.2));
		jset.getData().add(new XYChart.Data<Integer, Double>(2019, 17.0));

		XYChart.Series<Integer, Double> pset = new XYChart.Series<>();
		pset.setName("Python");
		pset.getData().add(new XYChart.Data<Integer, Double>(2002, 1.04));
		pset.getData().add(new XYChart.Data<Integer, Double>(2003, 1.00));
		pset.getData().add(new XYChart.Data<Integer, Double>(2004, 1.12));
		pset.getData().add(new XYChart.Data<Integer, Double>(2005, 5.2));
		pset.getData().add(new XYChart.Data<Integer, Double>(2006, 2.6));
		pset.getData().add(new XYChart.Data<Integer, Double>(2007, 3.5));
		pset.getData().add(new XYChart.Data<Integer, Double>(2008, 5.53));
		pset.getData().add(new XYChart.Data<Integer, Double>(2009, 4.73));
		pset.getData().add(new XYChart.Data<Integer, Double>(2010, 4.45));
		pset.getData().add(new XYChart.Data<Integer, Double>(2011, 3.21));
		pset.getData().add(new XYChart.Data<Integer, Double>(2012, 3.2));
		pset.getData().add(new XYChart.Data<Integer, Double>(2013, 4.17));
		pset.getData().add(new XYChart.Data<Integer, Double>(2014, 2.37));
		pset.getData().add(new XYChart.Data<Integer, Double>(2015, 2.6));
		pset.getData().add(new XYChart.Data<Integer, Double>(2016, 3.85));
		pset.getData().add(new XYChart.Data<Integer, Double>(2017, 4.00));
		pset.getData().add(new XYChart.Data<Integer, Double>(2018, 4.67));
		pset.getData().add(new XYChart.Data<Integer, Double>(2019, 8.3));

		XYChart.Series<Integer, Double> cset = new XYChart.Series<>();
		cset.setName("C++");
		cset.getData().add(new XYChart.Data<Integer, Double>(2002, 15.00));
		cset.getData().add(new XYChart.Data<Integer, Double>(2003, 13.2));
		cset.getData().add(new XYChart.Data<Integer, Double>(2004, 14.63));
		cset.getData().add(new XYChart.Data<Integer, Double>(2005, 11.92));
		cset.getData().add(new XYChart.Data<Integer, Double>(2006, 11.34));
		cset.getData().add(new XYChart.Data<Integer, Double>(2007, 10.42));
		cset.getData().add(new XYChart.Data<Integer, Double>(2008, 8.73));
		cset.getData().add(new XYChart.Data<Integer, Double>(2009, 10.11));
		cset.getData().add(new XYChart.Data<Integer, Double>(2010, 9.7));
		cset.getData().add(new XYChart.Data<Integer, Double>(2011, 7.83));
		cset.getData().add(new XYChart.Data<Integer, Double>(2012, 8.00));
		cset.getData().add(new XYChart.Data<Integer, Double>(2013, 9.14));
		cset.getData().add(new XYChart.Data<Integer, Double>(2014, 7.56));
		cset.getData().add(new XYChart.Data<Integer, Double>(2015, 6.00));
		cset.getData().add(new XYChart.Data<Integer, Double>(2016, 6.91));
		cset.getData().add(new XYChart.Data<Integer, Double>(2017, 6.3));
		cset.getData().add(new XYChart.Data<Integer, Double>(2018, 5.6));
		cset.getData().add(new XYChart.Data<Integer, Double>(2019, 8.16));

		lineChart.getData().addAll(jset, pset, cset);
	}
}
