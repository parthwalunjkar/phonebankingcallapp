package com.aristotle.phonebankingcallapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.id.message;

public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        System.out.println("textview changer");

        TextView txtwelcome = (TextView) findViewById(R.id.textView);

        txtwelcome.setText("Welcome "+MainActivity.CustID.getText());

        setTitle("Welcome "+MainActivity.CustID.getText());


        Button btnPhoneBanking= (Button) findViewById(R.id.btnPhoneBanking);
        Button btnInvestments= (Button) findViewById(R.id.btnInvestments);
        Button btnMyProfile= (Button) findViewById(R.id.btnUpdateProfile);
        Button btnRetailBanking= (Button) findViewById(R.id.btnretailBanking);

        btnPhoneBanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String extra= "com.aristotle.phonebankingcallapp.PhoneBanking";
                Intent intent= new Intent(v.getContext(), PhoneBanking.class);
                intent.putExtra(extra, message);
                startActivity(intent);
            }
        });

        btnMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String extra= "com.aristotle.phonebankingcallapp.ViewProfile";
                Intent intent= new Intent(v.getContext(), ViewProfile.class);
                intent.putExtra(extra, message);
                startActivity(intent);
            }
        });

    }

}
