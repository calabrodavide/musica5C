package com.example.songs5cinf;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class GestioneBrani {

    private ArrayList<Brano> brani;

    public GestioneBrani() {
        brani = new ArrayList<Brano>();
    }

    public void addBrano(Brano brano){
        brani.add(brano);
    }

    public void addBrano(ArrayList<Brano> brani){
        for(Brano brano : brani){
            this.brani.add(brano);
        }
    }

    public ArrayList getBrani(){
        return brani;
    }

    public void findBrano(Context c, Brano track){

        int i = 0;
        for (Brano brano : brani){

            Log.d("iteratore", String.valueOf(i));

            if(track.getAutore().equals(brano.getAutore()) || track.getTitolo().equals(brano.getTitolo()) ||
                    track.getData() == brano.getData() || track.getDurata() == brano.getDurata()
                    ){

                Toast.makeText(c, "Il brano è:", Toast.LENGTH_SHORT).show();
                Toast.makeText(c, "Titolo: " + brano.getTitolo(), Toast.LENGTH_SHORT).show();
                Toast.makeText(c, "Autore: " + brano.getAutore(), Toast.LENGTH_SHORT).show();
                Toast.makeText(c, "Data: " + brano.getData(), Toast.LENGTH_SHORT).show();
                Toast.makeText(c, "Durata: " + brano.getDurata(), Toast.LENGTH_SHORT).show();
                return;
            }
            i++;
        }

        Toast.makeText(c, "Non trovato", Toast.LENGTH_SHORT).show();

    }

    public boolean strIsEmpty(String string){
        if(string == null || string.isEmpty() || string.trim().isEmpty()){
            return true;
        }
        return false;
    }

}
