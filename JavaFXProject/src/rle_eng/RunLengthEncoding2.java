package rle_eng;

/**
 * Encoding and decoding of
 * data sequences using
 * RLE method.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RunLengthEncoding2 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 510, 370);
		scene.getStylesheets().add(getClass().getResource("encStyle2.css").toExternalForm());

		Label lab1 = new Label("Source");
		lab1.setId("lab1");
		lab1.setLayoutX(30);
		lab1.setLayoutY(20);
		root.setCenter(lab1);

		Label lab2 = new Label("Result");
		lab2.setId("lab2");
		lab2.setLayoutX(30);
		lab2.setLayoutY(170);
		root.setLeft(lab2);

		Label lab3 = new Label("Select method:");
		lab3.setId("lab3");
		lab3.setLayoutX(340);
		lab3.setLayoutY(30);
		root.setLeft(lab3);

		TextField text1source = new TextField();
		text1source.setId("text1");
		text1source.setLayoutX(30);
		text1source.setLayoutY(50);

		TextField text2result = new TextField();
		text2result.setId("text2");
		text2result.setLayoutX(30);
		text2result.setLayoutY(200);

		Button btn1copy = new Button("Copy");
		btn1copy.setId("btn1copy");
		btn1copy.setLayoutX(200);
		btn1copy.setLayoutY(100);

		Button btn2execute = new Button("Execute");
		btn2execute.setId("btn2execute");
		btn2execute.setLayoutX(30);
		btn2execute.setLayoutY(250);
		
		Button btn3clear = new Button("Clear fields");
		btn3clear.setId("btn3clear");
		btn3clear.setLayoutX(320);
		btn3clear.setLayoutY(270);

		Group center_group = new Group();
		root.setCenter(center_group);
		Image test_image = new Image(getClass().getResourceAsStream("bg.jpg"));

		ImageView test_image_view = new ImageView(test_image);
		center_group.getChildren().add(test_image_view);

		center_group.getChildren().add(text1source);
		center_group.getChildren().add(text2result);
		center_group.getChildren().addAll(lab1, lab2, lab3, btn1copy, btn2execute, btn3clear);

		RadioButton r1 = new RadioButton("coding");
		r1.setId("r1");

		RadioButton r2 = new RadioButton("decoding");
		r2.setId("r2");
		//r2.setFont(Font.font("Verdana", 16));

		r1.setLayoutX(340);
		r1.setLayoutY(70);
		r2.setLayoutX(340);
		r2.setLayoutY(110);

		ToggleGroup tgroup = new ToggleGroup();

		r1.setToggleGroup(tgroup);
		r2.setToggleGroup(tgroup);

		tgroup.selectedToggleProperty().addListener((ov, oldToggle, newToggle) -> {
			System.out.println(newToggle.getUserData().toString());
		});

		center_group.getChildren().addAll(r1, r2);

		text2result.setOnAction(event -> {

		});

		btn2execute.setOnAction(event -> {
			if (r1.isSelected()) {
				String t1 = text1source.getText().toString();
				text2result.getText();
				text2result.setText(encode(t1));
			} else if (r2.isSelected()) {
				String t1 = text1source.getText().toString();
				text2result.setText(t1);
			} else if (r1.isSelected() == false | r2.isSelected() == false) {
				Alert alert = new Alert(AlertType.INFORMATION, "Select coding or decoding.");
				alert.setTitle("info");
				alert.show();

			}

			else if (text1source.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION, "Fill in Source field.");
				alert.setTitle("info");
				alert.show();
			}
		});

		btn1copy.setOnAction(event -> {
			if (text2result.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION, "Result field is empty.");
				alert.setTitle("info");
				alert.show();
			} else if (r1.isSelected()) {
				String t1 = text1source.getText().toString();
				text2result.setText(encode(t1));
				String t2 = text2result.getText().toString();
				text1source.setText(t2);
				text2result.clear();

			} else if (r2.isSelected()) {
				String t2 = text2result.getText().toString();
				text1source.setText(decode(t2));
				text2result.clear();
			}

		});

		btn3clear.setOnAction(event -> {
			text1source.clear();
			text2result.clear();
		});

		primaryStage.setTitle("Coding and decoding of data");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	// methods:

	public static String encode(String plainText) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < plainText.length(); i++) {
			int encodedLength = 1;
			while (i + 1 < plainText.length() && plainText.charAt(i) == plainText.charAt(i + 1)) {
				encodedLength++;
				i++;
			}
			sb.append(encodedLength);
			sb.append(plainText.charAt(i));
		}
		return sb.toString();
	}

	public static String decode(String encodedText) {
		StringBuffer sb2 = new StringBuffer();
		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = pattern.matcher(encodedText);
		while (matcher.find()) {
			int number = Integer.parseInt(matcher.group());
			matcher.find();
			while (number-- != 0) {
				sb2.append(matcher.group());
			}
		}
		return sb2.toString();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
