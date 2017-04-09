package com.aristotle.phonebankingcallapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        System.out.println("textview changer");

        TextView txtwelcome= (TextView) findViewById(R.id.textView);

        txtwelcome.setText("Welcome Aristotle");

        setTitle("Welcome Aristotle");

        /*Window w = getWindow();
        w.setTitle("Welcome Aristotle");*/
        //setTitle("Menu");
    }

    /*public void MyProfile(){


    }*/
}
