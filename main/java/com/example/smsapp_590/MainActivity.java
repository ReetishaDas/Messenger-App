package com.example.smsapp_590;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtMessage;
    String phoneNo;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn =  findViewById(R.id.button);
        txtphoneNo = findViewById(R.id.editTextNumber);
        txtMessage = findViewById(R.id.editTextTextMultiLine);
        sendBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    phoneNo=txtphoneNo.getText().toString();
                    message =txtMessage.getText().toString();
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(phoneNo,null,message,null,null);
                    Toast.makeText(MainActivity.this, "SMS Sent Successfully to: "+phoneNo, Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "SMS Failed to Send, Please try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}