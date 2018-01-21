package com.kata;

import com.kata.exception.PlayerUnkownException;

public class Game {
    private Player player1;
    private Player player2;
    private boolean gameInProgress;

    public Game(Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
        p1.setScoreGame(0);
        p2.setScoreGame(0);
        gameInProgress = false;
    }

    public void endGame(Player p1, Player p2) {
        p1.setScoreGame(0);
        p2.setScoreGame(0);
    }

    public boolean isWon() {
        int score_set_player_one = player1.getScoreSet();
        int score_set_player_two = player2.getScoreSet();
        if (isSetWon(score_set_player_one, score_set_player_two) || (isSetWon(score_set_player_two, score_set_player_one))) {
            return true;
        }
        if (isSetPlanned(score_set_player_one, score_set_player_two) || (isSetPlanned(score_set_player_two, score_set_player_one))) {
            gameInProgress = true;
            return false;
        }
        if (((score_set_player_one == 7) || (score_set_player_two == 7)) && (gameInProgress == true)) {
            return true;
        }
        return false;
    }

    private boolean isSetPlanned(int score_set_player_one, int score_set_player_two) {
        return (score_set_player_one == 6) && (score_set_player_two == 5);
    }

    private boolean isSetWon(int score_set_player_one, int score_set_player_two) {
        return (score_set_player_one == 6) && (score_set_player_two <= 4);
    }

    public void playerIsScoring(String name) {
        int score_player_one = player1.getScoreGame();
        int score_player_two = player2.getScoreGame();
        if (name.equals(player1.getName())) {
            calculatePlayerScore(player1, score_player_one, player2);
        } else if (name.equals(player2.getName())) {
            calculatePlayerScore(player2, score_player_two, player1);
        }else {
            throw new PlayerUnkownException("The player " + name + "is Unkown");
        }
    }

    private void calculatePlayerScore(Player player, int score_player, Player adverse) {
        if (score_player < 40) {
            player.wonPoint();
        } else if (score_player == 40) {
            if (!player.hasAdvantage()) {
                if (!adverse.hasAdvantage()) {
                    player.setAdvantage();
                    System.out.println(player.getName() + " has Advantage");
                } else if (adverse.hasAdvantage() == true) {
                    adverse.setAdvantage();
                    System.out.println("DUEUCE");
                }
            } else if ((player.hasAdvantage() == true) && (!adverse.hasAdvantage())) {
                System.out.println(player.getName() + " won this game");
                endGame(player, adverse);
                player.setScoreSet(player.getScoreSet() + 1);
            }
        }
    }

    public void printScorePLayer() {
        System.out.println(player1.getName() + " score is : " + player1.getScoreGame());
        System.out.println(player2.getName() + " score is : " + player2.getScoreGame());
    }

    public void printScoreMatch() {
        System.out.println("The match is over");
        System.out.println(player1.getName()+" score is : " + player1.getScoreGame());
        System.out.println(player2.getName()+" score is : " + player2.getScoreGame());
        if (player1.getScoreGame() > player2.getScoreGame()) {
            System.out.println("Player one won the match");
        } else {
            System.out.println("Player two won the match");
        }
    }
}
