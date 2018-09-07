package com.kimandclak.tourguideapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView photoList;
    private RecyclerView attractionList;
    private AppCompatTextView photoLabel;
    private AppCompatTextView attractionLabel;
    private ListAdapter mListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        photoLabel = rootView.findViewById(R.id.photo_section_label);
        photoList = rootView.findViewById(R.id.photo_list);
        attractionLabel = rootView.findViewById(R.id.attractions_section_label);
        attractionList = rootView.findViewById(R.id.attractions);

        //set Headings
        photoLabel.setText(R.string.photo_heading);
        attractionLabel.setText(R.string.attraction_heading);


        // improves performance since changes in content do not change the layout size of the RecyclerView
        photoList.setHasFixedSize(true);
        attractionList.setHasFixedSize(true);

        photoList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        // specify an adapters
        PhotoListAdapter photoAdapter = new PhotoListAdapter(MainActivity.portHarcourt.getPhotos());
        mListAdapter = new ListAdapter(MainActivity.portHarcourt.getHighlights());
        photoList.setAdapter(photoAdapter);
        attractionList.setAdapter(mListAdapter);

        return rootView;
    }

    private static class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {

        private List<Integer> mDataset;

        public PhotoListAdapter(List<Integer> dataset) {
            mDataset = dataset;
        }

        // Create new views (invoked by the layout manager)
        @NonNull
        @Override
        public PhotoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                              int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.photo_list_item, parent, false);
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
                mImageView = v.findViewById(R.id.thumbnail);
            }
        }
    }


}
