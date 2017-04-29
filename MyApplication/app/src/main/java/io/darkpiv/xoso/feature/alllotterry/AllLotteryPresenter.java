package io.darkpiv.xoso.feature.alllotterry;

import android.content.Context;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.darkpiv.xoso.model.ErrorResponse;
import io.darkpiv.xoso.model.Province;
import io.darkpiv.xoso.network.NetworkModule;
import io.darkpiv.xoso.util.JSONUtil;
import io.darkpiv.xoso.util.baselogic.BasePresenter;

/**
 * Created by darkpiv on 4/29/17.
 */

public class AllLotteryPresenter extends BasePresenter<AllLotteryView, AllLotteryInteractor> {
    private List<Province> listProvince;

    public AllLotteryPresenter(Context context) {
        super(context);
    }

    @Override
    public void onViewAttached(AllLotteryView view) {
        listProvince = new ArrayList<>();
        NetworkModule networkModule = new NetworkModule(new File(context.getCacheDir(), "xosocache"));
        interactor = new AllLotteryInteractor(networkModule.providesNetworkService());
    }

    @Override
    public void onViewDetached() {
        super.onViewDetached();
    }

    public void getXoSo() {
        interactor.getXoSo(this::onXoSoSuccess, this::onXoSoFailure);
    }

    public void onXoSoSuccess(List<Province> data) {
        this.listProvince = data;
        getView().onReceivedData(data);
    }

    public void onXoSoFailure(ErrorResponse errorResponse) {
        try {
            String s = JSONUtil.loadJSONFromAsset(context, "data");
            JSONObject object = new JSONObject(s);
            this.listProvince = Province.parseListProvince(object);
            getView().onReceivedData(listProvince);
        } catch (Exception e) {
            getView().onNetworkFailed(e);
        }

    }

}
