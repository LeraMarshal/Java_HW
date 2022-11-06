package figures;

public class Rectangle extends AbstractFigure {
    public Rectangle(double width, double height) {
        super(width*height, 2 * (width+height));
    }

    @Override
    public String toString() {
        return "Rectangle";
    }
}
