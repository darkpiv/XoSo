package io.darkpiv.xoso.feature.alllotterry;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import io.darkpiv.xoso.R;
import io.darkpiv.xoso.model.Date;
import io.darkpiv.xoso.model.Province;

/**
 * Created by darkpiv on 4/29/17.
 */

public class LotteryAdapter extends ExpandableRecyclerViewAdapter<ProvinceViewHolder, LotteryHolder> {

    private List<Province> provinceList;
    public LotteryAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ProvinceViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_province, parent, false);
        return new ProvinceViewHolder(view);
    }

    @Override
    public LotteryHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_lottery, parent, false);
        return new LotteryHolder(view);
    }
    @Override
    public void onBindChildViewHolder(LotteryHolder holder, int flatPosition,
                                      ExpandableGroup group, int childIndex) {

        final Date date = ((Province) group).getItems().get(childIndex);
        holder.setData(date);
    }

    @Override
    public void onBindGroupViewHolder(ProvinceViewHolder holder, int flatPosition,
                                      ExpandableGroup group) {
        holder.setGenreTitle(group);
    }

}
