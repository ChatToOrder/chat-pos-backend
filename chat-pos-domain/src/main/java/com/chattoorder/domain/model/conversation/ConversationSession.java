package com.chattoorder.domain.model.conversation;

public class ConversationSession {

    private final String customerId;
    private String activeOrderId;
    private ConversationState state;

    public ConversationSession(String customerId) {
        this.customerId = customerId;
        this.state = ConversationState.IDLE;
    }

    public void startOrdering(String orderId) {
        this.activeOrderId = orderId;
        this.state = ConversationState.ORDERING;
    }

    public void checkout() {
        this.state = ConversationState.CHECKOUT;
    }
}
