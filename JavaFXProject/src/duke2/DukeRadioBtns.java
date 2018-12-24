package duke2;
/**
 * author DANUTA
 * 
 * This program uses images
 * taken from the web, dialogue windows,
 * radio buttons and css file reference.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DukeRadioBtns extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 450, 420);
		
		scene.getStylesheets().add(getClass().getResource("radiobtnstyle.css").toExternalForm());

		Image d_image = new Image("http://www.comscigate.com/gifs/duke/ExplodingCup6small.png");
		ImageView d_image_view = new ImageView(d_image);
		root.getChildren().add(d_image_view);  

		Button button1 = new Button("Selection");
		button1.setId("button1");
		
		HBox top_hbox = new HBox(10);
		root.setTop(top_hbox);
		top_hbox.getChildren().addAll(button1); 
		top_hbox.setPadding(new Insets(10, 10, 10, 10));

		RadioButton r1 = new RadioButton("1");
		r1.setId("r1");
		RadioButton r2 = new RadioButton("2");
		r2.setId("r2");
		RadioButton r3 = new RadioButton("3");
		r3.setId("r3");

		ToggleGroup tgroup = new ToggleGroup();

		r1.setToggleGroup(tgroup);
		r2.setToggleGroup(tgroup);
		r3.setToggleGroup(tgroup);

		tgroup.selectedToggleProperty().addListener(
				(ov, oldToggle, newToggle) -> {
					System.out.println(newToggle.getUserData().toString());
				});

		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(r1, r2, r3);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		root.setCenter(vbox);

		HBox hbox = new HBox(10);
		hbox.setLayoutX(100);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setLayoutY(300);
		root.setRight(hbox);
		
		
		r1.setOnAction(event -> {
			Image c_image = new Image("http://www.comscigate.com/gifs/duke/javaacro.gif");
			ImageView cimage_view = new ImageView(c_image);
			top_hbox.getChildren().add(cimage_view);
			c_image.isBackgroundLoading(); 
		});

		r2.setOnAction(event -> {
			Image c_image = new Image("http://www.comscigate.com/gifs/duke/javaacro.gif");
			ImageView cimage_view = new ImageView(c_image);
			hbox.getChildren().add(cimage_view);
			c_image.isBackgroundLoading(); 
		});

		r3.setOnAction(event -> {
			Image c_image = new Image("http://www.comscigate.com/gifs/duke/javaacro.gif");
			ImageView cimage_view = new ImageView(c_image);
			vbox.getChildren().add(cimage_view);
			c_image.isBackgroundLoading();
		});
		
		Label lb1 = new Label("");
		lb1.setFont(Font.font("Calibri", FontWeight.BOLD, 35));
		lb1.setTextFill(Color.ROYALBLUE);
		lb1.setLayoutY(540);
		root.setBottom(lb1);

		button1.setOnAction(event -> {
			if (r1.isSelected()==false && r2.isSelected()==false &&r3.isSelected()==false) {
				Alert alert = new Alert(AlertType.INFORMATION, "Select a radio button \nand then press button 'selection'.");
				alert.setTitle("Info");
				alert.show();
			}
			else if (r1.isSelected()) {
				lb1.setText(" Radio button 1 was selected");
			} else if (r2.isSelected()) {
				lb1.setText(" Radio button 2 was selected");
			} else if (r3.isSelected()) {
				lb1.setText(" Radio button 3 was selected");
			}
		});

		primaryStage.setTitle("radio buttons");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

