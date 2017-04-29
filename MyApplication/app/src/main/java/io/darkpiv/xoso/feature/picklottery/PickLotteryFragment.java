package io.darkpiv.xoso.feature.picklottery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.darkpiv.xoso.R;
import io.darkpiv.xoso.feature.moreinfo.MoreInfoActivity;
import io.darkpiv.xoso.model.Lottery;
import io.darkpiv.xoso.util.ViewUtil;
import io.darkpiv.xoso.util.baseui.BaseFragment;

public class PickLotteryFragment extends BaseFragment<PickLotteryPresenter> implements PickLotteyView {
    @BindView(R.id.spn_province)
    Spinner spnProvince;
    @BindView(R.id.spn_date)
    Spinner spnDate;
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
    @BindView(R.id.btn_more_info)
    Button btnMoreInfo;
    private ArrayAdapter<String> provinceAdapter, dateAdapter;

    public PickLotteryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PickLotteryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickLotteryFragment newInstance(Bundle bundle) {
        PickLotteryFragment fragment = new PickLotteryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void providePresenter(Context context) {
        presenter = new PickLotteryPresenter(context);
        presenter.attachView(this);
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_pick_lottery;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getXoSo();
        ViewUtil.hideKeyboardFrom(getContext(), rootView);

    }

    @Override
    public void onReceivedData(@NonNull List<String> data) {

        provinceAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, data);
        spnProvince.setAdapter(provinceAdapter);
        spnProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presenter.onProvinceClick(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onNetworkFailed(@NonNull Exception e) {
        Toast.makeText(this.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProvinceClick(List<String> listDate) {
        dateAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_dropdown_item_1line, listDate);
        spnDate.setAdapter(dateAdapter);
        spnDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                presenter.onDateClick(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onDateClick(Lottery lottery) {
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

    @OnClick(R.id.btn_more_info)
    public void openMoreInfo(View view) {
        Intent intent = new Intent(getContext(), MoreInfoActivity.class);
        getContext().startActivity(intent);
    }
}
