package com.example.dzhang4.dzhang4_gamebuzzer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by dzhang4 on 9/26/15.
 */
//class to calculate all key stats for singleplayer reaction time
public class singleCalculate {
    private ArrayList last10=new ArrayList();
    private ArrayList last100=new ArrayList();
    long Max10,Max100,Min10,Min100,Avg10,Avg100,Med10,Med100;
    private int counts;
    ArrayList list=new ArrayList();

    public singleCalculate(ArrayList time,int count) {
        this.counts=count;
        this.list=time;

    }

    public long max10() {
        if (counts<=10 && list.isEmpty()==false) {
            last10=list;
            Collections.sort(last10);
            Max10=(long)last10.get(counts-1);
        }

        else if(counts>10) {
            for(int i=1;i<=10;i++) {
                last10.add(counts-i);
            }
            Collections.sort(last10);
            Max10=(long)last10.get(counts-1);
        }

        else if(list.isEmpty()) {
            return -1;
        }
        //last10=time.removeRange(time.size()-10,time.size());
        //last10.clear();
        return Max10;
    }

    public long max100(){
        if (counts<=100 && list.isEmpty()==false) {
            last100=list;
            Collections.sort(last100);
            Max100=(long)last100.get(counts-1);
        }

        else if(counts>100) {
            for(int i=1;i<=100;i++) {
                last100.add(counts-i);
            }
            Collections.sort(last100);
            Max100=(long)last100.get(counts-1);
        }

        else if(list.isEmpty()) {
            return -1;
        }
        //last100.clear();
        return Max100;
    }
    public long min10(){
        if (counts<=10 && list.isEmpty()==false) {
            //last10=Collections.sort(time);
            last10=list;
            Collections.sort(last10);
            Min10=(long)last10.get(0);
        }

        else if(counts>10) {
            for(int i=1;i<=10;i++) {
                last10.add(counts-i);
            }
            Collections.sort(last10);
            Min10=(long)last10.get(0);
        }

        else if(list.isEmpty()) {
            return -1;
        }

        //last10.clear();
        return Min10;
    }
    public long min100(){
        if (counts<=100 && list.isEmpty()==false) {
            //last10=Collections.sort(time);
            last100=list;
            Collections.sort(last100);
            Min100=(long)last100.get(0);
        }

        else if(counts>100) {
            for(int i=1;i<=100;i++) {
                last100.add(counts-i);
            }
            Collections.sort(last100);
            Min100=(long)last10.get(0);
        }

        else if(list.isEmpty()) {
            return -1;
        }
        //last100.clear();
        return Min100;
    }
    public long avg10(){
        long sum=0;
        if(counts<=10 &&list.isEmpty()==false) {
            //find sum of list
            for(int i=0;i<counts;i++) {
                sum=sum+(long)list.get(i);
            }
            Avg10=sum/counts;
        }
        else if(counts>10) {
            for(int i=1;i<=10;i++) {
                last10.add(counts-i);
            }
            for(int i=0;i<10;i++) {
                sum=sum+(long)last10.get(i);
            }
            Avg10=sum/10;
        }
        else if(list.isEmpty()) {
            return -1;
        }
        //last10.clear();
        return Avg10;
    }

    public long avg100(){
        long sum=0;
        if(counts<=100 &&list.isEmpty()==false) {
            //find sum of list
            for(int i=0;i<counts;i++) {
                sum=sum+(long)list.get(i);
            }
            Avg100=sum/counts;
        }
        else if(counts>100) {
            for(int i=1;i<=100;i++) {
                last100.add(counts-i);
            }
            for(int i=0;i<100;i++) {
                sum=sum+(long)last100.get(i);
            }
            Avg100=sum/100;
        }
        else if(list.isEmpty()) {
            return -1;
        }
        //last100.clear();
        return Avg100;
    }

    public long med10(){
        int place=counts/2;
        if(counts<=10 && list.isEmpty()==false) {
            last10=list;
            Collections.sort(last10);
            Med10=(long)last10.get(place);
        }
        else if(counts>10) {
            for(int i=1;i<=10;i++) {
                last10.add(counts-i);
            }
            Collections.sort(last10);
            Med10=(long)last10.get(place);
        }
        else if(list.isEmpty()) {
            return -1;
        }
        //last10.clear();
        return Med10;
    }

    public long med100(){
        int place=counts/2;
        if(counts<=100 && list.isEmpty()==false) {
            last100=list;
            Collections.sort(last100);
            Med100=(long)last100.get(place);
        }
        else if(counts>100) {
            for(int i=1;i<=100;i++) {
                last100.add(counts-i);
            }
            Collections.sort(last100);
            Med100=(long)last100.get(place);
        }
        else if(list.isEmpty()) {
            return -1;
        }
        //last100.clear();
        return Med100;
    }


}
