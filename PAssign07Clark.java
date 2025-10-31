/**
 * File: PAssign07.java
 * Class: CSCI 1302
 * Author: Cameron Clark
 * Created on: Oct 31, 2025
 * Description: A JavaFX GUI that simulates a security keypad panel.
 */

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PAssign07Clark extends Application {

    private static final String ACCESS_CODE = "1234";

    @Override
    public void start(Stage primaryStage) {
        // Display field
        TextField display = new TextField();
        display.setEditable(false);
        display.setPrefWidth(200);
        display.setAlignment(Pos.CENTER_RIGHT);

        // GridPane for keypad
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        // Create digit buttons 1–9
        int num = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int digit = num;
                Button btn = new Button(String.valueOf(digit));
                btn.setPrefSize(60, 60);
                btn.setOnAction(e -> display.appendText(String.valueOf(digit)));
                grid.add(btn, col, row);
                num++;
            }
        }

        // 0, Clear, Enter buttons
        Button btn0 = new Button("0");
        Button btnClear = new Button("Clear");
        Button btnEnter = new Button("Enter");

        btn0.setPrefSize(60, 60);
        btnClear.setPrefSize(60, 60);
        btnEnter.setPrefSize(60, 60);

        btn0.setOnAction(e -> display.appendText("0"));
        btnClear.setOnAction(e -> display.clear());
        btnEnter.setOnAction(e -> {
            String entered = display.getText();
            if (entered.equals(ACCESS_CODE)) {
                display.setText("Access Granted");
            } else {
                display.setText("Access Denied");
            }
        });

        grid.add(btnClear, 0, 3);
        grid.add(btn0, 1, 3);
        grid.add(btnEnter, 2, 3);

        // Layout
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(display, grid);

        // Scene setup
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Security Panel Keypad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
