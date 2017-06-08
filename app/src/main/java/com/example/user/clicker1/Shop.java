package com.example.user.clicker1;

import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        final Button one=(Button)findViewById(R.id.appClickPerTapNormal);
        final Button two=(Button)findViewById(R.id.appClickPerTap1);
        final Button three=(Button)findViewById(R.id.appClickPerTap2);


        findViewById(R.id.appClickPerTapNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(1);

                one.setBackground(getDrawable(R.drawable.activated_button));
                two.setBackground(getDrawable(R.drawable.button_shop));
                three.setBackground(getDrawable(R.drawable.button_shop));

            }
        });

        findViewById(R.id.appClickPerTap1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(2);

                one.setBackground(getDrawable(R.drawable.button_shop));
                two.setBackground(getDrawable(R.drawable.activated_button));
                three.setBackground(getDrawable(R.drawable.button_shop));
            }
        });

        findViewById(R.id.appClickPerTap2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(3);

                one.setBackground(getDrawable(R.drawable.button_shop));
                two.setBackground(getDrawable(R.drawable.button_shop));
                three.setBackground(getDrawable(R.drawable.activated_button));
            }
        });
    }
}
