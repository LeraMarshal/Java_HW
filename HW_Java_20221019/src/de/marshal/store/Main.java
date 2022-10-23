package de.marshal.store;

import java.util.List;

public class Main {
    /*
    Допустим, у нас есть магазин. В нашем магазине есть товары трёх категорий:
    продукты, электроника(мобильные телефоны и ноутбуки), одежда.
    У каждого товара есть цена и наименование . Каждый товар можно купить (покупателю выставляется счет).

    - при покупке продуктов выставляется дополнительная цена за срочность доставки.
    - при покупке электроники, покупателю оформляют гарантию (т.е. при покупке должен выполнятся метод “Оформить гарантию”)
    - телефоны продаются только с контрактом оператора (т.е. при покупке должен выполнятся метод “Оформить контракт”)

    Необходимо создать соответствующую структуру классов метод покупки товара
     */

    public static void main(String[] args) {
        Store store = new Store();

        Invoice invoice = store.checkout(List.of(
                new FoodItem(100L, "Milk"),
                new ElectricalItem(10000L, "Monitor"),
                new PhoneItem(150000L, "iPhone14"),
                new LaptopItem(299000L, "MacBook"),
                new DressItem(100L, "Socks")
        ));

        System.out.println(invoice);
    }
}
