package com.aristotle.phonebankingcallapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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
        TextView name= (TextView) findViewById(R.id.txtName);
        TextView docNum= (TextView) findViewById(R.id.txtDocNum);
        TextView docType= (TextView)findViewById(R.id.txtDocType);
        TextView kycType= (TextView)findViewById(R.id.txtKYCType);
        TextView expiry= (TextView)findViewById(R.id.txtExpiry);

        try {

            String status=openurl.execute().get().toString();
            System.out.println("All Done");
            if (status.equals("true"))
            {
                name.setText(OpenViewProfileURL.name);
                //System.out.println(name);
                docNum.setText(OpenViewProfileURL.docNum);
                docType.setText(OpenViewProfileURL.docType);
                kycType.setText(OpenViewProfileURL.kycType);
                expiry.setText(OpenViewProfileURL.expiryDate);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }


    }
