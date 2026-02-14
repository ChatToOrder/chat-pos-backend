package com.chattoorder.domain.event;

public interface DomainEvent {

    String eventType();

    long occurredAt();

}
