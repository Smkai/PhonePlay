package ck.itheima.com.phoneplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 类名:    BaseActivity
 * 创建者:  ckqu
 * 创建时间:2017/1/15 0015 下午 12:15
 * 包名:    ck.itheima.com.phoneplay.base
 * 更新者:  $Author$ $Date$
 * 描述:    activity的基类
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        ButterKnife.bind(this);
        init();//初始化操作
    }

    private void init() {

    }

    public abstract int getLayoutID();


}
