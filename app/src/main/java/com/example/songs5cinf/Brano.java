package com.example.songs5cinf;

import android.provider.ContactsContract;


public class Brano {
    private String titolo;
    private String autore;
    private String genere;
    private int data;
    private int durata;


    public Brano(String titolo, String autore, String genere, String data, String durata) {
        this.titolo = titolo.trim();
        this.autore = autore.trim();
        this.genere = genere.trim();
        this.data = Integer.valueOf(data);
        this.durata = Integer.valueOf(durata);
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
}
