package For_example.AbstractClass;

import java.util.Objects;

public abstract class Figure {
private String color;

    public Figure(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public abstract double area();
    public abstract double perimeter();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(color, figure.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
