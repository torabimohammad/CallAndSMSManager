package com.example.callandsmsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChooseInternationalNumberActivity extends AppCompatActivity {
    RadioGroup internationalNumberRg;
    Button interNumChooseBtn;
    String selectedNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interntional_number);


        internationalNumberRg = findViewById(R.id.btn_international_number);
        interNumChooseBtn = findViewById(R.id.select_number);
        interNumChooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = internationalNumberRg.getCheckedRadioButtonId();
                if (selectedId != -1){
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    selectedNumber = selectedRadioButton.getText().toString();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("selectedNumber", selectedNumber);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    return;
                }
            }
        });
    }
}