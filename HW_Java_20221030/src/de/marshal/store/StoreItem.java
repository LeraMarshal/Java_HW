package de.marshal.store;

public class StoreItem {
    private long price;
    private String name;

    public StoreItem(long price, String name) {
        this.price = price;
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StoreItem{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
