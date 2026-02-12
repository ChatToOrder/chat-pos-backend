# chat-pos-backend

chat-pos-backend (parent / aggregator)
│
├── chat-pos-domain          → pure business logic
├── chat-pos-application     → use cases
├── chat-pos-infrastructure  → adapters (DB, external APIs)
└── chat-pos-boot            → Spring Boot entry point