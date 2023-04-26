package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.provider.ContactsContract;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.widget.EditText;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {

    EditText inputForename;
    EditText inputSurname;
    EditText inputPhone;
    Intent createContactIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputForename = findViewById(R.id.forenameEditText);
        inputSurname = findViewById(R.id.surnameEditText);
        inputPhone = findViewById(R.id.editTextPhone);
    }

        public void welcomeUser(View view){
            Bundle bundle = new Bundle();



            Intent intent = new Intent(this, WelcomePage.class);

            bundle.putString("forename",inputForename.getText().toString());
            bundle.putString("surname", inputSurname.getText().toString());

            intent.putExtras(bundle);

            startActivity(intent);

        }

        public void addToContacts(View view ){

        createContactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
        createContactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        createContactIntent.putExtra(ContactsContract.Intents.Insert.NAME,
                inputForename.getText().toString()+" "+inputSurname.getText().toString());
        createContactIntent.putExtra(ContactsContract.Intents.Insert.PHONE, inputPhone.getText().toString());

        arLauncherCreateContact.launch(createContactIntent);

        }

        private final ActivityResultLauncher<Intent> arLauncherCreateContact =
                registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                        this::processCreateContactActivityResult);

    public void callIntent(View view){
        Intent callContactIntent = new Intent(Intent.ACTION_DIAL);
        callContactIntent.setData(Uri.parse("tel:" + inputPhone.getText().toString()));
        startActivity(callContactIntent);

    }

    public void switchToFragments(View view){
        Intent intentToFragement = new Intent(this, FragmentActivity.class);
        startActivity(intentToFragement);
    }

    public void switchToPermission(View view){
        Intent intentToPermission = new Intent(this, PermissionActivity.class);
        startActivity(intentToPermission);
    }

    private void processCreateContactActivityResult(@Nullable ActivityResult activityResult) {
        View parentLayout = findViewById(android.R.id.content);

    Snackbar.make(parentLayout, Activity.RESULT_OK == activityResult.getResultCode() ?
            "Der Kontakt wurde erfolgreich angelegt" : "Der Kontakt wurde nicht angelegt!", Snackbar.LENGTH_LONG)
            .setAction("CLOSE", view -> {
            })
            .show();
    }

}