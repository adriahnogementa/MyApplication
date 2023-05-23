package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.FragmentApiBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFragment extends AppCompatActivity {

    FragmentApiBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentApiBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.apiCall.setOnClickListener(v -> {
            new Thread(this::getCurrentUSDEUROExchangeRate).start();
        });

    }

    private void getCurrentUSDEUROExchangeRate() {

        try {
            HttpURLConnection con = (HttpURLConnection) new URL(
                    "https://api.frankfurter.app/latest?from=USD"
            ).openConnection();
            System.setProperty("http.keepAlive", "false");
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK)
                return;
            StringBuilder builder = new StringBuilder();
            new BufferedReader(new InputStreamReader(con.getInputStream())).lines().forEach(builder::append);
            con.disconnect();

            JSONObject json = new JSONObject(builder.toString());

            runOnUiThread(() -> {

                binding.apiCallText.setText(json.toString());

            });

        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }

    }
}
