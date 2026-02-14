package com.chattoorder.infrastructure.external.ai.parser;

import com.chattoorder.domain.ai.Recommendation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AiResponseParser {

    /**
     * Converts raw AI response into domain objects.
     * Later this can be upgraded to JSON parsing.
     */
    public List<Recommendation> parseRecommendations(String rawResponse) {

        List<Recommendation> result = new ArrayList<>();

        // Temporary simple parsing (Phase 1)
        // Assume AI returns lines:
        // Pizza
        // Burger
        // Pasta

        if (rawResponse == null || rawResponse.isBlank()) {
            return result;
        }

        String[] lines = rawResponse.split("\\n");

        for (String line : lines) {
            String value = line.trim();
            if (!value.isEmpty()) {
                result.add(new Recommendation(value));
            }
        }

        return result;
    }
}