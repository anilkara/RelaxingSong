package com.teknasyon.relaxingsong.fragments.library.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setItemName(String name) {
            categoryNameTextView.setText(name);
        }
    }
}
