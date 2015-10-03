package com.example.dzhang4.dzhang4_gamebuzzer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
    public void player1of2Click(View view) {
        first.add(1);
        if (first.get(0) == 1) {
            globalVar= variable();
            count=globalVar.getp12Count();
            globalVar.setP12Count(count+1);
            result("Player1");
        }
    }

    //player2 clicks button
    public void player2of2Click(View view) {
        first.add(2);
        if (first.get(0) == 2) {
            globalVar= variable();
            count=globalVar.getp22Count();
            globalVar.setP22Count(count + 1);
            result("Player2");
        }
    }

}
