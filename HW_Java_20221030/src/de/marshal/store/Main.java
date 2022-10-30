package de.marshal.store;

public class Main {
    /*
    В задаче  про магазин (от  2022-10-19 ) добавить класс корзина (Basket).
    Реализовать метод добавления и удаления товара в корзине.
    Реализовать метод checkout, который должен возвращать список товаров и финальную стоимость покупки в виде строки.

    Подсказка1: класс корзина представляет собой класс, который управляет массивом товаров.
    Примерно аналогичный тому, что мы реализовывали в классе.

    Подсказка2: для получения строки в методе checkout желательно использовать StringBuilder

    Ограничение: не использовать стандартные классы коллекций в Java. Использовать только массив.
     */

    public static void main(String[] args) {
        Store store = new Store();

        Basket basket = new Basket(store);
        FoodItem foodItem = new FoodItem(100L, "Milk");
        basket.add(foodItem);
        basket.remove(foodItem);
        basket.add(foodItem);
        basket.add(foodItem);
        basket.add(foodItem);

        System.out.println(basket.checkout());
    }
}
