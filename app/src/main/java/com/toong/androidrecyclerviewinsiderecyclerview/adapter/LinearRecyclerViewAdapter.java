package com.toong.androidrecyclerviewinsiderecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.toong.androidrecyclerviewinsiderecyclerview.R;
import com.toong.androidrecyclerviewinsiderecyclerview.model.Item;
import java.util.ArrayList;

public class LinearRecyclerViewAdapter
        extends RecyclerView.Adapter<LinearRecyclerViewAdapter.ViewHolder> {

    private Item[] mData;
    private LayoutInflater mInflater;
    private LinearItemClickListener mLinearItemClickListener;

    public LinearRecyclerViewAdapter(Context context, Item[] data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.linear_item, parent, false);
        return new ViewHolder(view, mLinearItemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RecyclerView mRecyclerView;
        private LinearItemClickListener mLinearItemClickListener;

        ViewHolder(View itemView, LinearItemClickListener linearItemClickListener) {
            super(itemView);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
            mLinearItemClickListener = linearItemClickListener;

            ArrayList<Item> data = new ArrayList<>();
            data.add(new Item("a", "b"));
            data.add(new Item("c", "b"));
            data.add(new Item("d", "b"));
            data.add(new Item("e", "b"));
            data.add(new Item("f", "b"));
            data.add(new Item("g", "b"));
            data.add(new Item("h", "b"));
            data.add(new Item("j", "b"));

            GridRecyclerViewAdapter adapter = new GridRecyclerViewAdapter(itemView.getContext(),
                    data.toArray(new Item[data.size()]));
            adapter.setItemClickListener(new GridRecyclerViewAdapter.ItemClickListener() {
                @Override
                public void onItemClick(View v, int gridPosition) {
                    mLinearItemClickListener.onItemClick(getAdapterPosition(), gridPosition);
                }
            });
            mRecyclerView.setAdapter(adapter);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mLinearItemClickListener.onItemClick(getAdapterPosition(), -1);
        }
    }

    public interface LinearItemClickListener {
        void onItemClick(int linearPosition, int gridPosition);
    }

    public void setClickListener(LinearItemClickListener itemClickListener) {
        this.mLinearItemClickListener = itemClickListener;
    }
}