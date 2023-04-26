package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class WelcomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        TextView welcomeText = findViewById(R.id.welcomeMsgTextView);
        welcomeText.setText(getString(R.string.welcome_msg_with_name, getIntent().getExtras().getString("forename"),
                getIntent().getExtras().getString("surname")));
    }

    public void returnFromWelcomeActivity(View view){

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);


    }
}
