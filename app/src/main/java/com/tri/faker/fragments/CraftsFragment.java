package com.tri.faker.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.tri.faker.R;
import com.tri.faker.data.Crafts;

import org.litepal.LitePal;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class CraftsFragment extends Fragment {
    private static final String EQUIP_ID = "EQUIP_ID";
    private static final String EQUIP_FRAG = "EQUIP_FRAG";

    public static CraftsFragment newInstance(int id, int frag) {
        Bundle arguments = new Bundle();
        arguments.putInt(EQUIP_ID, id);
        arguments.putInt(EQUIP_FRAG, frag);
        CraftsFragment fragment = new CraftsFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int frag = getArguments().getInt(EQUIP_FRAG);
        int id = getArguments().getInt(EQUIP_ID);
        String url = null;
        View v = new View(getContext());

        if (frag == 1) {
            v = inflater.inflate(R.layout.content_card, container, false);
            ImageView img = v.findViewById(R.id.card_img);
            img.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            final LinearLayout line = v.findViewById(R.id.card_line);
            line.setPadding(100, 150, 100, 0);
            if (id < 10) {
                url = "https://img.fgowiki.com/fgo/card/equip/00" + id + "A.png";
            } else if (id < 100) {
                url = "https://img.fgowiki.com/fgo/card/equip/0" + id + "A.png";
            } else {
                url = "https://img.fgowiki.com/fgo/card/equip/" + id + "A.png";
            }

            Glide.with(this)
                    .load(url)
                    .apply(bitmapTransform(new BlurTransformation(25, 3)))
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            line.setBackground(resource);
                        }
                    });

            Glide.with(this)
                    .load(url)
                    .into(img);
        } else if (frag == 2) {
            v = inflater.inflate(R.layout.content_equip, container, false);
            final NestedScrollView nsv = v.findViewById(R.id.nsv);
            ImageView icon = v.findViewById(R.id.skill_img);
            TextView skill = v.findViewById(R.id.skill_base);
            TextView description = v.findViewById(R.id.description);

            Crafts crafts = LitePal.find(Crafts.class, id);

            if (crafts.getIcon() != null) {
                url = "https://www.fate.wiki" + crafts.getIcon();
                Glide.with(this).load(url).into(icon);
            }

            if (id < 10) {
                url = "https://img.fgowiki.com/fgo/card/equip/00" + id + "A.png";
            } else if (id < 100) {
                url = "https://img.fgowiki.com/fgo/card/equip/0" + id + "A.png";
            } else {
                url = "https://img.fgowiki.com/fgo/card/equip/" + id + "A.png";
            }
            Glide.with(this)
                    .load(url)
                    .apply(bitmapTransform(new BlurTransformation(25, 3)))
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            nsv.setBackground(resource);
                        }
                    });

            skill.setText((crafts.getSkill() != null) ? "固有技能\n" + crafts.getSkill() : "固有技能\n--");
            description.setText((crafts.getDescription() != null) ? "解说\n" + crafts.getDescription() : "解说\n--");
        }
        return v;
    }
}
