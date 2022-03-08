package com.au.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText number,message;
    Button send;
    SmsManager s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number=findViewById(R.id.no);
        message=findViewById(R.id.msg);
        send=findViewById(R.id.btn);

        s=SmsManager.getDefault();

        send.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                String n=number.getText().toString();
                String m=message.getText().toString();
                if (checkCallingOrSelfPermission(Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
                {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS},0);
                }
                s.sendTextMessage(n,null,m,null,null);
            }
        });
    }
}