package ck.itheima.com.phoneplay.presenter.impl;
import com.itheima.leon.funhttplib.NetworkListener;
import java.util.ArrayList;
import java.util.List;
import ck.itheima.com.phoneplay.beans.YueDanListBean;
import ck.itheima.com.phoneplay.network.YueDanRequest;
import ck.itheima.com.phoneplay.presenter.BaseListPresenter;
import ck.itheima.com.phoneplay.utils.URLProviderUtil;
import ck.itheima.com.phoneplay.view.BaseListView;

/**
 * 类名:    YueDanPersenterImpl
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 9:36
 * 包名:    ck.itheima.com.phoneplay.presenter.impl
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class YueDanPersenterImpl implements BaseListPresenter<YueDanListBean.PlayListsBean  > {
    private BaseListView mYueDanView;

    private List<YueDanListBean.PlayListsBean> mDateList;

    public YueDanPersenterImpl(BaseListView yueDanView) {
        mYueDanView = yueDanView;
        mDateList = new ArrayList<>();
    }


    @Override
    public void loadDataList() {
         loadDataList(0);
    }

    @Override
    public void refresh() {
        mDateList.clear();
         loadDataList(0);
    }

    @Override
    public void loadMoreData() {
        loadDataList(mDateList.size());

    }

    @Override
    public List getListData() {
        return mDateList;
    }
    private void loadDataList(int offset) {
        String url = URLProviderUtil.getYueDanUrl(offset, 10);
        new YueDanRequest(url, mYueDanBeanNetworkListener).execute();
    }
    private NetworkListener<YueDanListBean> mYueDanBeanNetworkListener = new NetworkListener<YueDanListBean>() {
        @Override
        public void onFailed(String s) {

        }

        @Override
        public void onSuccess(YueDanListBean yueDanBean) {
            //将网络请求的结果加入到数据集合
            mDateList.addAll(yueDanBean.getPlayLists());
            //通知view层数据加载成功
            mYueDanView.onDataloadedSuccess();
        }
    };
}
