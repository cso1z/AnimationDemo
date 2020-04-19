package com.example.animationtest.valueanimation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.animationtest.R;
import com.example.animationtest.base.BaseActivity;

import static android.animation.ValueAnimator.ofFloat;


/**
 * created by john on 2020/4/12
 */
public class ValueAnimationActivity extends BaseActivity {

    private ImageView imageView1;
    private ImageView imageView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);
        initUI();
        ofFloatTest();
    }

    boolean flag = false;

    private void ofFloatTest() {
        ValueAnimator animation = ofFloat(0f, 1f, 0f);
        animation.setDuration(3000);
        animation.setRepeatMode(ValueAnimator.RESTART);
        animation.setRepeatCount(-1);
        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animatedValue = (float) animation.getAnimatedValue();
                Log.e("xx", "current value:" + animatedValue);
                if (flag) {
                    imageView1.setTranslationX(animatedValue * 300);
                    imageView1.setTranslationY(animatedValue * 300);
                    imageView2.setTranslationX(-animatedValue * 300);
                    imageView2.setTranslationY(-animatedValue * 300);
                } else {
                    imageView1.setTranslationX(animatedValue * 300);
                    imageView1.setTranslationY(-animatedValue * 300);
                    imageView2.setTranslationX(-animatedValue * 300);
                    imageView2.setTranslationY(animatedValue * 300);
                }
                imageView1.setScaleX(animatedValue);
                imageView1.setScaleY(animatedValue);
                imageView2.setScaleX(animatedValue);
                imageView2.setScaleY(animatedValue);

            }
        });
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                flag = !flag;
            }
        });
        animation.start();
    }

    private void initUI() {
        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
    }
}
