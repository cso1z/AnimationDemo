package com.example.animationtest.valueanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.animationtest.R;
import com.example.animationtest.base.BaseActivity;
import com.example.animationtest.valueanimation.ofobject.ColorEvaluator;
import com.example.animationtest.valueanimation.ofobject.DIYView;

/**
 * created by shenyonghui on 2020/7/2
 */
public class ObjectAnimationDIYViewActivity extends BaseActivity {

    DIYView diyView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animation_diy);
        diyView = findViewById(R.id.diy_view);
        ObjectAnimator anim = ObjectAnimator.ofObject(diyView, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        // 设置自定义View对象、背景颜色属性值 & 颜色估值器
        // 本质逻辑：
        // 步骤1：根据颜色估值器不断 改变 值
        // 步骤2：调用set（）设置背景颜色的属性值（实际上是通过画笔进行颜色设置）
        // 步骤3：调用invalidate()刷新视图，即调用onDraw（）重新绘制，从而实现动画效果
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(-1);
        anim.setDuration(3000);
        anim.start();
    }
}
