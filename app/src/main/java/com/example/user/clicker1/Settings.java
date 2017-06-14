package com.example.user.clicker1;

import android.content.SharedPreferences;

public class Settings {
    private static Settings settings = new Settings();
    SharedPreferences sharedPreferences;

    private static int taps = 0;

    private static int record = 0;

    private static int coins = 0;

    private static int  coinsToUpCPT=1;
    private static int  coinsToRedDPB=5;
    private static int  coinsToUpCPC=10;

    public Settings() {

    }

    public static void setSharedPreferences(SharedPreferences preferences) {
        settings.sharedPreferences = preferences;
    }

    public static int getRecord() {
        return settings.sharedPreferences.getInt("record", record);
    }

    public static void setRecord(int newRecord) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("record", newRecord);
        editor.apply();
    }

    public static int getTaps() {
        return settings.sharedPreferences.getInt("taps", taps);
    }

    public static void setTaps(int newTaps) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("taps", newTaps);
        editor.apply();
    }

    public static int getCoins() {
        return settings.sharedPreferences.getInt("coins", coins);
    }

    public static void setCoins(int newCoins) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("coins", newCoins);
        editor.apply();
    }

    public static void setCoinsToRedDPB(int coinsToRedDPB) {
        Settings.coinsToRedDPB = coinsToRedDPB;
    }

    public static int getCoinsToRedDPB() {
        return coinsToRedDPB;
    }

    public static void setCoinsToUpCPC(int coinsToUpCPC) {
        Settings.coinsToUpCPC = coinsToUpCPC;
    }

    public static int getCoinsToUpCPC() {
        return coinsToUpCPC;
    }

    public static void setCoinsToUpCPT(int coinsToUpCPT) {
        Settings.coinsToUpCPT = coinsToUpCPT;
    }

    public static int getCoinsToUpCPT() {
        return coinsToUpCPT;
    }
}