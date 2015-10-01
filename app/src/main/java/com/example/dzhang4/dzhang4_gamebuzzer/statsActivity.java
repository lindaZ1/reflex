package com.example.dzhang4.dzhang4_gamebuzzer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

public class statsActivity extends MainActivity {
    protected static final String FILENAME = "file.sav";

    protected keyStatsSingleArray data=new keyStatsSingleArray();
    private ListView StatListView;
    //public ArrayAdapter<keyStatsSingle> adapter;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        StatListView=(ListView) findViewById(R.id.StatListView);
    }

    public void clear(View view) {
        //setResult(RESULT_OK);
        data.clear(); //clear keyStatsSingleArray
        save_to_file save=new save_to_file();
        saveInFile(data); //clear statistics screen
        //save.saveInFile(data);
        //clear all data
        final globalClass globalVar=(globalClass) getApplicationContext();
        globalVar.clear();
        adapter.notifyDataSetChanged();
    }

    public void email(View view) {
        // http://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
        // 2015/09/30
        StringBuffer mailBody=new StringBuffer();
        for (int i=0;i<data.size();i++) {
            mailBody.append(data.get(i).getData()+"\n");
        }

        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto: "));
        String[] re={""};
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL,re);
        intent.putExtra(Intent.EXTRA_SUBJECT, "reflex results");
        intent.putExtra(Intent.EXTRA_TEXT, mailBody.toString());
        try
        {
            startActivity(Intent.createChooser(intent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex)
        {
            Toast.makeText(statsActivity.this, "No email clients installed.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        //from lonelyTwitter onStart()
        super.onStart();
        if(data.getS()==null) {
            data=new keyStatsSingleArray();
        }
        data=loadFromFile();
        //StatListView=(ListView) findViewById(R.id.StatListView);
        adapter = new MyAdapter(this, R.layout.stat_list, data.getS());
        StatListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    protected keyStatsSingleArray loadFromFile() {
        keyStatsSingleArray data=null;
        try {

            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson=new Gson();
            //https://sites.google.com/site/gson/gson-user-guide sept27,2015
            Type arrayListType=new TypeToken<keyStatsSingleArray>() {}.getType();
            data=gson.fromJson(in,arrayListType);
            //wrap[] arr=gson.fromJson(in, wrap[].class);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            //throw new RuntimeException(e);
            //key=new ArrayList<keyStatsSingle>();
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        return data;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stats, menu);
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
}




