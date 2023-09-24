package com.cgvsu.rasterizationfxapp;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        // Rotation
        Rasterization.drawRotatedEllipses(canvas.getGraphicsContext2D(), 300, 300, 100,60, Color.BLACK, Color.RED);
        Rasterization.drawRotatedEllipses(canvas.getGraphicsContext2D(), 500, 200, 60,20, Color.RED, Color.GREEN);
        Rasterization.drawRotatedEllipses(canvas.getGraphicsContext2D(), 200, 400, 36, 20, Color.CHOCOLATE, Color.MAGENTA);
        Rasterization.drawRotatedEllipses(canvas.getGraphicsContext2D(), 100, 100, 50, 30, Color.GREEN, Color.BLUE);

        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 500,300,50,100,150,Color.DARKGRAY, Color.YELLOW);
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 300,400,20,60,24,Color.AQUAMARINE, Color.BLACK);
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 40,30,600,400,0,Color.BLACK, Color.CRIMSON);

        for (int i = 1; i <= 9; i++) {
            Rasterization.drawEllipse(canvas.getGraphicsContext2D(), i * 80,150,70,50, (i - 1) * 45,Color.RED, Color.BLUE);
        }

        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 600, 450, 60,60,0, Color.BLACK, Color.BLACK);
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 600, 450, 60,100,0, Color.BLACK, Color.BLACK);
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 600, 450, 100,60,0, Color.BLACK, Color.BLACK);
        Rasterization.drawEllipse(canvas.getGraphicsContext2D(), 600, 450, 100,100,0, Color.BLACK, Color.BLACK);

    }



}