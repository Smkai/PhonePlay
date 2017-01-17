package ck.itheima.com.phoneplay.ui.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import ck.itheima.com.phoneplay.R;
import ck.itheima.com.phoneplay.adapter.HomeListAdapter;
import ck.itheima.com.phoneplay.base.BaseFragment;
import ck.itheima.com.phoneplay.beans.HomeListItemBean;
import ck.itheima.com.phoneplay.utils.URLProviderUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类名:    HomeFragment
 * 创建者:  ckqu
 * 创建时间:2017/1/15 0015 下午 9:50
 * 包名:    ck.itheima.com.phoneplay.ui.fragment
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private   HomeListAdapter        mHomeListAdapter;
    private   Gson                   mGson;
    public    List<HomeListItemBean> mlist;
    private Handler mHandler = new Handler();

    @Override
    public int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        super.init();
        mGson = new Gson();

        initRecyclerView();
        loadDataList();
    }

    private void loadDataList() {
        String url = URLProviderUtil.getHomeUrl(0, 10);
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
                        mHomeListAdapter.notifyDataSetChanged();
                    }
                });

            }
        });


    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mlist = new ArrayList<>();

        mHomeListAdapter = new HomeListAdapter(getContext(),mlist);
        mRecyclerView.setAdapter(mHomeListAdapter);

    }
}
