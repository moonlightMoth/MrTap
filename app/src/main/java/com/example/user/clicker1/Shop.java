package com.example.user.clicker1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        findViewById(R.id.appClickPerTapNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(1);
            }
        });

        findViewById(R.id.appClickPerTap1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(2);
            }
        });

        findViewById(R.id.appClickPerTap2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vars vars = new Vars();
                vars.setNumOfClicksPerTap(3);
            }
        });
    }
}
