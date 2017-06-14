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

        final TextView amountDMGPerTap = (TextView) findViewById(R.id.amountDMGPerTap);

        amountDMGPerTap.setText(Integer.toString(vars.getNumOfClicksPerTap()));

        findViewById(R.id.TapDmgAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vars.setNumOfClicksPerTap(vars.getNumOfClicksPerTap()+1);
                amountDMGPerTap.setText(Integer.toString(vars.getNumOfClicksPerTap()));
            }
        });

        final TextView amountDMGPerBomb = (TextView) findViewById(R.id.amountDMGPerBomb);

        amountDMGPerBomb.setText(Integer.toString((int)Math.round(vars.getBombReduceMult()*10)));

        findViewById(R.id.bombDMGRed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vars.setBombReduceMult(vars.getBombReduceMult()+0.1);
                amountDMGPerBomb.setText(Integer.toString((int)Math.round(vars.getBombReduceMult()*10)));
            }
        });
    }
}
