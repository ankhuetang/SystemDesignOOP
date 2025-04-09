package org.example;

import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private ConcurrentHashMap<Product, Integer> stocks;

    public Inventory() {
        this.stocks = new ConcurrentHashMap<>();
    }

    public void dispenseProduct(Product product) {
        int currentStock = this.stocks.getOrDefault(product, 0);
        this.stocks.put(product, currentStock - 1);
    }

    public void restockProduct(Product product, int quantity) {
        int currentStock = this.stocks.getOrDefault(product, 0);
        this.stocks.put(product, currentStock + quantity);
    }

    public boolean isInStock(Product product) {
        if (this.stocks.get(product) > 0) {
            return true;
        }
        return false;
    }

}
