package by.shpak.laba1.domain;

public class CylinderVolume {
    private final double height;
    private final double radius;
    private final double value;

    public CylinderVolume(double height, double radius) {
        this.height = height;
        this.radius = radius;
        value = 3.14*Math.pow(radius,2)*height;
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    public double getValue() {
        return value;
    }
}
