package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.myapplication.databinding.ThreadActivityBinding;

public class FibonacciService extends Service {
    public ThreadActivityBinding binding;
    public Thread thread;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int n = intent.getIntExtra("input", 2);
        //binding = ThreadActivityBinding.inflate());
        thread = new Thread(() -> {

            String fibo = String.valueOf(calculateFibonacci(n));
            Log.d(fibo, fibo);

        });
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private int calculateFibonacci(int n) {
        if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }

        return n;
    }
}
