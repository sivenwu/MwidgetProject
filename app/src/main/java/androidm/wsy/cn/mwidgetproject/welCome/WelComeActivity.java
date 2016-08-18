package androidm.wsy.cn.mwidgetproject.welCome;

import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import androidm.wsy.cn.mwidgetproject.DirectionalViewPager;
import androidm.wsy.cn.mwidgetproject.R;

/**
 * Created by wsy on 2016/8/16.
 */
public class WelComeActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private DirectionalViewPager mViewPager;
    private boolean isArrive = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        WelcomeFragment fragment = new WelcomeFragment() {
            @Override
            public void addSubViewTab() {
                addTab("1", WecomlAFragment.class);
                addTab("2", WelcomeBFragment.class);
                addTab("3", WelcomeCFragment.class);
                addTab("4", WelcomeDFragment.class);
            }

            @Override
            public void loadFinishView(ViewPager viewPager, FragmentStatePagerAdapter mAdapter) {
                mViewPager = (DirectionalViewPager) viewPager;
                mViewPager.setOnPageChangeListener(WelComeActivity.this);
                mViewPager.setOrientation(DirectionalViewPager.VERTICAL);
            }
        };

        getSupportFragmentManager().beginTransaction().add(R.id.welcome_container,fragment).commit();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
//        if (position == 0){
//            isArrive = false;
//            mViewPager.setOrientation(DirectionalViewPager.VERTICAL);
//        }
//
//        if (position == 1){
//            mViewPager.setOrientation(DirectionalViewPager.HORIZONTAL);
//            if (isArrive)
//                mViewPager.setOrientation(DirectionalViewPager.VERTICAL);
//        }
//
//        if (position == 2){
//            isArrive = true;
//        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
