package com.example.atifnaseem.sms_apr13;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnSend, btnRead;
    ReadSMSFragment frgReadSMS;
    SendSMSFragment frgSendSMS;

    private final int REQUEST_PERMISSION_SEND_SMS = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnRead = findViewById(R.id.btnReadSMS);
        btnSend = findViewById(R.id.btnSendSMS);

        frgReadSMS = new ReadSMSFragment();
        frgSendSMS = new SendSMSFragment();

        setFragment(frgSendSMS);

        if(!checkPermission(Manifest.permission.SEND_SMS)){
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.SEND_SMS},
                    REQUEST_PERMISSION_SEND_SMS);
        }


        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(frgReadSMS);
            }
        });


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(frgSendSMS);
            }
        });
    }



    private void setFragment(Fragment frg){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, frg);
        ft.commit();
    }



    public boolean checkPermission(String permission){
        int permissionCode =
                ContextCompat.checkSelfPermission(this, permission);
        return permissionCode == PackageManager.PERMISSION_GRANTED;
    }


}
