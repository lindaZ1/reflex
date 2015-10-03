package com.example.dzhang4.dzhang4_gamebuzzer;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

    /*players who tap their button will append their player number to first(ArrayList) in superclass
   *first[0] is the first player to tap
   *this player will ArrayAt one point and access the result method in superclass*/

    //player1 clicks button
    public void player1of3Click(View view) {
        first.add(1);
        if (first.get(0)==1) {
            //final globalClass globalVar=(globalClass) getApplicationContext();
            globalVar= variable();
            count=globalVar.getp13Count();
            globalVar.setP13Count(count + 1);
            result("Player1");
        }
    }

    //player2 clicks button
    public void player2of3Click(View view) {
        first.add(2);
        if (first.get(0)==2) {
            //final globalClass globalVar=(globalClass) getApplicationContext();
            globalVar= variable();
            count=globalVar.getp23Count();
            globalVar.setP23Count(count + 1);
            result("Player2");

        }
    }

    //player3 clicks button
    public void player3of3Click(View view) {
        first.add(3);
        if (first.get(0)==3) {
            //final globalClass globalVar=(globalClass) getApplicationContext();
            globalVar= variable();
            count=globalVar.getp33Count();
            globalVar.setP33Count(count+1);
            result("Player3");

        }
    }

}
