package com.chattoorder.domain.event;

import lombok.Getter;

@Getter
public final class OrderConfirmedEvent implements DomainEvent {

    private final String orderId;
    private final long occurredAt;

    public OrderConfirmedEvent(String orderId) {

        if (orderId == null || orderId.isBlank())
            throw new IllegalArgumentException("OrderId required");

        this.orderId = orderId;
        this.occurredAt = System.currentTimeMillis();
    }

    @Override
    public String eventType() {
        return "ORDER_CONFIRMED";
    }

    @Override
    public long occurredAt() {
        return occurredAt;
    }
}