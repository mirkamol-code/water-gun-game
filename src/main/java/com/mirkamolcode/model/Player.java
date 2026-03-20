package com.mirkamolcode.model;

import java.util.Random;

public class Player {
    private String name;
    private int waterTank;

    public Player(String name) {
        this.name = name;
        this.waterTank = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWaterTank() {
        return waterTank;
    }

    public void setWaterTank(int waterTank) {
        this.waterTank = waterTank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", waterTank=" + waterTank +
                '}';
    }
}
