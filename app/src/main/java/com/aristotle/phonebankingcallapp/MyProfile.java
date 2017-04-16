package com.aristotle.phonebankingcallapp;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.id.message;

public class MyProfile extends AppCompatActivity {

    @TargetApi(17)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        System.out.println("textview changer");

        TextView txtwelcome = (TextView) findViewById(R.id.textView);

        txtwelcome.setText("Welcome "+MainActivity.name);

        setTitle("Welcome "+MainActivity.name);


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

    public void onBackPressed()
    {
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(this);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setTitle("Logout");
        dialogBuilder.setMessage("Do you want to logout?");
        dialogBuilder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                OpenURL.token= null;
                MyProfile.super.onBackPressed();

                MainActivity.CustID.setText("");
                MainActivity.password.setText("");
                MainActivity.CustID.requestFocus();
                Toast.makeText(MyProfile.this, "Logged out", Toast.LENGTH_SHORT).show();
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert=dialogBuilder.create();
        alert.show();

    }



}
