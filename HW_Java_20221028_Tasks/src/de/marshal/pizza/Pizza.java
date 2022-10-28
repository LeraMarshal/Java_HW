package de.marshal.pizza;

public abstract class Pizza {
    private PizzaType pizzaType;

    public Pizza(PizzaType pizzaType) {
        this.pizzaType = pizzaType;
    }

    public void prepare() {
        System.out.println("Preparing pizza " + pizzaType);
    }

    public  void bake() {
        System.out.println("Baking pizza " + pizzaType);
    }

    public void pack() {
        System.out.println("Packing pizza " + pizzaType);
    }
}
