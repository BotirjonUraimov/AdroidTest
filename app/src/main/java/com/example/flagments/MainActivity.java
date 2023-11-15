package com.example.flagments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);


        button1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, firstFragment)
                        .addToBackStack(null)
                        .commit();
            }
        }));

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, secondFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });

//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.fragment_container, firstFragment) //fragment_container => parent, firstFragment child
//                .commit();
    }




}