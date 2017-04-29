package io.darkpiv.xoso.feature.moreinfo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;
import io.darkpiv.xoso.R;
import io.darkpiv.xoso.util.baseui.BaseActivity;

public class MoreInfoActivity extends BaseActivity<MoreInfoPresenter> implements MoreInfoView {

    @BindView(R.id.imv_logo1)
    ImageView imvLogo1;
    @BindView(R.id.imv_logo2)
    ImageView imvLogo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @OnClick({R.id.imv_logo1,R.id.imv_logo2})
    public void goToWeb(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://vietlott.vn/vi/home/"));
        startActivity(browserIntent);
    }
    @Override
    protected int getRootLayoutId() {
        return R.layout.activity_more_info;
    }

    @Override
    protected void providePresenter(Context context) {
        presenter = new MoreInfoPresenter(context);
        presenter.attachView(this);
    }
}
