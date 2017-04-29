package io.darkpiv.xoso.util.baselogic;

/**
 * Created by darkpiv on 4/29/17.
 */

public interface Presenter<V extends BaseView> {
    void onViewAttached(V view);
    void onViewDetached();
}
