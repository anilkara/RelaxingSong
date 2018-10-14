package com.teknasyon.relaxingsong.fragments.library.librarydetail.adapter;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.data.model.RelaxingSong;
import com.teknasyon.relaxingsong.fragments.library.librarydetail.OnLibraryDetailAdapterListener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 14.10.2018.
 */

public class LibraryDetailListAdapter extends RecyclerView.Adapter<LibraryDetailListAdapter.ItemViewHolder> {

    private Context context;
    private List<RelaxingSong> favouriteList;
    private OnLibraryDetailAdapterListener onLibraryDetailAdapterListener;


    public LibraryDetailListAdapter(Context context, List<RelaxingSong> favouriteList, OnLibraryDetailAdapterListener onLibraryDetailAdapterListener) {
        this.context = context;
        this.favouriteList = favouriteList;
        this.onLibraryDetailAdapterListener = onLibraryDetailAdapterListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_library_detail_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        RelaxingSong favouriteSong = favouriteList.get(i);
        holder.setItemName(favouriteSong.name);
        holder.setFavouriteImageListener(favouriteSong);
        holder.setFavImageResource(favouriteSong);
    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }

    @IntDef({
            PlayerState.LIKE,
            PlayerState.NOTLIKE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerState {
        int LIKE = 0;
        int NOTLIKE = 1;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_name)
        TextView nameTextView;

        @BindView(R.id.iv_favourite)
        ImageView favouriteImageView;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setItemName(String name) {
            nameTextView.setText(name);
        }

        private void setFavImageResource(RelaxingSong relaxingSong){
            if (relaxingSong.isFavourite) {
                favouriteImageView.setImageResource(R.drawable.ic_favorite_black_18dp);
            } else {
                favouriteImageView.setImageResource(R.drawable.ic_favorite_border_black_18dp);
            }
        }

        private void setFavouriteImageListener(final RelaxingSong relaxingSong){
            favouriteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    relaxingSong.isFavourite = !relaxingSong.isFavourite;
                    setFavImageResource(relaxingSong);
                    onLibraryDetailAdapterListener.onFavImageClick(relaxingSong);
                }
            });
        }
    }

    public void setFavouriteList(List<RelaxingSong> favouriteList) {
        this.favouriteList = favouriteList;
        notifyDataSetChanged();
    }
}
