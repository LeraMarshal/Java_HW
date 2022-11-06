package figures;

public abstract class AbstractFigure implements Figure {
    private double area;
    private double perimeter;

    public AbstractFigure(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }
}
