package io.darkpiv.xoso.model;

/**
 * Created by darkpiv on 4/29/17.
 */

public class Date extends BaseModel {
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
}
