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

import java.util.ArrayList;
import java.util.List;

public class ContentFragment extends Fragment {
    private static final String EXTRA_CONTENT = "0";
    private RecyclerView rec;
    private CardAdapter adapter;
    private List<Card> cardList = new ArrayList<>();

    public static ContentFragment newInstance(String type) {
        Bundle arguments = new Bundle();
        arguments.putString(EXTRA_CONTENT, type);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.rec_layout, container, false);

        initCards(getArguments().getString(EXTRA_CONTENT));
        rec = v.findViewById(R.id.rec_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        adapter = new CardAdapter(cardList);
        rec.setLayoutManager(layoutManager);
        rec.setAdapter(adapter);

        return v;
    }

    private void initCards(String cardType) {
        cardList.clear();
        if (cardType.equals("1")) {
            for (int i = 1; i <= 211; i++) {
                Card[] cards = {
                        new Card("" + i, i, 1)
                };
                cardList.add(cards[0]);
            }
        } else if (cardType.equals("2")) {
            for (int i = 1; i <= 811; i++) {
                Card[] cards = {
                        new Card("" + i, i, 2)
                };
                cardList.add(cards[0]);
            }
        }
    }
}
