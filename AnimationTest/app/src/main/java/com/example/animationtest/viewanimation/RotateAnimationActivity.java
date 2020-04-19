package com.example.animationtest.viewanimation;

import android.os.Bundle;
import android.view.animation.RotateAnimation;

import androidx.annotation.Nullable;

import com.example.animationtest.R;

/**
 * 旋转
 * created by john on 2020/4/19
 */
public class RotateAnimationActivity extends BaseViewAnimationActivity {
    @Override
    int getViewAnimationResources() {
        return R.anim.rotate;
    }


}
