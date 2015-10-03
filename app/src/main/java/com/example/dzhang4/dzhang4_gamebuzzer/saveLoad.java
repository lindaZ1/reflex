package com.example.dzhang4.dzhang4_gamebuzzer;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

/**
 * Created by dzhang4 on 9/27/15.
 */
//save and load into json file
public class saveLoad {

    protected static final String FILENAME = "file.sav";

    //save keyStatsArray into file
    public void saveInFile(Context context,keyStatsArray data) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(fos));
            Gson gson=new Gson();
            gson.toJson(data, out);
            out.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }
    }

    //load keyStatsArray from file
    public keyStatsArray loadFromFile(Context context,keyStatsArray data) {
        data=null;
        try {

            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson=new Gson();
            //https://sites.google.com/site/gson/gson-user-guide sept27,2015
            Type arrayListType=new TypeToken<keyStatsArray>() {}.getType();
            data=gson.fromJson(in,arrayListType);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            //throw new RuntimeException(e);
            //key=new ArrayList<keyStats>();
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        return data;
    }
}
