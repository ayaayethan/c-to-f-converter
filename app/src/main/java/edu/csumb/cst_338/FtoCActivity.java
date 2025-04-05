package edu.csumb.cst_338;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.csumb.cst_338.databinding.ActivityFtoCactivityBinding;
import edu.csumb.cst_338.databinding.ActivityMainBinding;

public class FtoCActivity extends AppCompatActivity {
    ActivityFtoCactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityFtoCactivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.FtoCConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertValueFromDisplay();
            }
        });

        binding.FtoCConvertButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = MainActivity.intentFactory(getApplicationContext());
                startActivity(intent);
                return false;
            }
        });
    }

    private void convertValueFromDisplay() {
        String valueFromDisplay = binding.FtoCEnteredValueEditText.getText().toString();
        double celsius = 0.0;

        if (!valueFromDisplay.isEmpty()) {
            double fahrenheit = Double.parseDouble(valueFromDisplay);

            celsius = Utils.ftoc(fahrenheit);
        }

        binding.FtoCConvertedValueTextView.setText(celsius + "");

    }
    public static Intent intentFactory(Context packageContext) {
        Intent intent = new Intent(packageContext, FtoCActivity.class);
        return intent;
    }
}