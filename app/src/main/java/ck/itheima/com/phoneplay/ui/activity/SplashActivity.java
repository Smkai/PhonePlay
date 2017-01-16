package ck.itheima.com.phoneplay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.phoneplay.R;
import ck.itheima.com.phoneplay.base.BaseActivity;

/**
 * 类名:    SplashActivity
 * 创建者:  ckqu
 * 创建时间:2017/1/15 0015 下午 12:28
 * 包名:    ck.itheima.com.phoneplay.ui
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.iv_splash)
    ImageView mIvSplash;

    @Override
    public int getLayoutID() {
        return R.layout.activity_splash;
    }


    @Override
    protected void init() {
        super.init();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        mIvSplash.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                //动画
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
