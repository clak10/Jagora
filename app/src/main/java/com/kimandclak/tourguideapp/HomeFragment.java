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

import com.kimandclak.tourguideapp.model.Attraction;
import com.kimandclak.tourguideapp.model.City;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment.
     */
    public HomeFragment() {
    }

    public static City createData() {
        ArrayList<Integer> photoIds = new ArrayList<>();
        List<Attraction> attractions = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            photoIds.add(R.drawable.place_holder);
            attractions.add(new Attraction("Plesure Park", R.drawable.place_holder, "This is the Hotel", photoIds));
        }

        return new City("Port Harcourt", R.drawable.place_holder, "RatingBar is used to get the rating from the app user. " +
                "A user can simply touch, drag or click on the stars to set the rating value. " +
                "The value of rating always returns a floating point number which may be 1.0, 2.5, 4.5 etc", attractions, photoIds);
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
        ListAdapter listAdapter;

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

        City portHarcourt = createData();

        descriptions.setText(portHarcourt.getDescription());

        // specify an adapters
        PhotoListAdapter photoAdapter = new PhotoListAdapter(portHarcourt.getPhotos());
        listAdapter = new ListAdapter(portHarcourt.getHighlights());
        photoList.setAdapter(photoAdapter);
        attractionList.setAdapter(listAdapter);

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
