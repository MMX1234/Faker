package com.tri.faker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tri.faker.R;

public class SerFragment extends Fragment {
    private static final String CONTENT_TYPE = "0";


    public static SerFragment newInstance(String type) {
        Bundle arguments = new Bundle();
        arguments.putString(CONTENT_TYPE, type);
        SerFragment fragment = new SerFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_ser_skill, container, false);

        return v;
    }
}
