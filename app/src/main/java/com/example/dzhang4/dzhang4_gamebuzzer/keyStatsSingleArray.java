package com.example.dzhang4.dzhang4_gamebuzzer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by dzhang4 on 9/27/15.
 */
public class keyStatsSingleArray implements Serializable{
    protected ArrayList<keyStatsSingle> sArray = null;
    public keyStatsSingleArray() {
        sArray= new ArrayList<keyStatsSingle>();
    }

    public ArrayList<keyStatsSingle> addS(keyStatsSingle data) {
        sArray.add(data);
        return sArray;
    }
    public ArrayList<keyStatsSingle> getS() {
        return sArray;
    }
    public void clear() {
        sArray.clear();
    }
    public int size() {
        return sArray.size();
    }
    public keyStatsSingle get(int i) {
        return sArray.get(i);
    }
}
