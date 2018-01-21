package com.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void should_return_Not_Won_When_Player_Score_Is_Zero() throws Exception {
        //GIVEN
        Player player1 =new Player("test1");
        Player player2 =new Player("test2");
        Game game= new Game(player1,player2);
        //when
        boolean result = game.isWon();
        //then
        assertFalse(result);
    }
    @Test
    public void should_return_Won_When_We_Have_A_Winner() throws Exception {
        //GIVEN
        Player player1 =new Player("test1");
        Player player2 =new Player("test2");
        Game game= new Game(player1,player2);
        //When
        player1.setScoreGame(6);
        player1.setScoreGame(5);
        Boolean result = game.isWon();
        //then
        assertTrue(result);
    }
}