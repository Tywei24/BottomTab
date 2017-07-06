package com.tywei.fxzhbj.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.tywei.fxzhbj.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @BindView(R.id.splash_iv_horse)
    ImageView mSplashIvHorse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        //初始化控件
        //initView();
    }

    private void initView() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animator = new ObjectAnimator();
                animator.ofFloat(mSplashIvHorse, "rotationZ", 0, 90, 180, 360, 0);
                animator.setDuration(3000);
                animator.start();
            }
        }, 3000);
    }
}
