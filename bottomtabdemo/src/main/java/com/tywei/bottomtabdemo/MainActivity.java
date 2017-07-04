package com.tywei.bottomtabdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.tywei.bottomtabdemo.adapter.TabAdapter;
import com.tywei.bottomtabdemo.fragment.GovaffairsTabFragment;
import com.tywei.bottomtabdemo.fragment.HomeTabFragment;
import com.tywei.bottomtabdemo.fragment.NewsCenterTabFragment;
import com.tywei.bottomtabdemo.fragment.SettingTabFragment;
import com.tywei.bottomtabdemo.fragment.SmartServiceTabFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager mVp;

    private List<Fragment> mFragments;
    private RadioButton mRb_home;
    private RadioButton mRb_newscenter;
    private RadioButton mRb_smartservice;
    private RadioButton mRb_govaffairs;
    private RadioButton mRb_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initVP();

        initSlidingMenu();
    }

    /**
     * 初始化侧滑菜单
     */
    private void initSlidingMenu() {
        //创建侧滑菜单
        SlidingMenu slidingmenu = new SlidingMenu(this);
        //设置菜单从左边滑出
        slidingmenu.setMode(SlidingMenu.LEFT);
        //设置全屏可以(拉动)滑出菜单
        slidingmenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置侧滑菜单的宽度
        slidingmenu.setBehindWidth(380);
        //把侧滑菜单附加在Activity里面
        slidingmenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //设置侧滑菜单的布局
        slidingmenu.setMenu(R.layout.main_menu);
    }

    //初始化控件
    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        //要想使底部Tab和ViewPager进行切换，需要给RadioGroup进行监听
        RadioGroup rg_tab = (RadioGroup) findViewById(R.id.rg_tab);
        //设置选择改变监听
        rg_tab.setOnCheckedChangeListener(this);

        mRb_home = (RadioButton) findViewById(R.id.rb_home);
        mRb_newscenter = (RadioButton) findViewById(R.id.rb_newscenter);
        mRb_smartservice = (RadioButton) findViewById(R.id.rb_smartservice);
        mRb_govaffairs = (RadioButton) findViewById(R.id.rb_govaffairs);
        mRb_setting = (RadioButton) findViewById(R.id.rb_setting);

    }

    //初始化ViewPager
    private void initVP() {
        mFragments = new ArrayList<>();

        mFragments.add(new HomeTabFragment());
        mFragments.add(new NewsCenterTabFragment());
        mFragments.add(new SmartServiceTabFragment());
        mFragments.add(new GovaffairsTabFragment());
        mFragments.add(new SettingTabFragment());

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), mFragments);
        mVp.setAdapter(adapter);

        //给ViewPager设置页面滑动改变的监听
        mVp.addOnPageChangeListener(this);

    }

    //(RadioGroup.OnCheckedChangeListener的重写方法)当点击RadioGroup时候会触发这个方法,此时checkedId就是RadioButton的id
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int item = 0;
        switch (checkedId) {
            case R.id.rb_home:
                item = 0;
                break;
            case R.id.rb_newscenter:
                item = 1;
                break;
            case R.id.rb_smartservice:
                item = 2;
                break;
            case R.id.rb_govaffairs:
                item = 3;
                break;
            case R.id.rb_setting:
                item = 4;
                break;
        }

        //ViewPager切换到对应的页面,false不需要ViewPager页面切换的时候有滑动的动画
        mVp.setCurrentItem(item, false);
    }


    /**
     * (ViewPager.OnPageChangeListener的三个重写的方法)
     *
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 当滑动页面选中的时候，此时要把对应的RadioButton给选中
     *
     * @param position 对应的哪一个页面
     */
    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mRb_home.setChecked(true);
                break;
            case 1:
                mRb_newscenter.setChecked(true);
                break;
            case 2:
                mRb_smartservice.setChecked(true);
                break;
            case 3:
                mRb_govaffairs.setChecked(true);
                break;
            case 4:
                mRb_setting.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
