package com.example.javafx_sample_random_color_window;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Random;

public class TestJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Создаем две панели, каждая с кнопкой по центру
        StackPane leftPane = createPaneWithButton();
        StackPane rightPane = createPaneWithButton();

        // Размещаем панели горизонтально
        HBox root = new HBox(leftPane, rightPane);
        root.setPrefSize(Screen.getPrimary().getBounds().getWidth() * 0.25, Screen.getPrimary().getBounds().getHeight() * 0.25);

        // Создаем сцену и отображаем ее на экране
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Test JavaFX");
        primaryStage.show();
    }

    private StackPane createPaneWithButton() {
        // Создаем кнопку с обработчиком нажатия
        Button button = new Button("Change Color");
        button.setOnAction(event -> {
            StackPane pane = (StackPane) button.getParent();
            pane.setStyle("-fx-background-color: " + randomColor());
        });

        // Создаем панель с кнопкой по центру
        StackPane pane = new StackPane(button);
        pane.setMinSize(0, 0);
        pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        return pane;
    }

    private String randomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        return String.format("#%02x%02x%02x", red, green, blue);
    }
}
