package com.example.riaraschool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.nav_view)
    NavigationView nav_view;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        initNavigation();
        initHamburgerMenu();
    }

    private void initHamburgerMenu() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    private void initNavigation() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host);
        NavigationUI.setupWithNavController(nav_view, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                toggleDrawer();
                break;
            case R.id.menuExit:
                exitApp();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void exitApp() {
        new AlertDialog.Builder(this) // fluent interface
                .setIcon(R.drawable.logout)
                .setTitle(R.string.exit_app)
                .setPositiveButton(R.string.ok, (dialogInterface, i) -> finishAndRemoveTask())
                .setNegativeButton(R.string.cancel, null)
                .create()
                .show();
    }

    private void toggleDrawer(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
        }
        else{
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.host_menu, menu);
        return true;
    }
}