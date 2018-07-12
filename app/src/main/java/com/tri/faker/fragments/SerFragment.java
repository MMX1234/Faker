package com.tri.faker.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tri.faker.R;
import com.tri.faker.data.gson.Ser;

import java.util.ArrayList;
import java.util.List;

public class SerFragment extends Fragment {
    private RecyclerView rec;
    private SerFragmentAdapter adapter;
    private List<Ser> mSers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.rec_layout, container, false);
        rec = v.findViewById(R.id.rec_view);
        adapter = new SerFragmentAdapter(mSers);
        rec.setAdapter(adapter);

        return v;
    }


    public class SerFragmentAdapter extends RecyclerView.Adapter<SerFragmentAdapter.ViewHolder> {
        private Context mContext;
        private List<Ser> mSers;

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (mContext == null) {
                mContext = parent.getContext();
            }
            View v = LayoutInflater.from(mContext).inflate(R.layout.content_ser_skill, parent, false);
            TextView textView = v.findViewById(R.id.skill_tv);
            Button button = v.findViewById(R.id.skill_button);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mSers.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ConstraintLayout layout;
            TextView tv;


            public ViewHolder(View v) {
                super(v);
                layout = (ConstraintLayout) v;
                tv = v.findViewById(R.id.skill_tv);
            }
        }

        public SerFragmentAdapter(List<Ser> mSers) {
            this.mSers = mSers;
        }
    }
}
