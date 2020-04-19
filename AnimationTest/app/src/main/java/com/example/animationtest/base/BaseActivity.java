package com.example.animationtest.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/**
 * Created by Garen on 2017/4/13.
 */

public class BaseActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("xx", "activity:" + getClass().getSimpleName());
    }


    public void hideNavigation() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    protected boolean showFragment(int replaceLayoutId, String tag) {
        return showFragment(replaceLayoutId, tag, new Bundle());
    }

    protected boolean showFragment(int replaceLayoutId, String tag, Bundle args) {
        return showFragment(getSupportFragmentManager(), replaceLayoutId, tag, args);
    }

    private boolean showFragment(FragmentManager fm, int replaceLayoutId, String tag, Bundle args) {
        Fragment fragment = fm.findFragmentByTag(tag);
        if (fragment != null) {
            if (args != null) {
                if (fragment.getArguments() != null) {
                    fragment.getArguments().putAll(args);
                } else {
                    fragment.setArguments(args);
                }
            }
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(replaceLayoutId, fragment);
            ft.addToBackStack(tag);
            ft.commitAllowingStateLoss();
            return true;
        } else {
            return false;
        }
    }

    protected Fragment showFragment(int replaceLayoutId, Class<? extends Fragment> fragmentClass) {
        return replace(getSupportFragmentManager(), replaceLayoutId, fragmentClass);
    }

    protected Fragment showFragment(int replaceLayoutId, Class<? extends Fragment> fragmentClass, Bundle args) {
        return replace(getSupportFragmentManager(), replaceLayoutId, fragmentClass, args);
    }

    protected Fragment replace(FragmentManager fm, int replaceLayoutId, Class<? extends Fragment> fragmentClass, Bundle args) {
        return replace(fm, fragmentClass, replaceLayoutId, fragmentClass.getSimpleName(), args);
    }

    /**
     * Fragment跳转， 将一个layout替换为新的fragment。
     */
    protected Fragment replace(FragmentManager fm, int replaceLayoutId, Class<? extends Fragment> fragmentClass) {
        return replace(fm, fragmentClass, replaceLayoutId, fragmentClass.getSimpleName(), null);
    }

    /**
     * Fragment跳转， 将一个layout替换为新的fragment。
     */
    protected Fragment replace(FragmentManager fm, Class<? extends Fragment> fragmentClass, int replaceLayoutId, String tag,
                               Bundle args) {
        Fragment fragment = (Fragment) fm.findFragmentByTag(tag);
        boolean isFragmentExist = true;
        if (fragment == null) {
            try {
                isFragmentExist = false;
                fragment = fragmentClass.newInstance();
                if (args != null) {
                    fragment.setArguments(args);
                } else {
                    fragment.setArguments(new Bundle());
                }

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            if (args != null) {
                if (fragment.getArguments() != null) {
                    fragment.getArguments().putAll(args);
                } else {
                    fragment.setArguments(args);
                }
            }
        }
        if (fragment == null)
            return null;
        if (fragment.isAdded()) {
            return fragment;
        }
        FragmentTransaction ft = fm.beginTransaction();
        if (isFragmentExist) {
            ft.replace(replaceLayoutId, fragment);
        } else {
            ft.replace(replaceLayoutId, fragment, tag);
        }

        ft.addToBackStack(tag);
        ft.commitAllowingStateLoss();
        return fragment;
    }

    protected void startActivity(Class cls) {
        startActivity(new Intent(this, cls));
    }

    @Override
    public void finish() {
        super.finish();
        Log.i("activity", getClass().getSimpleName() + " .finish()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("activity", getClass().getSimpleName() + " .onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("activity", getClass().getSimpleName() + " .onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("activity", getClass().getSimpleName() + " .onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("activity", getClass().getSimpleName() + " .onStop()");

    }

    @Override
    protected void onDestroy() {
        Log.i("activity", getClass().getSimpleName() + " .onDestroy()");
        super.onDestroy();
    }
}