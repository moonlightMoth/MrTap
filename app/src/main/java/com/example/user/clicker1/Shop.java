package com.example.user.clicker1;

import android.content.Context;
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



        TextView scores=(TextView)findViewById(R.id.textView);
        Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
        scores.setText(Integer.toString(Settings.getCoins()));



        final Vars vars = new Vars();


        final TextView amount = (TextView) findViewById(R.id.textView);

        amount.setText(Integer.toString(vars.getCoins()));

        final TextView amountDMGPerTap = (TextView) findViewById(R.id.amountDMGPerTap);

        amountDMGPerTap.setText(Integer.toString(vars.getNumOfClicksPerTap()));

        findViewById(R.id.TapDmgAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Settings.getCoinsToUpCPT()<=Settings.getCoins()) {
                    vars.setNumOfClicksPerTap(vars.getNumOfClicksPerTap() + 1);
                    amountDMGPerTap.setText(Integer.toString(vars.getNumOfClicksPerTap()));
                    Settings.setCoins(Settings.getCoins() - Settings.getCoinsToUpCPT());
                    Settings.setCoinsToUpCPT(Settings.getCoinsToUpCPT()*2);
                    TextView scores = (TextView) findViewById(R.id.textView);
                    Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
                    scores.setText(Integer.toString(Settings.getCoins()));
                }
            }
        });

        final TextView amountDMGPerBomb = (TextView) findViewById(R.id.amountDMGPerBomb);

        amountDMGPerBomb.setText(Integer.toString((int)Math.round(vars.getBombReduceMult()*10)));

        findViewById(R.id.bombDMGRed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Settings.getCoinsToRedDPB()<=Settings.getCoins()) {
                    vars.setBombReduceMult(vars.getBombReduceMult() + 0.1);
                    amountDMGPerBomb.setText(Integer.toString((int) Math.round(vars.getBombReduceMult() * 10)));
                    Settings.setCoins(Settings.getCoins() - Settings.getCoinsToRedDPB());
                    Settings.setCoinsToRedDPB(Settings.getCoinsToRedDPB()*2);
                    TextView scores = (TextView) findViewById(R.id.textView);
                    Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
                    scores.setText(Integer.toString(Settings.getCoins()));
                }
            }
        });

        final TextView amountCPC = (TextView) findViewById(R.id.amountCPC);

        amountCPC.setText(Integer.toString(vars.getCPC()));

        findViewById(R.id.CPCAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Settings.getCoinsToUpCPC()<=Settings.getCoins()) {
                    vars.setCPC(vars.getCPC() + 1);
                    amountCPC.setText(Integer.toString(vars.getCPC()));
                    Settings.setCoins(Settings.getCoins() - Settings.getCoinsToUpCPC());
                    Settings.setCoinsToUpCPC(Settings.getCoinsToUpCPC()*2);
                    TextView scores = (TextView) findViewById(R.id.textView);
                    Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
                    scores.setText(Integer.toString(Settings.getCoins()));
                }
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();


        TextView scores=(TextView)findViewById(R.id.textView);
        Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
        scores.setText(Integer.toString(Settings.getCoins()));


    }
}
