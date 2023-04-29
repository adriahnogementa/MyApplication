package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentAnredeBinding;


public class AnredeFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentAnredeBinding binding = FragmentAnredeBinding.inflate(inflater);
        assert getArguments() != null;
        AnredeFragmentArgs args = AnredeFragmentArgs.fromBundle(getArguments());
        binding.anrede.setText(args.getVorname() + args.getNachname());
        return binding.getRoot();


    }
}