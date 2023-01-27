package For_example.AbstractClass;

public class Rectangle extends Figure {
    private double length;
    private double height;
    public Rectangle(double length, double height, String color) {
        super(color);
        this.length=length;
        this.height=height;
    }

    @Override
    public double area() {
        return length*height;
    }

    @Override
    public double perimeter() {
        return length+height+length+height;
    }

}
