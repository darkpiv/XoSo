package io.darkpiv.xoso.model;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by darkpiv on 4/28/17.
 */

public class Lottery extends BaseModel {
    @SerializedName("1")
    private List<String> giaiNhat;
    @SerializedName("2")
    private List<String> giaiNhi;
    @SerializedName("3")
    private List<String> giaiBa;
    @SerializedName("4")
    private List<String> giaiTu;
    @SerializedName("5")
    private List<String> giaiNam;
    @SerializedName("6")
    private List<String> giaiSau;
    @SerializedName("7")
    private List<String> giaiBay;
    @SerializedName("8")
    private List<String> giaiTam;
    @SerializedName("DB")
    private List<String> giaiDacBiet;


    public Lottery newLottery(JSONObject jsonObject) {
        return getObjectFromJson(jsonObject);
    }


    public List<Lottery> newListLottery(JSONArray jsonArray) {
        return getListObjectFromJson(jsonArray);
    }

    public List<String> getGiaiNhat() {
        return giaiNhat;
    }

    public Lottery setGiaiNhat(List<String> giaiNhat) {
        this.giaiNhat = giaiNhat;
        return this;
    }

    public List<String> getGiaiNhi() {
        return giaiNhi;
    }

    public Lottery setGiaiNhi(List<String> giaiNhi) {
        this.giaiNhi = giaiNhi;
        return this;
    }

    public List<String> getGiaiBa() {
        return giaiBa;
    }

    public Lottery setGiaiBa(List<String> giaiBa) {
        this.giaiBa = giaiBa;
        return this;
    }

    public List<String> getGiaiTu() {
        return giaiTu;
    }

    public Lottery setGiaiTu(List<String> giaiTu) {
        this.giaiTu = giaiTu;
        return this;
    }

    public List<String> getGiaiNam() {
        return giaiNam;
    }

    public Lottery setGiaiNam(List<String> giaiNam) {
        this.giaiNam = giaiNam;
        return this;
    }

    public List<String> getGiaiSau() {
        return giaiSau;
    }

    public Lottery setGiaiSau(List<String> giaiSau) {
        this.giaiSau = giaiSau;
        return this;
    }

    public List<String> getGiaiBay() {
        return giaiBay;
    }

    public Lottery setGiaiBay(List<String> giaiBay) {
        this.giaiBay = giaiBay;
        return this;
    }

    public List<String> getGiaiTam() {
        return giaiTam;
    }

    public Lottery setGiaiTam(List<String> giaiTam) {
        this.giaiTam = giaiTam;
        return this;
    }

    public List<String> getGiaiDacBiet() {
        return giaiDacBiet;
    }

    public Lottery setGiaiDacBiet(List<String> giaiDacBiet) {
        this.giaiDacBiet = giaiDacBiet;
        return this;
    }
}
