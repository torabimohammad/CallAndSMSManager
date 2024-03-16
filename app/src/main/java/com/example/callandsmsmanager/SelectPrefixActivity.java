package com.example.callandsmsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SelectPrefixActivity extends AppCompatActivity {
    Button selectPrefix;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_prefix);

        radioGroup = findViewById(R.id.btn_radio_group);

        selectPrefix = findViewById(R.id.select_prefix);
        selectPrefix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextActivity(v);
            }
        });
    }

    // Define a function to direct the app to enter number and internation dial page using prefix number
    public void goToNextActivity(View view) {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String selectedValue = selectedRadioButton.getText().toString();
        // Create an intent to start the next activity and pass the selected value
        Intent intent = new Intent(this, InternationalCallActivity.class);
        intent.putExtra("selectedValue", selectedValue);
        startActivity(intent);
    }

}
