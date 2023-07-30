package com.example.standbymode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.example.standbymode.BackgroundImages.BackgroundImg;
import com.example.standbymode.ClockStyle.Clocks;
import com.example.standbymode.PaidClocks.PaidClocks;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    //adding diff animation to nav bar
    private static final float END_SCALE = 0.7f;

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private View linearLayoutView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Getting back the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up Navigation Drawer
        drawerLayout = findViewById(R.id.appdrawerlayout);

        //Adding button on toolbar
        drawerToggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout, R.string.nav_open,R.string.nav_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //Implementing a navigation drawer
        navigationDrawer = findViewById(R.id.navView);
        setupDrawerContent(navigationDrawer);

        //Adding linearlayout view
        linearLayoutView = findViewById(R.id.linearLayout);

    }

    //Overriding a method
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    //Creating the setup drawer method
    private void setupDrawerContent(NavigationView navigationDrawer) {
        navigationDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectDrawerItem(item);
                return true;
            }
        });
    }

    //This will create a new fragment and specify the fragment to show by default
    private void selectDrawerItem(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass;

        if (item.getItemId() == R.id.view_clockstyle) {
            fragmentClass = Clocks.class;
        } else if (item.getItemId() == R.id.view_background) {
            fragmentClass = BackgroundImg.class;
        } else if (item.getItemId() == R.id.view_premiumclocks) {
            fragmentClass = PaidClocks.class;
        } else {
            fragmentClass = Clocks.class;
        }


        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        //Inserting fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();

        item.setChecked(true);
        setTitle(item.getTitle());
        drawerLayout.closeDrawers();

    }
}