package com.mirkamolcode.service;

import com.mirkamolcode.model.Player;

import java.util.Random;

public class GameService {
    private static final Random random = new Random();
    private static int turn = 0;

    public boolean isFirstPlayerTurn(){
        boolean isFirstTurn = (turn == 0);
        turn = (turn == 0) ? 1 : 0;
        return isFirstTurn;
    }

    public void doAction(Player shooter, Player receiver, int action){
        if (action == 1) {
           fillWaterGun(shooter);
        } else if (action == 2) {
            shoot(shooter, receiver);
        }
    }

    private int shoot() {
        return random.nextInt(21);
    }

    private void shoot(Player shooter, Player receiver) {
        var shootFromFirstPlayer = shoot();
        receiver.setWaterTank(receiver.getWaterTank() - shootFromFirstPlayer);
        System.out.printf("%s shot %s with %s water!", shooter.getName(), receiver.getName(), shootFromFirstPlayer);
        System.out.println();
    }

    private void fillWaterGun(Player player){
        player.setWaterTank(100);
    }


    public boolean isGameOver(Player firstPlayer, Player secondPlayer){
        return firstPlayer.getWaterTank() > 0 && secondPlayer.getWaterTank() > 0;
    }
    public void printWinner(Player firstPlayer, Player secondPlayer){
        System.out.println("\n=== GAME OVER ===");
        if (firstPlayer.getWaterTank() <= 0) {
            System.out.printf("%s is out of water. %s wins!", firstPlayer.getName(), secondPlayer.getName());
        } else if (secondPlayer.getWaterTank() <= 0) {
            System.out.printf("%s is out of water. %s wins!", secondPlayer.getName(), firstPlayer.getName());
        }
    }
}
