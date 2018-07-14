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
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tri.faker.R;
import com.tri.faker.adapters.FragAdapter;
import com.tri.faker.data.gson.Ser;
import com.tri.faker.fragments.SerFragment;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class ItemActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";
    public static final String TYPE = "1";

    private List<Fragment> fragments = new ArrayList<>();
    public static final String[] tabTitle = new String[]{"技能", "资料", "模型", "语音"};
    private FragAdapter adapter;
    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        Intent intent = getIntent();
        String cardName = intent.getStringExtra(FRUIT_NAME);
        int cardImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 1);
        int type = intent.getIntExtra(TYPE, 1);

        Ser ser = LitePal.find(Ser.class, cardImageId);

        Toolbar toolbar = findViewById(R.id.toolbar_second);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(ser.getCnName());
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(R.color.text_blue, null));

        ImageView baseHead = findViewById(R.id.base_head);
        TextView baseRank = findViewById(R.id.base_rank);
        TextView baseClass = findViewById(R.id.base_class);

        Bitmap bm = BitmapFactory.decodeStream(getClass().getResourceAsStream("/assets/head/servant/" + cardImageId + ".jpg"));
        Glide.with(this).load(bm).into(baseHead);

        baseRank.setText(ser.getRank());
        baseClass.setText(ser.getSerKind());

//        if (cardImageId == 1) {
//            Toast.makeText(this, "职阶：" + ser.getSerKind(), Toast.LENGTH_SHORT).show();
//        }

        //loadPic(cardImageId, type, itemImageView);


        fragments.add(new SerFragment());
        fragments.add(new SerFragment());
        fragments.add(new SerFragment());
        fragments.add(new SerFragment());

        adapter = new FragAdapter(getSupportFragmentManager(), fragments, tabTitle);

        vp = findViewById(R.id.vp_second);
        vp.setAdapter(adapter);

        tab = findViewById(R.id.tabs_second);
        tab.setTabMode(TabLayout.MODE_FIXED);
        tab.setTabTextColors(ContextCompat.getColor(this, R.color.item_unselected), ContextCompat.getColor(this, R.color.white));
        tab.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.yellow));
        ViewCompat.setElevation(tab, 10);
        tab.setupWithViewPager(vp);
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
