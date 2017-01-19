package ck.itheima.com.phoneplay.presenter.impl;

import android.os.Handler;

import com.google.gson.Gson;
import com.itheima.leon.funhttplib.NetworkListener;

import java.util.ArrayList;
import java.util.List;

import ck.itheima.com.phoneplay.beans.HomeListItemBean;
import ck.itheima.com.phoneplay.network.HomeRequest;
import ck.itheima.com.phoneplay.presenter.BaseListPresenter;
import ck.itheima.com.phoneplay.utils.URLProviderUtil;
import ck.itheima.com.phoneplay.view.BaseListView;

/**
 * 类名:    HomePersenterImpl
 * 创建者:  ckqu
 * 创建时间:2017/1/17 0017 下午 3:51
 * 包名:    ck.itheima.com.phoneplay.presenter.impl
 * 更新者:  $Author$ $Date$
 * 描述:    homePresenter接口的实现类
 */

public class HomePersenterImpl implements BaseListPresenter {
    public  List<HomeListItemBean> mlist;
    private Gson                   mGson;
    private Handler                mHandler;
    private BaseListView           mHomeView;

    public HomePersenterImpl(BaseListView homeView) {
        mHomeView =  homeView;
        mlist = new ArrayList<>();
        mGson = new Gson();
        mHandler = new Handler();
    }

    @Override
    public void loadDataList() {
        loadDataList(0);
    }

    @Override
    public void refresh() {
        mlist.clear();//清空集合
        loadDataList(0);//从新加载
    }

    @Override
    public void loadMoreData() {
        loadDataList(mlist.size());
    }

    @Override
    public List<HomeListItemBean> getListData() {
        return mlist;
    }
/*----------------------------数据加载------------------------------*/
    private void loadDataList(int offset) {
        String url = URLProviderUtil.getHomeUrl(offset, 10);
        new HomeRequest(url, mListNetworkListener).execute();
    }

    private NetworkListener<List<HomeListItemBean>> mListNetworkListener = new
            NetworkListener<List<HomeListItemBean>>() {


        @Override
        public void onFailed(String s) {

        }

        @Override
        public void onSuccess(List<HomeListItemBean> homeListItemBeen) {
            mlist.addAll(homeListItemBeen);
            //刷新界面和隐藏进度圈
            mHomeView.onDataloadedSuccess();

        }
    };

}
