package com.example.javaprojectphase1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Random;

public class GameMap extends Application {

    private static final int SIZE = 10;
    private static final int CELL_SIZE = 50;

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        Random rand = new Random();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Rectangle cell = new Rectangle(CELL_SIZE, CELL_SIZE);

                // The castle at the center
                if (i == SIZE / 2 && j == SIZE / 2) {
                    cell.setFill(Color.YELLOW);
                } else {
                    // Randomly place other elements
                    int element = rand.nextInt(5); // Random number between 0 and 4
                    switch (element) {
                        case 0: cell.setFill(Color.GREEN); break; // Treasures
                        case 1: cell.setFill(Color.BLACK); break; // Walls
                        case 2: cell.setFill(Color.ORANGE); break; // Markets
                        case 3: cell.setFill(Color.BLUE); break; // Lost Items
                        default: cell.setFill(Color.LIGHTGRAY); break; // Empty cell
                    }
                }

                grid.add(cell, j, i);
            }
        }

        // Randomly placing traps (red cells), number and positions are random
        int numberOfTraps = rand.nextInt(10) + 1; // At least 1 trap, up to 10
        for (int i = 0; i < numberOfTraps; i++) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);
            Rectangle trap = new Rectangle(CELL_SIZE, CELL_SIZE, Color.RED);
            grid.add(trap, col, row);
        }

        Scene scene = new Scene(grid);
        stage.setTitle("Game Map");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
