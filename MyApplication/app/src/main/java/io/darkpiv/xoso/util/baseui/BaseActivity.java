package io.darkpiv.xoso.util.baseui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.darkpiv.xoso.util.baselogic.BasePresenter;

/**
 * Created by darkpiv on 29/12/2016.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    protected Unbinder unbinder;
    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRootLayoutId());
        unbinder = ButterKnife.bind(this);
        providePresenter(this);
    }

    protected abstract int getRootLayoutId();
    protected abstract void providePresenter(Context context);

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        presenter.onViewDetached();
        super.onDestroy();

    }

}
