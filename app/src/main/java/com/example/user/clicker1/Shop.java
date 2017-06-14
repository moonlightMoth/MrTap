package com.example.user.clicker1;

import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        final Vars vars = new Vars();


        final TextView amount = (TextView) findViewById(R.id.textView);

        amount.setText(Integer.toString(vars.getCoins()));



    }
}
