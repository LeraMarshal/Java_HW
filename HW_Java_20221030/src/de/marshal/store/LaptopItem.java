package de.marshal.store;

public class LaptopItem extends ElectricalItem {
    public LaptopItem(long price, String name) {
        super(price, name);
    }

    @Override
    public String toString() {
        return "LaptopItem{} " + super.toString();
    }
}
