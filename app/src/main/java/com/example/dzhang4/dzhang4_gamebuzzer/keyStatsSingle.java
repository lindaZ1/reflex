package com.example.dzhang4.dzhang4_gamebuzzer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dzhang4 on 9/27/15.
 */
//single key data of reaction time from user
public class keyStatsSingle{
    private String data=null;

    public keyStatsSingle(String data) {
        this.data=data;
    }

    public void sStat(String data) {
        this.data=data;
        //return data;
    }

    public String getData() {
        return this.data;
    }

}
