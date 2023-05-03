package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class MonthListFragment extends ListFragment {


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Month> list = new ArrayList<>(Arrays.asList(Month.values()));


        setListAdapter(new MonthBaseAdapter(getActivity(), list));
    }
}