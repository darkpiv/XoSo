package io.darkpiv.xoso.feature.alllotterry;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.darkpiv.xoso.R;
import io.darkpiv.xoso.util.baseui.BaseFragment;



public class AllLotteryFragment extends BaseFragment<AllLotteryPresenter> implements AllLotteryView {

    public AllLotteryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AllLotteryFragment.
     */
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
    }
    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

}
