package ck.itheima.com.phoneplay.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import ck.itheima.com.phoneplay.R;
import ck.itheima.com.phoneplay.base.BaseActivity;
import ck.itheima.com.phoneplay.factory.FragmentFactory;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.bottomBar)
    BottomBar   mBottomBar;
    private FragmentManager mSupportFragmentManager;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();

        mSupportFragmentManager = getSupportFragmentManager();

        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                FragmentTransaction fragmentTransaction = mSupportFragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, FragmentFactory.getInstance().getFragment(tabId));

                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /*----------------------------设置的点击事件------------------------------*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setting:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
