package com.example.dzhang4.dzhang4_gamebuzzer;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


//activity of four players
public class four_playerActivity extends multi_playerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_player);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four_player, menu);
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
    public void player1of4Clicks(View view) {
        first.add(1);
        if (first.get(0)==1) {
            globalVar= variable();
            count=globalVar.getp14Count();
            globalVar.setP14Count(count + 1);
            result("Player1");

        }
    }

    //player2 clicks button
    public void player2of4Clicks(View view) {
        first.add(2);
        if (first.get(0)==2) {
            globalVar= variable();
            count=globalVar.getp24Count();
            globalVar.setP24Count(count + 1);
            result("Player2");

        }
    }

    //player3 clicks button
    public void player3of4Clicks(View view) {
        first.add(3);
        if (first.get(0)==3) {
            globalVar= variable();
            count=globalVar.getp34Count();
            globalVar.setP34Count(count + 1);
            result("Player3");

        }
    }

    //player4 clicks button
    public void player4of4Clicks(View view) {
        first.add(4);
        if (first.get(0)==4) {
            globalVar= variable();
            count=globalVar.getp44Count();
            globalVar.setP44Count(count+1);
            result("Player4");

        }
    }

}
