package com.muzi.addview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by muzi on 2018/1/4.
 * 727784430@qq.com
 */

public class EmptyActivity extends AppCompatActivity {

    protected Context context;
    private View view404, view;
    private FrameLayout container;
    private Button btnRefresh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(getContainer());
        view = LayoutInflater.from(this).inflate(layoutResID, null);
        container.addView(view, 0);
    }

    private View getContainer() {
        container = new FrameLayout(this);
        view404 = LayoutInflater.from(this).inflate(R.layout.view_404, null, false);
        btnRefresh = view404.findViewById(R.id.btn_404_refresh);
        container.addView(view404);
        return container;
    }

    /**
     * 设置404显示状态
     *
     * @param visiable
     */
    protected void set404Visiable(boolean visiable) {
        if (visiable) {
            view404.setVisibility(View.VISIBLE);
        } else {
            view404.setVisibility(View.GONE);
        }
    }

    /**
     * 404刷新数据回调
     *
     * @param listener
     */
    protected void setRefreshListener(View.OnClickListener listener) {
        btnRefresh.setOnClickListener(listener);
    }

}
