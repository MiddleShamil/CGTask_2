package com.cgvsu.rasterization;

import com.cgvsu.DrawElipseInterface;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Elipse implements DrawElipseInterface {

    private final int x0;
    private final int y0;
    private final double a;
    private final double b;
    private final int rotation;
    private final Color color1;
    private final Color color2;

    public Elipse (int x0, int y0, double a, double b, int rotation, Color color1, Color color2) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
        this.b = b;
        this.rotation = rotation;
        this.color1 = color1;
        this.color2 = color2;
    }

    @Override
    public void drawEllipse (final GraphicsContext graphicsContext) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        Color newColor;

        for (double i = 0; i <= 360; i += 0.07) {
            Point2D xy = Logic.getXYPoint(this.a, this.b, i);
            Point2D xyr = Logic.getXYRotatedPoint(xy, this.rotation);

            newColor = Color.rgb(
                    Logic.getInterpolatedChannel(this.x0 + xy.getX(), this.x0 + this.a, this.x0 - this.a, this.color1.getRed() * 255, this.color2.getRed() * 255),
                    Logic.getInterpolatedChannel(this.x0 + xy.getX(), this.x0 + this.a, this.x0 - this.a, this.color1.getGreen() * 255, this.color2.getGreen() * 255),
                    Logic.getInterpolatedChannel(this.x0 + xy.getX(), this.x0 + this.a, this.x0 - this.a, this.color1.getBlue() * 255, this.color2.getBlue() * 255)
            );

            pixelWriter.setColor((int) xyr.getX() + this.x0, (int) xyr.getY() + this.y0, newColor);

        }
    }
}
