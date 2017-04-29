package io.darkpiv.xoso.feature.moreinfo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import io.darkpiv.xoso.R;
import io.darkpiv.xoso.util.baseui.BaseActivity;

public class MoreInfoActivity extends BaseActivity<MoreInfoPresenter> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_more_info;
    }

    @Override
    protected void providePresenter(Context context) {

    }
}
