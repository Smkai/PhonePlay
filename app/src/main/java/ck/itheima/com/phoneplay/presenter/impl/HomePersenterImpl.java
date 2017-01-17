package ck.itheima.com.phoneplay.presenter.impl;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ck.itheima.com.phoneplay.beans.HomeListItemBean;
import ck.itheima.com.phoneplay.presenter.HomePresenter;
import ck.itheima.com.phoneplay.utils.URLProviderUtil;
import ck.itheima.com.phoneplay.view.HomeView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类名:    HomePersenterImpl
 * 创建者:  ckqu
 * 创建时间:2017/1/17 0017 下午 3:51
 * 包名:    ck.itheima.com.phoneplay.presenter.impl
 * 更新者:  $Author$ $Date$
 * 描述:    homePresenter接口的实现类
 */

public class HomePersenterImpl implements HomePresenter {
    public  List<HomeListItemBean> mlist;
    private Gson                   mGson;
    private Handler mHandler;
    private HomeView mHomeView;

    public HomePersenterImpl(HomeView homeView) {
        mHomeView = homeView;
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

    private void loadDataList(int offset) {
        String url = URLProviderUtil.getHomeUrl(offset, 10);
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().get().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Log.d("HomeFragment", result);
                //item的集合
                List<HomeListItemBean> listItemBeanList = mGson.fromJson(result, new
                        TypeToken<List<HomeListItemBean>>() {
                        }.getType());

                mlist.addAll(listItemBeanList);

//                for (int i = 0; i <listItemBeanList.size() ; i++) {
//                    Log.d("HomeFragment", listItemBeanList.get(i).title);
//                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
//                        mHomeListAdapter.notifyDataSetChanged();
//                        mSwipeHome.setRefreshing(false);//隐藏进度圈
                        mHomeView.onDataloadedSuccess();
                    }
                });

            }
        });
    }


}
