package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {

    private final ActivityResultLauncher<Intent> arLauncherCreateContact =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                                      this::processCreateContactActivityResult);
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

    @Override
    protected void onResume() {
        super.onResume();

        if (getIntent().getExtras() != null) {
            inputForename.setText(getIntent().getExtras().getString("extra"));
        }
    }

    public void welcomeUser(View view) {
        Bundle bundle = new Bundle();


        Intent intent = new Intent(this, WelcomePage.class);

        bundle.putString("forename", inputForename.getText().toString());
        bundle.putString("surname", inputSurname.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);

    }

    public void addToContacts(View view) {

        createContactIntent = new Intent(ContactsContract.Intents.Insert.ACTION);
        createContactIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        createContactIntent.putExtra(ContactsContract.Intents.Insert.NAME,
                                     inputForename.getText().toString() + " " + inputSurname.getText().toString());
        createContactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,
                                     inputPhone.getText().toString());

        arLauncherCreateContact.launch(createContactIntent);

    }

    public void callIntent(View view) {
        Intent callContactIntent = new Intent(Intent.ACTION_DIAL);
        callContactIntent.setData(Uri.parse("tel:" + inputPhone.getText().toString()));
        startActivity(callContactIntent);

    }

    public void switchToFragments(View view) {
        Intent intentToFragement = new Intent(this, FragmentActivity.class);
        startActivity(intentToFragement);
    }

    public void switchToNavActivity(View view) {
        Intent intentToNav = new Intent(this, NavActivity.class);
        startActivity(intentToNav);

    }

    public void switchToPermission(View view) {
        Intent intentToPermission = new Intent(this, PermissionActivity.class);
        startActivity(intentToPermission);
    }

    public void switchToLiveData(View view) {

        Intent intentToLiveData = new Intent(this, LiveDataActivity.class);
        startActivity(intentToLiveData);

    }

    public void switchToThreadActivity(View view) {

        Intent intentToThread = new Intent(this, ThreadActivity.class);
        startActivity(intentToThread);

    }

    public void switchToApiActivity(View view) {


        Intent intentToApi = new Intent(this, ApiFragment.class);
        startActivity(intentToApi);
    }

    public void switchToDB(View view) {

        Intent intentToDB = new Intent(this, DbActivity.class);
        startActivity(intentToDB);

    }

    private void processCreateContactActivityResult(@Nullable ActivityResult activityResult) {
        View parentLayout = findViewById(android.R.id.content);

        Snackbar.make(parentLayout, Activity.RESULT_OK == activityResult.getResultCode() ?
                "Der " + "Kontakt wurde erfolgreich angelegt" : "Der Kontakt wurde nicht " +
                "angelegt!", Snackbar.LENGTH_LONG).setAction("CLOSE", view -> {
        }).show();
    }


}