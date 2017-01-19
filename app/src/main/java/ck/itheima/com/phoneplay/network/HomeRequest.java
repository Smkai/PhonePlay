package ck.itheima.com.phoneplay.network;

import com.itheima.leon.funhttplib.NetworkListener;
import com.itheima.leon.funhttplib.Request;

import java.util.List;

import ck.itheima.com.phoneplay.beans.HomeListItemBean;

/**
 * 类名:    HomeRequest
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 6:05
 * 包名:    ck.itheima.com.phoneplay.network
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class HomeRequest extends Request<List<HomeListItemBean>> {
    public HomeRequest(String url, NetworkListener listener) {
        super(url, listener);
    }
}
