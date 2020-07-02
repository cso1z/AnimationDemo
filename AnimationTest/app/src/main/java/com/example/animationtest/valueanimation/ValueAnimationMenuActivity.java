package com.example.animationtest.valueanimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.animationtest.R;
import com.example.animationtest.base.BaseActivity;

/**
 * 属性动画菜单
 * created by shenyonghui on 2020/7/1
 */
public class ValueAnimationMenuActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation_menu);
        findViewById(R.id.of_int).setOnClickListener(this);
        findViewById(R.id.of_object).setOnClickListener(this);
        findViewById(R.id.object_animation).setOnClickListener(this);
        findViewById(R.id.diy_object_animation).setOnClickListener(this);
        findViewById(R.id.demo).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
         if (id == R.id.of_int) {
            intent.setClass(ValueAnimationMenuActivity.this, OfIntAnimationActivity.class);
        }else if (id == R.id.of_object) {
            intent.setClass(ValueAnimationMenuActivity.this, ValueAnimationOfObjectActivity.class);
        }else if (id == R.id.object_animation) {
            intent.setClass(ValueAnimationMenuActivity.this, ObjectAnimationActivity.class);
        } else if (id == R.id.diy_object_animation) {
            intent.setClass(ValueAnimationMenuActivity.this, ObjectAnimationDIYViewActivity.class);
        } else if (id == R.id.demo) {
            intent.setClass(ValueAnimationMenuActivity.this, ValueAnimationActivity.class);
        }
        startActivity(intent);
    }
}
