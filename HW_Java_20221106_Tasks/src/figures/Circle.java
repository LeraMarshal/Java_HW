package figures;

public class Circle extends AbstractFigure {
    public Circle(double radius) {
        super(Math.PI * radius * radius, 2 * Math.PI * radius);
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
