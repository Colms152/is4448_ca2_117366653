package com.example.is4448_ca2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/*
Please refer to README file in root directory for references.
All code has been created using IS4448 module material and referenced sources.
This project has been built to the requirements of the brief requirements.
Extra features and 3rd party library include:
    - Using a library for the recyclerview swipe L&R to enhance visual and functional performance.
    - Using a library to create a (line)chart to display the COVID statistics.
    - Created a splash screen.
Project at github: https://github.com/Colms152/is4448_ca2_117366653
 */

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigation;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HeroesFragment.newInstance("", ""));
        fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddHeroFragment fragment = AddHeroFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(fragment.getClass().getName()).commit();
            }
        });
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_heros:
                            openFragment(HeroesFragment.newInstance("", ""));
                            fabAdd.setVisibility(View.VISIBLE);
                            return true;
                        case R.id.navigation_covid:
                            openFragment(CovidFragment.newInstance("", ""));
                            fabAdd.setVisibility(View.GONE);
                            return true;
                    }
                    return false;
                }
            };

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}