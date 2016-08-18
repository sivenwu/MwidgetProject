package androidm.wsy.cn.mwidgetproject.adapters;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

import androidm.wsy.cn.mwidgetproject.Models.MatchMode;
import androidm.wsy.cn.mwidgetproject.R;
import cn.wsy.adapter.base.MyViewHolder;
import cn.wsy.adapter.base.SuperAdapter;

/**
 * Created by wsy on 2016/8/12.
 */
public class MatchAdapter extends SuperAdapter<MatchMode>{

    public MatchAdapter(Context mContext, List data) {
        super(mContext, data);
    }

    @Override
    public int injectLayoutID() {
        return R.layout.item_tab2_layout;
    }

    @Override
    public void onBind(MyViewHolder holder, int position, MatchMode item) {
        RelativeLayout match_info_layout = holder.getView(R.id.match_info_layout);

        if (item.getType() == 0){
            match_info_layout.setVisibility(View.GONE);
        }
    }
}
