package com.example.songs5cinf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //search fields
    EditText title;
    EditText author;
    EditText date;
    EditText duration;

    //function buttons
    Button add;
    Button search;
    Button playlist;

    //search select
    Spinner genre;

    //all genres
    String[] generi = {
            "Rap",
            "Classica",
            "Pop"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //all "find view by id"
        title = (EditText) findViewById(R.id.title_text);
        author = (EditText) findViewById(R.id.author_text);
        date = (EditText) findViewById(R.id.date_text);
        duration = (EditText) findViewById(R.id.duration_text);

        add = (Button) findViewById(R.id.add_btn);
        search = (Button) findViewById(R.id.search_btn);
        playlist = (Button) findViewById(R.id.playlist_btn);

        genre = (Spinner) findViewById(R.id.spinner);

        date = (EditText) findViewById(R.id.date_text);

        //end

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, generi);
        GestioneBrani manager = new GestioneBrani();

        genre.setAdapter(adapter);

        //add button logic
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (manager.strIsEmpty(title.getText().toString()) || manager.strIsEmpty(author.getText().toString())
                || manager.strIsEmpty(date.getText().toString()) || manager.strIsEmpty(duration.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Non aggiunto", Toast.LENGTH_SHORT).show();
                } else {

                    manager.addBrano(new Brano(
                            title.getText().toString(),
                            author.getText().toString(),
                            genre.getSelectedItem().toString(),
                            date.getText().toString(),
                            duration.getText().toString()
                    ));


                    Toast.makeText(getApplicationContext(), title.getText().toString().trim() + " aggiunto con successo",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        //search button logic
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                manager.findBrano(MainActivity.this, new Brano(
                        title.getText().toString(),
                        author.getText().toString(),
                        genre.getSelectedItem().toString(),
                        manager.strIsEmpty(date.getText().toString())? "0" : date.getText().toString(),
                        manager.strIsEmpty(duration.getText().toString())? "0" : duration.getText().toString()

                        ));
            }
        });

        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Playlist.class);
                StringBuilder titles = new StringBuilder();
                StringBuilder authors = new StringBuilder();
                ArrayList<Brano> brani = manager.getBrani();

                for(Brano brano: brani){
                    titles.append(brano.getTitolo());
                    authors.append(brano.getAutore());
                }
                String res_titles = titles.toString();
                String res_authors = authors.toString();

                i.putExtra("titles", res_titles);
                i.putExtra("authors", res_authors);

                startActivity(i);
            }
        });




    }

}