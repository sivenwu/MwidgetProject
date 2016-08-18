package androidm.wsy.cn.mwidgetproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import androidm.wsy.cn.mwidgetproject.Fragments.MainTabFragment;
import androidm.wsy.cn.mwidgetproject.Fragments.Tab1Fragment;

public class TestActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private MainTabFragment mainTabFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView(){
        tabLayout = (TabLayout) findViewById(R.id.test_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("标题1"));
        tabLayout.addTab(tabLayout.newTab().setText("标题1"));
        tabLayout.addTab(tabLayout.newTab().setText("标题1"));

        mainTabFragment = new MainTabFragment() {
            @Override
            public void addSubViewTab() {
                addTab("标题1",Tab1Fragment.class);
                addTab("标题1",Tab1Fragment.class);
                addTab("标题1",Tab1Fragment.class);
            }

            @Override
            public void loadFinishView(ViewPager viewPager, FragmentStatePagerAdapter mAdapter) {
                mViewPager = viewPager;
                tabLayout.setupWithViewPager(mViewPager);
                tabLayout.setTabsFromPagerAdapter(mAdapter);
            }

        };

        getSupportFragmentManager().beginTransaction().add(R.id.test_contanter,mainTabFragment).commit();
        //关联Tab
//        tabLayout.setTabsFromPagerAdapter(mainTabFragment.getmAdapter());
    }



}
