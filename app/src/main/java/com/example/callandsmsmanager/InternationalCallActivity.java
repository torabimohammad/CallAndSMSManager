package com.example.callandsmsmanager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InternationalCallActivity extends AppCompatActivity {
    private static final int REQUEST_CALL_PHONE = 1;
    private static final int PREFIX_REQUEST_CODE = 1;
    private static final int NUMBER_REQUEST_CODE = 2;

    Button composeInterCall, directInterCall, openPrefixBtn, openInternationalNumBtn;
    EditText prefix, phoneNumber;
    String selectedPrefix;
    String selectedInternationalNumber;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == PREFIX_REQUEST_CODE) {
            selectedPrefix = data.getStringExtra("selectedPrefix");
            prefix.setText(selectedPrefix);
        } else if (requestCode == NUMBER_REQUEST_CODE) {
                selectedInternationalNumber = data.getStringExtra("selectedNumber");
                phoneNumber.setText(selectedInternationalNumber);
            }
        }

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaional_call);

        // Retrieve the value passed from the previous activity
        String selectedValue = getIntent().getStringExtra("selectedValue");
        phoneNumber = findViewById(R.id.input_inter_phone_number);
        prefix = findViewById(R.id.input_prefix_number);
        prefix.setText(selectedValue);
        composeInterCall = findViewById(R.id.btn_compose_inter_call);
        directInterCall = findViewById(R.id.btn_make_inter_call);
        openPrefixBtn = findViewById(R.id.choose_prefix);
        openInternationalNumBtn = findViewById(R.id.choose_international_number);

        composeInterCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeCall();
            }
        });
        directInterCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                directCall();
            }
        });
        openPrefixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternationalCallActivity.this, ChoosePrefixActivity.class);
                startActivityForResult(intent, PREFIX_REQUEST_CODE);
            }
        });

        openInternationalNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InternationalCallActivity.this, ChooseInternationalNumberActivity.class);
                startActivityForResult(intent, NUMBER_REQUEST_CODE);
            }
        });
    }

    private void directCall() {
        String prefixValue = prefix.getText().toString();
        String phoneNumberValue = phoneNumber.getText().toString();

        if (phoneNumber != null) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + prefixValue + phoneNumberValue));
            try {
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    startActivity(callIntent);
                }
            } catch (SecurityException e) {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
            }
        }
    }

    private void composeCall() {
        String prefixValue = prefix.getText().toString();
        String phoneNumberValue = phoneNumber.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + prefixValue + phoneNumberValue));
        startActivity(intent);
    }
}