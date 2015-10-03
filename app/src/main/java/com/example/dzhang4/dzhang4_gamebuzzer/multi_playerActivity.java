package com.example.dzhang4.dzhang4_gamebuzzer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

//multiPlayer screen with 2player, 3player, 4player buttons
//determines first click and output result
public class multi_playerActivity extends Activity {

    protected ArrayList first=new ArrayList();
    protected int count;
    public globalClass globalVar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multi_player, menu);
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

    //define globalClass globalVar
    public globalClass variable() {
        final globalClass globalVar=(globalClass) this.getApplicationContext();
        return globalVar;
    }
    //open 2-player mode
    public void twoPlayer(View view) {
        Intent intent=new Intent(this, two_playerActivity.class);
        startActivity(intent);
    }

    //open 3-player mode
    public void threePlayer(View view) {
        Intent intent=new Intent(this, three_playerActivity.class);
        startActivity(intent);
    }

    //open 4-player mode
    public void fourPlayer(View view) {
        Intent intent=new Intent(this, four_playerActivity.class);
        startActivity(intent);
    }

    //show result in alertDialog and clear array
    public void result(String player) {
        //calculate and save count in file
        convert calc=new convert();
        calc.calculate(multi_playerActivity.this);

        //show result
        AlertDialog.Builder earlyClick=new AlertDialog.Builder(this);
        earlyClick.setTitle("Result");
        earlyClick.setMessage(player+" clicked first");
        earlyClick.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                first.clear();
            }
        });
        AlertDialog EarlyClick=earlyClick.create();
        EarlyClick.show();
    }


}
