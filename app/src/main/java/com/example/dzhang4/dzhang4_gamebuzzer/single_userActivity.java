package com.example.dzhang4.dzhang4_gamebuzzer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class single_userActivity extends MainActivity {

    private boolean countDownTimer=false;
    private boolean earlyC=false;
    private long beginTime;
    private long endTime;
    convert cal=new convert();

    //ArrayList rTime=new ArrayList(); //a list of reaction times in order from oldest to newest
    //protected int reacCount=0; //number of reactions
    private long reacTime;
    //private long data;
    private String stTime;

    private singleCalculate calc;
    private keyStatsSingleArray keyStatsA;

    ArrayList<keyStatsSingle> saveData=new ArrayList<keyStatsSingle>();
    protected static final String FILENAME = "file.sav";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);

        //openInfo();
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

    //openInfo alertDialog
    public void openInfo() {
        //alertdialog
        //http://stackoverflow.com/questions/31151306/how-to-show-a-dialog-with-android-studio heloisasim sep23,2015
        AlertDialog.Builder singleInfo=new AlertDialog.Builder(this);
        singleInfo.setTitle("Reaction Time Info");
        singleInfo.setMessage("Test your reaction time by clicking on the button in the middle when the message appears.");
        singleInfo.setPositiveButton("Start", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //start countdown timer and toast
                downTime();
            }
        });
        AlertDialog SingleInfo=singleInfo.create();
        SingleInfo.show();
    }

    //generate a random number between 10 and 2000
    public int random() {
        Random randInt=new Random();
        int rand=randInt.nextInt(1990) + 10;
        return rand;
    }

    //countdown timer:count from random number to 1
    public void downTime() {
        int rand=random();
        //http://developer.android.com/reference/android/os/CountDownTimer.html Sep23,2015
        new CountDownTimer(rand, 1){
            public void onTick (long millisUntilFinished){
            }

            public void onFinish () {
                //create toast
                if (earlyC==false) {
                    Context context = getApplicationContext();
                    CharSequence text = "Click Now";
                    int dur = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, dur);
                    toast.show();
                    countDownTimer = true;
                    //set start time
                    beginTime=System.currentTimeMillis();

                }

            }
        }.start();
    }

    //button clicked
    public void singleClick(View view) {
        //countdown not finished
        if(countDownTimer==false) {
            earlyC=true;
            AlertDialog.Builder earlyClick=new AlertDialog.Builder(this);
            earlyClick.setTitle("Warning");
            earlyClick.setMessage("You clicked too early, please click after message appears.");
            earlyClick.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    earlyC=false;
                    downTime();
                }
            });

            AlertDialog EarlyClick=earlyClick.create();
            EarlyClick.show();
        }
        else {
            //button clicked, calculate reaction time
            endTime=System.currentTimeMillis();
            reacTime=endTime-beginTime;
            //rTime.add(reacTime);
            //reacCount=reacCount+1;
            final globalClass globalVar=(globalClass) getApplicationContext();
            globalVar.addTime(reacTime);
            int count=globalVar.getReacCount();
            globalVar.setreacCount(count + 1);

            //cal.calculate();
            calculate();

            //convert reacTime to String
            stTime=cal.Stringconvert(reacTime);


            //show result using alertDialog
            AlertDialog.Builder earlyClick=new AlertDialog.Builder(this);
            earlyClick.setTitle("Results");
            earlyClick.setMessage("Your reaction time is " + stTime + " seconds.\nWait for 'click now' to disappear before starting again. \nTap back button twice to exit.");
            earlyClick.setPositiveButton("Start Again", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    downTime();
                }
            });
            AlertDialog EarlyClick=earlyClick.create();
            EarlyClick.show();

        }

    }

    /*//convert reacTime to String with a decimal
    public String Stringconvert(long a) {
        String convert=String.valueOf(a);
        if(convert.length()>=3) {
            convert = convert.substring(0, convert.length() - 3) + "." + convert.substring(convert.length() - 3);
        }
        return convert;

    }

    //call singleCalculate and calculate key data for stats
    public void calculate() {
        calc=new singleCalculate(rTime,reacCount);
        keyStatsA=new keyStatsSingleArray();

        data=calc.max10();
        keyStatsA.addS(new keyStatsSingle("Maximum time in Last 10 Tries: "+Stringconvert(data)));
        data=calc.max100();
        keyStatsA.addS(new keyStatsSingle("Maximum time in last 100 Tries: "+Stringconvert(data)));
        data=calc.min10();
        keyStatsA.addS(new keyStatsSingle("Minimum time in last 10 Tries: "+Stringconvert(data)));
        data=calc.min100();
        keyStatsA.addS(new keyStatsSingle("Minimum time in last 100 Tries: "+Stringconvert(data)));
        data=calc.avg10();
        keyStatsA.addS(new keyStatsSingle("Average time in last 10 Tries: "+Stringconvert(data)));
        data=calc.avg100();
        keyStatsA.addS(new keyStatsSingle("Average time in last 100 Tries: "+Stringconvert(data)));
        data=calc.med10();
        keyStatsA.addS(new keyStatsSingle("Median time in last 10 Tries: "+Stringconvert(data)));
        data=calc.med100();
        keyStatsA.addS(new keyStatsSingle("Median time in last 100 Tries: "+Stringconvert(data)));
        saveInFile(keyStatsA);
    }


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
    }*/
}
