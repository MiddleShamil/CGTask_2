package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    private static int getInterpolatedChannel(
            double x,
            double x0, double x1,
            double c0, double c1)
    {
        return (int) Math.abs((c0 + ((c1 - c0) / (x1 - x0)) * (x - x0)) % 256);
    }
    public static void drawEllipse (
            final GraphicsContext graphicsContext,
            final int x0, final int y0,
            final double a, final double b,
            final double rotation,
            final Color color1, final Color color2) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        double x, y, xr, yr;
        Color newColor;
        
        for (double i = 0; i <= 360 ; i+=0.08) {
            x = a * Math.cos(Math.toRadians(i));
            y = b * Math.sin(Math.toRadians(i));

            xr = x * Math.cos(Math.toRadians(rotation)) - y * Math.sin(Math.toRadians(rotation));
            yr = x * Math.sin(Math.toRadians(rotation)) + y * Math.cos(Math.toRadians(rotation));

            newColor = Color.rgb(
                    getInterpolatedChannel(x0 + x,x0 + a,x0 - a, color1.getRed() * 255, color2.getRed() * 255),
                    getInterpolatedChannel(x0 + x,x0 +  a,x0 - a, color1.getGreen()* 255, color2.getGreen()* 255),
                    getInterpolatedChannel(x0 + x,x0 + a,x0 - a, color1.getBlue()* 255, color2.getBlue()* 255)
            );

            pixelWriter.setColor((int)xr + x0, (int)yr + y0, newColor);

        }
    }

    public static void drawRotatedEllipses(
            final GraphicsContext graphicsContext,
            final int x0, final int y0,
            final double a, final double b,
            final Color color1, final Color color2
            ) {
        for (int i = 0; i <= 18; i++) {
            drawEllipse(graphicsContext, x0 ,y0, a, b,i * 10, color1, color2 );
        }
     }
}
