package edu.csumb.cst_338;

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
                convertValueFromDisplay();
            }
        });

        binding.CtoFConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = FtoCActivity.intentFactory(getApplicationContext());
                startActivity(intent);
                return false;
            }
        });
    }

    private void convertValueFromDisplay() {
        String valueFromDisplay = binding.CtoFEnteredValueEditText.getText().toString();
        double fahrenheit = 0.0;

        if (!valueFromDisplay.isEmpty()) {
            double celsius = Double.parseDouble(valueFromDisplay);

            fahrenheit = Utils.ctof(celsius);
        }

        binding.CtoFConvertedValueTextView.setText(fahrenheit + "");

    }
}