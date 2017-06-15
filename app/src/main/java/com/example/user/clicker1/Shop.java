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

        final TextView CPCcost=(TextView)findViewById(R.id.CPCcost);
        final TextView CPTcost=(TextView)findViewById(R.id.CPTcost);
        final TextView DMGcost=(TextView)findViewById(R.id.DMGcost);

        TextView scores=(TextView)findViewById(R.id.textView);
        Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
        scores.setText(Integer.toString(Settings.getCoins()));



        final Vars vars = new Vars();




        final TextView amount = (TextView) findViewById(R.id.textView);

        amount.setText(Integer.toString(vars.getCoins()));

        final TextView amountDMGPerTap = (TextView) findViewById(R.id.amountDMGPerTap);

        amountDMGPerTap.setText(Integer.toString(Settings.getNumOfClicksPerTap()));

        findViewById(R.id.TapDmgAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
                if (Settings.getCoinsToUpCPT()<=Settings.getCoins()) {
                    Settings.setNumOfClicksPerTap(Settings.getNumOfClicksPerTap() + 1);
                    amountDMGPerTap.setText(Integer.toString(Settings.getNumOfClicksPerTap()));

                    Settings.setCoins(Settings.getCoins() - Settings.getCoinsToUpCPT());
                    Settings.setCoinsToUpCPT(Settings.getCoinsToUpCPT()*2);
                    CPTcost.setText(Integer.toString(Settings.getCoinsToUpCPT()));
                    TextView scores = (TextView) findViewById(R.id.textView);
                    scores.setText(Integer.toString(Settings.getCoins()));
                }
            }
        });

        final TextView amountDMGPerBomb = (TextView) findViewById(R.id.amountDMGPerBomb);

        amountDMGPerBomb.setText(Integer.toString((int)Math.round(Settings.getBombReduceMult()*10)));

        findViewById(R.id.bombDMGRed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
                if (Settings.getCoinsToRedDPB()<=Settings.getCoins()) {
                    Settings.setBombReduceMult(Settings.getBombReduceMult() - 1);

                    amountDMGPerBomb.setText(Integer.toString((int) Math.round(Settings.getBombReduceMult() * 10)));
                    Settings.setCoins(Settings.getCoins() - Settings.getCoinsToRedDPB());

                    Settings.setCoinsToRedDPB(Settings.getCoinsToRedDPB()*2);
                    DMGcost.setText(Integer.toString(Settings.getCoinsToRedDPB()));
                    TextView scores = (TextView) findViewById(R.id.textView);
                    scores.setText(Integer.toString(Settings.getCoins()));
                }
            }
        });

        final TextView amountCPC = (TextView) findViewById(R.id.amountCPC);

        amountCPC.setText(Integer.toString(Settings.getCPC()));

        findViewById(R.id.CPCAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
                if(Settings.getCoinsToUpCPC()<=Settings.getCoins()) {
                    Settings.setCPC(Settings.getCPC() + 1);

                    Settings.setCoins(Settings.getCoins() - Settings.getCoinsToUpCPC());
                    Settings.setCoinsToUpCPC(Settings.getCoinsToUpCPC()*2);
                    amountCPC.setText(Integer.toString(Settings.getCPC()));

                    CPCcost.setText(Integer.toString(Settings.getCoinsToUpCPC()));
                    TextView scores = (TextView) findViewById(R.id.textView);
                    scores.setText(Integer.toString(Settings.getCoins()));
                }
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();

        final TextView CPCcost=(TextView)findViewById(R.id.CPCcost);
        final TextView CPTcost=(TextView)findViewById(R.id.CPTcost);
        final TextView DMGcost=(TextView)findViewById(R.id.DMGcost);
        DMGcost.setText(Integer.toString(Settings.getCoinsToRedDPB()));
        CPCcost.setText(Integer.toString(Settings.getCoinsToUpCPC()));
        CPTcost.setText(Integer.toString(Settings.getCoinsToUpCPT()));
        TextView scores=(TextView)findViewById(R.id.textView);
        Settings.setSharedPreferences(getSharedPreferences("appSetings", Context.MODE_PRIVATE));
        scores.setText(Integer.toString(Settings.getCoins()));


    }
}
