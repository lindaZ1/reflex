package com.example.dzhang4.dzhang4_gamebuzzer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class three_playerActivity extends multi_playerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_player);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three_player, menu);
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
    public void P13(View view) {
        first.add(1);
        if (first.get(0)==1) {
            final globalClass globalVar=(globalClass) getApplicationContext();
            count=globalVar.getp13Count();
            globalVar.setP13Count(count + 1);
            result("Player1");
        }
    }

    //player2 clicks button
    public void P23(View view) {
        first.add(2);
        if (first.get(0)==2) {
            final globalClass globalVar=(globalClass) getApplicationContext();
            count=globalVar.getp23Count();
            globalVar.setP23Count(count + 1);
            result("Player2");

        }
    }

    //player3 clicks button
    public void P33(View view) {
        first.add(3);
        if (first.get(0)==3) {
            final globalClass globalVar=(globalClass) getApplicationContext();
            count=globalVar.getp33Count();
            globalVar.setP33Count(count+1);
            result("Player3");

        }
    }

}
