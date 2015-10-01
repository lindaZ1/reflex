package com.example.dzhang4.dzhang4_gamebuzzer;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by dzhang4 on 9/27/15.
 */
public class save_to_file extends MainActivity{

    //keyStatsSingleArray data=new keyStatsSingleArray();
   /* protected static final String FILENAME = "file.sav";
    public save_to_file() {
    }

    public void saveInFile(keyStatsSingleArray data) {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
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
    }*/
}
