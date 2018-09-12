package com.kimandclak.tourguideapp;

import android.content.Intent;
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

import com.kimandclak.tourguideapp.model.Attraction;
import com.kimandclak.tourguideapp.model.City;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment.
     */
    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView photoList;
        RecyclerView attractionList;
        AppCompatTextView descriptions;
        AppCompatTextView photoLabel;
        AppCompatTextView attractionLabel;
        final ListAdapter listAdapter;

        descriptions = rootView.findViewById(R.id.city_desc);
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

        final City city = MainActivity.getmCity();

        descriptions.setText(city.getDescription());

        // specify an adapters
        PhotoListAdapter photoAdapter = new PhotoListAdapter(city.getPhotos());
        listAdapter = new ListAdapter(city.getHighlights());
        photoList.setAdapter(photoAdapter);
        attractionList.setAdapter(listAdapter);
        attractionList.addOnItemTouchListener(new RecyclerTouchListener(getContext(), attractionList, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Attraction attraction = city.getHighlights().get(position);
                Intent i = new Intent(getActivity(), AttractionsInfoActivity.class);
                i.putExtra("Attraction", attraction);
                i.putIntegerArrayListExtra("Photos", attraction.getPhotos());
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return rootView;
    }

    private static class PhotoListAdapter extends RecyclerView.Adapter<PhotoListAdapter.ViewHolder> {

        private ArrayList<Integer> mDataset;

        public PhotoListAdapter(ArrayList<Integer> dataset) {
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
