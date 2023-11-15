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

        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);


        button1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstFragment = (FirstFragment) getSupportFragmentManager().findFragmentByTag("first_fragment");
                if (firstFragment ==null) {
                    firstFragment = new FirstFragment();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setReorderingAllowed(true)
                            .add(R.id.fragment_container, firstFragment, "first_fragment")
                            //.addToBackStack(null)
                            .commit();
                } else {
                    if (secondFragment !=null){
                        getSupportFragmentManager()
                                .beginTransaction()
                                .hide(secondFragment)
                                .show(firstFragment)
                                .commit();
                    } else {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .show(firstFragment)
                                .commit();
                    }
                }
            }
        }));

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentByTag("second_fragment");
                if (secondFragment == null){
                    secondFragment = new SecondFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .setReorderingAllowed(true)
                        .add(R.id.fragment_container, secondFragment, "second_fragment")
                        //.addToBackStack(null)
                        .commit();
                } else {

                    if (firstFragment !=null){
                        getSupportFragmentManager()
                                .beginTransaction()
                                .hide(firstFragment)
                                .show(secondFragment)
                                .commit();
                    } else {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .show(secondFragment)
                                .commit();
                    }
                }

            }
        });

//
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.fragment_container, firstFragment) //fragment_container => parent, firstFragment child
//                .commit();
    }




}