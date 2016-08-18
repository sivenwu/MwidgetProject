package androidm.wsy.cn.mwidgetproject.adapters;

import android.content.Context;
import android.widget.ImageView;

import java.util.List;

import androidm.wsy.cn.mwidgetproject.Models.ResponseNew;
import androidm.wsy.cn.mwidgetproject.R;
import cn.wsy.adapter.base.MyViewHolder;
import cn.wsy.adapter.base.SuperAdapter;
import cn.wsy.generallib.photolib.utils.PhotoUtils;

/**
 * Created by wsy on 2016/8/11.
 */
public class Tab3Apater extends SuperAdapter<ResponseNew.NewInfo>{

    public Tab3Apater(Context mContext, List data) {
        super(mContext, data);
    }

    @Override
    public int injectLayoutID() {
        return R.layout.item_tab3_layout;
    }

    @Override
    public void onBind(MyViewHolder holder, int position, ResponseNew.NewInfo info) {
        ImageView piv = holder.getView(R.id.new_img);
        if (info.getPicUrl() !=null)
        PhotoUtils.showImage(piv, info.getPicUrl());

        holder.setText(R.id.new_content,info.getCtime() +"\n\n"+info.getTitle());
    }


}
