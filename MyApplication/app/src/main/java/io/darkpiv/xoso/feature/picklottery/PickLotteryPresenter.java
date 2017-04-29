package io.darkpiv.xoso.feature.picklottery;

import android.content.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.darkpiv.xoso.model.Date;
import io.darkpiv.xoso.model.ErrorResponse;
import io.darkpiv.xoso.model.Province;
import io.darkpiv.xoso.network.NetworkModule;
import io.darkpiv.xoso.util.baselogic.BasePresenter;

/**
 * Created by darkpiv on 4/29/17.
 */

public class PickLotteryPresenter extends BasePresenter<PickLotteyView, PickLotteryInteractor> {

    private List<Date> date;
    private List<Province> listProvince;
    private int currentProvince;

    public PickLotteryPresenter(Context context) {
        super(context);
    }

    @Override
    public void onViewAttached(PickLotteyView view) {
        date = new ArrayList<>();
        listProvince = new ArrayList<>();
        NetworkModule networkModule = new NetworkModule(new File(context.getCacheDir(), "xosocache"));
        interactor = new PickLotteryInteractor(networkModule.providesNetworkService());
    }

    @Override
    public void onViewDetached() {
        super.onViewDetached();
    }

    public void getXoSo() {
        interactor.getXoSo(this::onXoSoSuccess, this::onXoSoFailure);
    }

    public void onXoSoSuccess(List<Province> listProvince) {
        this.listProvince = listProvince;
        List<String> pro = new ArrayList<>();
        for(int i=0;i<listProvince.size();i++) {
            pro.add(listProvince.get(i).getProvinceName());
        }
        getView().onReceivedData(pro);
    }

    public void onXoSoFailure(ErrorResponse errorResponse) {

    }

    public void onProvinceClick(int id) {
        currentProvince = id;
        date = listProvince.get(id).getDates();
        List<String> d = new ArrayList<>();
        for (int i = 0; i < date.size(); i++) {
            d.add(date.get(i).getDate());
        }
        getView().onProvinceClick(d);
    }

    public void onDateClick(int id) {
        date = listProvince.get(currentProvince).getDates();
        getView().onDateClick(date.get(id).getLottery());

    }
}
