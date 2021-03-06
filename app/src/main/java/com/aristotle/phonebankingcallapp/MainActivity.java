package com.aristotle.phonebankingcallapp;



import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
import org.json.JSONArray;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

import static android.R.attr.duration;
import static android.R.id.message;
import static com.aristotle.phonebankingcallapp.R.id.text;


public class MainActivity extends AppCompatActivity {


    public static EditText CustID, password;
    private Button sbmtButton;
    String status = null;
    public static String name, CustomerID;
    @TargetApi(17)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustID = (EditText) findViewById(R.id.txtCustID);
        password = (EditText) findViewById(R.id.txtPwd);

       // System.out.println(CustomerID);
        sbmtButton = (Button) findViewById(R.id.btnSubmit);

        sbmtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CustomerID=CustID.getText().toString();
                    login(CustomerID, password);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


    }

    public String login(String custID, EditText password) throws JSONException, ExecutionException, InterruptedException {

       // System.out.println("hello"+custID);

        if ((custID.equals("33336562")||custID.equals("33336561")) && password.getText().toString().equals("alchemist")) {
            try {
                OpenURL openurl = new OpenURL();

                if(custID.equals("33336562")){
                    name="Parth";
                }
                else if(custID.equals("33336561"))
                {
                    name="Smriti";
                }


                String status = openurl.execute().get().toString();
                // status = String.valueOf(openurl.doInBackground());
                // System.out.println(openurl.execute());
                System.out.println(OpenURL.token + " : status");
                // JSONObject jsonobj = new JSONObject(OpenURL.token);
                //JSONArray jsonArray = new JSONArray(OpenURL.token);
                //List<String> list = new ArrayList<String>();


               // for (int i = 0; i < jsonArray.length(); i++) {
                 //   list.add(jsonArray.getString(i));
                    // String value = jsonobj.getString("token");
                    // System.out.println(value + "json");
                    if (status.equals("true")) {
                        String extra = "com.aristotle.phonebankingcallapp.MyProfile";
                        Intent intent = new Intent(this, MyProfile.class);

                        intent.putExtra(extra, message);
                        startActivity(intent);
//                          setContentView(R.layout.activity_my_profile);

                    }

            }
            catch(Exception e){
                e.printStackTrace();
            }

            return null;
        }
        else if(custID.equals("")) {
        Toast.makeText(this, "Userid cannot be blank",Toast.LENGTH_SHORT).show();
        }
        else if(password.getText().toString().equals("")){
            Toast.makeText(this, "Password cannot be blank",Toast.LENGTH_SHORT).show();
        }

        else {

            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();

        }

        return null;
    }



}



