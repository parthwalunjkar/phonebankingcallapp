package com.aristotle.phonebankingcallapp;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by Admin on 4/7/2017.
 */

public class OpenURL extends AsyncTask {

    public static String token;

    private Context applicationContext;
    private Object savedInstanceState;

    @Override
    protected Object doInBackground(Object[] params) {
        URL url;
        //HttpURLConnection urlConnection = null;
        // HttpClient Client = new DefaultHttpClient();

        System.out.println("about to enter try");
        try {
            String url1 = "https://corporateapiprojectwar.mybluemix.net/corporate_banking/mybank/authenticate_client?client_id=rsmritimurty@gmail.com&password=3E6HU5RP";
            System.out.println("url defined");

            url = new URL(url1);

            System.out.println("url object");
            URLConnection urlConnection = url.openConnection();
            System.out.println("url open con ");
            InputStream in = urlConnection.getInputStream();
            System.out.println(in);

            if(in==null)
            {
                Context c = getApplicationContext();
                Toast.makeText(c,"No Access Token", Toast.LENGTH_SHORT).show();
                return null;
            }
            else
            {
                Scanner s = new Scanner(in).useDelimiter("\\A");
                  token = s.hasNext()?s.next():"";
                System.out.println(token);
                System.out.println("else");
                //super.onCreate(savedInstanceState);
            //    setContentView(R.layout.activity_my_profile);
                return true;
                //System.out.println("post return");
            }

        }
        catch(IOException e){
            e.printStackTrace();
            return null;
        }
    finally {
            System.out.println("end");
        }
      //  return null;
    }


    public Context getApplicationContext() {
        return applicationContext;
    }


}
