package de.marshal.store;

public class ElectricalItem extends StoreItem {
    public ElectricalItem(long price, String name) {
        super(price, name);
    }

    @Override
    public String toString() {
        return "ElectricalItem{} " + super.toString();
    }
}
