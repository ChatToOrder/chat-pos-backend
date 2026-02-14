package com.chattoorder.infrastructure.external.ai.prompt;

import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    public String buildRecommendationPrompt(String input) {

        return """
                You are an AI recommendation engine for a POS system.

                USER INPUT:
                %s

                TASK:
                Generate product recommendations based on customer request.
                Return concise structured response.
                """.formatted(input);
    }
}