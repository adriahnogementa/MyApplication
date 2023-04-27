package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PermissionActivity extends AppCompatActivity {

    private static final String PERMISSION = Manifest.permission.READ_PHONE_NUMBERS;
    private static final int REQUEST_CODE = 12345;
    private TextView info;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_activity);

        this.info = findViewById(R.id.textViewPermission);
        this.button = findViewById(R.id.buttonPermission);

        this.button.setOnClickListener(v -> requestPermissions(
                new String[]{PERMISSION}, REQUEST_CODE)
        );

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (PackageManager.PERMISSION_GRANTED == checkSelfPermission(PERMISSION)) {

            info.setText("Berechtigung erteilt");
            button.setVisibility(View.GONE);
        }
        else {

            if (shouldShowRequestPermissionRationale(PERMISSION)) {

                info.setText("Berechtigung bitte manuell erteilen.");
            }
            else {

                requestPermissions(new String[]{PERMISSION}, REQUEST_CODE);

            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (REQUEST_CODE == requestCode) {

            if (PackageManager.PERMISSION_GRANTED == grantResults[0]) {

                info.setText("Berechtigung erteilt!");
                button.setVisibility(View.GONE);

            }
            else {

                info.setText("Berechtigung nicht erteilt.");
            }
        }
    }
}
