package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ThreadActivityBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThreadActivity extends AppCompatActivity {

    public ThreadActivityBinding binding;
    private volatile boolean running;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ThreadActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = new Intent(this,
                                   FibonacciService.class);
        Integer n = Integer.getInteger(binding.editTextNumber.getText().toString());

        intent.putExtra("input", n.intValue());
        Log.d("tag", "1234");
        binding.button3.setOnClickListener(v -> {
            startService(intent);
        });

    }

    private void showTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        while (running) {
            String date = dateFormat.format(Calendar.getInstance().getTime());
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(() -> {
                binding.textView4.setText(date);
            });
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        this.running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.running = true;
        new Thread(this::showTime).start();

    }

}
