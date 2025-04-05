package edu.csumb.cst_338;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import edu.csumb.cst_338.databinding.ActivityFtoCactivityBinding;

public class FtoCActivity extends AppCompatActivity {
    ActivityFtoCactivityBinding binding;
    private static final String CONVERTED_VALUE_EXTRA_KEY = "FtoCActivity_Received_Value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFtoCactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        double fahrenheit = getIntent().getDoubleExtra(CONVERTED_VALUE_EXTRA_KEY, 0.0);

        binding.FtoCEnteredValueEditText.setText(fahrenheit + "");

        binding.FtoCConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayConvertedValue();
            }
        });

        binding.FtoCConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = MainActivity.mainActivityIntentFactory(getApplicationContext(), convertValue());
                startActivity(intent);
                return false;
            }
        });
    }

    private double convertValue() {
        String valueFromDisplay = binding.FtoCEnteredValueEditText.getText().toString();
        double celsius = 0.0;

        if (!valueFromDisplay.isEmpty()) {
            double fahrenheit = Double.parseDouble(valueFromDisplay);

            celsius = Utils.ftoc(fahrenheit);
        }

        return celsius;
    }

    private void displayConvertedValue() {
        String celsius = String.format(Locale.US, "%.2f", convertValue()) + "°C";
        binding.FtoCConvertedValueTextView.setText(celsius);
    }
    public static Intent ftoCIntentFactory(Context packageContext, double fahrenheitValue) {
        Intent intent = new Intent(packageContext, FtoCActivity.class);
        intent.putExtra(CONVERTED_VALUE_EXTRA_KEY, fahrenheitValue);
        return intent;
    }
}