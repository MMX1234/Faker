package com.tri.faker.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tri.faker.R;
import com.tri.faker.adapters.CardAdapter;
import com.tri.faker.data.Card;
import com.tri.faker.data.Crafts;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class EquipMainFrag extends Fragment {
    private static final String CONTENT_RANK = "CONTENT_RANK";
    private List<Card> cardList = new ArrayList<>();

    public static ContentFragment newInstance(String rank) {
        Bundle arguments = new Bundle();
        arguments.putString(CONTENT_RANK, rank);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(arguments);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.rec_layout, container, false);
        String rank = getArguments().getString(CONTENT_RANK);

        List<Crafts> crafts = LitePal
                .select("id")
                .where("rank = ", rank)
                .order("id")
                .find(Crafts.class);
        for (int i = 0; i < crafts.size(); i++) {
            Card[] cards = {
                    new Card(crafts.get(i).getId(), 2)
            };
            cardList.add(cards[0]);
        }

        RecyclerView rec = v.findViewById(R.id.rec_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        CardAdapter adapter = new CardAdapter(cardList);
        rec.setLayoutManager(layoutManager);
        rec.setAdapter(adapter);

        return v;
    }
}
