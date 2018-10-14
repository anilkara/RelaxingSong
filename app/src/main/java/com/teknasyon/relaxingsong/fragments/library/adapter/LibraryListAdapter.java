package com.teknasyon.relaxingsong.fragments.library.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teknasyon.relaxingsong.R;
import com.teknasyon.relaxingsong.data.model.LibraryResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 14.10.2018.
 */

public class LibraryListAdapter extends RecyclerView.Adapter<LibraryListAdapter.ItemViewHolder> {

    private Context context;
    private List<LibraryResponse> libraryResponseList;

    public LibraryListAdapter(Context context, List<LibraryResponse> libraryResponseList) {
        this.context = context;
        this.libraryResponseList = libraryResponseList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_library_list, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int i) {
        LibraryResponse libraryResponse = libraryResponseList.get(i);
        holder.setItemName(libraryResponse.categoryName);
        holder.setBackground(libraryResponse.backgroundUrl);
    }

    @Override
    public int getItemCount() {
        return libraryResponseList.size();
    }

    public void setLibraryResponseList(List<LibraryResponse> libraryResponseList) {
        this.libraryResponseList = libraryResponseList;
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_category_name)
        TextView categoryNameTextView;

        @BindView(R.id.iv_category)
        ImageView categoryImageView;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        // sets item name s
        private void setItemName(String name) {
            categoryNameTextView.setText(name);
        }

        //sets background image
        private void setBackground(String base64){
            Picasso.get()
                    .load(base64)
                    .placeholder(R.drawable.bg_waiting_placeholder)
                    .error(R.drawable.bg_error_placeholder)
                    .into(categoryImageView);
        }
    }
}
