package ck.itheima.com.phoneplay.view;

/**
 * 类名:    BaseListView
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 7:57
 * 包名:    ck.itheima.com.phoneplay.view
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public interface BaseListView {
    //更新界面的回调
    void onDataloadedSuccess();
    //失败的回调
    void onDataLoadFailde();
}
