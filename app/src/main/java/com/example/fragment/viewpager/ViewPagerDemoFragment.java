package com.example.fragment.viewpager;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.fragment.FragmentDemo1Fragment;
import com.example.fragment.FragmentDemo2Fragment;
import com.example.fragment.FragmentDemo3Fragment;
import com.example.fragment.FragmentDemo4Fragment;
import com.example.fragment.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerDemoFragment extends Fragment {

    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;

    public static ViewPagerDemoFragment newInstance() {
        Bundle args = new Bundle();
        ViewPagerDemoFragment fragment = new ViewPagerDemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager_demo, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.radio_group);

        mViewPager.setOffscreenPageLimit(3);
        List<Fragment> list = new ArrayList<Fragment>();
        list.add(FragmentDemo1Fragment.newInstance());
        list.add(FragmentDemo2Fragment.newInstance());
        list.add(FragmentDemo3Fragment.newInstance());
        list.add(FragmentDemo4Fragment.newInstance());
        MyFragmentAdapter adapter = new MyFragmentAdapter(getFragmentManager(), list);
        mViewPager.setAdapter(adapter);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int position = -1;
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_button_tab1:
                        position = 0;
                        break;
                    case R.id.radio_button_tab2:
                        position = 1;
                        break;
                    case R.id.radio_button_tab3:
                        position = 2;
                        break;
                    case R.id.radio_button_tab4:
                        position = 3;
                        break;
                }
                mViewPager.setCurrentItem(position);
            }
        });
    }

}
