package ck.itheima.com.phoneplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 类名:    BaseFragment
 * 创建者:  ckqu
 * 创建时间:2017/1/15 0015 下午 12:24
 * 包名:    ck.itheima.com.phoneplay.base
 * 更新者:  $Author$ $Date$
 * 描述:    Fragment的基类
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), null);
        ButterKnife.bind(this,view);
        init();
        return view;
    }

    private void init() {
    }

    public abstract int getLayoutID();
}
