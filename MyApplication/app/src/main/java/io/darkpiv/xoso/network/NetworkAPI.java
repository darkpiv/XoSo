package io.darkpiv.xoso.network;

import io.darkpiv.xoso.util.APIConfig;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by darkpiv on 19/12/2016.
 */

public interface NetworkAPI {
    @GET(APIConfig.XOSO)
    Call<ResponseBody> getXoSo();
    
}
