package com.example.songs5cinf;

import androidx.appcompat.app.AppCompatActivity;

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

    //function buttons
    Button add;
    Button search;

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

        add = (Button) findViewById(R.id.add_btn);
        search = (Button) findViewById(R.id.search_btn);

        genre = (Spinner) findViewById(R.id.spinner);

        //end

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, generi);
        GestioneBrani manager = new GestioneBrani();

        genre.setAdapter(adapter);

        //add button logic
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (manager.strIsEmpty(title.getText().toString()) || manager.strIsEmpty(author.getText().toString())) {

                    Toast.makeText(getApplicationContext(), "Non aggiunto", Toast.LENGTH_SHORT).show();
                } else {

                    manager.addBrano(new Brano(title.getText().toString().trim(),
                            author.getText().toString().trim(),
                            genre.getSelectedItem().toString()));

                    Toast.makeText(getApplicationContext(), title.getText().toString().trim() + " aggiunto con successo",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        //search button logic
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (manager.strIsEmpty(title.getText().toString()) && manager.strIsEmpty(author.getText().toString())){

                    Toast.makeText(getApplicationContext(), "Inserisci qualcosa", Toast.LENGTH_SHORT).show();
                }else{
                    ArrayList<Brano> list= manager.getBrani();
                    for (Brano brano : list){
                        if(title.getText().toString().trim().equals(brano.getTitolo()) ||
                        author.getText().toString().trim().equals(brano.getAutore())){

                            Toast.makeText(getApplicationContext(), "Il brano è:", Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "Titolo: " + brano.getTitolo(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "Autore: " + brano.getAutore(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Non trovato", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //futuro intent con playlist di tutti i brani inseriti
        /*
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Brano> list = manager.getBrani();
                for (Brano brano : list) {
                    Toast.makeText(getApplicationContext(), brano.getTitolo(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        */



    }

}