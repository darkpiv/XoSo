package io.darkpiv.xoso.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by darkpiv on 4/29/17.
 */

public class Date extends BaseModel implements Parcelable{
    private String lotteryDate;
    private Lottery lottery;

    public String getDate() {
        return lotteryDate;
    }

    public Date setDate(String date) {
        this.lotteryDate = date;
        return this;
    }

    public Lottery getLottery() {
        return lottery;
    }

    public Date setLottery(Lottery lottery) {
        this.lottery = lottery;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.lotteryDate);
        dest.writeParcelable(this.lottery, flags);
    }

    public Date() {
    }

    protected Date(Parcel in) {
        this.lotteryDate = in.readString();
        this.lottery = in.readParcelable(Lottery.class.getClassLoader());
    }

    public static final Creator<Date> CREATOR = new Creator<Date>() {
        @Override
        public Date createFromParcel(Parcel source) {
            return new Date(source);
        }

        @Override
        public Date[] newArray(int size) {
            return new Date[size];
        }
    };
}
