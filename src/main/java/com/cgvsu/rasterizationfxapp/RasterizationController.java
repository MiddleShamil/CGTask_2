package com.cgvsu.rasterizationfxapp;

import com.cgvsu.DrawElipseInterface;
import com.cgvsu.RasterizationInterface;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

import com.cgvsu.rasterization.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class RasterizationController implements RasterizationInterface {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        List<DrawElipseInterface> list = new ArrayList<>();

        // Rotation
        for (int i = 0; i < 19; i++) {
            list.add(new Elipse(300,300,100,60,i * 10, Color.BLACK, Color.RED));
            list.add(new Elipse(500, 200, 60,20,i * 10, Color.RED, Color.GREEN));
            list.add(new Elipse(200, 400, 36, 20,i * 10, Color.CHOCOLATE, Color.MAGENTA));
            list.add(new Elipse(100, 100, 50, 30, i * 10, Color.GREEN, Color.BLUE));

        }

        list.add(new Elipse(500,300,50,100,150,Color.DARKGRAY, Color.YELLOW));
        list.add(new Elipse(300,400,20,60,24,Color.AQUAMARINE, Color.BLACK));
        list.add(new Elipse(40,30,600,400,0,Color.BLUE, Color.CRIMSON));


        for (int i = 1; i < 9; i++) {
            list.add(new Elipse(i*80,150,70,50,(i-1) * 45, Color.RED, Color.BLUE));
        }

        list.add(new Elipse(600,450,60,60,0,Color.BLACK,Color.BLACK));
        list.add(new Elipse(600,450,60,100,0,Color.BLACK,Color.BLACK));
        list.add(new Elipse(600,450,100,60,0,Color.BLACK,Color.BLACK));
        list.add(new Elipse(600,450,100,100,0,Color.BLACK,Color.BLACK));

        draw(list);
    }

    public void draw (List<DrawElipseInterface> list) {
        for (DrawElipseInterface elipse : list) {
            elipse.drawEllipse(canvas.getGraphicsContext2D());
        }
    }


}