package com.chattoorder.application.service;

import com.chattoorder.application.port.out.AIInferencePort;
import com.chattoorder.domain.ai.Recommendation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for RecommendationService
 */
@ExtendWith(MockitoExtension.class)
class RecommendationServiceTest {

    @Mock
    private AIInferencePort aiInferencePort;

    private RecommendationService recommendationService;

    @BeforeEach
    void setUp() {
        recommendationService = new RecommendationService(aiInferencePort);
    }

    @Test
    void testGenerateRecommendations_Success() {
        // Arrange
        String input = "Show me pizza";
        List<Recommendation> expectedRecommendations = new ArrayList<>();

        when(aiInferencePort.generateRecommendations(input))
            .thenReturn(expectedRecommendations);

        // Act
        List<Recommendation> result = recommendationService.generateRecommendations(input);

        // Assert
        assertNotNull(result);
        assertEquals(expectedRecommendations, result);
        verify(aiInferencePort, times(1)).generateRecommendations(input);
    }

    @Test
    void testGenerateRecommendations_WithNullInput() {
        // Arrange
        List<Recommendation> expectedRecommendations = new ArrayList<>();

        when(aiInferencePort.generateRecommendations(null))
            .thenReturn(expectedRecommendations);

        // Act
        List<Recommendation> result = recommendationService.generateRecommendations(null);

        // Assert
        assertNotNull(result);
        assertEquals(expectedRecommendations, result);
    }

    @Test
    void testGenerateRecommendations_ServiceIsCalledWithCorrectInput() {
        // Arrange
        String input = "Burger";
        List<Recommendation> mockRecommendations = new ArrayList<>();

        when(aiInferencePort.generateRecommendations(input))
            .thenReturn(mockRecommendations);

        // Act
        recommendationService.generateRecommendations(input);

        // Assert
        verify(aiInferencePort).generateRecommendations(input);
    }

    @Test
    void testRecommendationService_ConstructorInjection() {
        // Arrange & Act
        RecommendationService service = new RecommendationService(aiInferencePort);

        // Assert
        assertNotNull(service);
    }
}

