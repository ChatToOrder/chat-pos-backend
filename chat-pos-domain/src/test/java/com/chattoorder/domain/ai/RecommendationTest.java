package com.chattoorder.domain.ai;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Recommendation domain model
 */
class RecommendationTest {

    @Test
    void testRecommendationCreation() {
        // Arrange
        String value = "Margherita Pizza";

        // Act
        Recommendation recommendation = new Recommendation(value);

        // Assert
        assertNotNull(recommendation);
        assertEquals(value, recommendation.getValue());
    }

    @Test
    void testRecommendationWithEmptyString() {
        // Arrange
        String value = "";

        // Act
        Recommendation recommendation = new Recommendation(value);

        // Assert
        assertNotNull(recommendation);
        assertEquals("", recommendation.getValue());
    }

    @Test
    void testRecommendationValue_NotNull() {
        // Arrange
        String value = "Pepperoni Pizza";

        // Act
        Recommendation recommendation = new Recommendation(value);

        // Assert
        assertNotNull(recommendation.getValue());
    }

    @Test
    void testRecommendationEquality() {
        // Arrange
        String value = "Hawaiian Pizza";
        Recommendation rec1 = new Recommendation(value);
        Recommendation rec2 = new Recommendation(value);

        // Act & Assert
        assertEquals(rec1.getValue(), rec2.getValue());
    }

    @Test
    void testRecommendationWithSpecialCharacters() {
        // Arrange
        String value = "Pizza - Special 50% off!";

        // Act
        Recommendation recommendation = new Recommendation(value);

        // Assert
        assertEquals(value, recommendation.getValue());
    }
}

