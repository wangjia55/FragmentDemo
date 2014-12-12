package com.example.fragment.viewpager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.fragment.R;

/**
 * Package : com.example.fragment.viewpager
 * Author : jacob
 * Date : 14-12-11
 * Description : 这个类是用来xxx
 */
public class ViewPagerActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_demo);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, ViewPagerDemoFragment.newInstance())
                    .commit();
        }
    }


}
