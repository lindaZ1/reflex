package com.example.dzhang4.dzhang4_gamebuzzer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    protected static final String FILENAME = "file.sav";

    private long data; //store data from keySingleStats
    private singleCalculate calc;
    private keyStatsSingleArray keyStatsA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //single player button pressed
    public void singlePlayer(View view) {
        Intent intent=new Intent(this,single_userActivity.class);
        startActivity(intent);
    }

    //multi-player button pressed
    public void multiPlayer(View view) {
        Intent intent=new Intent(this, multi_playerActivity.class);
        startActivity(intent);
    }

    //stats button pressed
    public void stats(View view) {
        Intent intent=new Intent(this, statsActivity.class);
        startActivity(intent);
    }

   //convert reacTime to String with a decimal
    public String Stringconvert(long a) {
        String convert=String.valueOf(a);
        if(a==-1) {
            convert="-1";
        }
        if(convert.length()>=3) {
            convert = convert.substring(0, convert.length() - 3) + "." + convert.substring(convert.length() - 3);
        }
        else if(convert.length()==2 && a!=-1) {
            convert="0.0"+convert;
        }
        else if(convert.length()==1) {
            convert="0.00"+convert;
        }

        return convert;
    }


    //call singleCalculate and calculate key data for stats
    public void calculate() {
        final globalClass globalVar=(globalClass) getApplicationContext();
        //calc=new singleCalculate(rTime,reacCount);
        calc=new singleCalculate(globalVar.getTime(),globalVar.getReacCount());
        keyStatsA=new keyStatsSingleArray();
        save_to_file save=new save_to_file();

        //calculate single stats
        data=calc.max10();
        keyStatsA.addS(new keyStatsSingle("Maximum time in Last 10 Tries: " + Stringconvert(data)));
        data = calc.max100();
        keyStatsA.addS(new keyStatsSingle("Maximum time in last 100 Tries: " + Stringconvert(data)));
        data = calc.min10();
        keyStatsA.addS(new keyStatsSingle("Minimum time in last 10 Tries: " + Stringconvert(data)));
        data = calc.min100();
        keyStatsA.addS(new keyStatsSingle("Minimum time in last 100 Tries: " + Stringconvert(data)));
        data = calc.avg10();
        keyStatsA.addS(new keyStatsSingle("Average time in last 10 Tries: " + Stringconvert(data)));
        data = calc.avg100();
        keyStatsA.addS(new keyStatsSingle("Average time in last 100 Tries: " + Stringconvert(data)));
        data = calc.med10();
        keyStatsA.addS(new keyStatsSingle("Median time in last 10 Tries: " + Stringconvert(data)));
        data = calc.med100();
        keyStatsA.addS(new keyStatsSingle("Median time in last 100 Tries: " + Stringconvert(data)));


        //multistats
        keyStatsA.addS(new keyStatsSingle("2Player"));
        keyStatsA.addS(new keyStatsSingle("Player 1: "+globalVar.getp12Count()));
        keyStatsA.addS(new keyStatsSingle("Player 2: "+globalVar.getp22Count()));

        keyStatsA.addS(new keyStatsSingle("3Player"));
        keyStatsA.addS(new keyStatsSingle("Player 1: "+globalVar.getp13Count()));
        keyStatsA.addS(new keyStatsSingle("Player 2: "+globalVar.getp23Count()));
        keyStatsA.addS(new keyStatsSingle("Player 3: "+globalVar.getp33Count()));

        keyStatsA.addS(new keyStatsSingle("4Player"));
        keyStatsA.addS(new keyStatsSingle("Player 1: "+globalVar.getp14Count()));
        keyStatsA.addS(new keyStatsSingle("Player 2: "+globalVar.getp24Count()));
        keyStatsA.addS(new keyStatsSingle("Player 3: "+globalVar.getp34Count()));
        keyStatsA.addS(new keyStatsSingle("Player 4: "+globalVar.getp44Count()));
        //save.saveInFile(keyStatsA);
        saveInFile(keyStatsA);
    }


    //from lonely twitter
    public void saveInFile(keyStatsSingleArray data) {
        try {
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter out=new OutputStreamWriter(fos);
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

}
