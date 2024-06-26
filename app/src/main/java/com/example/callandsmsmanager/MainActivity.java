package com.example.callandsmsmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button smsActivity, callActivity,internationalCallActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smsActivity = findViewById(R.id.direct_to_sms);
        callActivity = findViewById(R.id.direct_to_call);
        internationalCallActivity = findViewById(R.id.direct_to_international_call);

        // Handle the call button to direct the app in Call activity layout
        callActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });

        // Handle the sms button to direct the app in SMS activity layout
        smsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(intent);
            }
        });

        // Handle the international call button to direct the app in international call activity layout
        internationalCallActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InternationalCallActivity.class);
                startActivity(intent);
            }
        });

    }
}