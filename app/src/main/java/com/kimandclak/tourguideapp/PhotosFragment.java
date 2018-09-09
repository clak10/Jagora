package com.kimandclak.tourguideapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment {


    public PhotosFragment() {
    }

    public static ArrayList<Integer> createData() {
        ArrayList<Integer> photoIds = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            photoIds.add(R.drawable.place_holder);
        }
        return photoIds;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.photos);

        LargePhotoAdapter largePhotoAdapter = new LargePhotoAdapter(createData());

        recyclerView.setAdapter(largePhotoAdapter);

        return rootView;
    }


    private static class LargePhotoAdapter extends RecyclerView.Adapter<LargePhotoAdapter.ViewHolder> {

        private ArrayList<Integer> mDataset;

        public LargePhotoAdapter(ArrayList<Integer> dataset) {
            mDataset = dataset;
        }

        // Create new views (invoked by the layout manager)
        @NonNull
        @Override
        public LargePhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                               int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.large_photo_list_item, parent, false);
            return new ViewHolder(v);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mImageView.setImageResource(mDataset.get(position));

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        static class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            AppCompatImageView mImageView;

            ViewHolder(View v) {
                super(v);
                mImageView = v.findViewById(R.id.large_photo);
            }
        }
    }

}
