package io.darkpiv.xoso.feature.alllotterry;

import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.darkpiv.xoso.R;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

/**
 * Created by darkpiv on 4/29/17.
 */

public class ProvinceViewHolder extends GroupViewHolder {
    @BindView(R.id.tv_province_name)
    TextView tvProvinceName;
    @BindView(R.id.list_item_genre_arrow)
    ImageView arrow;

    public ProvinceViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }
    public void setGenreTitle(ExpandableGroup province) {
        tvProvinceName.setText(province.getTitle());
    }
    private void animateExpand() {
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
