package com.example.huzaifaabid_contextmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class message extends AppCompatActivity {

    private EditText etPhoneNumber, etMessage;
    private Button btnSendSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        etPhoneNumber = findViewById(R.id.phoneNumber);
        etMessage = findViewById(R.id.message);
        btnSendSMS = findViewById(R.id.btnSendSMS);

        Intent intent=getIntent();
        String number=intent.getExtras().getString("number");

        etPhoneNumber.setText(number);

        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = etPhoneNumber.getText().toString().trim();
                String message = etMessage.getText().toString().trim();
                sendSMS(phoneNumber, message);
            }
        });
    }

    void sendSMS(String number, String message) {
        System.out.println("!1111111111111111111111111");

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(number, null, message, pi,null);
        }else {
            Toast.makeText(getApplicationContext(), "send text", Toast.LENGTH_LONG).show();
        }
    }
}