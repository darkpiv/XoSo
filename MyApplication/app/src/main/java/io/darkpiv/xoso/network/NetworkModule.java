package io.darkpiv.xoso.network;

import android.util.Log;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static io.darkpiv.xoso.util.APIConfig.BASE_URL;


/**
 * Created by darkpiv on 19/12/2016.
 */
public class NetworkModule {
    public static final String TAG = NetworkModule.class.getName();
    private static Retrofit retrofit;
    private File cacheFile;

    public NetworkModule(File cacheFile) {
        this.cacheFile = cacheFile;
    }

    private Retrofit provideRetrofit() {
        synchronized (NetworkModule.class) {
            if (retrofit == null) {
                Cache cache = null;
                try {
                    cache = new Cache(cacheFile, 10 * 1024 * 1024);
                } catch (Exception e) {
                    Log.e(TAG, "provideRetrofit: ", e);
                }

                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .cache(cache)
                        .build();

                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
        }
        return retrofit;
    }

    public NetworkAPI providesNetworkService() {
        return provideRetrofit().create(NetworkAPI.class);
    }


}
