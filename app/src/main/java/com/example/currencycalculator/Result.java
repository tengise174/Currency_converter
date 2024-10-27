package com.example.currencycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;

public class Result extends AppCompatActivity {

    private HashMap<String, Integer> currencyFlags;
    private HashMap<String, Double> exchangeRates;

    private ImageView currencyFlag;
    private TextView foreignCurrencyLabel;
    private EditText foreignCurrencyInput;
    private TextView convertedAmount;
    private String selectedCurrency = "EUR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        initCurrencyData();

        selectedCurrency = getIntent().getStringExtra("currencyCode");
        int flagResource = getIntent().getIntExtra("flagResource", R.drawable.eur_flag);

        currencyFlag = findViewById(R.id.currencyFlag);
        foreignCurrencyLabel = findViewById(R.id.foreignCurrencyLabel);
        foreignCurrencyInput = findViewById(R.id.foreignCurrencyInput);
        Button convertButton = findViewById(R.id.convertButton);
        convertedAmount = findViewById(R.id.convertedAmount);

        updateCurrencyInfo(selectedCurrency, flagResource);

        setupSpinner();

        // Bodoh button darah uyd hiigdene
        convertButton.setOnClickListener(v -> {
            String inputAmountStr = foreignCurrencyInput.getText().toString();
            if (!inputAmountStr.isEmpty()) {
                double inputAmount = Double.parseDouble(inputAmountStr);
                double conversionRate = exchangeRates.get(selectedCurrency);
                double resultAmount = inputAmount * conversionRate;
                convertedAmount.setText(String.format("%,.2f", resultAmount));
            }
        });

    }

    private void initCurrencyData() {
        currencyFlags = new HashMap<>();
        currencyFlags.put("EUR", R.drawable.eur_flag);
        currencyFlags.put("GBP", R.drawable.gbp_flag);
        currencyFlags.put("RUB", R.drawable.rub_flag);
        currencyFlags.put("CNY", R.drawable.cny_flag);
        currencyFlags.put("JPY", R.drawable.jpy_flag);
        currencyFlags.put("KRW", R.drawable.krw_flag);
        currencyFlags.put("AUD", R.drawable.aud_flag);
        currencyFlags.put("CHF", R.drawable.chf_flag);
        currencyFlags.put("CAD", R.drawable.cad_flag);
        currencyFlags.put("SGD", R.drawable.sgd_flag);
        currencyFlags.put("SEK", R.drawable.sek_flag);
        currencyFlags.put("TRY", R.drawable.try_flag);
        currencyFlags.put("HKD", R.drawable.hkd_flag);

        exchangeRates = new HashMap<>();
        exchangeRates.put("EUR", 3639.0);
        exchangeRates.put("GBP", 4367.0);
        exchangeRates.put("RUB", 32.0);
        exchangeRates.put("CNY", 476.0);
        exchangeRates.put("JPY", 22.1);
        exchangeRates.put("KRW", 2.3);
        exchangeRates.put("AUD", 1994.0);
        exchangeRates.put("CHF", 3859.0);
        exchangeRates.put("CAD", 2422.0);
        exchangeRates.put("SGD", 2543.0);
        exchangeRates.put("SEK", 305.0);
        exchangeRates.put("TRY", 95.0);
        exchangeRates.put("HKD", 434.0);

    }

    private void setupSpinner() {
        Spinner currencySpinner = findViewById(R.id.currencySpinner);

        // Spinnert strings.xml dotor baigaa utga olgoj bn
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapter);

        int spinnerPosition = adapter.getPosition(selectedCurrency);
        currencySpinner.setSelection(spinnerPosition);

        // Spinner soligdoh uyd utga avc bn
        currencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // odoo baigaa currency utga avna
                selectedCurrency = parent.getItemAtPosition(position).toString();
                // avsan currency daa zoriulj delgets shineclen
                updateCurrencyInfo(selectedCurrency, currencyFlags.get(selectedCurrency));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

// Currency torold tohiruulj deed zurag, text tohiruulna
    private void updateCurrencyInfo(String currencyCode, int flagResource) {
        foreignCurrencyLabel.setText(currencyCode);
        currencyFlag.setImageResource(flagResource);
    }
}