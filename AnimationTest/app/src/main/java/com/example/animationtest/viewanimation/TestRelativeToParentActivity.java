package com.example.animationtest.viewanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.animationtest.R;

/**
 * RELATIVE_TO_PARENT 测试
 * created by john on 2020/4/19
 */
public class TestRelativeToParentActivity extends Activity {
    TranslateAnimation translateAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_relative_to_parent);
        final ImageView imageView = findViewById(R.id.image1);
        translateAnimation =
                new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.5f);
        translateAnimation.setDuration(4000);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.clearAnimation();
                imageView.setAnimation(translateAnimation);
                translateAnimation.start();
            }
        });
    }
}
