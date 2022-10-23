package de.marshal.store;

public class PhoneItem extends ElectricalItem {
    public PhoneItem(long price, String name) {
        super(price, name);
    }

    @Override
    public String toString() {
        return "PhoneItem{} " + super.toString();
    }
}
