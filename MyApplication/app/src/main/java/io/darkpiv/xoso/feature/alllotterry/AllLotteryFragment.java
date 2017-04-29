package io.darkpiv.xoso.feature.alllotterry;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.darkpiv.xoso.R;
import io.darkpiv.xoso.feature.moreinfo.MoreInfoActivity;
import io.darkpiv.xoso.model.Province;
import io.darkpiv.xoso.util.ViewUtil;
import io.darkpiv.xoso.util.baseui.BaseFragment;


public class AllLotteryFragment extends BaseFragment<AllLotteryPresenter> implements AllLotteryView {

    @BindView(R.id.rv_lot)
    RecyclerView rvLot;
    LotteryAdapter adapter;
    @BindView(R.id.btn_more_info)
    Button btnMoreInfo;
    public AllLotteryFragment() {
        // Required empty public constructor
    }

    public static AllLotteryFragment newInstance(@NonNull Bundle bundle) {
        AllLotteryFragment fragment = new AllLotteryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_all_lottery;
    }

    @Override
    protected void providePresenter(@NonNull Context context) {
        presenter = new AllLotteryPresenter(context);
        presenter.attachView(this);
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        presenter.getXoSo();
        return rootView;
    }

    @Override
    public void onReceivedData(@NonNull List<Province> province) {
        RecyclerView.ItemAnimator animator = rvLot.getItemAnimator();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        adapter = new LotteryAdapter(province);

        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }
        rvLot.setLayoutManager(layoutManager);
        rvLot.setAdapter(adapter);
    }

    @Override
    public void onNetworkFailed(@NonNull Exception e) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null)
            adapter.onRestoreInstanceState(savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();
        presenter.getXoSo();
        ViewUtil.hideKeyboardFrom(getContext(), rootView);

    }
    @OnClick(R.id.btn_more_info)
    public void openMoreInfo(View view) {
        Intent intent = new Intent(getContext(), MoreInfoActivity.class);
        getContext().startActivity(intent);
    }
}
