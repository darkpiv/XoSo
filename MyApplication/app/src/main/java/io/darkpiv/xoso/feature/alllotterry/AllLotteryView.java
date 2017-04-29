package io.darkpiv.xoso.feature.alllotterry;

import android.support.annotation.NonNull;

import java.util.List;

import io.darkpiv.xoso.model.Province;
import io.darkpiv.xoso.util.baselogic.BaseView;

/**
 * Created by darkpiv on 4/29/17.
 */

public interface AllLotteryView extends BaseView {
    void onReceivedData(@NonNull List<Province> province);

    void onNetworkFailed(@NonNull Exception e);
}
