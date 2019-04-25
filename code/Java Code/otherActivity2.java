// Project name: HomeBody
// Description: An Android application where low-income individuals in the Ewing/Trenton area can locate gender inclusive housing nearby.
// Filename: otherActivity2.java
// Description: Content of Trenton houses
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
//otherActivity2 class, for Trenton houses
public class otherActivity2 extends AppCompatActivity implements View.OnClickListener {
    //initializing buttons and textview
    Button CornwallAveInfo, CornwallAveContact, RenfrewAveInfo, RenfrewAveContact;
    TextView textfile_2, textfile_3;

    @Override
    //below will show up on screen when user clicks on trenton houses
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //sets the content view as activity_other2.xml
        setContentView(R.layout.activity_other2);
        Toast.makeText(this, "Showing results for Trenton houses", Toast.LENGTH_SHORT).show();

        //finding texts and buttons on the page
        textfile_2 = findViewById(R.id.textfile_2);
        textfile_3 = findViewById(R.id.textfile_3);
        CornwallAveInfo = findViewById(R.id.button_more_info_CornwallAve);
        CornwallAveContact = findViewById(R.id.contact_CornwallAve);
        RenfrewAveInfo = findViewById(R.id.button_more_info_RenfrewAve);
        RenfrewAveContact = findViewById(R.id.contact_RenfrewAve);
        CornwallAveInfo.setOnClickListener(this);
        CornwallAveContact.setOnClickListener(this);
        RenfrewAveInfo.setOnClickListener(this);
        RenfrewAveContact.setOnClickListener(this);

        //int i = 0;
        String text = "";
        //reading from textfile and printing out to the screen
        try {
            InputStream is = getAssets().open("file2.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //size of the file
            int size = is.available();
/*
            for (i = 0; i <= 3; i++){
                String hello = br.readLine();

            }
            String hello = br.readLine();
            textfile1.setText(hello);
            */
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //sets the text to whatever was in the textfile
        textfile_2.setText(text);




        String text2 = "";
        //reading from another textfile
        try {
            InputStream is = getAssets().open("file3.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int size = is.available();
/*
            for (i = 0; i <= 3; i++){
                String hello = br.readLine();

            }
            String hello = br.readLine();
            textfile1.setText(hello);
            */
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text2 = new String(buffer);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        textfile_3.setText(text2);





    }
    @Override
    public void onClick(View h) {
        //switch cases that shows what would happen if users click on these buttons
        switch (h.getId())
        {
            //if user clicks on more info for CornwallAve
            case R.id.button_more_info_CornwallAve:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.trulia.com/p/nj/ewing/217-cornwall-ave-ewing-nj-08618--2007976121"));
                startActivity(intent3);
                break;
            //if user clicks on contact info for CornwallAve
            case R.id.contact_CornwallAve:
                Intent intent4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:6097379100"));
                startActivity(intent4);
                break;
            //if user clicks on more info RenfrewAve
            case R.id.button_more_info_RenfrewAve:
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.trulia.com/p/nj/ewing/221-renfrew-ave-ewing-nj-08618--2007976265"));
                startActivity(intent5);
                break;
            //if user clicks on contact info RenfrewAve
            case R.id.contact_RenfrewAve:
                Intent intent6 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:6093949600"));
                startActivity(intent6);
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
