package com.aristotle.phonebankingcallapp;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by parth on 11/04/2017.
 */

public class OpenViewProfileURL extends AsyncTask {


    public static String name,docNum,docType, kycType,expiryDate ;

    @Override
    protected Object doInBackground(Object[] params) {

        System.out.println("Inside ViewProfile");
        String url2 = "https://kycdetails.mybluemix.net/banking/icicibank/getKYC?client_id=rsmritimurty@gmail.com&cust_id="+MainActivity.CustomerID+"&token="+OpenURL.token;
        System.out.println("url defined");


        JSONArray jProfArray;
        JSONObject jtoken;


        try{
            URL url = new URL(url2);
            System.out.println("url object");
            URLConnection urlConnection = url.openConnection();
            System.out.println("url open con ");
            InputStream in = urlConnection.getInputStream();
            System.out.println("started inputstream_viewProfile");

            Scanner s = new Scanner(in).useDelimiter("\\A");
            String response = s.hasNext() ? s.next() : "";

            in.close();
            jProfArray = (JSONArray) new JSONTokener(response).nextValue();

            String strtoken=  jProfArray.getString(0);
            System.out.println(strtoken);
            if (strtoken.contains("200")){

                jtoken = (JSONObject) new JSONTokener(jProfArray.getString(1)).nextValue();

                name= jtoken.getString("Name on Document");
                docNum= jtoken.getString("Document Number");
                docType= jtoken.getString("Document Type");
                kycType= jtoken.getString("KYC Type");
                expiryDate= jtoken.getString("Expirydate on document");

                System.out.println(name+" "+docNum+" "+docType+" "+kycType+" "+expiryDate);
                return true;
            }
            else{
                System.out.println("Details are not available. Please check again.!");
                return false;
            }




        }
        catch(Exception e)
        {
            e.printStackTrace();

            return false;
        }

//        return null;
    }
}
