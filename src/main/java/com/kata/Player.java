package com.kata;

public class Player {

    private String name;
    private int scoreGame;
    private int scoreSet;
    private boolean advantage;

    public Player(String name) {
        this.name = name;
        this.scoreGame = 0;
        this.scoreSet = 0;
        this.advantage = false;
    }

    public void setAdvantage() {
        this.advantage = (!this.advantage);
    }

    public boolean hasAdvantage() {
        return this.advantage;
    }

    public String getName() {
        return this.name;
    }

    public int getScoreGame() {
        return this.scoreGame;
    }

    public int getScoreSet() {
        return this.scoreSet;
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
}


