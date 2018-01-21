package com.kata;

import static org.junit.Assert.*;

public class PlayerTest {
    @org.junit.Test
    public void should_Increase_Player_Score_When_Player_Is_Scoring_First_Time() throws Exception {
        //given
        Player player = new Player("test");
        //when
        player.wonPoint();
        //then
        assertEquals(15,player.getScoreGame());
    }

    @org.junit.Test
    public void should_Increas_Player_Score_When_Player_Is_Scoring() throws Exception {
        //given
        Player player = new Player("test");
        player.setScoreGame(30);
        //when
        player.wonPoint();
        //then
        assertEquals(40,player.getScoreGame());
    }

}