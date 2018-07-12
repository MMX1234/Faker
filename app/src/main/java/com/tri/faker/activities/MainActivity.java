package com.tri.faker.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.os.Bundle;
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
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tri.faker.R;
import com.tri.faker.adapters.FragAdapter;
import com.tri.faker.data.gson.Ser;
import com.tri.faker.fragments.ContentFragment;

import org.litepal.LitePal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        fragments.add(ContentFragment.newInstance("1"));
        fragments.add(ContentFragment.newInstance("2"));
        adapter = new FragAdapter(getSupportFragmentManager(), fragments, tabTitle);

        vp = findViewById(R.id.vp_main);
        vp.setAdapter(adapter);

        tab = findViewById(R.id.tabs_main);
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setTabTextColors(ContextCompat.getColor(this, R.color.item_unselected), ContextCompat.getColor(this, R.color.white));
        tab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.white));
        ViewCompat.setElevation(tab, 10);
        tab.setupWithViewPager(vp);

        context = getApplicationContext();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_gallery: {
                String fileName = "ser.json";
                StringBuilder stringBuilder = new StringBuilder();
                //获得assets资源管理器
                AssetManager assetManager = context.getAssets();
                //使用IO流读取json文件内容
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                            assetManager.open(fileName), "utf-8"));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("MainActivity", stringBuilder.toString());
                Ser serJson = new Gson().fromJson(stringBuilder.toString(), Ser.class);
                Ser ser = new Ser();
                ser.setId(serJson.getId());
                ser.setAlign(serJson.getAlign());
                ser.setBaseATK(serJson.getBaseATK());
                ser.setBaseHP(serJson.getBaseHP());
                ser.setBreak4ATK(serJson.getBreak4ATK());
                ser.setBreak4HP(serJson.getBreak4HP());
                ser.setSerKind(serJson.getSerKind());
                ser.setCnName(serJson.getCnName());
                ser.save();
                Toast.makeText(context, "创建数据库成功！", Toast.LENGTH_SHORT).show();
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
                builder.setTitle("筛选");
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
