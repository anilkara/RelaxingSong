package com.teknasyon.relaxingsong.fragments.favourites.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 14.10.2018.
 */

public class FavouriteListAdapter extends RecyclerView.Adapter<FavouriteListAdapter.ItemViewHolder> {

    private Context context;
    private List<RelaxingSong> favouriteList;


    public FavouriteListAdapter(Context context, List<RelaxingSong> favouriteList) {
        this.context = context;
        this.favouriteList = favouriteList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_favourite_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        RelaxingSong favouriteSong = favouriteList.get(i);
        holder.setItemName(favouriteSong.name);
    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_name)
        TextView nameTextView;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setItemName(String name) {
            nameTextView.setText(name);
        }
    }

    public void setFavouriteList(List<RelaxingSong> favouriteList) {
        this.favouriteList = favouriteList;
        notifyDataSetChanged();
    }
}
