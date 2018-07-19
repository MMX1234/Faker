package com.tri.faker.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tri.faker.R;
import com.tri.faker.activities.ItemActivity;
import com.tri.faker.data.Card;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    private Context mContext;
    private List<Card> mCards;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View v = LayoutInflater.from(mContext).inflate(R.layout.content_card, parent, false);
        final ViewHolder holder = new ViewHolder(v);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Card card = mCards.get(position);
                Intent intent = new Intent(mContext, ItemActivity.class);
                intent.putExtra(ItemActivity.ID, card.getId());
                intent.putExtra(ItemActivity.TYPE, card.getType());
                if (card.getType() == 1) {
                    Toast.makeText(mContext, "功能完善中。。。请查看礼装一览", Toast.LENGTH_SHORT).show();
                } else {
                    mContext.startActivity(intent);
                }
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = mCards.get(position);
        showImg(card, holder);
    }

    private void showImg(Card card, ViewHolder holder) {
        int type = card.getType();
        int id = card.getId();
        String url = null;
        if (type == 1) {
            if (id < 10) {
                url = "https://img.fgowiki.com/fgo/head/00" + id + ".jpg";
            } else if (id < 100) {
                url = "https://img.fgowiki.com/fgo/head/0" + id + ".jpg";
            } else {
                url = "https://img.fgowiki.com/fgo/head/" + id + ".jpg";
            }
            holder.cardId.setText(String.valueOf(card.getId()));
            Glide.with(mContext)
                    .load(url)
                    .into(holder.cardImg);
        } else if (type == 2) {
            if (id < 10) {
                url = "https://cdn.fgowiki.com/fgo/equip/00" + id + ".jpg";
            } else if (id < 100) {
                url = "https://cdn.fgowiki.com/fgo/equip/0" + id + ".jpg";
            } else {
                url = "https://cdn.fgowiki.com/fgo/equip/" + id + ".jpg";
            }
            holder.cardId.setText(String.valueOf(card.getId()));
            Glide.with(mContext)
                    .load(url)
                    .into(holder.cardImg);
        }
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        LinearLayout linearLayout;
        ImageView cardImg;
        TextView cardId;


        public ViewHolder(View v) {
            super(v);
            linearLayout = (LinearLayout) v;
            cardView = v.findViewById(R.id.card_view);
            cardImg = v.findViewById(R.id.card_img);
            cardId = v.findViewById(R.id.card_id);
        }
    }

    public CardAdapter(List<Card> cards) {
        this.mCards = cards;
    }
}
