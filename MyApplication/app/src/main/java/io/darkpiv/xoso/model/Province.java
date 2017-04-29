package io.darkpiv.xoso.model;

import android.util.Log;

import com.google.gson.Gson;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darkpiv on 4/29/17.
 */

public class Province extends ExpandableGroup<Date> {
    public static final String TAG = "PROVINCE PARSING";

    public Province(String title, List<Date> items) {
        super(title, items);
    }

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
        List<Date> listDate = new ArrayList<>();
        Province province = new Province("", listDate);
        try {
            List<String> tmpDate = new ArrayList<>();
            for (int i = 0; i < provinceData.names().length(); i++) {
                tmpDate.add(provinceData.names().getString(i));
            }
            Lottery tmpLot;
            for (int i = 0; i < tmpDate.size(); i++) {
                JSONObject tempLot = provinceData.getJSONObject(tmpDate.get(i));
                tmpLot = new Gson()
                        .fromJson(tempLot.toString(), Lottery.class);
                listDate.add(new Date()
                        .setDate(tmpDate.get(i))
                        .setLottery(tmpLot));

            }
            province = new Province(name, listDate);


        } catch (Exception e) {
            Log.e(TAG, "parseProvince: ", e);
        }
        Log.d(TAG, "parseProvince: " + province);
        return province;
    }


    public String getProvinceName() {
        return getTitle();
    }


    public List<Date> getDates() {
        return getItems();
    }

}