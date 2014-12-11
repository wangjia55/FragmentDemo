package com.example.fragment.tabhost;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.widget.TabHost;

import com.example.fragment.FragmentDemo1Fragment;
import com.example.fragment.FragmentDemo2Fragment;
import com.example.fragment.FragmentDemo3Fragment;
import com.example.fragment.FragmentDemo4Fragment;
import com.example.fragment.R;

/**
 * Package : com.example.fragment
 * Author : jacob
 * Date : 14-12-11
 * Description : 这个类是用来xxx
 */
public class FragmentTabHostDemo extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host);

        FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        FragmentDemo1Fragment fragmentDemo1Fragment = FragmentDemo1Fragment.newInstance();
        FragmentDemo2Fragment fragmentDemo2Fragment = FragmentDemo2Fragment.newInstance();
        FragmentDemo3Fragment fragmentDemo3Fragment = FragmentDemo3Fragment.newInstance();
        FragmentDemo4Fragment fragmentDemo4Fragment = FragmentDemo4Fragment.newInstance();


        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("tab1").setIndicator("TAB1", null), fragmentDemo1Fragment.getClass(), null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("tab2").setIndicator("TAB2", null), fragmentDemo2Fragment.getClass(), null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("tab3").setIndicator("TAB3", null), fragmentDemo3Fragment.getClass(), null);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("tab4").setIndicator("TAB4", null), fragmentDemo4Fragment.getClass(), null);

        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                Log.e("TABChanged:---s:",s);
            }
        });
    }

}
