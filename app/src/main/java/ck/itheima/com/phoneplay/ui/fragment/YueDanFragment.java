package ck.itheima.com.phoneplay.ui.fragment;

import android.support.v7.widget.RecyclerView;

import ck.itheima.com.phoneplay.adapter.YueDanAdapter;
import ck.itheima.com.phoneplay.base.BaseListFragment;
import ck.itheima.com.phoneplay.presenter.BaseListPresenter;
import ck.itheima.com.phoneplay.presenter.impl.YueDanPersenterImpl;
import ck.itheima.com.phoneplay.view.BaseListView;

/**
 * 类名:    HomeFragment
 * 创建者:  ckqu
 * 创建时间:2017/1/15 0015 下午 9:50
 * 包名:    ck.itheima.com.phoneplay.ui.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class YueDanFragment extends BaseListFragment {

    private BaseListPresenter mBaseListPresenter;

    @Override
    public BaseListPresenter getPresenter(BaseListView baseListView) {
        mBaseListPresenter = new YueDanPersenterImpl(baseListView);
        return mBaseListPresenter;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return new YueDanAdapter(mBaseListPresenter.getListData(),getContext());
    }
}
