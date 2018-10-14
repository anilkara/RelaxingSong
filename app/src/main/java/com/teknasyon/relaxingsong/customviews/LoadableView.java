package com.teknasyon.relaxingsong.customviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.teknasyon.relaxingsong.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anilkara on 14.10.2018.
 */

/**
 * with this view each layout has async loading ability
 * this view enable non blocking ui views
 */
public class LoadableView extends FrameLayout {

    private TextView errorTextView;
    private LinearLayout errorLayout;
    private ProgressBar progressBar;
    private FrameLayout stateFrameLayout;

    public LoadableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initArgs(context, attrs);
    }

    public LoadableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initArgs(context, attrs);
    }

    private void initArgs(Context context, AttributeSet attrs) {
        LayoutInflater.from(getContext()).inflate(R.layout.view_loadable, this, true);

        errorTextView = findViewById(R.id.tv_error_text);
        errorLayout = findViewById(R.id.ll_error_view);
        progressBar = findViewById(R.id.pb_loading);
        stateFrameLayout = findViewById(R.id.fl_loadable_state_views);
    }

    public void showLoading() {

        stateFrameLayout.setVisibility(VISIBLE);
        changeCustomViewsStateTo(GONE);
        progressBar.setVisibility(View.VISIBLE);
        errorLayout.setVisibility(GONE);
        errorTextView.setText("");
    }

    public void showContent(){
        stateFrameLayout.setVisibility(GONE);
        changeCustomViewsStateTo(VISIBLE);
    }

    public void showError(final String message) {

        changeCustomViewsStateTo(View.GONE);
        stateFrameLayout.setVisibility(VISIBLE);
        progressBar.setVisibility(View.GONE);
        errorLayout.setVisibility(VISIBLE);
        errorTextView.setText(message);
    }

    // change visibilities of child views
    private void changeCustomViewsStateTo(int visibility) {

        for (View view : getCustomViews()) {
            view.setVisibility(visibility);
        }
    }

    // return views childs
    private List<View> getCustomViews() {
        List<View> views = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (!shouldStatesViews(view)) {
                views.add(view);
            }
        }
        return views;
    }

    private boolean shouldStatesViews(View view) {
        return view.equals(stateFrameLayout);
    }

}