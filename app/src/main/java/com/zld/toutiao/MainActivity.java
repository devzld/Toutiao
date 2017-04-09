package com.zld.toutiao;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zld.library.base.BaseAppCompatActivity;
import com.zld.library.eventbus.EventCenter;
import com.zld.library.netstatus.NetUtils;

import butterknife.BindView;

public class MainActivity extends BaseAppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tl_main)
    TabLayout tlMain;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.nv_main)
    NavigationView nvMain;
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;


    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {
        setToolbar();
        addTab();
    }

    private void addTab() {
        tlMain.addTab(tlMain.newTab().setText("头条"));
        tlMain.addTab(tlMain.newTab().setText("国内"));
        tlMain.addTab(tlMain.newTab().setText("娱乐"));
        tlMain.addTab(tlMain.newTab().setText("体育"));
        tlMain.addTab(tlMain.newTab().setText("头条"));
        tlMain.addTab(tlMain.newTab().setText("国内"));
        tlMain.addTab(tlMain.newTab().setText("娱乐"));
        tlMain.addTab(tlMain.newTab().setText("体育"));
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //菜单按钮可用
        actionBar.setHomeButtonEnabled(true);

        //回退按钮可用
        actionBar.setDisplayHomeAsUpEnabled(true);
        //将drawerlayout和toolbar绑在一起
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,dlMain,toolbar,R.string.app_name,R.string.app_name);
        //初始化状态
        drawerToggle.syncState();
        dlMain.setDrawerListener(drawerToggle);

        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

    }

    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return false;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return null;
    }

}
