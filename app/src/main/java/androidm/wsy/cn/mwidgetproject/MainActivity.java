package androidm.wsy.cn.mwidgetproject;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import androidm.wsy.cn.mwidgetproject.Fragments.Tab1Fragment;
import androidm.wsy.cn.mwidgetproject.Fragments.Tab2Fragment;
import androidm.wsy.cn.mwidgetproject.Fragments.Tab3Fragment;
import androidm.wsy.cn.mwidgetproject.adapters.MainPagerAdapter;
import cn.wsy.generallib.photolib.utils.PhotoUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private CollapsingToolbarLayout collapsingToolbar;
    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView toobar_img;

    //Fragment
    private MainPagerAdapter viewAdapter;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private Tab1Fragment tab1Fragment;
    private Tab2Fragment tab2Fragment;
    private Tab3Fragment tab3Fragment;


    private List<String> data = new ArrayList<>();
    TestAdapter adapter;

    private float currentY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhotoUtils.init(getApplicationContext());
        initView();
        initFragment();
        initData();
    }

    private void initFragment(){

//        MainTabFragment fragment = new MainTabFragment() {
//            @Override
//            public void addSubViewTab() {
//                addTab(titleList.get(0),Tab1Fragment.class);
//                addTab(titleList.get(1),Tab2Fragment.class);
//                addTab(titleList.get(2),Tab3Fragment.class);
//            }
//        };
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.contanter_main, fragment)
//                .commit();

//        //将TabLayout和ViewPager关联起来。
//        tabLayout.setupWithViewPager(fragment.getViewPager());
//        //给TabLayout设置适配器
//        tabLayout.setTabsFromPagerAdapter(fragment.getmAdapter());

        tab1Fragment = new Tab1Fragment();
        tab2Fragment = new Tab2Fragment();
        tab3Fragment = new Tab3Fragment();

        fragmentList.add(tab1Fragment);
        fragmentList.add(tab2Fragment);
        fragmentList.add(tab3Fragment);
        viewAdapter = new MainPagerAdapter(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(viewAdapter);
        viewPager.setCurrentItem(0);

        //将TabLayout和ViewPager关联起来。
        tabLayout.setupWithViewPager(viewPager);
        //给TabLayout设置适配器
        tabLayout.setTabsFromPagerAdapter(viewAdapter);
    }

    private void initView() {
        initToolbarView();
        initTab();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new TestAdapter(this, data);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initToolbarView() {
//        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toobar_img = (ImageView) findViewById(R.id.toobar_img);
        setSupportActionBar(toolbar);

        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.i("WUSY", " "
                        + verticalOffset + " toorbar h:  "
                        + toolbar.getHeight()
                        + " appbar h " + appBarLayout.getHeight()
                        + " tab h : " + tabLayout.getHeight()
                );
                if (appBarLayout.getHeight() - tabLayout.getHeight() - toolbar.getHeight() - 100 <= -verticalOffset) {
                    Log.i("WUSY", "就是这个位置！！！tab y " + toolbar.getY());
                    toobar_img.setVisibility(View.VISIBLE);
                }else{
                    toobar_img.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

    private void initTab() {

        titleList.add("奖牌");
        titleList.add("当前赛事");
        titleList.add("新闻");

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
//
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));
    }

    private void initData() {
        for (int i = 0 ;i < 10;i++){
            data.add("wusy");
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
