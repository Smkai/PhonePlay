package ck.itheima.com.phoneplay.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ck.itheima.com.phoneplay.beans.YueDanListBean;
import ck.itheima.com.phoneplay.widget.YueDanListItemView;

/**
 * 类名:    YueDanAdapter
 * 创建者:  ckqu
 * 创建时间:2017/1/18 0018 下午 8:52
 * 包名:    ck.itheima.com.phoneplay.adapter
 * 更新者:  $Author$ $Date$
 * 描述:    TODO
 */

public class YueDanAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<YueDanListBean.PlayListsBean> mPlayList;

    public YueDanAdapter(Context context) {
        mContext = context;
    }

    public YueDanAdapter(List<YueDanListBean.PlayListsBean> playList, Context context) {
        mPlayList = playList;
        mContext = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YueDanListItemViewHolder(new YueDanListItemView(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((YueDanListItemView)holder.itemView).bingView(mPlayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPlayList.size();
    }

    public class YueDanListItemViewHolder extends RecyclerView.ViewHolder{
        public YueDanListItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
