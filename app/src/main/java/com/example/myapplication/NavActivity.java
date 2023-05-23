package com.example.myapplication;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.snackbar.Snackbar;

public class NavActivity extends AppCompatActivity {

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity);

        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert navHostFragment != null;
        navController = navHostFragment.getNavController();
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        Snackbar.make(findViewById(R.id.nav_host_fragment), "Für Infos drücken",
                      Snackbar.LENGTH_INDEFINITE).setAction("CLOSE", v -> {
        }).show();
        return super.onContextItemSelected(item);
    }
}
