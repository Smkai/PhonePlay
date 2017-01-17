package ck.itheima.com.phoneplay.presenter;

import java.util.List;

import ck.itheima.com.phoneplay.beans.HomeListItemBean;

/**
 * 类名:    HomePresenter
 * 创建者:  ckqu
 * 创建时间:2017/1/17 0017 下午 3:47
 * 包名:    ck.itheima.com.phoneplay.presenter
 * 更新者:  $Author$ $Date$
 * 描述:    HomePresenter
 */

public interface HomePresenter {
    //初始化数据
    void loadDataList();
    //下拉刷新
    void  refresh();
    //加载更多
    void loadMoreData();

    List<HomeListItemBean> getListData();
}
