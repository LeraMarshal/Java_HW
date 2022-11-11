package de.marshal;

public abstract class Plant {
    private String displayName;
    protected int height = 0;
    protected int age = 0;

    public Plant(String displayName) {
        this.displayName = displayName;
    }

    public abstract void grow(Season season);

    @Override
    public String toString() {
        return "Plant{" +
                "displayName='" + displayName + '\'' +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
