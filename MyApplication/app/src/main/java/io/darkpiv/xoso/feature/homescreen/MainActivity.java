package io.darkpiv.xoso.feature.homescreen;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.WindowManager;

import butterknife.BindView;
import io.darkpiv.xoso.R;
import io.darkpiv.xoso.feature.alllotterry.AllLotteryFragment;
import io.darkpiv.xoso.feature.picklottery.PickLotteryFragment;
import io.darkpiv.xoso.util.ViewUtil;
import io.darkpiv.xoso.util.baseui.BaseActivity;
import io.darkpiv.xoso.util.baseui.BaseFragment;
import io.darkpiv.xoso.util.baseui.SmartFragmentStatePagerAdapter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    MyPagerAdapter adapterViewPager;
    @BindView(R.id.tab_layout)
    TabLayout slidingTabs;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpMain.setAdapter(adapterViewPager);
        slidingTabs.setupWithViewPager(vpMain);
        vpMain.setCurrentItem(0);
        vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                ViewUtil.hideKeyboardFrom(MainActivity.this, getCurrentFocus());

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void providePresenter(Context context) {
        presenter = new MainPresenter(context);
        presenter.attachView(this);
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_main;
    }

    public static class MyPagerAdapter extends SmartFragmentStatePagerAdapter<BaseFragment> {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return PickLotteryFragment.newInstance(new Bundle());
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return AllLotteryFragment.newInstance(new Bundle());
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Pick Lottery";
                case 1:
                    return "All Lotteries";

            }
            return "";

        }

    }
}
