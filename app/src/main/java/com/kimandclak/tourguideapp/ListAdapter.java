package com.kimandclak.tourguideapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimandclak.tourguideapp.model.Attraction;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Attraction> mDataset;

    public ListAdapter(List<Attraction> myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.att_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Attraction att = mDataset.get(position);
        holder.mImageView.setImageResource(att.getDisplayPic());
        holder.mName.setText(att.getName());
        holder.mDescription.setText(att.getDescription());
        if (att.isShowRating())
            holder.mRatingBar.setRating(att.getRating());
        else
            holder.mRatingBar.setVisibility(View.INVISIBLE);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        AppCompatImageView mImageView;
        AppCompatTextView mName;
        AppCompatTextView mDescription;
        AppCompatRatingBar mRatingBar;

        ViewHolder(View v) {
            super(v);
            mImageView = v.findViewById(R.id.attraction_thumbnail);
            mName = v.findViewById(R.id.att_name);
            mDescription = v.findViewById(R.id.att_desc);
            mRatingBar = v.findViewById(R.id.rate_bar);
        }
    }
}
