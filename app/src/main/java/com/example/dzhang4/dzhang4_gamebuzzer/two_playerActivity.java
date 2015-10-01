package com.example.dzhang4.dzhang4_gamebuzzer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class two_playerActivity extends multi_playerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_player, menu);
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

    //whoever clicked first will access result method
    //player1 clicks button
    public void P1(View view) {
        first.add(1);
        if (first.get(0) == 1) {
            final globalClass globalVar=(globalClass) getApplicationContext();
            count=globalVar.getp12Count();
            globalVar.setP12Count(count+1);
            result("Player1");
        }
    }

    //player2 clicks button
    public void P2(View view) {
        first.add(2);
        if (first.get(0) == 2) {
            final globalClass globalVar=(globalClass) getApplicationContext();
            count=globalVar.getp22Count();
            globalVar.setP22Count(count + 1);
            result("Player2");
        }
    }

}
