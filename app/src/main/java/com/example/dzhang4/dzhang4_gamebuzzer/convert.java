package com.example.dzhang4.dzhang4_gamebuzzer;

/**
 * Created by dzhang4 on 9/30/15.
 */
public class convert extends MainActivity{
    /*private long data; //store data from keySingleStats
    private singleCalculate calc;
    private keyStatsSingleArray keyStatsA;
    save_to_file save=new save_to_file();
    //convert reacTime to String with a decimal
    public String Stringconvert(long a) {
        String convert=String.valueOf(a);
        if(a==-1) {
            convert="-1";
        }
        if(convert.length()>=3) {
            convert = convert.substring(0, convert.length() - 3) + "." + convert.substring(convert.length() - 3);
        }
        else if(convert.length()==2 && a!=-1) {
            convert="0.0"+convert;
        }
        else if(convert.length()==1) {
            convert="0.00"+convert;
        }

        return convert;
    }

    //call singleCalculate and calculate key data for stats
    public void calculate() {
        final globalClass globalVar=(globalClass) getApplicationContext();
        //calc=new singleCalculate(rTime,reacCount);
        calc=new singleCalculate(globalVar.getTime(),globalVar.getReacCount());
        keyStatsA=new keyStatsSingleArray();

        //calculate single stats
        data=calc.max10();
        keyStatsA.addS(new keyStatsSingle("Maximum time in Last 10 Tries: " + Stringconvert(data)));
        data = calc.max100();
        keyStatsA.addS(new keyStatsSingle("Maximum time in last 100 Tries: " + Stringconvert(data)));
        data = calc.min10();
        keyStatsA.addS(new keyStatsSingle("Minimum time in last 10 Tries: " + Stringconvert(data)));
        data = calc.min100();
        keyStatsA.addS(new keyStatsSingle("Minimum time in last 100 Tries: " + Stringconvert(data)));
        data = calc.avg10();
        keyStatsA.addS(new keyStatsSingle("Average time in last 10 Tries: " + Stringconvert(data)));
        data = calc.avg100();
        keyStatsA.addS(new keyStatsSingle("Average time in last 100 Tries: " + Stringconvert(data)));
        data = calc.med10();
        keyStatsA.addS(new keyStatsSingle("Median time in last 10 Tries: " + Stringconvert(data)));
        data = calc.med100();
        keyStatsA.addS(new keyStatsSingle("Median time in last 100 Tries: " + Stringconvert(data)));


        //multistats
        keyStatsA.addS(new keyStatsSingle("2Player"));
        keyStatsA.addS(new keyStatsSingle("Player 1: "+globalVar.getp12Count()));
        keyStatsA.addS(new keyStatsSingle("Player 2: "+globalVar.getp22Count()));

        keyStatsA.addS(new keyStatsSingle("3Player"));
        keyStatsA.addS(new keyStatsSingle("Player 1: "+globalVar.getp13Count()));
        keyStatsA.addS(new keyStatsSingle("Player 2: "+globalVar.getp23Count()));
        keyStatsA.addS(new keyStatsSingle("Player 3: "+globalVar.getp33Count()));

        keyStatsA.addS(new keyStatsSingle("4Player"));
        keyStatsA.addS(new keyStatsSingle("Player 1: "+globalVar.getp14Count()));
        keyStatsA.addS(new keyStatsSingle("Player 2: "+globalVar.getp24Count()));
        keyStatsA.addS(new keyStatsSingle("Player 3: "+globalVar.getp34Count()));
        keyStatsA.addS(new keyStatsSingle("Player 4: "+globalVar.getp44Count()));
        save.saveInFile(keyStatsA);
    }

*/
}
