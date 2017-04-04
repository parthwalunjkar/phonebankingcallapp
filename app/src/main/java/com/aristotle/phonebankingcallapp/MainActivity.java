package com.aristotle.phonebankingcallapp;



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


public class MainActivity extends AppCompatActivity {

    private EditText userEmailID, password;
    private Button sbmtButton;
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
        });}

        public static String login(EditText emailID, EditText password){

 //       URL url;
        HttpURLConnection urlConnection = null;
            HttpClient Client = new DefaultHttpClient();
        try {
            String url = "https://corporateapiprojectwar.mybluemix.net/corporate_banking/mybank/authenticate_client?client_id=rsmritimurty@gmail.com&password=3E6HU5RP";

        String setServerString;

            HttpGet httpget=new HttpGet(url);
            ResponseHandler<String>responseHandler= new BasicResponseHandler();
            setServerString=Client.execute(httpget,responseHandler);

            System.out.println(setServerString);

        }
            catch(IOException e){
                e.printStackTrace();
        }

    return "Parth";

    }


    }
