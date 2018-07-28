package com.tri.faker.fragments;

import android.os.Bundle;
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
import com.tri.faker.data.Equip;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment {
    private static final String EXTRA_CONTENT = "EXTRA_CONTENT";
    private static final String CONTENT_RANK = "CONTENT_RANK";
    private List<Card> cardList = new ArrayList<>();

    public static ContentFragment newInstance(int type, String rank) {
        Bundle arguments = new Bundle();
        arguments.putInt(EXTRA_CONTENT, type);
        arguments.putString(CONTENT_RANK, rank);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.rec_layout, container, false);
        int type = getArguments().getInt(EXTRA_CONTENT);
        String rank = getArguments().getString(CONTENT_RANK);
        if (("1").equals(rank)) {
            List<Equip> equips = LitePal
                    .select("id")
                    .where("rank = ", rank)
                    .order("id")
                    .find(Equip.class);
            for (int i = 0; i < equips.size(); i++) {
                Card[] cards = {
                        new Card(equips.get(i).getId(), 2)
                };
                cardList.add(cards[0]);
            }
        } else if (("2").equals(rank)) {

        }
        initCards(type);
        RecyclerView rec = v.findViewById(R.id.rec_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        CardAdapter adapter = new CardAdapter(cardList);
        rec.setLayoutManager(layoutManager);
        rec.setAdapter(adapter);

        return v;
    }

    private void initCards(int type) {
        cardList.clear();
        if (type == 1) {
            for (int i = 1; i <= 212; i++) {
                Card[] cards = {
                        new Card(i, 1)
                };
                cardList.add(cards[0]);
            }
        } else if (type == 2) {
            for (int i = 1; i <= 812; i++) {
                Card[] cards = {
                        new Card(i, 2)
                };
                cardList.add(cards[0]);
            }
        }
    }
}
