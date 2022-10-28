package de.marshal.pizza;

public class PizzaFactory {
    public Pizza createPizza(PizzaType pizzaType) {
        Pizza pizza = switch (pizzaType) {
            case SALAMI -> new PizzaSalami();
            case HAWAII -> new PizzaHawaii();
            case MOZARELLA -> new PizzaMozarella();
        };

        pizza.prepare();
        pizza.bake();
        pizza.pack();

        return pizza;
    }
}
