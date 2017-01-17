package ck.itheima.com.phoneplay.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.phoneplay.R;
import ck.itheima.com.phoneplay.adapter.HomeListAdapter;
import ck.itheima.com.phoneplay.base.BaseFragment;
import ck.itheima.com.phoneplay.presenter.HomePresenter;
import ck.itheima.com.phoneplay.presenter.impl.HomePersenterImpl;
import ck.itheima.com.phoneplay.view.HomeView;

/**
 * 类名:    HomeFragment
 * 创建者:  ckqu
 * 创建时间:2017/1/15 0015 下午 9:50
 * 包名:    ck.itheima.com.phoneplay.ui.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class HomeFragment extends BaseFragment implements HomeView {
    @BindView(R.id.recycler_view)
    RecyclerView       mRecyclerView;
    @BindView(R.id.swipe_home)
    SwipeRefreshLayout mSwipeHome;
    private HomeListAdapter mHomeListAdapter;


    private HomePresenter mHomePresenter;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        super.init();
        mHomePresenter = new HomePersenterImpl(this);


        //进度圈的颜色
        mSwipeHome.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        // 刷新的监听
        mSwipeHome.setOnRefreshListener(mOnRefreshListener);
        //加载更多 滑动监听
        mRecyclerView.addOnScrollListener(mOnScrollListener);

        initRecyclerView();
        //加载数据
//        loadDataList(0);
        mHomePresenter.loadDataList();

    }

    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            //判断是否是底部
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (layoutManager.findLastVisibleItemPosition() == mHomePresenter.getListData().size() - 1) {
                    //加载数据
                    mHomePresenter.loadMoreData();
                }
            }
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {


            super.onScrolled(recyclerView, dx, dy);
        }
    };


    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mHomePresenter.refresh();
        }
    };

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mHomeListAdapter = new HomeListAdapter(getContext(), mHomePresenter.getListData());
        mRecyclerView.setAdapter(mHomeListAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDataloadedSuccess() {
        mHomeListAdapter.notifyDataSetChanged();
        mSwipeHome.setRefreshing(false);//隐藏进度圈
    }
}
