package com.chattoorder.domain.service;

import com.chattoorder.domain.model.order.Order;

public class OrderPricingService {

    public double calculateWithTax(Order order) {
        return order.calculateTotal() * 1.18;
    }
}
