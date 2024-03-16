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

public class SmsActivity extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_SEND_SMS = 1;
    Button btnSendSms;
    private EditText phoneNumber, textMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        btnSendSms = findViewById(R.id.btn_send_message);
        phoneNumber = findViewById(R.id.input_number_message);
        textMessage = findViewById(R.id.input_text_message);
        btnSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String number = phoneNumber.getText().toString().trim();
        String message = textMessage.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + Uri.encode(number)));
        intent.putExtra("sms_body", message);
        startActivity(intent);
    }
}
