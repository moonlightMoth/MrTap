package com.example.user.clicker1;

import android.content.SharedPreferences;

public class Settings {
    private static Settings settings = new Settings();
    SharedPreferences sharedPreferences;

    private static int taps = 0;

    private static int record = 0;

    private static int coins = 0;

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
}