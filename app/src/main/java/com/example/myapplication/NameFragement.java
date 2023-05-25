package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class NameFragement extends ListFragment {


    private NameAdapter adapter;
    private NameOpenHelper helper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new NameAdapter(getContext());
        helper = new NameOpenHelper(getContext());
        setListAdapter(adapter);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter.changeCursor(helper.selectAll());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        helper.close();
    }
}
