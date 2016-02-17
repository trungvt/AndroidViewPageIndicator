package com.trungvu.androidviewpagerindicator.component;

import android.widget.LinearLayout;
import android.widget.ImageView;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.trungvu.androidviewpagerindicator.R;

/**
 * Created by TrungVT on 2/18/16.
 */
public class ViewPagerIndicator extends LinearLayout {

    private Context mContext;
    private LinearLayout mRootView;
    private int mNormalResourceId, mSelectedResourceId;
    private ImageView[] mIndicators;
    private int mCurrentIndicatorPosition;

    public ViewPagerIndicator(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    public ViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ViewPagerIndicator(Context context) {
        super(context);
        initView(context);
    }
    /**
     * Initialize this ViewPagerIndicator
     * @param context
     */
    protected void initView(Context context) {
        mContext = context;
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.view_page_indicator, this, true);
        mRootView = (LinearLayout) findViewById(R.id.view_pager_indicator_container);
    }
    /**
     * Initialize the image of an element depends on indicator status (normal/selected)
     * @param normalResourceId
     * @param selectedResourceId
     */
    public void setIndicatorResource(int normalResourceId, int selectedResourceId) {
        mNormalResourceId = normalResourceId;
        mSelectedResourceId = selectedResourceId;
    }
    /**
     * Initialize the Indicator elements
     * @param count number of elements
     * @param layoutParams of each element
     */
    public void setIndicators(int count, LayoutParams layoutParams) {
        mIndicators = new ImageView[count];
        for (int i = 1; i <= count; i++) {
            ImageView indicator = new ImageView(mContext);
            indicator.setId(i);
            if (layoutParams != null) {
                layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.layout_margin_low);
                layoutParams.rightMargin = (int) getResources().getDimension(R.dimen.layout_margin_low);
                indicator.setLayoutParams(layoutParams);
            }
            if (i == 1) {
                indicator.setImageResource(mSelectedResourceId);
            } else {
                indicator.setImageResource(mNormalResourceId);
            }
            mIndicators[i - 1] = indicator;
            mRootView.addView(indicator);
        }
        mCurrentIndicatorPosition = 0;
    }
    /**
     * Set the current indicator
     * @param currentPosition
     */
    public void setCurrentIndicator(int currentPosition) {
        ImageView oldIndicator = (ImageView) mRootView.getChildAt(mCurrentIndicatorPosition);
        if (oldIndicator != null) {
            oldIndicator.setImageResource(mNormalResourceId);
        }
        ImageView newIndicator = (ImageView) mRootView.getChildAt(currentPosition);
        if (newIndicator != null) {
            newIndicator.setImageResource(mSelectedResourceId);
            mCurrentIndicatorPosition = currentPosition;
        }
    }

    public void reset() {
        mIndicators = null;
        mRootView.removeAllViews();
    }
}
