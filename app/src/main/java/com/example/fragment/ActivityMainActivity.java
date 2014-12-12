package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.example.fragment.pagerAndhost.ViewPagerAndHostActivity;
import com.example.fragment.slideActivity.SlideMainActivity;
import com.example.fragment.tabhost.FragmentTabHostDemo;
import com.example.fragment.viewpager.ViewPagerActivity;

public class ActivityMainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_tabhost).setOnClickListener(this);
        findViewById(R.id.button_slidemenu).setOnClickListener(this);
        findViewById(R.id.button_vp_host).setOnClickListener(this);
        findViewById(R.id.button_view_pager).setOnClickListener(this);
        findViewById(R.id.button_slide_main).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_tabhost: {
                Intent intent = new Intent(this, FragmentTabHostDemo.class);
                startActivity(intent);
            }
            break;
            case R.id.button_vp_host: {
                Intent intent = new Intent(this, ViewPagerAndHostActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.button_view_pager: {
                Intent intent = new Intent(this, ViewPagerActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.button_slide_main: {
                Intent intent = new Intent(this, SlideMainActivity.class);
                startActivity(intent);
            }
            break;

            case R.id.button_slidemenu:
                break;
        }
    }
}
