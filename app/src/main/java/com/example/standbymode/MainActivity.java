package com.example.standbymode;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Getting back the ction bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Setting up Navigation Drawer
        nvDrawer = findViewById(R.id.navView);

        //Implementing a navigation drawer
        nvDrawer = findViewById(R.id.navView);

    }
    //Creating setupdrawer method
   // private void setupDrawerContent(NavigationView nvDrawer) {
    //    nvDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
         //   @Override
        //    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         //       selectDrawerItem(item);
          //      return true;
          //  }
      //  });
   // }
}