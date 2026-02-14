package com.chattoorder.infrastructure.external.ai.adapter;

import com.chattoorder.application.port.out.AIInferencePort;
import com.chattoorder.domain.ai.Recommendation;
import com.chattoorder.infrastructure.external.ai.client.AiClient;
import com.chattoorder.infrastructure.external.ai.prompt.PromptBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AiInferenceAdapter implements AIInferencePort {

    private final AiClient aiClient;
    private final PromptBuilder promptBuilder;

    public AiInferenceAdapter(AiClient aiClient,
                              PromptBuilder promptBuilder) {
        this.aiClient = aiClient;
        this.promptBuilder = promptBuilder;
    }

    @Override
    public List<Recommendation> generateRecommendations(String input) {

        String prompt = promptBuilder.buildRecommendationPrompt(input);

        String response = aiClient.callAI(prompt);

        // temporary
        return List.of();
    }
}