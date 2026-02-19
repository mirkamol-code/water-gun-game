package com.mirkamolcode;

import com.mirkamolcode.model.Player;
import com.mirkamolcode.service.GameService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameService gameService = new GameService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Water Gun Game!");
        System.out.print("Enter Player 1's: ");
        String firstPlayerName = scanner.nextLine();
        System.out.print("Enter Player 2's: ");
        String secondPlayerName = scanner.nextLine();

        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        while (gameService.isGameOver(firstPlayer, secondPlayer)) {
            System.out.println(firstPlayerName + "'s water: " + firstPlayer.getWaterTank());
            System.out.println(secondPlayerName + "'s water: " + secondPlayer.getWaterTank());
            if (gameService.isFirstPlayerTurn()) {
                System.out.print(firstPlayerName + ", choose an action (1: Fill water gun, 2: Shoot): ");
                var action = scanner.nextInt();
                gameService.doAction(firstPlayer, secondPlayer, action);

            } else {
                System.out.print(secondPlayerName + ", choose an action (1: Fill water gun, 2: Shoot): ");
                var action = scanner.nextInt();
                gameService.doAction(secondPlayer, firstPlayer, action);

            }
        }
        gameService.printWinner(firstPlayer, secondPlayer);
    }
}
