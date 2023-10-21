package com.cgvsu.rasterization;

import javafx.geometry.Point2D;

public class Logic {
    public static int getInterpolatedChannel(
            double x,
            double x0, double x1,
            double c0, double c1)
    {
        return (int) Math.abs((c0 + ((c1 - c0) / (x1 - x0)) * (x - x0)) % 256);
    }

    public static Point2D getXYPoint (
            double a, double b,
            double i
    )  {
        double x,y;
        x = a * Math.cos(Math.toRadians(i));
        y = b * Math.sin(Math.toRadians(i));

        return new Point2D(x,y);
    }

    public static Point2D getXYRotatedPoint (
            Point2D xy,
            double rotation
    ) {
        double x,y, xr,yr;
        x = xy.getX();
        y = xy.getY();

        xr = x * Math.cos(Math.toRadians(rotation)) - y * Math.sin(Math.toRadians(rotation));
        yr = x * Math.sin(Math.toRadians(rotation)) + y * Math.cos(Math.toRadians(rotation));

        return new Point2D(xr,yr);

    }
}
