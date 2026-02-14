package com.chattoorder.domain.model.order;


import com.chattoorder.domain.event.DomainEvent;
import com.chattoorder.domain.event.OrderConfirmedEvent;
import com.chattoorder.domain.model.product.Price;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(of = "id")
public class Order {

    @Getter
    private final String id;
    @Getter
    private final String customerId;
    Instant createdAt;
    Instant updatedAt;
    @Getter
    private OrderStatus status;
    private String currency;
    private Price subtotal;
    private double tax;
    private double discount;
    private final List<OrderItem> items = new ArrayList<>();
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    private void touch() {
        updatedAt = Instant.now();
    }

    public Order(String id, String customerId) {

        if (id == null || id.isBlank())
            throw new IllegalArgumentException("Order ID required");

        if (customerId == null || customerId.isBlank())
            throw new IllegalArgumentException("Customer ID required");

        this.id = id;
        this.customerId = customerId;
        this.status = OrderStatus.DRAFT;
        this.updatedAt = this.createdAt;
        this.currency = "INR";
    }

    public void addItem(OrderItem item) {
        ensureDraft();

        if (item == null)
            throw new IllegalArgumentException("Order item required");

        items.add(item);
        touch();
    }

    public void removeItem(String productId) {
        ensureDraft();
        items.removeIf(i -> i.getProductId().equals(productId));
        touch();
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getTotalPrice)
                .sum();
    }

    public void confirmOrder() {
        ensureStatus(OrderStatus.DRAFT);

        if (items.isEmpty())
            throw new IllegalStateException("Order cannot be empty");

        this.status = OrderStatus.CONFIRMED;

        domainEvents.add(new OrderConfirmedEvent(id));
        touch();
    }

    private void ensureDraft() {
        if (status != OrderStatus.DRAFT) {
            throw new IllegalStateException("Order is not editable");
        }
    }

    private void ensureStatus(OrderStatus expected) {
        if (status != expected) {
            throw new IllegalStateException(
                    "Invalid state transition from " + status
            );
        }
    }

    public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = List.copyOf(domainEvents);
        domainEvents.clear();
        return events;
    }

}