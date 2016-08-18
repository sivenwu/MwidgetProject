package androidm.wsy.cn.mwidgetproject;

import android.support.v4.view.PagerAdapter;

/**
 * Created by wsy on 2016/8/16.
 */
public  class VerticalViewPagerCompat {
    private VerticalViewPagerCompat() {
    }

    public static void setDataSetObserver(PagerAdapter adapter, DataSetObserver observer) {
        adapter.registerDataSetObserver(observer);
    }

    public static class DataSetObserver extends android.database.DataSetObserver {
    }
}
