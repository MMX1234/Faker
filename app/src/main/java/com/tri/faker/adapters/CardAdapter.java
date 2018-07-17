package com.tri.faker.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
                Log.i("CardAdapter", String.valueOf(card.getId()));
                intent.putExtra(ItemActivity.TYPE, card.getType());
                Log.i("CardAdapter", String.valueOf(card.getType()));
                mContext.startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = mCards.get(position);
        if (card.getType() == 1) {
            Bitmap bm = BitmapFactory.decodeStream(getClass().getResourceAsStream("/assets/head/servant/" + card.getId() + ".jpg"));
            holder.cardId.setText("" + card.getId());
            Glide.with(mContext).load(bm).into(holder.cardImg);
        } else if (card.getType() == 2) {
            Bitmap bm = BitmapFactory.decodeStream(getClass().getResourceAsStream("/assets/head/equip/" + card.getId() + ".jpg"));
            holder.cardId.setText("" + card.getId());
            Glide.with(mContext).load(bm).into(holder.cardImg);
        }
    }

    private void showImg(Card card) {
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView cardImg;
        TextView cardId;


        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v;
            cardImg = v.findViewById(R.id.card_img);
            cardId = v.findViewById(R.id.card_id);
        }
    }

    public CardAdapter(List<Card> cards) {
        this.mCards = cards;
    }
}
