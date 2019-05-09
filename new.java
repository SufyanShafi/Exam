package com.example.smsapp;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.Permission;
import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
     private   EditText etname,etphone;
     private        Button btnsend;
     private final static int REQUEST_CODE_PERMISSION_SEND_SMS=123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname =findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        btnsend =findViewById(R.id.btnSend);
        btnsend.setEnabled(false);
        if(chekpermession(Manifest.permission.SEND_SMS)){
            btnsend.setEnabled(true);

        }else {
            ActivityCompat.requestPermissions(MainActivity.this,new String[] {
                    (Manifest.permission.SEND_SMS)},REQUEST_CODE_PERMISSION_SEND_SMS);



        }
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etname.getText().toString();
                String Pnum =etphone.getText().toString();
                SmsManager smsMan=SmsManager.getDefault();
                smsMan.sendTextMessage(Pnum ,null,msg,null,null);
                Toast.makeText(MainActivity.this,"Send Sms"+Pnum,Toast.LENGTH_LONG).show();


            }
        });
    }
     private boolean chekpermession(String permission) {
         int chekpermession = ContextCompat.checkSelfPermission(this,permission);
         return chekpermession == PackageManager.PERMISSION_GRANTED;
     }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION_SEND_SMS:
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                      btnsend.setEnabled(true);

                }
                break;
        }
        }
    }

