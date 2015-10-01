package com.example.dzhang4.dzhang4_gamebuzzer;

import android.app.Application;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by dzhang4 on 9/30/15.
 */
//http://www.codeproject.com/Tips/611985/Global-Variable-in-Android josh-jw
    /*
    Source Code and Executable Files can be used in commercial applications;
Source Code and Executable Files can be redistributed; and
Source Code can be modified to create derivative works.
No claim of suitability, guarantee, or any warranty whatsoever is provided. The software is provided "as-is".
The Article(s) accompanying the Work may not be distributed or republished without the Author's consent
     */
//sept30,2015
public class globalClass extends Application {
    private ArrayList rTime=new ArrayList();
    private int reacCount;

    //2player counts
    protected int p12Count;
    protected int p22Count;
    //3player counts
    protected int p13Count;
    protected int p23Count;
    protected int p33Count;
    //4player counts
    protected int p14Count;
    protected int p24Count;
    protected int p34Count;
    protected int p44Count;

    //rTime methods
    public void addTime(long time) {
        rTime.add(time);
    }

    public ArrayList getTime() {
        return this.rTime;
    }

    public int getSize() {
        return rTime.size();
    }

    //reacCount geter and setter
    public void setreacCount(int count) {
        reacCount=count;
    }

    public int getReacCount() {
        return this.reacCount;
    }

    //2player count getters and setters
    public int getp12Count() {
        return p12Count;
    }

    public void setP12Count(int count) {
        this.p12Count=count;
    }

    public int getp22Count() {
        return p22Count;
    }

    public void setP22Count(int count) {
        this.p22Count=count;
    }

    //3player count getters and setters
    public int getp13Count() {
        return p13Count;
    }

    public void setP13Count(int count) {
        this.p13Count=count;
    }

    public int getp23Count() {
        return p23Count;
    }

    public void setP23Count(int count) {
        this.p23Count=count;
    }

    public int getp33Count() {
        return p33Count;
    }

    public void setP33Count(int count) {
        this.p33Count=count;
    }

    //4player count getters and setters
    public int getp14Count() {
        return p14Count;
    }

    public void setP14Count(int count) {
        this.p14Count=count;
    }

    public int getp24Count() {
        return p24Count;
    }

    public void setP24Count(int count) {
        this.p24Count=count;
    }

    public int getp34Count() {
        return p34Count;
    }

    public void setP34Count(int count) {
        this.p34Count=count;
    }

    public int getp44Count() {
        return p44Count;
    }

    public void setP44Count(int count) {
        this.p44Count=count;
    }

    //clear all data in this class
    public void clear() {
        rTime.clear();
        reacCount=0;
        p12Count=0;
        p22Count=0;
        p13Count=0;
        p23Count=0;
        p33Count=0;
        p14Count=0;
        p24Count=0;
        p34Count=0;
        p44Count=0;

    }

}
