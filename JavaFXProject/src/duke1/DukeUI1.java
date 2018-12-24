package duke1;
/**
 * author DANUTA
 * 
 * This program uses images
 * taken from the web, a dialogue window 
 * and css file reference.
 */

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DukeUI1 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 470, 480);
		scene.getStylesheets().add(getClass().getResource("style1.css").toExternalForm());

		Image d_image = new Image("http://www.comscigate.com/gifs/duke/SantaDuke.png");
		ImageView d_image_view = new ImageView(d_image);
		root.getChildren().add(d_image_view);

		Group center_group = new Group();
		root.setCenter(center_group);

		Button button1 = new Button("Java cup");
		button1.setId("button1");
		Button button2 = new Button("playing Duke");
		button2.setId("button2");
		Button button3 = new Button("hot");
		button3.setId("button3");
		HBox top_hbox = new HBox(10);
		root.setTop(top_hbox);
		top_hbox.getChildren().addAll(button1, button2, button3);
		top_hbox.setPadding(new Insets(10, 10, 10, 10));

		button1.setOnAction(event -> {
			Image c_image = new Image("http://www.comscigate.com/gifs/duke/javaCup.gif");
			ImageView cimage_view = new ImageView(c_image);
			center_group.getChildren().add(cimage_view);
			c_image.getPixelReader();
			c_image.isBackgroundLoading();
		});

		button2.setOnAction(event -> {

			Image test_image2 = new Image("https://eldermoraes.files.wordpress.com/2015/12/duke-guitar.png");
			ImageView test_image_view2 = new ImageView(test_image2);
			center_group.getChildren().add(test_image_view2);

			Alert alert = new Alert(AlertType.CONFIRMATION, " Click OK to get a cup.");
			Optional<ButtonType> result = alert.showAndWait();

			if (result.isPresent() && result.get() == ButtonType.OK) {
				Image c_image = new Image("http://www.comscigate.com/gifs/duke/javaCup.gif");
				ImageView cimage_view = new ImageView(c_image);
				center_group.getChildren().add(cimage_view);
				c_image.isBackgroundLoading();
			}
		});

		button3.setOnAction(event -> {
			Image h_image = new Image("http://www.comscigate.com/gifs/duke/javaHot.gif");
			ImageView himage_view = new ImageView(h_image);
			top_hbox.getChildren().add(himage_view);
			h_image.getPixelReader();
			h_image.isBackgroundLoading();

		});

		primaryStage.setTitle("Xmass App with Duke");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
