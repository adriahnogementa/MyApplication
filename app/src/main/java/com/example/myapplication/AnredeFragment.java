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

        if (args.getIstMann()) {

            binding.anrede.setText(getString(R.string.herr, args.getVorname(), args.getNachname()));
        }
        else if (args.getIstFrau()) {

            binding.anrede.setText(getString(R.string.frau, args.getVorname(), args.getNachname()));
        }
        else {

            binding.anrede.setText(getString(R.string.welcome_msg_with_name, args.getVorname(),
                                             args.getNachname()));

        }


        return binding.getRoot();


    }
}