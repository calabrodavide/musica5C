package com.example.songs5cinf;

public class Brano {
    private String titolo;
    private String autore;
    private String genere;


    public Brano(String titolo, String autore, String genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
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
}
