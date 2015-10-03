package com.example.dzhang4.dzhang4_gamebuzzer;

import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by dzhang4 on 10/2/15.
 */
/*counts down from a randomly generated number between 10-2000ms
 *show toast to click when countdown is finished*/
public class timer {
    public long beginTime;
    public Boolean countDownTimer=false;

    //generate a random number between 10 and 2000
    public int random() {
        Random randInt=new Random();
        int rand=randInt.nextInt(1990) + 10;
        return rand;
    }

    //countdown timer:count from random number to 1
    public void downTime(final Context acontext, final Boolean earlyClick) {
        int rand=random();
        //http://developer.android.com/reference/android/os/CountDownTimer.html Sep23,2015
        new CountDownTimer(rand, 1){
            public void onTick (long millisUntilFinished){
            }

            public void onFinish () {
                //create toast
                if (earlyClick==false) {
                    Context context = acontext.getApplicationContext();
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

    public Boolean getCountDownTimer() {
        return countDownTimer;
    }

    public long getBeginTime() {
        return beginTime;
    }
}
