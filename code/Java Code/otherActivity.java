/* reivew */

// Project name: HomeBody
// Description: An Android application where low-income individuals in the Ewing/Trenton area can locate gender inclusive housing nearby.
// Filename: otherActivity.java
// Description: Content of Ewing Houses
// Last modified on: 4/24/2019

package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//otherActivity class, houses for Ewing
public class otherActivity extends AppCompatActivity implements View.OnClickListener {
    //Initializing the buttons and TextView
    Button BrandonAveInfo, BrandonAveContact, GreenLnInfo, GreenLnContact;
    TextView textfile1, textfile4;

    @Override
    //bellow will be showed on the screen the moment user clicks on Ewing button
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Toast.makeText(this, "Showing results for Ewing houses", Toast.LENGTH_SHORT).show();

        //finding the text on this page
        textfile1 = findViewById(R.id.textfile1);
        textfile4 = findViewById(R.id.textfile_4);
        //finding buttons on this page
        GreenLnInfo = findViewById(R.id.button_more_info_GreenLn);
        BrandonAveInfo = findViewById(R.id.button_more_info_brandonAve);
        BrandonAveContact = findViewById(R.id.contact_brandonAve);
        GreenLnContact = findViewById(R.id.contact_GreenLn);
        BrandonAveInfo.setOnClickListener(this);
        BrandonAveContact.setOnClickListener(this);
        GreenLnInfo.setOnClickListener(this);
        GreenLnContact.setOnClickListener(this);

        String text = "";
        //reading from the textfile and printing out to the screen
        try {
            //opens the textfile
            InputStream is = getAssets().open("file.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //size of the file
            int size = is.available();
/*
            for (int i = 0; i <= 3; i++){
                String hello = br.readLine();

            }
            String hello = br.readLine();
            textfile1.setText(hello);
            */
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
            //exception handling for IO below
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //sets the text to whatever was in the textfile
       textfile1.setText(text);




        String text4 = "";
        //reading from the textfile and printing out to the screen
        try {
            //opens the textfile
            InputStream is = getAssets().open("file4.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //size of the file
            int size = is.available();
/*
            for (int i = 0; i <= 3; i++){
                String hello = br.readLine();

            }
            String hello = br.readLine();
            textfile1.setText(hello);
            */
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text4 = new String(buffer);
            //exception handling for IO below
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //sets the text to whatever was in the textfile
        textfile4.setText(text4);











    }
    @Override
    public void onClick(View h) {
        //switch cases that shows what would happen if users click on these buttons
        switch (h.getId())
        {
            //if user clicks on more info button
            case R.id.button_more_info_brandonAve:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.trulia.com/p/nj/ewing/24-brandon-ave-ewing-nj-08618--1150281844"));
                startActivity(intent3);
                break;
            //if user clicks on contact landlord
            case R.id.contact_brandonAve:
                Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7327847233"));
                startActivity(intent4);
                break;
            case R.id.button_more_info_GreenLn:
                Intent intent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.trulia.com/p/nj/ewing/43-green-ln-ewing-nj-08638--2008006647"));
                startActivity(intent6);
                break;
            case R.id.contact_GreenLn:
                Intent intent7 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9083287713"));
                startActivity(intent7);
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
