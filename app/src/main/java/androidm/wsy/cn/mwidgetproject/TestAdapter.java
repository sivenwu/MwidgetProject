package androidm.wsy.cn.mwidgetproject;

import android.content.Context;

import java.util.List;

import cn.wsy.adapter.base.MyViewHolder;
import cn.wsy.adapter.base.SuperAdapter;

/**
 * Created by wsy on 2016/8/8.
 */
public class TestAdapter extends SuperAdapter<String>{

    public TestAdapter(Context mContext, List data) {
        super(mContext, data);
    }

    @Override
    public int injectLayoutID() {
        return R.layout.tem_test_layout;
    }

    @Override
    public void onBind(MyViewHolder holder, int position, String item) {

    }
}
