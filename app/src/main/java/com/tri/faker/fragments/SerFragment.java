package com.tri.faker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tri.faker.R;
import com.tri.faker.data.Ser;

import org.litepal.LitePal;

public class SerFragment extends Fragment {
    private static final String CARD_ID = "0";


    public static SerFragment newInstance(int type) {
        Bundle arguments = new Bundle();
        arguments.putInt(CARD_ID, type);
        SerFragment fragment = new SerFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_ser_skill, container, false);
        TextView tv = v.findViewById(R.id.testText);

        Ser ser = LitePal.find(Ser.class, getArguments().getInt(CARD_ID));
        tv.setText(ser.getSkill());

        return v;
    }
}
