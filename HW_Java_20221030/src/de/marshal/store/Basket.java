package de.marshal.store;

import java.util.List;

public class Basket {
    private Store store;
    private StoreItem[] list = new StoreItem[1];
    private int size = 0;

    public Basket(Store store) {
        this.store = store;
    }

    public void add(StoreItem storeItem) {
        if (size >= list.length) {
            StoreItem[] list2 = new StoreItem[list.length * 2];

            for (int i = 0; i < list.length; i++) {
                list2[i] = list[i];
            }

            list = list2;
        }

        list[size++] = storeItem;
    }

    public void remove(StoreItem storeItem) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == storeItem) {
                for (int j = i; j < list.length - 1; j++) {
                    list[j] = list[j + 1];
                }

                size -= 1;

                list[list.length - 1] = null;
                break;
            }
        }
    }

    public String checkout() {
        /*
        FoodItem{} StoreItem{price=100, name='Milk'} // fi.toString()
        FoodItem{} StoreItem{price=100, name='Milk'}
        FoodItem{} StoreItem{price=100, name='Milk'}

        Total: 300.0 // invoice.getTotal()
         */

        StoreItem[] storeItems = new StoreItem[size];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            storeItems[i] = list[i];

            stringBuilder.append(list[i].toString());
            stringBuilder.append('\n');
        }

        Invoice invoice = store.checkout(List.of(storeItems));

        stringBuilder.append("Total: ");
        stringBuilder.append(invoice.getTotal());

        return stringBuilder.toString();
    }
}
