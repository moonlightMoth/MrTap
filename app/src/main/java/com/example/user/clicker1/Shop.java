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
        final Button one=(Button)findViewById(R.id.appClickPerTapNormal);
        final Button two=(Button)findViewById(R.id.appClickPerTap1);
        final Button three=(Button)findViewById(R.id.appClickPerTap2);
        final TextView amount = (TextView) findViewById(R.id.textView);
        amount.setText(vars.getCoins());


        findViewById(R.id.appClickPerTapNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(1);
                vars.setAddHpPerTap(1);

                one.setBackground(getDrawable(R.drawable.activated_button));
                two.setBackground(getDrawable(R.drawable.button_shop));
                three.setBackground(getDrawable(R.drawable.button_shop));

            }
        });

        findViewById(R.id.appClickPerTap1).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(2);
                vars.setAddHpPerTap(1);

                one.setBackground(getDrawable(R.drawable.button_shop));
                two.setBackground(getDrawable(R.drawable.activated_button));
                three.setBackground(getDrawable(R.drawable.button_shop));
            }
        });

        findViewById(R.id.appClickPerTap2).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(3);
                vars.setAddHpPerTap(2);

                one.setBackground(getDrawable(R.drawable.button_shop));
                two.setBackground(getDrawable(R.drawable.button_shop));
                three.setBackground(getDrawable(R.drawable.activated_button));
            }
        });
    }
}
