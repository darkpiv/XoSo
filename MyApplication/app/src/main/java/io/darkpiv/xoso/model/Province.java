package io.darkpiv.xoso.model;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darkpiv on 4/29/17.
 */

public class Province extends BaseModel {
    public static final String TAG = "PROVINCE PARSING";

    private String provinceName;
    private List<Date> dates;

    public static List<Province> parseListProvince(JSONObject jsonObject) {
        List<Province> listProvince = new ArrayList<>();
        try {
            for (int i = 0; i < jsonObject.names().length(); i++) {
                String name = jsonObject.names().getString(i);
                listProvince.add(parseProvince(name, jsonObject.getJSONObject(name)));
            }

        } catch (Exception e) {
            Log.e(TAG, "parseListProvince: ", e);
        }
        Log.d(TAG, "parseListProvince: " + listProvince);
        return listProvince;
    }

    public static Province parseProvince(String name, JSONObject provinceData) {
        Province province = new Province();
        try {
            List<String> tmpDate = new ArrayList<>();
            for (int i = 0; i < provinceData.names().length(); i++) {
                tmpDate.add(provinceData.names().getString(i));
            }
            Lottery tmpLot;
            List<Date> listDate = new ArrayList<>();
            for (int i = 0; i < tmpDate.size(); i++) {
                JSONObject tempLot = provinceData.getJSONObject(tmpDate.get(i));
                tmpLot = new Gson()
                        .fromJson(tempLot.toString(), Lottery.class);
                listDate.add(new Date()
                        .setDate(tmpDate.get(i))
                        .setLottery(tmpLot));

            }
            province.setProvinceName(name).setDates(listDate);

        } catch (Exception e) {
            Log.e(TAG, "parseProvince: ", e);
        }
        Log.d(TAG, "parseProvince: " + province);
        return province;
    }


    public String getProvinceName() {
        return provinceName;
    }

    public Province setProvinceName(String provinceName) {
        this.provinceName = provinceName;
        return this;
    }

    public List<Date> getDates() {
        return dates;
    }

    public Province setDates(List<Date> dates) {
        this.dates = dates;
        return this;
    }
}