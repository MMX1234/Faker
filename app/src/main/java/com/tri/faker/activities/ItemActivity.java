package com.tri.faker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tri.faker.R;
import com.tri.faker.data.gson.Ser;

import org.litepal.LitePal;

public class ItemActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";
    public static final String TYPE = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_servant);

        Intent intent = getIntent();
        String cardName = intent.getStringExtra(FRUIT_NAME);
        int cardImageId = intent.getIntExtra(FRUIT_IMAGE_ID, 1);
        int type = intent.getIntExtra(TYPE, 1);


        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView itemImageView = findViewById(R.id.item_image_view);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Ser ser = LitePal.find(Ser.class, cardImageId);

        collapsingToolbar.setTitle(cardName);
        if (cardImageId == 1) {
            Toast.makeText(this, "职阶：" + ser.getSerKind(), Toast.LENGTH_SHORT).show();
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
