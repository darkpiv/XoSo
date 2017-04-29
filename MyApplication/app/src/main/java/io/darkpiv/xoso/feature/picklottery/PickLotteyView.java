package io.darkpiv.xoso.feature.picklottery;

import android.support.annotation.NonNull;

import java.util.List;

import io.darkpiv.xoso.model.Lottery;
import io.darkpiv.xoso.util.baselogic.BaseView;

/**
 * Created by darkpiv on 4/29/17.
 */

public interface PickLotteyView extends BaseView {
    void onReceivedData(@NonNull List<String> province);

    void onNetworkFailed(@NonNull Exception e);

    void onProvinceClick(List<String> listDate);

    void onDateClick(Lottery lottery);
}
