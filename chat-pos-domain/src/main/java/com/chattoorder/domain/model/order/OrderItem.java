package com.chattoorder.domain.model.order;

public class OrderItem {

    private final String productId;
    private final int quantity;
    private final double price;

    public OrderItem(String productId, int quantity, double price) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0");
        }
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public double getTotalPrice() {
        return quantity * price;
    }

    public String getProductId() {
        return productId;
    }
}
