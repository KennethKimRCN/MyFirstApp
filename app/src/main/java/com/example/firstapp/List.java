package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends AppCompatActivity {

    ListView myList;
    String[] items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res = getResources();

        myList = (ListView) findViewById(R.id.myList);
        items = res.getStringArray(R.array.items);

        //We are going to need an adapter to merge these two
        myList.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_db, items));

    }
}