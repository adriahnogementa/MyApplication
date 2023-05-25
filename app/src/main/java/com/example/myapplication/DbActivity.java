package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.DbActivityBinding;

public class DbActivity extends AppCompatActivity {

    private DbActivityBinding binding;
    private NameOpenHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DbActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        helper = new NameOpenHelper(this);

        binding.button5.setOnClickListener(v -> {

            save(binding.vornameEingabeText.getText().toString(),
                 binding.nachnameEingabeText.getText().toString());
            String test = String.valueOf(load());

            binding.textView11.setText(test);
        });

    }


    private void save(String vorname, String nachname) {

        helper.insert(vorname, nachname);


    }

    private int load() {

        return helper.selectTheSumOfEntries();

    }
}
