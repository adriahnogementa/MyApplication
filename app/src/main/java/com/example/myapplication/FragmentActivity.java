package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentTransaction;

public class FragmentActivity extends androidx.fragment.app.FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        Button add = findViewById(R.id.add);
        add.setOnClickListener(v -> addTextAsFragment());
    }

    public void addTextAsFragment() {
        TextView textView = findViewById(R.id.textViewFragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_list,
                        OutputFragment.newInstance(textView.getText().toString()));
        transaction.addToBackStack(null);
        transaction.commit();


    }

}
