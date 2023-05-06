package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.LivedataActivityBinding;

public class LiveDataActivity extends AppCompatActivity {

    private LivedataActivityBinding binding;
    private TextViewModel textViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LivedataActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        textViewModel = new ViewModelProvider(this).get(TextViewModel.class);

        
    }
}
