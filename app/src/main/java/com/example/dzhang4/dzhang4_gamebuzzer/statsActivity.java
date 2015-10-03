package com.example.dzhang4.dzhang4_gamebuzzer;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class statsActivity extends Activity {
    protected saveLoad save=new saveLoad();
    protected keyStatsArray data=new keyStatsArray();
    private ListView StatListView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        StatListView=(ListView) findViewById(R.id.StatListView);
    }

    public void clear(View view) {
        data.clear(); //clear keyStatsArray
        save.saveInFile(this,data); //save empty keyStatsArray in file
        //clear all data
        final globalClass globalVar=(globalClass) getApplicationContext();
        globalVar.clear();
        adapter.notifyDataSetChanged();
    }

    public void email(View view) {
        // http://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
        //Jeremy Logan
        // 2015/09/30

        //load message
        StringBuffer mailBody=new StringBuffer();
        for (int i=0;i<data.size();i++) {
            mailBody.append(data.ArrayAt(i).getData()+"\n");
        }

        //send email
        Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto: "));
        intent.setType("message/rfc822");
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
        if(data.getArray()==null) {
            data=new keyStatsArray();
        }
        data=save.loadFromFile(this, data);
        //StatListView=(ListView) findViewById(R.id.StatListView);
        adapter = new MyAdapter(this, R.layout.stat_list, data.getArray());
        StatListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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




