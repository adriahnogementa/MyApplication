package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentTextBinding;
import com.example.myapplication.databinding.LivedataActivityBinding;

public class LiveDataActivity extends AppCompatActivity {

    private LivedataActivityBinding binding;
    private FragmentTextBinding fragmentTextBinding;

    private TextViewModel textViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LivedataActivityBinding.inflate(getLayoutInflater());
        fragmentTextBinding = FragmentTextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Fragen an den Meister: Dieses this impliziert, dass diese Klasse "LiveDataActivity" ist
        // der Observer?
        textViewModel = new ViewModelProvider(this).get(TextViewModel.class);

        fragmentTextBinding.liveDataText.setText("Moin");

    }
}
