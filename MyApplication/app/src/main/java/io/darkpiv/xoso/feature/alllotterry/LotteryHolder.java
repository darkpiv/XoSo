package io.darkpiv.xoso.feature.alllotterry;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.darkpiv.xoso.R;
import io.darkpiv.xoso.model.Date;
import io.darkpiv.xoso.model.Lottery;

/**
 * Created by darkpiv on 4/29/17.
 */

public class LotteryHolder extends ChildViewHolder {
    @BindView(R.id.tv_giai_dac_biet)
    TextView tvGiaiDacBiet;
    @BindView(R.id.tv_giai_nhat)
    TextView tvGiaiNhat;
    @BindView(R.id.tv_giai_nhi)
    TextView tvGiaiNhi;
    @BindView(R.id.tv_giai_ba)
    TextView tvGiaiBa;
    @BindView(R.id.tv_giai_tu)
    TextView tvGiaiTu;
    @BindView(R.id.tv_giai_nam)
    TextView tvGiaiNam;
    @BindView(R.id.tv_giai_sau)
    TextView tvGiaiSau;
    @BindView(R.id.tv_giai_bay)
    TextView tvGiaiBay;
    @BindView(R.id.tv_giai_tam)
    TextView tvGiaiTam;
    @BindView(R.id.tv_date)
    TextView tvDate;

    public LotteryHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }


    public void setData(Date data) {
        Lottery lottery = data.getLottery();
        tvDate.setText(data.getDate());
        tvGiaiDacBiet.setText(createLotteryString(lottery.getGiaiDacBiet()));
        tvGiaiNhat.setText(createLotteryString(lottery.getGiaiNhat()));
        tvGiaiNhi.setText(createLotteryString(lottery.getGiaiNhi()));
        tvGiaiBa.setText(createLotteryString(lottery.getGiaiBa()));
        tvGiaiTu.setText(createLotteryString(lottery.getGiaiTu()));
        tvGiaiNam.setText(createLotteryString(lottery.getGiaiNam()));
        tvGiaiSau.setText(createLotteryString(lottery.getGiaiSau()));
        tvGiaiBay.setText(createLotteryString(lottery.getGiaiBay()));
        tvGiaiTam.setText(createLotteryString(lottery.getGiaiTam()));

    }

    private String createLotteryString(List<String> lo) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lo.size(); i++) {
            builder.append(lo.get(i));
            builder.append(" ");

        }
        return builder.toString();
    }
}
