package com.example.animationtest;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.animationtest.base.BaseActivity;
import com.example.animationtest.valueanimation.ValueAnimationMenuActivity;
import com.example.animationtest.viewanimation.ViewAnimationMenuActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text1).setOnClickListener(this);
        findViewById(R.id.text2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        switch (id) {
            case R.id.text1:
                intent.setClass(MainActivity.this, ValueAnimationMenuActivity.class);
                break;
            case R.id.text2:
                intent.setClass(MainActivity.this, ViewAnimationMenuActivity.class);
            default:
                break;
        }
        startActivity(intent);
    }
}
