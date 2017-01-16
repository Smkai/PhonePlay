package ck.itheima.com.phoneplay.ui.fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import java.io.IOException;
import butterknife.BindView;
import ck.itheima.com.phoneplay.R;
import ck.itheima.com.phoneplay.adapter.HomeListAdapter;
import ck.itheima.com.phoneplay.base.BaseFragment;
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
    private HomeListAdapter mHomeListAdapter;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init() {
        super.init();
        initRecyclerView();
        loadDataList();
    }

    private void loadDataList() {
        String url = URLProviderUtil.getHomeUrl(0,10);
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
            }
        });


    }

    private void initRecyclerView() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mHomeListAdapter = new HomeListAdapter(getContext());
        mRecyclerView.setAdapter(mHomeListAdapter);
    }
}
