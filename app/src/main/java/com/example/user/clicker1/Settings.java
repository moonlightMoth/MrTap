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

    private static int healPerHealCircle=150;
    private static int bombReduceMult =1;
    private static int CPC=1;
    private static int numOfClicksPerTap = 1;
    public Settings() {

    }

    public static void setSharedPreferences(SharedPreferences preferences) {
        settings.sharedPreferences = preferences;
    }


    public static int getCoinsToUpCPT() {
        return settings.sharedPreferences.getInt("coinsToUpCPT", coinsToUpCPT);
    }

    public static void setCoinsToUpCPT(int newB) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("coinsToUpCPT", newB);
        editor.apply();
    }


    public static int getCoinsToRedDPB() {
        return settings.sharedPreferences.getInt("coinsToRedDPB", coinsToRedDPB);
    }

    public static void setCoinsToRedDPB(int newB) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("coinsToRedDPB", newB);
        editor.apply();
    }


    public static int getCoinsToUpCPC() {
        return settings.sharedPreferences.getInt("coinsToUpCPC", coinsToUpCPC);
    }

    public static void setCoinsToUpCPC(int newB) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("coinsToUpCPC", newB);
        editor.apply();
    }





    public static int getNumOfClicksPerTap() {
        return settings.sharedPreferences.getInt("numOfClicksPerTap", numOfClicksPerTap);
    }

    public static void setNumOfClicksPerTap(int newB) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("numOfClicksPerTap", newB);
        editor.apply();
    }


    public static int getHealPerHealCircle() {
        return settings.sharedPreferences.getInt("healPerHealCircle", healPerHealCircle);
    }

    public static void setHealPerHealCircle(int newB) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("healPerHealCircle", newB);
        editor.apply();
    }




    public static int getCPC() {
        return settings.sharedPreferences.getInt("CPC", CPC
        );
    }

    public static void setCPC(int newC) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("CPC", newC);
        editor.apply();
    }



    public static int getBombReduceMult() {
        return settings.sharedPreferences.getInt("bombReduceMult", bombReduceMult);
    }

    public static void setBombReduceMult(int newA) {
        SharedPreferences.Editor editor = settings.sharedPreferences.edit();
        editor.putInt("bombReduceMult", newA);
        editor.apply();
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


}