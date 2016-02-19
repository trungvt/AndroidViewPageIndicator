package com.trungvu.androidviewpagerindicator.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

import com.trungvu.androidviewpagerindicator.R;

/**
 * Created by TrungVT on 2/20/16.
 */
public class ViewPagerSlideFragment extends Fragment {

    private String pagerContent;

    public void setPagerContent(String content) {
        this.pagerContent = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.view_pager_slide_fragment, container, false);
        TextView content = (TextView) rootView.findViewById(R.id.view_pager_slide_content);
        content.setText(pagerContent);
        return rootView;
    }
}
