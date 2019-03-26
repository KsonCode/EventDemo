package com.kson.eventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    HorizontalViewOuter viewOuter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewOuter = findViewById(R.id.view1);

        viewOuter.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                System.out.println("ontouchlisener");
                return false;
            }
        });

        viewOuter.setClickable(true);
        viewOuter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println("onnclick");

            }
        });




    }
}
