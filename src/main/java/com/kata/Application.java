package com.kata;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the first player :");
        String playerOneName = sc.nextLine();
        System.out.println("Please enter the name of the second player :");
        String playerTwoName = sc.nextLine();

        Player player1 = new Player(playerOneName);
        Player player2 = new Player(playerTwoName);

        Game game = new Game(player1, player2);
        while (!game.isWon()) {
            System.out.println("Please enter the name of the player that will score");
            String name = sc.nextLine();
            game.playerIsScoring(name);
            game.printScorePLayer();
        }
        System.out.println("Match is over");
        game.printScoreMatch();
    }
}
