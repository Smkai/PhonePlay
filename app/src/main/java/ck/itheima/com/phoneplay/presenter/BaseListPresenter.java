package ck.itheima.com.phoneplay.presenter;

import java.util.List;

/**
 * 类名:    BaseListPresenter
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 8:10
 * 包名:    ck.itheima.com.phoneplay.presenter
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public interface BaseListPresenter<T> {
    //初始化数据
    void loadDataList();
    //下拉刷新
    void  refresh();
    //加载更多
    void loadMoreData();

    List<T> getListData();
}
