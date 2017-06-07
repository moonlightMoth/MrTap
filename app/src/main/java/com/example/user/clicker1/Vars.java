package com.example.user.clicker1;


public class Vars {
    private static int clicked=1;
    private static int coins=0;
    private static int maxTap=0;
    private static int maxPops=0;
    private static int maxNuberOfTapToDestroy=4;
    private static int minNuberOfTapToDestroy=2;
    private static int numOfClicksPerTap=1;
    private static int dispalyHeight=0;
    private static int dispalyWidth=0;

    public void setClicked(int clicked) {
        this.clicked = clicked;
    }

    public int getClicked() {
        return clicked;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public void setMaxNuberOfTapToDestroy(int maxNuberOfTapToDestroy) {
        this.maxNuberOfTapToDestroy = maxNuberOfTapToDestroy;
    }

    public int getMaxNuberOfTapToDestroy() {
        return maxNuberOfTapToDestroy;
    }

    public void setMaxPops(int maxPops) {
        this.maxPops = maxPops;
    }

    public int getMaxPops() {
        return maxPops;
    }

    public void setMaxTap(int maxTap) {
        this.maxTap = maxTap;
    }

    public int getMaxTap() {
        return maxTap;
    }

    public void setMinNuberOfTapToDestroy(int minNuberOfTapToDestroy) {
        this.minNuberOfTapToDestroy = minNuberOfTapToDestroy;
    }

    public int getMinNuberOfTapToDestroy() {
        return minNuberOfTapToDestroy;
    }

    public static void setNumOfClicksPerTap(int numOfClicksPerTap) {
        Vars.numOfClicksPerTap = numOfClicksPerTap;
    }

    public static int getNumOfClicksPerTap() {
        return numOfClicksPerTap;
    }

    public static void setDispalyHeight(int dispalyHeight) {
        Vars.dispalyHeight = dispalyHeight;
    }

    public static int getDispalyHeight() {
        return dispalyHeight;
    }

    public static void setDispalyWidth(int dispalyWidth) {
        Vars.dispalyWidth = dispalyWidth;
    }

    public static int getDispalyWidth() {
        return dispalyWidth;
    }
}
