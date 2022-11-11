package de.marshal.growing_plants;

public class Flower extends Plant {

    protected boolean isBlooming = false;

    public Flower(String displayName) {
        super(displayName);
    }

    @Override
    public void grow(Season season) {
        switch (season) {
            case SPRING:
                height += 1;
                isBlooming = true;
                break;
            case SUMMER:
                isBlooming = false;
                break;
            case AUTUMN:
                break;
            case WINTER:
                age += 1;
                break;
        }
    }

    @Override
    public String toString() {
        return "Flower{" +
                "isBlooming=" + isBlooming +
                "} " + super.toString();
    }
}
