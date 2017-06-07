package com.example.user.yahotelcrasivononet;

import android.graphics.Paint;

import java.util.Random;

/**
 * Created by user on 6/6/17.
 */

public class varibles {
    class Gold
    {
        private int Amount;
        public Gold(int Amount)
        {
            this.Amount=Amount;
        }
        public int getAmount()
        {
            return Amount;
        }
    }
    class Highscore
    {
        private int Score;
        public Highscore (int Score)
        {
            this.Score=Score;
        }
        public int getScore()
        {
            return Score;
        }
    }
    static class RandomNumber
    {
        public RandomNumber(){}
        public int GenerateRadius()
        {
            int a;
            a=new Random().nextInt(41)+50;
            return a;
        }
        public int GenerateClicks()
        {
            int a;
            a=new Random().nextInt(5)+1;
            return a;
        }
    }
}
