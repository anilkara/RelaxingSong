package com.teknasyon.relaxingsong.fragments.favourites.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
import com.teknasyon.relaxingsong.fragments.favourites.OnFavouriteAdapterListener;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by anilkara on 14.10.2018.
 */

public class FavouriteListAdapter extends RecyclerView.Adapter<FavouriteListAdapter.ItemViewHolder> {

    private Context context;
    private List<RelaxingSong> favouriteList;
    private OnFavouriteAdapterListener onFavouriteAdapterListener;


    public FavouriteListAdapter(Context context, List<RelaxingSong> favouriteList, OnFavouriteAdapterListener onFavouriteAdapterListener) {
        this.context = context;
        this.favouriteList = favouriteList;
        this.onFavouriteAdapterListener = onFavouriteAdapterListener;
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
        holder.setPlayPauseListener(favouriteSong);
        holder.setFavouriteImageListener(favouriteSong);
    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }

    public void setFavouriteList(List<RelaxingSong> favouriteList) {
        this.favouriteList = favouriteList;
        notifyDataSetChanged();
    }

    @IntDef({
            PlayerState.PLAY,
            PlayerState.PAUSE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerState {
        int PLAY = 0;
        int PAUSE = 1;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_name)
        TextView nameTextView;

        @BindView(R.id.iv_play_pause)
        ImageView playPauseImageView;

        @BindView(R.id.iv_favourite)
        ImageView favouriteImageView;

        private MediaPlayer mediaPlayer = null;
        private int playerState = PlayerState.PAUSE;

        ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setItemName(String name) {
            nameTextView.setText(name);
        }

        private void setFavouriteImageListener(final RelaxingSong favouriteSong){
            favouriteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onFavouriteAdapterListener.onFavouriteDismiss(favouriteSong);
                }
            });
        }

        private void setPlayPauseListener(final RelaxingSong favouriteSong) {
            playPauseImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (playerState == PlayerState.PAUSE) {
                        startMediaPlayer(favouriteSong.url);
                    } else {
                        stopMediaPlayer();
                    }
                }
            });
        }

        private void startMediaPlayer(String url) {

            try {
                if (mediaPlayer == null) {
                    mediaPlayer = new MediaPlayer();
                }

                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare(); // might take long! (for buffering, etc)
                mediaPlayer.start();
                playPauseImageView.setBackgroundResource(R.drawable.ic_pause_black_18dp);
            } catch (IOException e) {
                e.printStackTrace();
                playPauseImageView.setBackgroundResource(R.drawable.ic_play_arrow_black_18dp);
            }
        }

        private void stopMediaPlayer() {
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
            playPauseImageView.setBackgroundResource(R.drawable.ic_play_arrow_black_18dp);
        }
    }
}
