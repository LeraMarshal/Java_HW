package de.marshal.pizza;

public class Main {
    public static void main(String[] args) {
        /*
        2. Создать фабрику по производству пиццу. Фабрика должна уметь готовить следующие виды пиццы:
        Гавайи, Моцарелла, Салями. Каждый вид пиццы должен уметь:

        подготавливаться(накладывать ингридиенты напр), печься и упаковываться.

        В каждом случае должно быть понятно о какой пицце идет речь.

        Класс Main не должен создавать новый обьект пицца, а из него должен поступать "заказ" на иготовление
        требуемого вида пиццы (обьекта) в класс PizzaFactory, который и должен выбрать нужную пиццу для изготовления.
         */

        PizzaFactory pizzaFactory = new PizzaFactory();

        pizzaFactory.createPizza(PizzaType.SALAMI);
        pizzaFactory.createPizza(PizzaType.MOZARELLA);
        pizzaFactory.createPizza(PizzaType.HAWAII);
    }
}
