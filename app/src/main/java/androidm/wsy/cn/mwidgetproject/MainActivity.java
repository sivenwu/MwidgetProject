package androidm.wsy.cn.mwidgetproject;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private CollapsingToolbarLayout collapsingToolbar;
    private AppBarLayout appBarLayout;
    private TabLayout tabLayout,tablayout_tmp;

    private float currentY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initToolbarView();
        initTab();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initToolbarView(){
//        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                Log.i("WUSY", " "
                        + verticalOffset + " toorbar h:  "
                        + toolbar.getHeight()
                        + " appbar h "+appBarLayout.getHeight()
                        + " tab h : "+tabLayout.getHeight()
                );
                if (appBarLayout.getHeight() - tabLayout.getHeight()-toolbar.getHeight() - 100<= -verticalOffset){
                    Log.i("WUSY","就是这个位置！！！tab y " +  toolbar.getY());
//                    tablayout_tmp.setVisibility(View.GONE);
//                    tabLayout.setVisibility(View.VISIBLE);
//                    appBarLayout.removeOnOffsetChangedListener(this);
                }
            }
        });

    }

    private void initTab(){
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout_tmp = (TabLayout) findViewById(R.id.tablayout_tmp);

        tablayout_tmp.addTab(tablayout_tmp.newTab().setText("tab1"));
        tablayout_tmp.addTab(tablayout_tmp.newTab().setText("tab2"));
        tablayout_tmp.addTab(tablayout_tmp.newTab().setText("tab3"));
        tablayout_tmp.addTab(tablayout_tmp.newTab().setText("tab4"));
        tablayout_tmp.addTab(tablayout_tmp.newTab().setText("tab5"));

        tabLayout.addTab(tabLayout.newTab().setText("tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("tab3"));
        tabLayout.addTab(tabLayout.newTab().setText("tab4"));
        tabLayout.addTab(tabLayout.newTab().setText("tab5"));


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
