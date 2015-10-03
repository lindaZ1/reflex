package com.example.dzhang4.dzhang4_gamebuzzer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//single player reaction time
public class single_userActivity extends Activity{

    private boolean earlyClick =false;
    private long beginTime;
    private long endTime;
    private convert calc =new convert();


    private long reacTime;
    private String stringTime;

    private timer time=new timer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);

    }

    @Override
    protected void onStart() {
        super.onStart();
        openInfo();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_user, menu);
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


    //info on what to do
    //press start to play
    //only call this method when page is opened from MainActivity
    public void openInfo() {
        //alertdialog
        //http://stackoverflow.com/questions/31151306/how-to-show-a-dialog-with-android-studio heloisasim sep23,2015
        AlertDialog.Builder singleInfo=new AlertDialog.Builder(this);
        singleInfo.setTitle("Reaction Time Info");
        singleInfo.setMessage("Test your reaction time by clicking on the button in the middle when the message appears.");
        singleInfo.setPositiveButton("Start", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //start countdown timer and toast
                //downTime();
                time.downTime(single_userActivity.this, earlyClick);
            }
        });
        AlertDialog SingleInfo=singleInfo.create();
        SingleInfo.show();
    }

    //button clicked
    public void singleClick(View view) {
        //countdown not finished
        if(time.getCountDownTimer()==false) {
            earlyClick =true;
            AlertDialog.Builder earlyClick=new AlertDialog.Builder(this);
            earlyClick.setTitle("Warning");
            earlyClick.setMessage("You clicked too early, please click after message appears.");
            earlyClick.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    single_userActivity.this.earlyClick =false;
                    //downTime();
                    time.downTime(single_userActivity.this, single_userActivity.this.earlyClick);
                }
            });

            AlertDialog EarlyClick=earlyClick.create();
            EarlyClick.show();
        }

        else {
            beginTime=time.getBeginTime();
            //button clicked, calculate reaction time
            endTime=System.currentTimeMillis();
            reacTime=endTime-beginTime;

            //append reacTime to rTime in globalClass
            final globalClass globalVar=(globalClass) getApplicationContext();
            globalVar.addTime(reacTime);
            //increase count in globalClass by 1
            int count=globalVar.getReacCount();
            globalVar.setreacCount(count + 1);

            calc.calculate(single_userActivity.this);

            //convert reacTime to String
            stringTime = calc.Stringconvert(reacTime);


            //show result using alertDialog
            AlertDialog.Builder earlyClick=new AlertDialog.Builder(this);
            earlyClick.setTitle("Results");
            earlyClick.setMessage("Your reaction time is " + stringTime + " seconds.\nWait for 'click now' to disappear before starting again. \nTap back button twice to exit.");
            earlyClick.setPositiveButton("Start Again", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //downTime();
                    time.downTime(single_userActivity.this, single_userActivity.this.earlyClick);
                }
            });
            AlertDialog EarlyClick=earlyClick.create();
            EarlyClick.show();

        }

    }

}
