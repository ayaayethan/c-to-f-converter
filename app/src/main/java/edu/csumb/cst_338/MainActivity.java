package edu.csumb.cst_338;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import edu.csumb.cst_338.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private static final String CONVERTED_VALUE_EXTRA_KEY = "MainActivity_Received_Value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        double celsius = getIntent().getDoubleExtra(CONVERTED_VALUE_EXTRA_KEY, 0.0);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.CtoFConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayConvertedValue();
            }
        });

        binding.CtoFConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = FtoCActivity.ftoCIntentFactory(getApplicationContext(), convertValue());
                startActivity(intent);
                return false;
            }
        });

        binding.CtoFEnteredValueEditText.setText(celsius + "");
    }

    private double convertValue() {
        String valueFromDisplay = binding.CtoFEnteredValueEditText.getText().toString();
        double fahrenheit = 0.0;

        if (!valueFromDisplay.isEmpty()) {
            double celsius = Double.parseDouble(valueFromDisplay);
            fahrenheit = Utils.ctof(celsius);
        }

        return fahrenheit;
    }

    private void displayConvertedValue() {
        String fahrenheit = String.format(Locale.US, "%.2f", convertValue()) + "°F";
        binding.CtoFConvertedValueTextView.setText(fahrenheit);
    }

    public static Intent mainActivityIntentFactory(Context packageContext, double celsius) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        intent.putExtra(CONVERTED_VALUE_EXTRA_KEY, celsius);
        return intent;
    }
}