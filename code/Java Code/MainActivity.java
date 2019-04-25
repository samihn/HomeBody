// Project name: HomeBody
// Description: An Android application where low-income individuals in the Ewing/Trenton area can locate gender inclusive housing nearby.
// Filename: MainActivity.java
// Description: Main content (first page) of the app
// Last modified on: 4/24/2019

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

//MainActivity class
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //initializing textView
    TextView textView;
    //Initializing the buttons on the page
    Button Ewing, Trenton, BrandonAveInfo;
    @Override
    //bellow will be showed on the screen the moment app is opened
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the view as activity_main.xml
        setContentView(R.layout.activity_main);

        //finding buttons on the activity_main view
        textView =  findViewById(R.id.textView2);
        Ewing =  findViewById(R.id.Ewing_button);
        Trenton = findViewById(R.id.Trenton_button);
        BrandonAveInfo = findViewById(R.id.button_more_info_brandonAve);
        //setOnclickListener, system would execute code in onClick(View) at the bottom
        Ewing.setOnClickListener(this);
        Trenton.setOnClickListener(this);

    }


    @Override
    //below is for the action bar
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    //switch cases that shows what would happen if users click on these buttons
    public void onClick(View v) {
        switch (v.getId())
        {
            //if user clicks on Ewing button
            case R.id.Ewing_button:
                Intent intent = new Intent(MainActivity.this, otherActivity.class);
                startActivity(intent);
                break;
            //if user clicks on Trenton button
            case R.id.Trenton_button:
                Intent intent1 = new Intent(MainActivity.this, otherActivity2.class);
                startActivity(intent1);
                break;
        }
    }
}
