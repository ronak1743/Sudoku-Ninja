package com.ronak.logic;

public class ScoreCalculator {

    // Difficulty multiplier
    public enum Difficulty {
        EASY(1),
        MEDIUM(2),
        HARD(3);

        private final int multiplier;
        Difficulty(int multiplier) { this.multiplier = multiplier; }
        public int getMultiplier() { return multiplier; }
    }

    private Difficulty difficulty;
    private int hintsUsed;
    private int timeInSeconds;

    // Constructor
    public ScoreCalculator(Difficulty difficulty, int hintsUsed, int timeInSeconds) {
        this.difficulty = difficulty;
        this.hintsUsed = hintsUsed;
        this.timeInSeconds = timeInSeconds;
    }

    // Setters to update dynamically
    public void setHintsUsed(int hintsUsed) { this.hintsUsed = hintsUsed; }
    public void setTimeInSeconds(int timeInSeconds) { this.timeInSeconds = timeInSeconds; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    // Calculate final score
    public int calculateScore() {
        int baseScore = 1000 * difficulty.getMultiplier(); // base score depending on difficulty

        // Time penalty: every second reduces score slightly
        int timePenalty = timeInSeconds * 2;

        // Hint penalty: each hint reduces score
        int hintPenalty = hintsUsed * 50;

        int finalScore = baseScore - timePenalty - hintPenalty;

        // Avoid negative score
        if(finalScore < 0) finalScore = 0;

        return finalScore;
    }
}