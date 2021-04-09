package by.shpak.laba1.dto;

import java.util.Objects;

public class QueryContainer {
    private final double radius;
    private final double height;

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public QueryContainer(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryContainer that = (QueryContainer) o;
        return radius == that.radius && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, height);
    }
}
