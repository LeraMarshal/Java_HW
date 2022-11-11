package de.marshal.growing_plants;

public class Tree extends Plant {

    public Tree(String displayName) {
        super(displayName);
    }

    @Override
    public void grow(Season season) {
        switch (season) {
            case SPRING:
                height += 2;
                break;
            case SUMMER:
                height += 3;
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
        return "Tree{} " + super.toString();
    }
}
