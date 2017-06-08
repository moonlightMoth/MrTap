package com.example.user.yahotelcrasivononet;

public class Vars {
    private static int clicked=1;
    private static int coins=0;
    private static int maxTaps=0;
    private static int maxPops=0;
    private static int maxNuberOfTapToDestroy=4;
    private static int minNuberOfTapToDestroy=2;
    private static int numOfClicksPerTap=1;
    private static int dispalyHeight=0;
    private static int dispalyWidth=0;
    private static int numOfRandObjects=2;
    private static int pops=0;
    private static int taps=0;
    private static int reduceHpPerTick = 1;
    private static int addHpPerPop=0;
    private static int addHpPerTap=1;


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

    public void setMaxTaps(int maxTaps) {
        this.maxTaps = maxTaps;
    }

    public int getMaxTaps() {
        return maxTaps;
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

    public static void setNumOfRandObjects(int numOfRandObjects) {
        Vars.numOfRandObjects = numOfRandObjects;
    }

    public static int getNumOfRandObjects() {
        return numOfRandObjects;
    }

    public static int getPops() {
        return pops;
    }

    public static void setPops(int pops) {
        Vars.pops = pops;
    }

    public static int getTaps() {
        return taps;
    }

    public static void setTaps(int taps) {
        Vars.taps = taps;
    }

    public static void setAddHpPerPop(int addHpPerPop) {
        Vars.addHpPerPop = addHpPerPop;
    }

    public static int getAddHpPerPop() {
        return addHpPerPop;
    }

    public static void setReduceHpPerTick(int reduceHpPerTick) {
        Vars.reduceHpPerTick = reduceHpPerTick;
    }

    public static int getReduceHpPerTick() {
        return reduceHpPerTick;
    }

    public static void setAddHpPerTap(int addHpPerTap) {
        Vars.addHpPerTap = addHpPerTap;
    }

    public static int getAddHpPerTap() {
        return addHpPerTap;
    }
}
