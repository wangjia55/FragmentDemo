package com.example.fragment.pagerAndhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

import com.example.fragment.FragmentDemo1Fragment;
import com.example.fragment.FragmentDemo2Fragment;
import com.example.fragment.FragmentDemo3Fragment;
import com.example.fragment.FragmentDemo4Fragment;
import com.example.fragment.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAndHostActivity extends FragmentActivity implements
        OnPageChangeListener, OnTabChangeListener {

    private FragmentTabHost mTabHost;
    private Class fragmentArray[] = {FragmentDemo1Fragment.class,
            FragmentDemo2Fragment.class,
            FragmentDemo3Fragment.class, FragmentDemo4Fragment.class};
    private String textViewArray[] = {"TAB1", "TAB2", "TAB3", "TAB4"};
    private List<Fragment> list = new ArrayList<Fragment>();
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_layout_vp_host);

        initView();
        initPage();
    }

    /**
     * �ؼ���ʼ��
     */
    private void initView() {
        vp = (ViewPager) findViewById(R.id.pager);
        vp.setOnPageChangeListener(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.pager);
        mTabHost.setOnTabChangedListener(this);

        int count = textViewArray.length;

        for (int i = 0; i < count; i++) {
            TabSpec tabSpec = mTabHost.newTabSpec(textViewArray[i])
                    .setIndicator(textViewArray[i]);
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.setTag(i);
        }
    }

    /**
     * ��ʼ��Fragment
     */
    private void initPage() {
        FragmentDemo1Fragment fragment1 = FragmentDemo1Fragment.newInstance();
        FragmentDemo2Fragment fragment2 = FragmentDemo2Fragment.newInstance();
        FragmentDemo3Fragment fragment3 = FragmentDemo3Fragment.newInstance();
        FragmentDemo4Fragment fragment4 = FragmentDemo4Fragment.newInstance();
        list.add(fragment1);
        list.add(fragment2);
        list.add(fragment3);
        list.add(fragment4);
        vp.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), list));
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {
        TabWidget widget = mTabHost.getTabWidget();
        int oldFocusability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        mTabHost.setCurrentTab(arg0);
        widget.setDescendantFocusability(oldFocusability);
    }

    @Override
    public void onTabChanged(String tabId) {
        int position = mTabHost.getCurrentTab();
        vp.setCurrentItem(position);
    }

}
