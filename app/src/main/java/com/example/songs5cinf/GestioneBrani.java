package com.example.songs5cinf;

import java.util.ArrayList;

public class GestioneBrani {

    private ArrayList<Brano> brani;

    public GestioneBrani() {
        brani = new ArrayList<Brano>();
    }

    public void addBrano(Brano brano){
        brani.add(brano);
    }

    public ArrayList getBrani(){
        return brani;
    }

    public void findBrano(Brano brano){

    }

    public boolean strIsEmpty(String string){
        if(string == null || string.isEmpty() || string.trim().isEmpty()){
            return true;
        }
        return false;
    }

}
