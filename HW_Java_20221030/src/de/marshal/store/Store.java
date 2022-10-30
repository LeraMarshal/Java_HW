package de.marshal.store;

import java.util.List;

public class Store {
    private static final long URGENCY_FEE = 500L;

    public Invoice checkout(List<StoreItem> items) {
        Invoice invoice = new Invoice();

        for (StoreItem item : items) {
            invoice.addItem(item);

            if (item instanceof FoodItem) {
                invoice.setUrgencyFee(URGENCY_FEE);
            } else if (item instanceof ElectricalItem) {
                invoice.addWarranty(createWarranty(item));

                if (item instanceof PhoneItem) {
                    invoice.addContract(createContract(item));
                }
            }
        }

        return invoice;
    }

    private String createWarranty(StoreItem item) {
        return "Warranty for " + item;
    }

    private String createContract(StoreItem item) {
        return "Contract for " + item;
    }
}
