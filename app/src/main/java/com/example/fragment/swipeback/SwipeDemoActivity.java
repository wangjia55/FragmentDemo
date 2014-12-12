
package com.example.fragment.swipeback;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.RadioGroup;

import com.example.fragment.R;
import com.example.fragment.swipeback.lib.SwipeBackActivity;
import com.example.fragment.swipeback.lib.SwipeBackLayout;

/**
 * Created by Issac on 8/11/13.
 */
public class SwipeDemoActivity extends SwipeBackActivity implements View.OnClickListener {
    private static final int VIBRATE_DURATION = 1;

    private int[] mBgColors;

    private static int mBgIndex = 0;

    private String mKeyTrackingMode;

    private RadioGroup mTrackingModeGroup;

    private SwipeBackLayout mSwipeBackLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        changeActionBarColor();
        findViews();
        mKeyTrackingMode = getString(R.string.key_tracking_mode);
        mSwipeBackLayout = getSwipeBackLayout();

        mTrackingModeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int edgeFlag;
                switch (checkedId) {
                    case R.id.mode_left:
                        edgeFlag = SwipeBackLayout.EDGE_LEFT;
                        break;
                    case R.id.mode_right:
                        edgeFlag = SwipeBackLayout.EDGE_RIGHT;
                        break;
                    case R.id.mode_bottom:
                        edgeFlag = SwipeBackLayout.EDGE_BOTTOM;
                        break;
                    default:
                        edgeFlag = SwipeBackLayout.EDGE_ALL;
                }
                mSwipeBackLayout.setEdgeTrackingEnabled(edgeFlag);
                saveTrackingMode(edgeFlag);
            }
        });
        mSwipeBackLayout.addSwipeListener(new SwipeBackLayout.SwipeListener() {
            @Override
            public void onScrollStateChange(int state, float scrollPercent) {

            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
            }

            @Override
            public void onScrollOverThreshold() {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreTrackingMode();
    }

    private void saveTrackingMode(int flag) {
        PreferenceUtils.setPrefInt(getApplicationContext(), mKeyTrackingMode, flag);
    }

    private void restoreTrackingMode() {
        int flag = PreferenceUtils.getPrefInt(getApplicationContext(), mKeyTrackingMode,
                SwipeBackLayout.EDGE_LEFT);
        mSwipeBackLayout.setEdgeTrackingEnabled(flag);
        switch (flag) {
            case SwipeBackLayout.EDGE_LEFT:
                mTrackingModeGroup.check(R.id.mode_left);
                break;
            case SwipeBackLayout.EDGE_RIGHT:
                mTrackingModeGroup.check(R.id.mode_right);
                break;
            case SwipeBackLayout.EDGE_BOTTOM:
                mTrackingModeGroup.check(R.id.mode_bottom);
                break;
            case SwipeBackLayout.EDGE_ALL:
                mTrackingModeGroup.check(R.id.mode_all);
                break;
        }
    }

    private void changeActionBarColor() {
        mBgIndex++;
        if (mBgIndex >= getColors().length) {
            mBgIndex = 0;
        }
    }

    private void findViews() {
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_finish).setOnClickListener(this);
        mTrackingModeGroup = (RadioGroup) findViewById(R.id.tracking_mode);
    }

    private int[] getColors() {
        if (mBgColors == null) {
            Resources resource = getResources();
            mBgColors = new int[] {
                    resource.getColor(R.color.androidColorA),
                    resource.getColor(R.color.androidColorB),
                    resource.getColor(R.color.androidColorC),
                    resource.getColor(R.color.androidColorD),
                    resource.getColor(R.color.androidColorE),
            };
        }
        return mBgColors;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                startActivity(new Intent(SwipeDemoActivity.this, SwipeDemoActivity.class));
                break;
            case R.id.btn_finish:
                scrollToFinishActivity();
                break;
        }
    }


}
