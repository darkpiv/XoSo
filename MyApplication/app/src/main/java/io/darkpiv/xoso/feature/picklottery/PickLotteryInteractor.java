package io.darkpiv.xoso.feature.picklottery;

import org.json.JSONObject;

import java.util.List;

import io.darkpiv.xoso.model.ErrorResponse;
import io.darkpiv.xoso.model.Province;
import io.darkpiv.xoso.network.NetworkAPI;
import io.darkpiv.xoso.util.baselogic.BaseInteractor;
import io.darkpiv.xoso.util.baselogic.OnErrorListener;
import io.darkpiv.xoso.util.baselogic.OnSuccessListener;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by darkpiv on 4/29/17.
 */

public class PickLotteryInteractor extends BaseInteractor {

    private NetworkAPI networkAPI;

    public PickLotteryInteractor(NetworkAPI networkAPI) {
        this.networkAPI = networkAPI;
    }

    public void getXoSo(final OnSuccessListener<List<Province>> ls, final OnErrorListener<ErrorResponse> le) {
        Call<ResponseBody> call = networkAPI.getXoSo();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String s = response.body().string();
                        JSONObject object = new JSONObject(s);
                        ls.onSuccess(Province.parseListProvince(object));
                    } catch (Exception e) {
                        le.onError(new ErrorResponse().setStatus(e.getMessage()));
                    }

                } else {
                    le.onError(new ErrorResponse().setStatus("Loi ket noi mang"));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                le.onError(new ErrorResponse().setStatus(t.getMessage()));
            }
        });
    }


}
