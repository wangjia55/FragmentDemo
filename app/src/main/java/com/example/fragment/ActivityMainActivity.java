package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import com.example.fragment.tabhost.FragmentTabHostDemo;

public class ActivityMainActivity extends Activity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_tabhost).setOnClickListener(this);
        findViewById(R.id.button_slidemenu).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_tabhost:
                Intent intent = new Intent(this, FragmentTabHostDemo.class);
                startActivity(intent);
                break;
            case R.id.button_slidemenu:
                break;
        }
    }
}
