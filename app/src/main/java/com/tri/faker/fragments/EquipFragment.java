package com.tri.faker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tri.faker.R;
import com.tri.faker.data.Equip;

import org.litepal.LitePal;

public class EquipFragment extends Fragment {
    private static final String EQUIP_ID = "48";

    public static EquipFragment newInstance(int id) {
        Bundle arguments = new Bundle();
        arguments.putInt(EQUIP_ID, id);
        EquipFragment fragment = new EquipFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_equip, container, false);


        ImageView icon = v.findViewById(R.id.skill_img);
        TextView skillBase = v.findViewById(R.id.skill_base);
        TextView skillMax = v.findViewById(R.id.skill_max);
        TextView description = v.findViewById(R.id.description);

        Equip equip = LitePal.find(Equip.class, getArguments().getInt(EQUIP_ID));

        if (equip.getIcon() != null) {
            String url = "https://img.fgowiki.com/mobile/images/Skill/" + equip.getIcon() + ".png";
            Glide.with(this).load(url).into(icon);
        }
        skillBase.setText((equip.getSkillBase() != null) ? "固有技能\n" + equip.getSkillBase() : "固有技能\n--");
        skillMax.setText((equip.getSkillMax() != null) ? "界限突破\n" + equip.getSkillMax() : "界限突破\n--");
        description.setText((equip.getDescription() != null) ? "解说\n" + equip.getDescription() : "解说\n--");

        return v;
    }
}
