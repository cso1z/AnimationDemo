package com.example.animationtest.valueanimation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.animationtest.R;
import com.example.animationtest.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static android.animation.ValueAnimator.ofInt;


/**
 * created by john on 2020/4/12
 */
public class OfIntAnimationActivity extends BaseActivity implements View.OnClickListener {


    private TextView scrollView;
    private TextView valueText;
    private TextView lifeText;

    private ValueAnimator animation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_of_int_animation);
        initUI();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.start) {
            ofIntTest();
        } else if (id == R.id.end) {
            stop();
        }
    }

    private void stop() {
        if (animation != null) {
            animation.cancel();
        }
    }

    private void ofIntTest() {
        final int height = scrollView.getMeasuredHeight();
        if (animation == null) {
            animation = ValueAnimator.ofInt(0, 100);
            animation.setDuration(3000);
            animation.setRepeatMode(ValueAnimator.RESTART);
            animation.setRepeatCount(-1);
            animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) scrollView.getLayoutParams();
                    layoutParams.bottomMargin = (int) (((int) animation.getAnimatedValue() / 100.0) * height * 2);
                    scrollView.requestLayout();
                    setValueText(String.valueOf((int) animation.getAnimatedValue()));
                }
            });
            animation.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    setLifeText("Start");
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    setLifeText("End");
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    setLifeText("Cancel");
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    setLifeText("Repeat");
                }
            });
        }
        animation.start();
    }

    private StringBuffer valueStr;
    private List<String> valueList;

    private void setValueText(String str) {
        if (valueStr == null) {
            valueStr = new StringBuffer();
        } else {
            valueStr.setLength(0);
        }
        if (valueList == null) {
            valueList = new ArrayList<>(30);
        }
        if (valueList.size() >= 20) {
            valueList.remove(0);
        }
        valueList.add(str);
        for (String s : valueList) {
            valueStr.append(s).append("\n");
        }
        valueText.setText(valueStr);
    }

    private void setLifeText(String str) {
        String text = lifeText.getText().toString();
        text = text + "\n" + str;
        lifeText.setText(text);
    }

    private void initUI() {
        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.end).setOnClickListener(this);
        scrollView = findViewById(R.id.scroll_text);
        valueText = findViewById(R.id.value_view);
        valueText.setMovementMethod(ScrollingMovementMethod.getInstance());
        lifeText = findViewById(R.id.life_view);
    }
}
