package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class NameAdapter extends CursorAdapter {

    private LayoutInflater inflater;

    public NameAdapter(Context context) {
        super(context, null, 0);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return inflater.inflate(R.layout.fragment_name, null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView idTextview = view.findViewById(R.id.idNummer);
        TextView nameTextview = view.findViewById(R.id.nachnameListe);

        idTextview.setText(cursor.getString(0));
        nameTextview.setText(String.format("%s %s", cursor.getString(1).toString(),
                                           cursor.getString(2).toString()));
    }
}
