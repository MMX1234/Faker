package com.tri.faker.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tri.faker.R;
import com.tri.faker.adapters.FragAdapter;
import com.tri.faker.data.Crafts;
import com.tri.faker.data.Ser;
import com.tri.faker.fragments.CraftsFragment;
import com.tri.faker.fragments.SerFragment;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {
    public static final String ID = "ID";
    public static final String TYPE = "TYPE";
    private FragAdapter adapter;
    private ViewPager vp;
    private TabLayout tab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        Intent intent = getIntent();
        int id = intent.getIntExtra(ID, 1);
        int type = intent.getIntExtra(TYPE, 1);

        Ser ser = LitePal.find(Ser.class, id);
        Crafts crafts = LitePal.find(Crafts.class, id);

        Toolbar toolbar = findViewById(R.id.toolbar_second);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        vp = findViewById(R.id.vp_second);
        tab = findViewById(R.id.tabs_second);

        ImageView baseHead = findViewById(R.id.base_head);
        TextView rank_rank = findViewById(R.id.rank_rank);
        TextView class_cost = findViewById(R.id.class_cost);
        TextView atk = findViewById(R.id.atk);
        TextView hp = findViewById(R.id.hp);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.top_blue, null));
        }

        if (type == 1) {
            collapsingToolbar.setTitle((crafts.getCnName() != null) ? crafts.getCnName() : "--");

            loadPic(id, type, baseHead);
            rank_rank.setText((crafts.getRank() != null) ? "星级\n" + crafts.getRank() : "星级\n--");
            class_cost.setText((crafts.getCost() != null) ? "cost\n" + crafts.getCost() : "cost\n--");

            atk.setText((crafts.getAtk() != null) ? "基础-最大atk\n" + crafts.getAtk() : "基础-最大atk\n--");
            hp.setText((crafts.getHp() != null) ? "基础-最大hp\n" + crafts.getHp() : "基础-最大hp\n--");


            List<Fragment> fragments = new ArrayList<>();
            String[] tabTitle = new String[]{"技能", "资料", "模型", "语音"};

            fragments.add(SerFragment.newInstance(id));
            fragments.add(SerFragment.newInstance(id));
            fragments.add(SerFragment.newInstance(id));
            fragments.add(SerFragment.newInstance(id));

            adapter = new FragAdapter(getSupportFragmentManager(), fragments, tabTitle);
            vp.setAdapter(adapter);

            tab.setTabMode(TabLayout.MODE_FIXED);
            tab.setTabTextColors(ContextCompat.getColor(this, R.color.item_unselected), ContextCompat.getColor(this, R.color.white));
            tab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.yellow));
            ViewCompat.setElevation(tab, 10);
            tab.setupWithViewPager(vp);
        } else if (type == 2) {
            collapsingToolbar.setTitle((crafts.getCnName() != null) ? crafts.getCnName() : "--");

            loadPic(id, type, baseHead);
            rank_rank.setText((crafts.getRank() != null) ? "星级\n" + crafts.getRank() : "星级\n--");
            class_cost.setText((crafts.getCost() != null) ? "cost\n" + crafts.getCost() : "cost\n--");

            atk.setText((crafts.getAtk() != null) ? "atk\n" + crafts.getAtk() : "atk\n--");
            hp.setText((crafts.getHp() != null) ? "hp\n" + crafts.getHp() : "hp\n--");

            List<Fragment> fragments = new ArrayList<>();
            String[] tabTitle = new String[]{"高清立绘", "礼装信息"};

            fragments.add(CraftsFragment.newInstance(id, 1));
            fragments.add(CraftsFragment.newInstance(id, 2));
            adapter = new FragAdapter(getSupportFragmentManager(), fragments, tabTitle);
            vp.setAdapter(adapter);
            tab.setTabTextColors(ContextCompat.getColor(this, R.color.item_unselected), ContextCompat.getColor(this, R.color.white));
            tab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.yellow));
            ViewCompat.setElevation(tab, 10);
            tab.setupWithViewPager(vp);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadPic(int id, int type, ImageView imageView) {
        String url = null;
        if (type == 1) {
            if (id == 149 || id == 151 || id == 152 || id == 168) {
                url = "https://img.fgowiki.com/fgo/card/servant/" + id + "A.png";
            } else if (id < 10) {
                url = "https://img.fgowiki.com/fgo/card/servant/00" + id + "D.png";
            } else if (id < 100) {
                if (id == 83) {
                    url = "https://img.fgowiki.com/fgo/card/servant/0" + id + "A.png";
                } else {
                    url = "https://img.fgowiki.com/fgo/card/servant/0" + id + "D.png";
                }
            } else {
                url = "https://img.fgowiki.com/fgo/card/servant/" + id + "D.png";

            }
            Glide.with(this)
                    .load(url)
                    .into(imageView);
        } else if (type == 2) {
            if (id < 10) {
                url = "https://img.fgowiki.com/fgo/card/equip/00" + id + "A.png";
            } else if (id < 100) {
                url = "https://img.fgowiki.com/fgo/card/equip/0" + id + "A.png";
            } else {
                url = "https://img.fgowiki.com/fgo/card/equip/" + id + "A.png";
            }
            Glide.with(this)
                    .load(url)
                    .into(imageView);
        }
    }
}
