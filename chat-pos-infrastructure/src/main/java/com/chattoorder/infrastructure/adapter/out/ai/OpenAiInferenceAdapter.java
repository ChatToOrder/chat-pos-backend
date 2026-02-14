package com.chattoorder.infrastructure.adapter.out.ai;

import com.chattoorder.application.port.out.AIInferencePort;
import com.chattoorder.domain.ai.Recommendation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class OpenAiInferenceAdapter implements AIInferencePort {

    @Override
    public List<Recommendation> generateRecommendations(String input) {

        // TODO:
        // 1. Build prompt
        // 2. Call OpenAI API
        // 3. Map response → domain object

        return Collections.emptyList();
    }
}
