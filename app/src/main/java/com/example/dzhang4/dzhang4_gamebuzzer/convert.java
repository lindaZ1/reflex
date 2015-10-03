package com.example.dzhang4.dzhang4_gamebuzzer;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by dzhang4 on 9/30/15.
 */
/*converts reaction time(long) into string
 *ArrayAt returned reaction time statistics(keyStats) and
 *push into keyStatsArray
 *save keyStatsArray into a json file in saveLoad class*/
public class convert {

    private long data; //store data from keyStats
    private singleCalculate calc;
    private keyStatsArray keyStatsA;
    private saveLoad save;
    private String convert;

    //convert reacTime to String with a decimal in the form
    //".___"(3 spaces after the decimal)
    public String Stringconvert(long time) {
        convert=String.valueOf(time);
        if(time==-1) {
            convert="-1";
        }
        if(convert.length()>=3) {
            convert = convert.substring(0, convert.length() - 3) + "." + convert.substring(convert.length() - 3);
        }
        else if(convert.length()==2 && time!=-1) {
            convert="0.0"+convert;
        }
        else if(convert.length()==1) {
            convert="0.00"+convert;
        }

        return convert;
    }

    //call singleCalculate and calculate key data for statistics
    //put key data in keyStatsArray
    //save keyStatsArray to json file
    public void calculate(Context context) {
        save=new saveLoad();
        //establish globalClass with context
        final globalClass globalVar=(globalClass)context.getApplicationContext();
        calc=new singleCalculate(globalVar.getTime(),globalVar.getReacCount());
        keyStatsA=new keyStatsArray();

        //calculate single statsClick and append to keyStatsArray
        data=calc.max10();
        keyStatsA.addS(new keyStats("Maximum time in Last 10 Tries: " + Stringconvert(data)));
        data = calc.max100();
        keyStatsA.addS(new keyStats("Maximum time in last 100 Tries: " + Stringconvert(data)));
        data=calc.maxAll();
        keyStatsA.addS(new keyStats("Maximum time in All Tries: " + Stringconvert(data)));

        data = calc.min10();
        keyStatsA.addS(new keyStats("Minimum time in last 10 Tries: " + Stringconvert(data)));
        data = calc.min100();
        keyStatsA.addS(new keyStats("Minimum time in last 100 Tries: " + Stringconvert(data)));
        data=calc.minAll();
        keyStatsA.addS(new keyStats("Maximum time in Last 10 Tries: " + Stringconvert(data)));

        data = calc.avg10();
        keyStatsA.addS(new keyStats("Average time in last 10 Tries: " + Stringconvert(data)));
        data = calc.avg100();
        keyStatsA.addS(new keyStats("Average time in last 100 Tries: " + Stringconvert(data)));
        data=calc.avgAll();
        keyStatsA.addS(new keyStats("Maximum time in Last 10 Tries: " + Stringconvert(data)));

        data = calc.med10();
        keyStatsA.addS(new keyStats("Median time in last 10 Tries: " + Stringconvert(data)));
        data = calc.med100();
        keyStatsA.addS(new keyStats("Median time in last 100 Tries: " + Stringconvert(data)));
        data=calc.medAll();
        keyStatsA.addS(new keyStats("Maximum time in Last 10 Tries: " + Stringconvert(data)));


        //append multistats:2,3,4 player statsClick to keyStatsArray
        keyStatsA.addS(new keyStats("2Player"));
        keyStatsA.addS(new keyStats("Player 1: "+globalVar.getp12Count()));
        keyStatsA.addS(new keyStats("Player 2: "+globalVar.getp22Count()));

        keyStatsA.addS(new keyStats("3Player"));
        keyStatsA.addS(new keyStats("Player 1: "+globalVar.getp13Count()));
        keyStatsA.addS(new keyStats("Player 2: "+globalVar.getp23Count()));
        keyStatsA.addS(new keyStats("Player 3: "+globalVar.getp33Count()));

        keyStatsA.addS(new keyStats("4Player"));
        keyStatsA.addS(new keyStats("Player 1: "+globalVar.getp14Count()));
        keyStatsA.addS(new keyStats("Player 2: "+globalVar.getp24Count()));
        keyStatsA.addS(new keyStats("Player 3: "+globalVar.getp34Count()));
        keyStatsA.addS(new keyStats("Player 4: "+globalVar.getp44Count()));
        //save keyStatsArray to json file
        save.saveInFile(context, keyStatsA);
    }


}
