package edu.csumb.cst_338;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.csumb.cst_338.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        binding.CtoFConvertedValueTextView.setText(convertValue() + "");
    }

    public static Intent mainActivityIntentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        return intent;
    }
}