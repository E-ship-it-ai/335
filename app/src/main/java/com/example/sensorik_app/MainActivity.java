package com.example.sensorik_app;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.ListActivity;

public class MainActivity extends ListActivity {

    private TextView text;
    private List<String> listValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.mainText);

        listValues = new ArrayList<String>();
        listValues.add("Sensor1");
        listValues.add("Sensor2");
        listValues.add("Sensor3");
        listValues.add("Sensor4");
        listValues.add("Sensor5");


        ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this,
                R.layout.row_layout, R.id.listText, listValues);


        setListAdapter(myAdapter);

    }

    // click event for the list
    @Override
    protected void onListItemClick(ListView list, View view, int position, long id) {
        super.onListItemClick(list, view, position, id);

        String selectedItem = (String) getListView().getItemAtPosition(position);
        //String selectedItem = (String) getListAdapter().getItem(position);
        Intent intent = new Intent(MainActivity.this, TempActivity.class);
        text.setText("You clicked " + selectedItem + " at position " + position);
    }

}