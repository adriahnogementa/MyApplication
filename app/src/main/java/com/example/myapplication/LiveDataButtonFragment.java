package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentWithButtonBinding;

public class LiveDataButtonFragment extends Fragment {

    private FragmentWithButtonBinding binding;
    private TextViewModel textViewModel;
    private Button button1;
    private Button button2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentWithButtonBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewModel = new ViewModelProvider(requireActivity()).get(TextViewModel.class);


        binding.firstButton.setOnClickListener(v -> {

            textViewModel.setText("Hallo ich bin der erste Knopf!");
        });

        binding.secondButton.setOnClickListener(v -> {

            textViewModel.setText("Hallo ich bin der zweite Knopf!");
        });

    }
}
