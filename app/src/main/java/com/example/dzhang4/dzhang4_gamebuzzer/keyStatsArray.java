package com.example.dzhang4.dzhang4_gamebuzzer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dzhang4 on 9/27/15.
 */
/*store all key data in keyStats form in an array*/
public class keyStatsArray {
    protected ArrayList<keyStats> sArray;
    public keyStatsArray() {
        sArray= new ArrayList<keyStats>();
    }

    public void addS(keyStats data) {
        sArray.add(data);
        //return sArray;
    }
    public ArrayList<keyStats> getArray() {
        return sArray;
    }
    public void clear() {
        sArray.clear();
    }
    public int size() {
        return sArray.size();
    }
    public keyStats ArrayAt(int index) {
        return sArray.get(index);
    }
}
