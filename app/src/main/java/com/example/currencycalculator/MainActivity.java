package com.example.currencycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Layout uud oloh
        LinearLayout eurLayout = findViewById(R.id.EUR);
        LinearLayout gbpLayout = findViewById(R.id.GBP);
        LinearLayout rubLayout = findViewById(R.id.RUB);
        LinearLayout cnyLayout = findViewById(R.id.CNY);
        LinearLayout jpyLayout = findViewById(R.id.JPY);
        LinearLayout krwLayout = findViewById(R.id.KRW);
        LinearLayout audLayout = findViewById(R.id.AUD);
        LinearLayout chfLayout = findViewById(R.id.CHF);
        LinearLayout cadLayout = findViewById(R.id.CAD);
        LinearLayout sgdLayout = findViewById(R.id.SGD);
        LinearLayout sekLayout = findViewById(R.id.SEK);
        LinearLayout tryLayout = findViewById(R.id.TRY);
        LinearLayout hkdLayout = findViewById(R.id.HKD);


        eurLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("EUR",  R.drawable.eur_flag);
            }
        });

        gbpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("GBP",  R.drawable.gbp_flag);
            }
        });

        rubLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("RUB",  R.drawable.rub_flag);
            }
        });

        cnyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("CNY",  R.drawable.cny_flag);
            }
        });

        jpyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("JPY",  R.drawable.jpy_flag);
            }
        });

        krwLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("KRW",  R.drawable.krw_flag);
            }
        });
        audLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("AUD",  R.drawable.aud_flag);
            }
        });

        chfLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("CHF",  R.drawable.chf_flag);
            }
        });

        cadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("CAD",  R.drawable.cad_flag);
            }
        });

        sgdLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("SGD",  R.drawable.sgd_flag);
            }
        });

        sekLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("SEK",  R.drawable.sek_flag);
            }
        });

        tryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("TRY",  R.drawable.try_flag);
            }
        });

        hkdLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openResultActivity("HKD",  R.drawable.hkd_flag);
            }
        });
    }

    private void openResultActivity(String currencyCode,  int flagResource) {
        Intent intent = new Intent(this, Result.class);
        intent.putExtra("currencyCode", currencyCode);
        intent.putExtra("flagResource", flagResource);
        startActivity(intent);
    }
}