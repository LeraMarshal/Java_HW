package de.marshal.store;

public class DressItem extends StoreItem {
    public DressItem(long price, String name) {
        super(price, name);
    }

    @Override
    public String toString() {
        return "DressItem{} " + super.toString();
    }
}
