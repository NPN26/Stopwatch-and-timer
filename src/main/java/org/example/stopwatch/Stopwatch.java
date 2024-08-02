package org.example.stopwatch;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Box;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Integer.parseInt;

public class Stopwatch extends Application {
    GridPane root;
    Button rightButton;
    Button leftButton;
    Text time;
    int minute = 0;
    int second = 0;
    int milliseconds = 0;
    Circle circle;
    Box circle2;
    Boolean isRunning = false;
    Timeline timer;


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

        //GridPane layout as main
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        // Scene
        Scene scene = new Scene(root, 800, 600);

        // Clock face
        time = new Text("0:0:0");
        time.setTextAlignment(TextAlignment.CENTER);
        time.setWrappingWidth(100);
        time.setStyle("-fx-font-size: 24px;");

        // Add clock face to main layout
        root.addRow(0,time);

        // Start and Stop Buttons to control the stopwatch
        rightButton = new Button("Start");
        rightButton.setOnAction(e -> startStopwatch());

        leftButton = new Button("Reset");
        leftButton.setOnAction(e -> resetStopwatch());

        // GridPane layout for buttons
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(0,leftButton, rightButton);

        // Add buttons to main layout
        root.addRow(1,grid);

        root.setGridLinesVisible(false);

        // Set the scene
        stage.setTitle("Homepage");
        stage.setScene(scene);
        stage.show();

        // Initialize the timer
        timer = new Timeline(new KeyFrame(Duration.millis(10), event -> incrementTime()));
        timer.setCycleCount(Timeline.INDEFINITE);
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Start the stopwatch
    public void startStopwatch() {
        isRunning = true;
        leftButton.setText("Lap");
        rightButton.setText("Stop");
        rightButton.setOnAction(e -> stopStopwatch());
        timer.play();
    }

    private void incrementTime() {
        String times[] = time.getText().split(":");
        minute = parseInt(times[0]);
        second = parseInt(times[1]);
        milliseconds = parseInt(times[2]);
        if (milliseconds == 99) {
            second++;
            milliseconds = 0;
        } else {
            milliseconds++;
        }

        if(second == 60){
            minute++;
            second = 0;
        }
        String newTime = minute + ":" + second + ":" + milliseconds;
        time.setText(newTime);
    }

    // Stop the stopwatch
    public void stopStopwatch() {
        timer.stop();
        leftButton.setText("Reset");
        leftButton.setOnAction(e -> resetStopwatch());
        rightButton.setText("Continue");
        rightButton.setOnAction(e -> startStopwatch());
    }

    // Reset the stopwatch
    public void resetStopwatch() {
        time.setText("0:0:0");
        rightButton.setText("Start");
    }

    public boolean isCounting(){
        return parseInt(time.getText())>0;
    }
}