package com.aristotle.phonebankingcallapp;



import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import static android.R.attr.duration;
import static com.aristotle.phonebankingcallapp.R.id.text;


public class MainActivity extends AppCompatActivity {



    private EditText userEmailID, password;
    private Button sbmtButton;
    String status=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmailID= (EditText) findViewById(R.id.txtEmailID);
        password= (EditText) findViewById(R.id.txtPwd);

        sbmtButton= (Button) findViewById(R.id.btnSubmit);

        sbmtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(userEmailID, password);
            }
        });





    }

        public  String login(EditText emailID, EditText password){

              if(emailID.getText().toString().equals("rsmritimurty@gmail.com") && password.getText().toString().equals("alchemist")) {
                  try {
                      OpenURL openurl = new OpenURL();
                      String status = openurl.execute().get().toString();

                      // status = String.valueOf(openurl.doInBackground());
                      // System.out.println(openurl.execute());
                      System.out.println(OpenURL.token + " : status");
                      if (status.equals("true")) {
                          setContentView(R.layout.activity_my_profile);
                      }

                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }else{

                  Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();

                  }

            return null;
                }


        }



