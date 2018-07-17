package com.quangnv.threadhandlerasynctaskdemo.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.quangnv.threadhandlerasynctaskdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ItemViewHolder> {

    private List<String> mFiles;
    private LayoutInflater mLayoutInflater;

    public ImageAdapter(Context context) {
        mFiles = new ArrayList<>();
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_recycler_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Glide.with(holder.mImageView.getContext())
                .load(mFiles.get(position))
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mFiles.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;

        public ItemViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
        }
    }

    public void setFiles(List<String> files) {
        mFiles = files;
//        notifyDataSetChanged();
    }

}
