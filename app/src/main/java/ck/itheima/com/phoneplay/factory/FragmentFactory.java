package ck.itheima.com.phoneplay.factory;

/**
 * Created by Leon on 2017/1/15.
 */

import android.support.v4.app.Fragment;

import ck.itheima.com.phoneplay.R;
import ck.itheima.com.phoneplay.ui.fragment.HomeFragment;
import ck.itheima.com.phoneplay.ui.fragment.MvFragment;
import ck.itheima.com.phoneplay.ui.fragment.VbangFragment;
import ck.itheima.com.phoneplay.ui.fragment.YueDanFragment;


/**
 * 工厂模式， 更加不同条件（不同的输入），生产出不同的对象
 */
public class FragmentFactory {


    //单例模式，一个app中只维护一个实例（对象）
    private static FragmentFactory sFragmentFactory;

    //内存缓存 类的成员变量，存在内存当中
    private Fragment mHomeFragment;
    private Fragment mMVFragment;
    private Fragment mVbangFragment;
    private Fragment mYueDanFragment;

    private FragmentFactory() {
    }

/*    public static FragmentFactory getInstance() {
        //线程A //线程B
        if (sFragmentFactory == null) {
            //线程A //线程B
            sFragmentFactory = new FragmentFactory();
        }
        return sFragmentFactory;
    }*/

/*    //线程A 线程B
    public static synchronized FragmentFactory getInstance() {
        if (sFragmentFactory == null) {
            sFragmentFactory = new FragmentFactory();
        }
        return sFragmentFactory;
    }*/

    public static FragmentFactory getInstance() {
        //线程A 线程B
        if (sFragmentFactory == null) {
            //线程A 线程B
            synchronized (FragmentFactory.class) {
                if (sFragmentFactory == null) {
                    sFragmentFactory = new FragmentFactory();
                }
            }
        }
        return sFragmentFactory;
    }

    public Fragment getFragment(int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                return getHomeFragment();
            case R.id.tab_mv:
                return getMVFragment();
            case R.id.tab_vbang:
                return getVbangFragment();
            case R.id.tab_yuedan:
                return getYueDanFragment();
        }
        return null;
    }

    private Fragment getHomeFragment() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        return mHomeFragment;
    }

    private Fragment getMVFragment() {
        if (mMVFragment == null) {
            mMVFragment = new MvFragment();
        }
        return mMVFragment;
    }

    private Fragment getVbangFragment() {
        if (mVbangFragment == null) {
            mVbangFragment = new VbangFragment();
        }
        return mVbangFragment;
    }

    private Fragment getYueDanFragment() {
        if (mYueDanFragment == null) {
            mYueDanFragment = new YueDanFragment();
        }
        return mYueDanFragment;
    }
}
