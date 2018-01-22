package com.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void should_return_Not_Won_When_Player_Score_Is_Zero() throws Exception {
        //GIVEN
        Player player1 = new Player("test1");
        Player player2 = new Player("test2");
        Game game = new Game(player1, player2);
        //WHEN
        boolean result = game.isWon();
        //THEN
        assertFalse(result);
    }

    @Test
    public void should_return_Won_When_We_Have_A_Winner() throws Exception {
        //GIVEN
        Player player1 = new Player("test1");
        Player player2 = new Player("test2");
        Game game = new Game(player1, player2);
        //WHEN
        player1.setScoreSet(6);
        player2.setScoreSet(4);
        Boolean result = game.isWon();
        //THEN
        assertTrue(result);
    }

    @Test
    public void should_switch_to_tie_break_mode_when_score_is_6_6() {
        //GIVEN
        Player player1 = new Player("test1");
        Player player2 = new Player("test2");
        Game game = new Game(player1, player2);
        player1.setScoreSet(6);
        player1.setScoreGame(15);
        player2.setScoreSet(5);
        player2.setScoreGame(40);
        //WHEN
        game.playerIsScoring("test2");
        //THEN
        assertTrue(game.isTieBreak());
    }

    @Test
    public void should_won_tie_break_mode_when_difference_is_more_than_two() {
        //GIVEN
        Player player1 = new Player("test1");
        Player player2 = new Player("test2");
        Game game = new Game(player1, player2);
        player1.setScoreSet(6);
        player1.setScoreTieBreak(5);
        player2.setScoreSet(6);
        player2.setScoreTieBreak(6);
        game.switchToTieBreakMode();
        //WHEN
        game.playerIsScoring("test2");
        //THEN
        assertTrue(game.isWon());
    }
}