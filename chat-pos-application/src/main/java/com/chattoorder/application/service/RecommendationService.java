package com.chattoorder.application.service;

import com.chattoorder.application.port.out.AIInferencePort;
import com.chattoorder.domain.ai.Recommendation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    private final AIInferencePort aiInferencePort;

    public RecommendationService(AIInferencePort aiInferencePort) {
        this.aiInferencePort = aiInferencePort;
    }

    public List<Recommendation> generateRecommendations(String input) {
        return aiInferencePort.generateRecommendations(input);
    }
}