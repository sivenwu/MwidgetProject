package androidm.wsy.cn.mwidgetproject.adapters;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import androidm.wsy.cn.mwidgetproject.Models.MedalBean;
import androidm.wsy.cn.mwidgetproject.R;
import cn.wsy.adapter.base.MyViewHolder;
import cn.wsy.adapter.base.SuperAdapter;

/**
 * Created by wsy on 2016/8/12.
 */
public class MedalAdapter extends SuperAdapter<MedalBean> {

    //View
    private RelativeLayout brand_num_layout;
    private RelativeLayout country_layout;
    private RelativeLayout price_num_layout;
    private FrameLayout price_num_sum_layout;

    private FrameLayout price_glod_layout;
    private FrameLayout price_silver_layout;
    private FrameLayout price_copper_layout;

    private TextView brand_num;
    private TextView brand_simple;

    private ImageView country_img;
    private TextView country_name;

    //glod
    private ImageView price_glod_img;
    private TextView price_glod;

    private ImageView price_copper_img;
    private TextView price_copper;

    private ImageView price_silver_img;
    private TextView price_silver;

    private FrameLayout price_num_sum_img_layout;
    private TextView price_num_sum;


    public MedalAdapter(Context mContext, List data) {
        super(mContext, data);
    }

    @Override
    public int injectLayoutID() {
        return R.layout.itrm_tab1_layout;
    }

    @Override
    public void onBind(MyViewHolder holder, int position, MedalBean item) {
        initView(holder);
        if (position != 0){
            price_glod_img.setVisibility(View.INVISIBLE);
            price_copper_img.setVisibility(View.INVISIBLE);
            price_silver_img.setVisibility(View.INVISIBLE);
            price_num_sum_img_layout.setVisibility(View.INVISIBLE);

            price_silver.setVisibility(View.VISIBLE);
            price_glod.setVisibility(View.VISIBLE);
            price_copper.setVisibility(View.VISIBLE);
            price_num_sum.setVisibility(View.VISIBLE);
        }else{
            brand_num_layout.setVisibility(View.INVISIBLE);
            country_layout.setVisibility(View.INVISIBLE);
            price_silver.setVisibility(View.INVISIBLE);
            price_glod.setVisibility(View.INVISIBLE);
            price_copper.setVisibility(View.INVISIBLE);
            price_num_sum.setVisibility(View.INVISIBLE);
        }
    }

    private void initView(MyViewHolder holder){

        brand_num_layout = holder.getView(R.id.brand_num_layout);
        country_layout = holder.getView(R.id.country_layout);
        price_num_layout = holder.getView(R.id.price_num_layout);
        price_num_sum_layout = holder.getView(R.id.price_num_sum_layout);
        price_glod_layout = holder.getView(R.id.price_glod_layout);
        price_silver_layout = holder.getView(R.id.price_silver_layout);
        price_copper_layout = holder.getView(R.id.price_copper_layout);
        brand_num = holder.getView(R.id.brand_num);
        brand_simple = holder.getView(R.id.brand_simple);
        country_img = holder.getView(R.id.country_img);
        country_name = holder.getView(R.id.country_name);
        price_glod_img = holder.getView(R.id.price_glod_img);
        price_glod = holder.getView(R.id.price_glod);
        price_glod_img = holder.getView(R.id.price_glod_img);
        price_copper_img = holder.getView(R.id.price_copper_img);
        price_copper = holder.getView(R.id.price_copper);
        price_silver_img = holder.getView(R.id.price_silver_img);
        price_silver = holder.getView(R.id.price_silver);
        price_num_sum = holder.getView(R.id.price_num_sum);
        price_num_sum_img_layout = holder.getView(R.id.price_num_sum_img_layout);
    }
}
