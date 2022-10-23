package de.marshal.store;

public class FoodItem extends StoreItem {
    public FoodItem(long price, String name) {
        super(price, name);
    }

    @Override
    public String toString() {
        return "FoodItem{} " + super.toString();
    }
}
