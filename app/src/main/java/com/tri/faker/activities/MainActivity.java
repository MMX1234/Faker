package com.tri.faker.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.tri.faker.R;
import com.tri.faker.adapters.FragAdapter;
import com.tri.faker.fragments.ContentFragment;
import com.tri.faker.fragments.EquipMainFrag;
import com.tri.faker.util.CraftsUtil;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static DrawerLayout sDrawerLayout;
    private List<Fragment> fragments = new ArrayList<>();
    public static final String[] tabTitle = new String[]{"从者一览", "礼装一览"};
    private FragAdapter adapter;
    private ViewPager vp;
    private TabLayout tab;
    private Toolbar toolbar;
    private NavigationView nav;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LitePal.initialize(this);
        context = getApplicationContext();

        setContentView(R.layout.activity_main);
        sDrawerLayout = findViewById(R.id.drawer_layout);
        nav = findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(this);

        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        toolbar.setTitle("从者信息一览");


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.sDrawerLayout.openDrawer(Gravity.START, true);
            }
        });

        fragments.add(ContentFragment.newInstance(1, "all"));
        fragments.add(ContentFragment.newInstance(2, "all"));
        adapter = new FragAdapter(getSupportFragmentManager(), fragments, tabTitle);

        vp = findViewById(R.id.vp_main);
        vp.setAdapter(adapter);

        tab = findViewById(R.id.tabs_main);
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setTabTextColors(ContextCompat.getColor(this, R.color.item_unselected), ContextCompat.getColor(this, R.color.white));
        tab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ViewCompat.setElevation(tab, 10);
        tab.setupWithViewPager(vp);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences.getString("isTrue", null) == null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    CraftsUtil craftsUtil = new CraftsUtil();
                    craftsUtil.setCraftsData(context);
                }
            }).start();

//            AlertDialog.Builder builder = new AlertDialog.Builder(context);
//            builder.setTitle("注意！");
//            builder.setMessage("在点击图标进入详情时\n\n会获取高清立绘，并自动缓存\n\n下次加载不消耗流量\n\n建议wifi环境下查看\n\n后续完善图片开关");
//            builder.create().show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_camera: {
                fragments.remove(1);
                fragments.add(1, EquipMainFrag.newInstance("1"));
                Toast.makeText(context, "一星筛选", Toast.LENGTH_SHORT).show();
                break;
            }
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_search: {
                break;
            }
            case R.id.filter: {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_layout, null);
                CheckBox rank0 = v.findViewById(R.id.rank0);
                CheckBox rank1 = v.findViewById(R.id.rank1);
                CheckBox rank2 = v.findViewById(R.id.rank2);
                CheckBox rank3 = v.findViewById(R.id.rank3);
                CheckBox rank4 = v.findViewById(R.id.rank4);
                CheckBox rank5 = v.findViewById(R.id.rank5);

                builder.setTitle("筛选(功能完善中。。。)");
                builder.setView(v);
                builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
            }
            default:
                break;
        }
        return true;
    }
}
