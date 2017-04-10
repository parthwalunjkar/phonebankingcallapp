package com.aristotle.phonebankingcallapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class ViewProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        OpenViewProfileURL openurl = new OpenViewProfileURL();
        try {
            openurl.execute();
            System.out.println("All Done");
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }


    }
