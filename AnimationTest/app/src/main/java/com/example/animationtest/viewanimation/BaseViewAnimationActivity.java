package com.example.animationtest.viewanimation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.animationtest.R;

/**
 * created by john on 2020/4/19
 */
public abstract class BaseViewAnimationActivity extends Activity {
    private ImageView imageView1;
    private Animation animation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_view_animation);
        imageView1 = findViewById(R.id.image1);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

    }

    private void startAnimation() {
        if (animation == null) {
            animation = AnimationUtils.loadAnimation(this, getViewAnimationResources());
            imageView1.setAnimation(animation);
            animation.setInterpolator(new LinearInterpolator());
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    Log.e("xx", "onAnimationStart");
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Log.e("xx", "onAnimationEnd");
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        imageView1.clearAnimation();
        imageView1.startAnimation(animation);
        animation.start();
    }

    abstract int getViewAnimationResources();
}
