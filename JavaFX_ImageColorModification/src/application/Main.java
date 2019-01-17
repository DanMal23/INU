package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {

		Group root = new Group();
		Scene scene = new Scene(root, 530, 420);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		Button btn1 = new Button("Load Image");
		btn1.setId("btn1");
		btn1.setLayoutX(350);
		btn1.setLayoutY(10);

		Button btn2 = new Button("Red");
		btn2.setId("btn2");
		btn2.setLayoutX(350);
		btn2.setLayoutY(70);

		Button btn3 = new Button("Green");
		btn3.setId("btn3");
		btn3.setLayoutX(350);
		btn3.setLayoutY(110);

		Button btn4 = new Button("Blue");
		btn4.setId("btn4");
		btn4.setLayoutX(350);
		btn4.setLayoutY(150);

		Button btn5 = new Button("Negative");
		btn5.setId("btn5");
		btn5.setLayoutX(350);
		btn5.setLayoutY(190);

		Button btn6 = new Button("Solarise");
		btn6.setId("btn6");
		btn6.setLayoutX(350);
		btn6.setLayoutY(230);

		Button btn7 = new Button("Grayscale");
		btn7.setId("btn7");
		btn7.setLayoutX(350);
		btn7.setLayoutY(270);

		Button btn8 = new Button("Dark");
		btn8.setId("btn8");
		btn8.setLayoutX(350);
		btn8.setLayoutY(310);

		Button btn9 = new Button("Clear image");
		btn9.setId("btn9");
		btn9.setLayoutX(350);
		btn9.setLayoutY(370);

		final Canvas canvas = new Canvas(530, 420);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image image = new Image(getClass().getResourceAsStream("white.jpg"));
		gc.drawImage(image, 0, 0);

		int height = (int) image.getHeight();
		int width = (int) image.getWidth();

		PixelReader reader = image.getPixelReader();

		WritableImage dstImage = new WritableImage(width, height);
		PixelWriter writer = dstImage.getPixelWriter();

		root.getChildren().addAll(canvas, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);

		Image image1 = new Image(getClass().getResourceAsStream("decor.jpg"));
		PixelReader reader1 = image1.getPixelReader();

		btn1.setOnAction(event -> {

			gc.drawImage(image1, 10, 0);
		});

		btn2.setOnAction(event -> {
			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++) {
					Color colorX = reader1.getColor(x, y);
					writer.setColor(x, y, Color.color(colorX.getRed(), colorX.getGreen() / 3, colorX.getBlue() / 3));
				}
			gc.drawImage(dstImage, 10, 0);
		});

		btn3.setOnAction(event -> {
			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++) {
					Color colorX = reader1.getColor(x, y);
					writer.setColor(x, y, Color.color(colorX.getRed() / 3, colorX.getGreen(), colorX.getBlue() / 3));
				}
			gc.drawImage(dstImage, 10, 0);
		});

		btn4.setOnAction(event -> {
			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++) {
					Color colorX = reader1.getColor(x, y);
					writer.setColor(x, y, Color.color(colorX.getRed() / 3, colorX.getGreen() / 3, colorX.getBlue()));
				}
			gc.drawImage(dstImage, 10, 0);
		});

		btn5.setOnAction(event -> {
			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++) {
					Color colorX = reader1.getColor(x, y);
					writer.setColor(x, y,
							Color.color(1.0 - colorX.getRed(), 1.0 - colorX.getGreen(), 1.0 - colorX.getBlue()));
				}
			gc.drawImage(dstImage, 10, 0);
		});

		btn6.setOnAction(event -> {
			double SOLARISE = 1.443;
			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++) {
					Color colorX = reader1.getColor(x, y);
					if (colorX.getRed() + colorX.getGreen() + colorX.getBlue() > SOLARISE)
						writer.setColor(x, y, Color.color(colorX.getRed(), colorX.getGreen(), colorX.getBlue()));

					else
						writer.setColor(x, y,
								Color.color(1.0 - colorX.getRed(), 1.0 - colorX.getGreen(), 1.0 - colorX.getBlue()));

				}
			gc.drawImage(dstImage, 10, 0);
		});

		btn7.setOnAction(event -> {
			// int count = 0;
			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++) {
					Color colorX = reader1.getColor(x, y);
					// count += 1;

					writer.setColor(x, y,
							new Color((colorX.getRed() * 0.3 + colorX.getGreen() * 0.59 + colorX.getBlue() * 0.11),
									(colorX.getRed() * 0.3 + colorX.getGreen() * 0.59 + colorX.getBlue() * 0.11),
									(colorX.getRed() * 0.3 + colorX.getGreen() * 0.59 + colorX.getBlue() * 0.11), 1.0));
				}
			gc.drawImage(dstImage, 10, 0);
		});

		btn8.setOnAction(event -> {
			for (int x = 0; x < width; x++)
				for (int y = 0; y < height; y++) {
					Color colorX = reader1.getColor(x, y);

					writer.setColor(x, y,
							Color.color(colorX.getRed() / 2.5, colorX.getGreen() / 3, colorX.getBlue() / 2));
				}
			gc.drawImage(dstImage, 10, 0);
		});

		btn9.setOnAction(event -> {

			gc.drawImage(image, 10, 0);
		});

		
		primaryStage.setTitle("change image color");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
