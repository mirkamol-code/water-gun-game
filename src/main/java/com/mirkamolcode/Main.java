package com.mirkamolcode;

import com.mirkamolcode.model.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Water Gun Game!");
        System.out.print("Enter Player 1's: ");
        String firstPlayerName = scanner.nextLine();
        System.out.print("Enter Player 2's: ");
        String secondPlayerName = scanner.nextLine();

        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);

        var turn = 0;
        while (firstPlayer.getWaterTank() > 0 && secondPlayer.getWaterTank() > 0) {
            System.out.println(firstPlayerName + "'s water: " + firstPlayer.getWaterTank());
            System.out.println(secondPlayerName + "'s water: " + secondPlayer.getWaterTank());
            if (turn == 0) {
                System.out.print(firstPlayerName + ", choose an action (1: Fill water gun, 2: Shoot): ");
                var action = scanner.nextInt();
                if (action == 1) {
                    firstPlayer.setWaterTank(100);

                } else if (action == 2) {
                    var shootFromFirstPlayer = firstPlayer.shoot();
                    secondPlayer.setWaterTank(secondPlayer.getWaterTank() - shootFromFirstPlayer);
                    System.out.printf("%s shot %s with %s water!", firstPlayerName, secondPlayerName, shootFromFirstPlayer);
                    System.out.println();

                }
                turn = 1;

            } else if (turn == 1) {
                System.out.print(secondPlayerName + ", choose an action (1: Fill water gun, 2: Shoot): ");
                var action2 = scanner.nextInt();
                if (action2 == 1) {
                    secondPlayer.setWaterTank(100);

                } else if (action2 == 2) {
                    var shootFromSecondPlayer = secondPlayer.shoot();
                    firstPlayer.setWaterTank(firstPlayer.getWaterTank() - shootFromSecondPlayer);
                    System.out.printf("%s shot %s with %s water!", secondPlayerName, firstPlayerName, shootFromSecondPlayer);
                    System.out.println();

                }
                turn = 0;

            }
        }

        System.out.println("\n=== GAME OVER ===");
        if (firstPlayer.getWaterTank() <= 0) {
            System.out.printf("%s is out of water. %s wins!", firstPlayerName, secondPlayerName);
        } else if (secondPlayer.getWaterTank() <= 0) {
            System.out.printf("%s is out of water. %s wins!", secondPlayer, firstPlayer);
        }
    }
}
