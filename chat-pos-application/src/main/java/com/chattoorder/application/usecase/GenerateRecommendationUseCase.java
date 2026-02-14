package com.chattoorder.application.usecase;

import com.chattoorder.application.port.out.AIInferencePort;
import com.chattoorder.domain.ai.Recommendation;

import java.util.List;

public class GenerateRecommendationUseCase {
    private final AIInferencePort aiInferencePort;

    public GenerateRecommendationUseCase(AIInferencePort aiInferencePort) {
        this.aiInferencePort = aiInferencePort;
    }

    public List<Recommendation> execute(String input) {
        return aiInferencePort.generateRecommendations(input);
    }
}
