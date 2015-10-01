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
public class MyAdapter extends ArrayAdapter<keyStatsSingle> {
    private Context context;
    private ArrayList<keyStatsSingle> itemsArray;

    public MyAdapter(Context context, int resource,
                     ArrayList<keyStatsSingle> objects) {
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
