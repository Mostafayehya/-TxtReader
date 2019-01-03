package com.example.andr0id_devel0pment.txtreader;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button citiesButton = findViewById(R.id.button);
        Button countriesButton = findViewById(R.id.button2);

        citiesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int FILE_NAME = R.raw.cities;

                ArrayList<String> result = readFile(FILE_NAME);
                Intent citiesActivity = new Intent(getApplicationContext(),Cities.class);
                citiesActivity.putExtra("data",result);
                startActivity(citiesActivity);


            }
        });

        countriesButton.setOnClickListener(new View.OnClickListener() {

            //TODO use string constants instead of hard coding it
            @Override
            public void onClick(View view) {

                int FILE_NAME = R.raw.countries;


                ArrayList<String> result = readFile(FILE_NAME);

                Intent countriesActivity = new Intent(getApplicationContext(),countries.class);
                countriesActivity.putExtra("data",result);
                startActivity(countriesActivity);


            }
        });


    }

    public ArrayList<String> readFile(int fileID) {

        String city, population, country;
        String[] details;
        String line;

        ArrayList<String> buffer = new ArrayList<>();

        StringBuffer sBuffer = new StringBuffer();
        int FILE_NAME = fileID;

        InputStream iStream = this.getResources().openRawResource(FILE_NAME);
        BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));


        try {

            if (fileID == R.raw.cities) {
                while ((line = reader.readLine()) != null) {
                    details = line.split(";");
                    city = details[0];
                    population = details[1];
                    country = details[2];

                    buffer.add(city + " " + population + " " + country);


                }
                reader.close();
            } else {
                while ((line = reader.readLine()) != null) {
                    details = line.split(";");

                    country = details[0];
                    population = details[1];


                    buffer.add(country + " " + population);

                }

            }

        } catch (Exception e) {
            Toast.makeText(getBaseContext(), FILE_NAME + " file not found", Toast.LENGTH_SHORT).show();
        }

        return buffer;
    }
}
