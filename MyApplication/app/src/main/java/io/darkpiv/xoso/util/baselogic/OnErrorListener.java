package io.darkpiv.xoso.util.baselogic;

import android.support.annotation.NonNull;

/**
 * Created by darkpiv on 29/12/2016.
 */

public interface OnErrorListener<E> {
    void onError(@NonNull E error);

}
