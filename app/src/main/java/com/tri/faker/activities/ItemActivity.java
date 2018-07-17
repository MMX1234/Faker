package com.tri.faker.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tri.faker.R;
import com.tri.faker.adapters.FragAdapter;
import com.tri.faker.data.Equip;
import com.tri.faker.data.Ser;
import com.tri.faker.fragments.EquipFragment;
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

        Log.i("ItemMain", String.valueOf(id + "    " + type));

        Ser ser = LitePal.find(Ser.class, id);
        Equip equip = LitePal.find(Equip.class, id);

        Toolbar toolbar = findViewById(R.id.toolbar_second);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        vp = findViewById(R.id.vp_second);
        tab = findViewById(R.id.tabs_second);

        ImageView baseHead = findViewById(R.id.base_head);
        TextView baseRank = findViewById(R.id.base_rank);
        TextView baseClass = findViewById(R.id.base_class);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.top_blue, null));

        if (type == 1) {
            collapsingToolbar.setTitle(ser.getCnName());
            Bitmap bm = BitmapFactory.decodeStream(getClass().getResourceAsStream("/assets/head/servant/" + id + ".jpg"));
            Glide.with(this).load(bm).into(baseHead);
            baseRank.setText(ser.getRank());
            baseClass.setText(ser.getSerKind());

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
            collapsingToolbar.setTitle(equip.getCnName());
            Bitmap bm = BitmapFactory.decodeStream(getClass().getResourceAsStream("/assets/head/equip/" + id + ".jpg"));
            Glide.with(this).load(bm).into(baseHead);
            baseRank.setText(equip.getRank());
            baseClass.setText(equip.getCost());

            List<Fragment> fragments = new ArrayList<>();
            String[] tabTitle = new String[]{"礼装信息"};

            fragments.add(EquipFragment.newInstance(id));
            adapter = new FragAdapter(getSupportFragmentManager(), fragments, tabTitle);
            vp.setAdapter(adapter);
            tab.setTabTextColors(ContextCompat.getColor(this, R.color.item_unselected), ContextCompat.getColor(this, R.color.white));
            tab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.yellow));
            ViewCompat.setElevation(tab, 10);
            tab.setupWithViewPager(vp);
        }
        //loadPic(cardImageId, type, itemImageView);
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

    public void loadPic(int cardImageId, int type, ImageView itemImageView) {
        String url = null;
        if (type == 1) {
            if (cardImageId == 149 || cardImageId == 151 || cardImageId == 152 || cardImageId == 168) {
                url = "https://img.fgowiki.com/fgo/card/servant/" + cardImageId + "A.png";
            } else if (cardImageId < 10) {
                url = "https://img.fgowiki.com/fgo/card/servant/00" + cardImageId + "D.png";
            } else if (cardImageId < 100) {
                if (cardImageId == 83) {
                    url = "https://img.fgowiki.com/fgo/card/servant/0" + cardImageId + "A.png";
                } else {
                    url = "https://img.fgowiki.com/fgo/card/servant/0" + cardImageId + "D.png";
                }
            } else {
                url = "https://img.fgowiki.com/fgo/card/servant/" + cardImageId + "D.png";

            }
            Glide.with(this)
                    .load(url)
                    .into(itemImageView);
        } else if (type == 2) {
            if (cardImageId < 10) {
                url = "https://img.fgowiki.com/fgo/card/equip/00" + cardImageId + "A.png";
            } else if (cardImageId < 100) {
                url = "https://img.fgowiki.com/fgo/card/equip/0" + cardImageId + "A.png";
            } else {
                url = "https://img.fgowiki.com/fgo/card/equip/" + cardImageId + "A.png";
            }
            Glide.with(this)
                    .load(url)
                    .into(itemImageView);
        }
    }
}
