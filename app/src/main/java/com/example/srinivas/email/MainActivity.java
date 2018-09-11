package com.example.srinivas.email;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText to,subject,body,cc,bcc;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        to=findViewById(R.id.emailText);
        subject=findViewById(R.id.emailSubjects);
        body=findViewById(R.id.emailBody);
        cc=findViewById(R.id.cc);
        bcc=findViewById(R.id.bcc);
        button=findViewById(R.id.btn1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Toemail=to.getText().toString();
                String sub=subject.getText().toString();
                String bod=body.getText().toString();
                String carbon=cc.getText().toString();
                String bcarbon=bcc.getText().toString();
                String ccAddress[]=new String[100];
                for(int i=0;i<carbon.length();i++){

                   ccAddress=carbon.split(";");
                }
                String bccAddress[]=new String[100];
                for(int i=0;i<bcarbon.length();i++){

                    bccAddress=bcarbon.split(";");
                }


                Intent eIntent= new Intent(Intent.ACTION_SEND);
                eIntent.setData(Uri.parse("mailto:"));
                eIntent.setType("text/plain");
                eIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{Toemail});
                eIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                eIntent.putExtra(Intent.EXTRA_TEXT,bod);
                eIntent.putExtra(Intent.EXTRA_CC,ccAddress);
                eIntent.putExtra(Intent.EXTRA_BCC,bccAddress);
                startActivity(eIntent);
            }
        });
    }
}
