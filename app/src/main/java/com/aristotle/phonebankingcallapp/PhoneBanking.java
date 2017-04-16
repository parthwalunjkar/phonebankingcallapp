package com.aristotle.phonebankingcallapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.String;

import static com.aristotle.phonebankingcallapp.R.id.loanacc;


public class PhoneBanking extends AppCompatActivity {
    String phNo ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_banking);
        System.out.println("PhoneBanking");
        TextView savingsacc = (TextView) findViewById(R.id.savingsacc);
        savingsacc.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              phNo = "tel:+91-904-965-3059";
                                              Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                                              phoneIntent.setData(Uri.parse(phNo));
                                              if (ActivityCompat.checkSelfPermission(PhoneBanking.this,
                                                      Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                                  return;
                                              }


                                              startActivity(phoneIntent);
                                          }
                                      });

            TextView loanacc = (TextView) findViewById(R.id.loanacc);
        loanacc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    phNo = "tel:+91-705-773-0067";
                    Intent phoneIntent = new Intent( Intent.ACTION_CALL );
                    phoneIntent.setData(Uri.parse(phNo));
                    if (ActivityCompat.checkSelfPermission( PhoneBanking.this,
                            Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }


                    startActivity( phoneIntent );
                }
        });




    }
}
