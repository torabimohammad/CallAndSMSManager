package com.example.callandsmsmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChoosePrefixActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    RadioGroup radioGroup;
    Button prefixBtn, infoBtn;
    String selectedPrefix;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefix);


        radioGroup = findViewById(R.id.btn_radio_group);
        prefixBtn = findViewById(R.id.select_prefix);
        infoBtn = findViewById(R.id.show_info);
        prefixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1){
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    selectedPrefix = selectedRadioButton.getText().toString();
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("selectedPrefix", selectedPrefix);
                    setResult(RESULT_OK, resultIntent);
                    finish();
                } else {
                    return;
                }
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prefixList ="https://en.wikipedia.org/wiki/List_of_international_call_prefixes";

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(prefixList));
                startActivity(intent);
            }
        });
    }
}
