package com.zhengjt.floatingball.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.zhengjt.floatingball.FloatBall;

public class MainActivity extends AppCompatActivity {

    private FrameLayout flContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flContent = (FrameLayout) findViewById(R.id.fl_content);

        initBall();

        Button btnTest = (Button) findViewById(R.id.btn_test);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "button click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initBall() {
        FloatBall floatBall = new FloatBall.Builder(this)
                .setBottomMargin(90)
                .setRightMargin(90)
                .setHeight(180)
                .setWidth(180)
                .setRes(com.zhengjt.floatingball.sample.R.drawable.qipao)
                .setBall(new ImageView(this))
                .build();

        floatBall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "floating ball click", Toast.LENGTH_SHORT).show();
            }
        });

        flContent.addView(floatBall.getBall());
    }
}
