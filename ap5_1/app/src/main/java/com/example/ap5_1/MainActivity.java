package com.example.ap5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MenuFragment menuFragment;
    MainFragment mainFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }

    public  void onFragmentChaged(int idx){
        if(idx == 0 )
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    menuFragment).commit();
        else getSupportFragmentManager().beginTransaction().replace(R.id.container,
                mainFragment).commit();
    }
}