package com.mapps.listtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ListView myListView = (ListView) findViewById(R.id.mylistview);
        ArrayList<String> myFamily = new ArrayList<String >();
        myFamily.add("Hi");
        myFamily.add("Hello");
        myFamily.add("how are you?");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Log.i("Name tapped: ", adapterView.getItemAtPosition(i).toString());


            }
        }
        );
        */

        ListView myListView1 = (ListView) findViewById(R.id.mylistview);
        ArrayList<String> myArrayList = new ArrayList<String>();
        myArrayList.add("Friend1");
        myArrayList.add("Friend2");
        myArrayList.add("Friend3");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, myArrayList);
        myListView1.setAdapter(arrayAdapter);

        myListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),(adapterView.getItemAtPosition(i)).toString(),Toast.LENGTH_LONG).show();


            }
        }


        );



    }
}
