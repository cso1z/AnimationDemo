package com.example.animationtest.valueanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.animationtest.R;
import com.example.animationtest.base.BaseActivity;

/**
 * created by shenyonghui on 2020/7/1
 */
public class ObjectAnimationActivity extends BaseActivity implements View.OnClickListener {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation);
        textView = findViewById(R.id.button);
        findViewById(R.id.alpha).setOnClickListener(this);
        findViewById(R.id.rotation).setOnClickListener(this);
        findViewById(R.id.translationX).setOnClickListener(this);
        findViewById(R.id.scaleX).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.alpha) {
            changeAlpha();
        } else if (id == R.id.rotation) {
            changeRotation();
        } else if (id == R.id.translationX) {
            changeTranslationX();
        } else if (id == R.id.scaleX) {
            changeScaleX();
        }
    }

    private void changeAlpha() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
        // 表示的是:
        // 动画作用对象是mButton
        // 动画作用的对象的属性是透明度alpha
        // 动画效果是:常规 - 全透明 - 常规
        animator.setDuration(5000);
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }

    private void changeRotation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);

        // 表示的是:
        // 动画作用对象是mButton
        // 动画作用的对象的属性是旋转alpha
        // 动画效果是:0 - 360
        animator.setDuration(5000);
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();
    }

    private void changeTranslationX() {

        float curTranslationX = textView.getTranslationX();
        // 获得当前按钮的位置
        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "translationX", curTranslationX, 500, curTranslationX, curTranslationX + curTranslationX - 500, curTranslationX);


        // 表示的是:
        // 动画作用对象是mButton
        // 动画作用的对象的属性是X轴平移（在Y轴上平移同理，采用属性"translationY"
        // 动画效果是:从当前位置平移到 x=1500 再平移到初始位置
        animator.setDuration(5000);
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();

    }

    private void changeScaleX() {

        ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "scaleX", 1f, 1.5f, 1f, 1.5f, 1);
        // 表示的是:
        // 动画作用对象是mButton
        // 动画作用的对象的属性是X轴缩放
        // 动画效果是:放大到3倍,再缩小到初始大小
        animator.setDuration(5000);
        animator.setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();

    }
}
