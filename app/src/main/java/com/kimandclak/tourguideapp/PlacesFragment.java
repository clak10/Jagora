package com.kimandclak.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimandclak.tourguideapp.model.Attraction;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {

    public PlacesFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        RecyclerView hotelList = rootView.findViewById(R.id.hotel_list);
        RecyclerView restaurant = rootView.findViewById(R.id.restaurant_list);

        // improves performance since changes in content do not change the layout size of the RecyclerView
        hotelList.setHasFixedSize(true);
        restaurant.setHasFixedSize(true);

        List<Attraction> attractions = createData();


        ListAdapter hListAdapter = new ListAdapter(attractions);
        hotelList.setAdapter(hListAdapter);
        ListAdapter rListAdapter = new ListAdapter(attractions);
        restaurant.setAdapter(rListAdapter);

        return rootView;
    }

    public List<Attraction> createData() {
        ArrayList<Integer> photoIds = new ArrayList<>();
        List<Attraction> attractions = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            float rating = (float) Math.abs(5.0 - 10.0 * Math.random());
            photoIds.add(R.drawable.place_holder);
            attractions.add(new Attraction("Plesure Park", R.drawable.place_holder, "This is the Hotel", photoIds, rating));
        }

        return attractions;
    }

}
