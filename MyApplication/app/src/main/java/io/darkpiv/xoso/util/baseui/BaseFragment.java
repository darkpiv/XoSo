package io.darkpiv.xoso.util.baseui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.darkpiv.xoso.util.baselogic.BasePresenter;

/**
 * Created by darkpiv on 3/27/17.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    protected Unbinder unbinder;
    protected View rootView;
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(getRootLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        providePresenter(context);

    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        presenter.onViewDetached();
        super.onDestroy();

    }

    protected View getRootLayout() {
        return rootView;
    }

    protected abstract int getRootLayoutId();

    protected abstract void providePresenter(Context context);

}


