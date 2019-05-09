package com.example.atifnaseem.sms_apr13;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendSMSFragment extends Fragment {

    Button btnSendSMS;
    EditText etPhoneNum, etMsg;


    public SendSMSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View myView;
        myView = inflater.inflate(R.layout.fragment_send_sm, container, false);

        btnSendSMS = myView.findViewById(R.id.btnSend);
        etPhoneNum = myView.findViewById(R.id.etPhoneNum);
        etMsg = myView.findViewById(R.id.etMsg);

        btnSendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = etPhoneNum.getText().toString().trim();
                String sms = etMsg.getText().toString().trim();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null,
                        sms, null, null);
                Toast.makeText(myView.getContext(),
                        "SMS send to : " + phoneNumber,
                        Toast.LENGTH_LONG).show();
            }
        });

        return myView;
    }

}
