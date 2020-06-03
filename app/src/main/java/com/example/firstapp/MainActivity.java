package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To reference a button? create an object of the reference type
        Button addBtn = (Button) findViewById(R.id.addBtn); //R is your resource object

        //Next we are going to assign an on-click listener
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //This casts into a EditText object
                EditText firstNumEditText = (EditText) findViewById(R.id.input1);
                EditText secondNumEditText = (EditText) findViewById(R.id.input2);

                TextView resultTextView = (TextView) findViewById(R.id.resultNum);

                //This changes the string to an integer
                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());

                int result = num1 + num2;

                resultTextView.setText(result + "");
            }
        });

        //Launch and activity within app
        Button secondActivity = (Button) findViewById((R.id.secondActivty));
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                //Normally you want to name your "key" as your package address ex. com.example.firstapp
                startIntent.putExtra("key", "Hello World");
                //Pass information to the second screen
                startActivity(startIntent);
            }
        });

        Button googleBtn = (Button) findViewById((R.id.googleBtn));

        googleBtn.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String google = "http://sakai.rutgers.edu";

                Uri webaddress = Uri.parse(google);

                //This broadcasts to your phone to check if an app can open this
                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);

                if(gotoGoogle.resolveActivity(getPackageManager()) != null){
                    startActivity(gotoGoogle);
                }
            }
        }));
    }
}