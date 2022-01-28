package com.example.songs5cinf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Playlist extends AppCompatActivity {

    TextView res_titles;
    TextView res_authors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        res_titles = (TextView) findViewById(R.id.result_titles);
        res_authors = (TextView) findViewById(R.id.result_authors);

        Intent i = getIntent();

        String result_titles = i.getStringExtra("titles");
        String result_authors = i.getStringExtra("authors");

        res_titles.append(result_titles);
        res_authors.append(result_authors);


    }
}