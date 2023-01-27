package For_example.AbstractClass;

public class Triangle extends Figure {
private double sideA;
    private double sideB;
    private double sideC;
    public Triangle(double sideA, double sideB, double sideC, String color) {
        super(color);
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;
    }

    @Override
    public double area() {
        return (((sideA+sideB+sideC)/2.0)*((sideA+sideB+sideC)/2.0-sideA)*((sideA+sideB+sideC)/2.0-sideB)*((sideA+sideB+sideC)/2.0-sideC));
    }

    @Override
    public double perimeter() {
        return sideA+sideB+sideC;
    }
}
