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
        TextView name = v.findViewById(R.id.name);
        TextView rank = v.findViewById(R.id.rank);
        TextView cost = v.findViewById(R.id.cost);
        TextView painter = v.findViewById(R.id.painter);

        TextView atkBase = v.findViewById(R.id.atk_base);
        TextView hpBase = v.findViewById(R.id.hp_base);
        TextView atkMax = v.findViewById(R.id.atk_max);
        TextView hpMax = v.findViewById(R.id.hp_max);

        ImageView icon = v.findViewById(R.id.skill_img);
        TextView skillBase = v.findViewById(R.id.skill_base);
        TextView skillMax = v.findViewById(R.id.skill_max);
        TextView description = v.findViewById(R.id.description);

        Equip equip = LitePal.find(Equip.class, getArguments().getInt(EQUIP_ID));

        name.setText((equip.getCnName() != null) ? equip.getCnName() : "--");
        rank.setText((equip.getRank() != null) ? equip.getRank() : "--");
        cost.setText((equip.getCost() != null) ? equip.getCost() : "--");
        painter.setText((equip.getPainter() != null) ? equip.getPainter() : "--");

        atkBase.setText((equip.getBaseATK() != null) ? equip.getBaseATK() : "--");
        hpBase.setText((equip.getBaseHP() != null) ? equip.getBaseHP() : "--");
        atkMax.setText((equip.getMaxATK() != null) ? equip.getMaxATK() : "--");
        hpMax.setText((equip.getMaxHP() != null) ? equip.getMaxHP() : "--");

        if (equip.getIcon() != null) {
            String url = "https://img.fgowiki.com/mobile/images/Skill/" + equip.getIcon() + ".png";
            Glide.with(this).load(url).into(icon);
        }
        skillBase.setText((equip.getSkillBase() != null) ? equip.getSkillBase() : "--");
        skillMax.setText((equip.getSkillMax() != null) ? equip.getSkillMax() : "--");
        description.setText((equip.getDescription() != null) ? equip.getDescription() : "--");

        return v;
    }
}
