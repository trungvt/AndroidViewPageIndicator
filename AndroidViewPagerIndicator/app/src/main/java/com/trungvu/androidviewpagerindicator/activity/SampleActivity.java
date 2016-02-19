package com.trungvu.androidviewpagerindicator.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.trungvu.androidviewpagerindicator.R;
import com.trungvu.androidviewpagerindicator.component.ViewPagerIndicator;
import com.trungvu.androidviewpagerindicator.fragment.ViewPagerSlideFragment;

/**
 * Created by TrungVT on 2/18/16.
 */
public class SampleActivity extends FragmentActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 3;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    /**
     * View pager indicator
     */
    private ViewPagerIndicator mIndicator;

    @Deprecated
    @Override
    public void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sample_activity);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.main_view_pager);
        mPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                mIndicator.setCurrentIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });

        // Indicator
        mIndicator = (ViewPagerIndicator) findViewById(R.id.header_view_pager_indicator);
        mIndicator.reset();
        mIndicator.setIndicatorResource(R.drawable.indicator_bg_normal, R.drawable.indicator_bg_selected);
        mIndicator.setIndicators(NUM_PAGES, null);
        mIndicator.setVisibility(View.VISIBLE);
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ViewPagerSlideFragment fragment = new ViewPagerSlideFragment();
            fragment.setPagerContent("Test view pager - " + (position + 1));
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
