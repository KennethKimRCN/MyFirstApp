package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends AppCompatActivity {

    ListView myList;
    String[] items;
    String[] description;
    String[] prices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res = getResources();

        myList = (ListView) findViewById(R.id.myList);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        description = res.getStringArray(R.array.description);


        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, description);
        myList.setAdapter(itemAdapter);

        //We are going to need an adapter to merge these two
        //myList.setAdapter(new ArrayAdapter<String>(this, R.layout.my_list_db, items));

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetailActivity = new Intent(getApplicationContext(), ListDetail.class);
                //Index
                showDetailActivity.putExtra("com.example.firstapp.ITEM_INDEX", position);
                startActivity(showDetailActivity);
            }
        });
    }
}