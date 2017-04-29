package io.darkpiv.xoso.util.baselogic;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by darkpiv on 19/12/2016.
 */

public class BasePresenter<V extends BaseView, I extends BaseInteractor> implements Presenter<V>{
    protected Context context;
    protected V view;
    protected I interactor;

    public BasePresenter (Context context) {
        this.context = context;
    }

    public boolean isViewAttached() {
        return this.view != null;
    }

    public void attachView(@NonNull V view) {
        this.view = view;
        onViewAttached(view);
    }

    public void detachView() {
        this.view = null;
        onViewDetached();
    }

    @Override
    public void onViewAttached(V view) {

    }

    @Override
    public void onViewDetached() {

    }

    public V getView() {
        return view;
    }
}
