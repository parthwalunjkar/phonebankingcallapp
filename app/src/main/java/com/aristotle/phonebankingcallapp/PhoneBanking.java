package com.aristotle.phonebankingcallapp;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.String;

import static com.aristotle.phonebankingcallapp.R.id.loanacc;


public class PhoneBanking extends AppCompatActivity {


    String phNo ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_banking);

        TextView welcome=(TextView) findViewById(R.id.textView);
        welcome.setText("Welcome to phone banking");
        setTitle("Call Us "+MainActivity.name+".!!");

        System.out.println("PhoneBanking");
        TextView savingsacc = (TextView) findViewById(R.id.savingsacc);
        savingsacc.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(PhoneBanking.this);
                                              dialogBuilder.setCancelable(false);
                                              dialogBuilder.setTitle("Call Phone Banking");
                                              dialogBuilder.setMessage("Do you want to call for saving account enquiries?");
                                              dialogBuilder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                                                  @Override
                                                  public void onClick(DialogInterface dialog, int which) {
                                                      Toast.makeText(PhoneBanking.this, "Calling", Toast.LENGTH_SHORT).show();
                                                      phNo = "tel:+91-904-965-3059";
                                                      callNow(phNo);

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

                                      });


            TextView loanacc = (TextView) findViewById(R.id.loanacc);
        loanacc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //System.out.print("jhjfh");
                    AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(PhoneBanking.this);
                    dialogBuilder.setCancelable(false);
                    dialogBuilder.setTitle("Call Phone Banking");
                    dialogBuilder.setMessage("Do you want to call for loan enquiries?");
                    dialogBuilder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(PhoneBanking.this, "Calling", Toast.LENGTH_SHORT).show();
                            phNo = "tel:+91-705-773-0067";
                            callNow(phNo);

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
        });

        TextView cards = (TextView) findViewById(R.id.cards);
        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(PhoneBanking.this);
                dialogBuilder.setCancelable(false);
                dialogBuilder.setTitle("Call Phone Banking");
                dialogBuilder.setMessage("Do you want to enquire about cards?");
                dialogBuilder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(PhoneBanking.this, "Calling", Toast.LENGTH_SHORT).show();
                        phNo = "tel:+91-996-721-0890";
                        callNow(phNo);

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
        });




    }

    public void callNow(String phNo){
        Intent phoneIntent = new Intent( Intent.ACTION_CALL );
        phoneIntent.setData(Uri.parse(phNo));
        if (ActivityCompat.checkSelfPermission( PhoneBanking.this,
                Manifest.permission.CALL_PHONE ) != PackageManager.PERMISSION_GRANTED) {
            return;
        }


        startActivity( phoneIntent );


    }
}
