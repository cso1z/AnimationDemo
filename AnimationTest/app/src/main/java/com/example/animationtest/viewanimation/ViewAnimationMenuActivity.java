package com.example.animationtest.viewanimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.animationtest.R;
import com.example.animationtest.base.BaseActivity;

/**
 * created by john on 2020/4/12
 */
public class ViewAnimationMenuActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        findViewById(R.id.frame).setOnClickListener(this);
        findViewById(R.id.scale).setOnClickListener(this);
        findViewById(R.id.alpha).setOnClickListener(this);
        findViewById(R.id.rotate).setOnClickListener(this);
        findViewById(R.id.translate).setOnClickListener(this);
        findViewById(R.id.set).setOnClickListener(this);
        findViewById(R.id.test_for_relative_to_parent).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.frame) {
            startActivity(new Intent(ViewAnimationMenuActivity.this, FrameAnimationActivity.class));
        } else if (id == R.id.scale) {
            startActivity(new Intent(ViewAnimationMenuActivity.this, ScaleAnimationActivity.class));
        } else if (id == R.id.alpha) {
            startActivity(new Intent(ViewAnimationMenuActivity.this, AlphaAnimationActivity.class));
        } else if (id == R.id.rotate) {
            startActivity(new Intent(ViewAnimationMenuActivity.this, RotateAnimationActivity.class));
        } else if (id == R.id.translate) {
            startActivity(new Intent(ViewAnimationMenuActivity.this, TranslateAnimationActivity.class));
        } else if (id == R.id.set) {
            startActivity(new Intent(ViewAnimationMenuActivity.this, SetAnimationActivity.class));
        } else if (id == R.id.test_for_relative_to_parent) {
            startActivity(new Intent(ViewAnimationMenuActivity.this, TestRelativeToParentActivity.class));
        }
    }
}