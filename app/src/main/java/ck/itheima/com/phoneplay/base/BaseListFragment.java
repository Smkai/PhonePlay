package ck.itheima.com.phoneplay.base;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import butterknife.BindView;
import ck.itheima.com.phoneplay.R;
import ck.itheima.com.phoneplay.presenter.BaseListPresenter;
import ck.itheima.com.phoneplay.view.BaseListView;

/**
 * 类名:    BaseListFragment
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 7:37
 * 包名:    ck.itheima.com.phoneplay.base
 * 更新者:  $Author$ $Date$
 * 描述:    抽取公共的布局
 */

public abstract class BaseListFragment extends BaseFragment implements BaseListView {
    @BindView(R.id.recycler_view)
    RecyclerView       mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private BaseListPresenter mBaseListPresenter;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_base_list;
    }

    @Override
    protected void init() {
        super.init();
        //初始化presenter

        mBaseListPresenter = getPresenter(this);

        //进度圈的颜色
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        //刷新的回调
        mSwipeRefreshLayout.setOnRefreshListener(mOnRefreshListener);

        //初始化recylerView
        initRecyclerView();

        //加载数据
        mBaseListPresenter.loadDataList();

    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //设置适配器
        mRecyclerView.setAdapter(getAdapter());

        mRecyclerView.addOnScrollListener(mOnScrollListener);

    }


       /*----------------------------刷新的监听------------------------------*/


    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mBaseListPresenter.refresh();//下拉刷新
        }
    };

        /*----------------------------滚动的监听------------------------------*/


    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

            if (newState == RecyclerView.SCROLL_STATE_IDLE) {//判断是否是底部
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (layoutManager.findLastVisibleItemPosition() == mBaseListPresenter.getListData().size() - 1) {

                    mBaseListPresenter.loadMoreData(); //加载更多
                }
            }
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {


            super.onScrolled(recyclerView, dx, dy);
        }
    };

    @Override
    public void onDataloadedSuccess() {//成功的回调
        Toast.makeText(getContext(), "数据加载成功", Toast.LENGTH_SHORT).show();
        mRecyclerView.getAdapter().notifyDataSetChanged(); //刷新界面
        mSwipeRefreshLayout.setRefreshing(false);//隐藏刷新头
    }

    @Override
    public void onDataLoadFailde() {//失败的回调
        Toast.makeText(getContext(), "数据加载失败", Toast.LENGTH_SHORT).show();
    }

    public abstract BaseListPresenter getPresenter(BaseListView baseListView);//子类返回各自的presenter

    public abstract RecyclerView.Adapter getAdapter();//子类来实现这个方法

}
