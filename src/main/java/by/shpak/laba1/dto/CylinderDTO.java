package by.shpak.laba1.dto;

public class CylinderDTO {
    private final double radius;
    private final double height;
    private final double volume;

    public CylinderDTO(double radius, double height, double volume) {
        this.radius = radius;
        this.height = height;
        this.volume = volume;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return volume;
    }
}
