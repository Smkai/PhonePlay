package ck.itheima.com.phoneplay.network;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.leon.funhttplib.Request;

import ck.itheima.com.phoneplay.beans.YueDanListBean;

/**
 * 类名:    YueDanRequest
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 9:56
 * 包名:    ck.itheima.com.phoneplay.network
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class YueDanRequest extends Request<YueDanListBean> {
    public YueDanRequest(String url, NetworkListener listener) {
        super(url, listener);
    }
}
