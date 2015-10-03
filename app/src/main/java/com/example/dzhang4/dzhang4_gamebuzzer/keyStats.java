package com.example.dzhang4.dzhang4_gamebuzzer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dzhang4 on 9/27/15.
 */
//key data of reaction time and multiplayer counts
public class keyStats {
    private String data;

    public keyStats(String data) {
        this.data=data;
    }

    public String getData() {
        return this.data;
    }

}
