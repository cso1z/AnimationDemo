package com.example.animationtest.viewanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.animationtest.R;

/**
 * 帧动画（Frame Animation）
 * created by john on 2020/4/19
 */
public class FrameAnimationActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        ImageView imageView = findViewById(R.id.image);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }
}
