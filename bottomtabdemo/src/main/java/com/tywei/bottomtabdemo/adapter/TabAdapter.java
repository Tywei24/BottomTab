package com.tywei.bottomtabdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Tywei on 2017/6/13.
 */

public class TabAdapter extends FragmentPagerAdapter {

    //通过构造传递过来的数据
    private List<Fragment> mFragments;

    public TabAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    //获取对应位置的Fragment
    @Override
    public Fragment getItem(int position) {
        //得到对应的fragment
        return mFragments.get(position);
    }

    //页面的数量
    @Override
    public int getCount() {
        //页面的多少，由mFragments的数量决定
        return mFragments.size();
    }
}
