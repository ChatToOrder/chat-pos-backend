package com.chattoorder.application.port.out;

import com.chattoorder.domain.ai.Recommendation;
import java.util.List;

public interface AIInferencePort {

    List<Recommendation> generateRecommendations(String input);

}
