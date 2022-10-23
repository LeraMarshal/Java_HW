package de.marshal.store;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private long urgencyFee = 0L;
    private List<StoreItem> items = new ArrayList<>();
    private List<String> warranties = new ArrayList<>();
    private List<String> contracts = new ArrayList<>();

    public void addItem(StoreItem item) {
        items.add(item);
    }

    public void addWarranty(String warranty) {
        warranties.add(warranty);
    }

    public void addContract(String contract) {
        contracts.add(contract);
    }

    public void setUrgencyFee(long urgencyFee) {
        this.urgencyFee = urgencyFee;
    }

    public long getTotal() {
        long total = urgencyFee;
        for (StoreItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "urgencyFee=" + urgencyFee +
                ", items=" + items +
                ", warranties=" + warranties +
                ", contracts=" + contracts +
                ", total=" + getTotal() +
                '}';
    }
}
