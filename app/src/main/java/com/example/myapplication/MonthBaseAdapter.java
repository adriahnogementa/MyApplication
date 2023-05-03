package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.time.Month;
import java.util.ArrayList;

public class MonthBaseAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Month> items;

    public MonthBaseAdapter(Context context, ArrayList items) {
        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_item_list,
                                                               parent, false);
        }

        Month currentMonth = (Month) getItem(position);

        TextView textView = (TextView) convertView.findViewById(R.id.monthHolder);

        textView.setText(getItem(position).toString());
        return convertView;

    }
}