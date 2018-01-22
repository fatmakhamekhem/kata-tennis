package com.kata;

public class Player {

    private String name;
    private int scoreGame;
    private int scoreSet;
    private int scoreTieBreak;
    private boolean advantage;

    public Player(String name) {
        this.name = name;
        scoreGame = 0;
        scoreSet = 0;
        scoreTieBreak = 0;
        advantage = false;
    }

    public void setAdvantage() {
        advantage = true;
    }

    public void lostAdventage() {
        advantage = false;
    }

    public boolean hasAdvantage() {
        return advantage;
    }

    public String getName() {
        return name;
    }

    public int getScoreGame() {
        return scoreGame;
    }

    public int getScoreSet() {
        return scoreSet;
    }


    public void setScoreGame(int scoreGame) {
        this.scoreGame = scoreGame;
    }

    public void setScoreSet(int scoreSet) {
        this.scoreSet = scoreSet;
    }

    public void wonPoint() {
        int playerScore = getScoreGame();
        if ((playerScore == 0) || (playerScore == 15)) {
            setScoreGame(playerScore + 15);
        } else if (playerScore == 30) {
            setScoreGame(playerScore + 10);
        }
    }

    public void wonTieBreakPoint() {
        scoreTieBreak += 1;
    }

    public int getScoreTieBreak() {
        return scoreTieBreak;
    }

    public void setScoreTieBreak(int scoreTieBreak) {
        this.scoreTieBreak = scoreTieBreak;
    }
}


