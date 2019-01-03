package com.example.andr0id_devel0pment.txtreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class countries extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        ListView listView = findViewById(R.id.countries_list);

        Intent intent = getIntent();

        ArrayList<String> data = (ArrayList<String>) intent.getSerializableExtra("data");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this
                , R.layout.list_item,data);
        listView.setAdapter(adapter);

    }
}
