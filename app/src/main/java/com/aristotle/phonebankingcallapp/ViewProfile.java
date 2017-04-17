package com.aristotle.phonebankingcallapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView name = (TextView) findViewById(R.id.txtName);
        TextView docNum = (TextView) findViewById(R.id.txtDocNum);
        TextView docType = (TextView) findViewById(R.id.txtDocType);
        TextView kycType = (TextView) findViewById(R.id.txtKYCType);
        TextView expiry = (TextView) findViewById(R.id.txtExpiry);



        try {

            String status = openurl.execute().get().toString();
            System.out.println("All Done");
            if (status.equals("true")) {
                setTitle("Details for " + MainActivity.name);
                name.setText(OpenViewProfileURL.name);
                //System.out.println(name);
                docNum.setText(OpenViewProfileURL.docNum);
                docType.setText(OpenViewProfileURL.docType);
                kycType.setText(OpenViewProfileURL.kycType);
                expiry.setText(OpenViewProfileURL.expiryDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button btnCallToKyc = (Button) findViewById(R.id.btncalltokyc);
        btnCallToKyc.setOnClickListener((view) -> {
            Builder dialogBuilder=new Builder(ViewProfile.this);
            dialogBuilder.setCancelable(false);
            dialogBuilder.setTitle("Call Phone Banking");
            dialogBuilder.setMessage("Do you want to call for saving account enquiries?");
            dialogBuilder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText  (ViewProfile.this, "Calling", Toast.LENGTH_SHORT).show();
                    String phNo = "tel:+91-904-965-3059";
                   Intent phoneIntent = new Intent( Intent.ACTION_CALL );
                    phoneIntent.setData(Uri.parse(phNo));
                    if (ActivityCompat.checkSelfPermission( ViewProfile.this,
                            Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity( phoneIntent );


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
        });

    }
    }
