package com.example.dzhang4.dzhang4_gamebuzzer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dzhang4 on 9/29/15.
 */

/*
    Copyright (C) <2014>  <liwen Chen>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

    https://github.com/liwenCHEN20/todu/blob/master/src/com/example/todolist/MyAdapter.java
    sept 20,2015*/
public class MyAdapter extends ArrayAdapter<keyStats> {
    private Context context;
    private ArrayList<keyStats> itemsArray;

    public MyAdapter(Context context, int resource,
                     ArrayList<keyStats> objects) {
        super(context, resource, objects);
        this.context = context;
        this.itemsArray = objects;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.stat_list, null, false);
            TextView textview = (TextView) convertView.findViewById(R.id.stat_list);
            textview.setText(itemsArray.get(position).getData());

        } else {

            TextView textview = (TextView) convertView.findViewById(R.id.stat_list);
            textview.setText(itemsArray.get(position).getData());
        }

        return convertView;
    }
}
