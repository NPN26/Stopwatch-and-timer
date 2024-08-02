package org.example.stopwatch;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Stopwatch extends Application {
    GridPane root;
    Button startButton;
    Button stopButton;
    Text time;
    Text second;
    Circle circle;
    Box circle2;

    @Override
    public void start(Stage stage) {
//        circle = new Circle(200, 150, 300);
//        circle.setFill(null);
//        circle.setStroke(Color.BLACK);
//        circle.setStrokeWidth(2);
//        root.getChildren().add(circle);
//
//        circle2 = new Box(250, 150, 100);
//        root.getChildren().add(circle2);
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        Scene scene = new Scene(root, 800, 600);

        time = new Text("00 : 00");
        time.setTextAlignment(TextAlignment.CENTER);
        time.setWrappingWidth(100);
        time.setStyle("-fx-font-size: 24px;");

        root.addRow(0,time);

        startButton = new Button("Start");
        startButton.setOnAction(e -> startStopwatch());

        stopButton = new Button("Stop");
        stopButton.setOnAction(e -> stopStopwatch());

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(0,stopButton,startButton);
        root.addRow(1,grid);

        root.setGridLinesVisible(false);

        stage.setTitle("Homepage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void startStopwatch() {
        second.setText("01");
    }

    public void stopStopwatch() {

    }

    public void resetStopwatch() {

    }
}