package com.ddd_bootcamp.domain.events;

public class ItemAddedToCartEvent implements DomainEvent {
    private String productName;
    private int quantity;

    public ItemAddedToCartEvent(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
