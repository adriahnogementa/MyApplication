package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentStartBinding.inflate(inflater);
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        binding.zuAnredeFragment.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(StartFragmentDirections.actionStartFragmentToAnredeFragment(
                    binding.vorname.getText().toString(), binding.nachname.getText().toString()
            ));
        });

        return binding.getRoot();
    }

}