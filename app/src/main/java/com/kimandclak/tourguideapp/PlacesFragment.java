package com.kimandclak.tourguideapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimandclak.tourguideapp.model.Attraction;

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
        RecyclerView restaurantList = rootView.findViewById(R.id.restaurant_list);

        // improves performance since changes in content do not change the layout size of the RecyclerView
        hotelList.setHasFixedSize(true);
        restaurantList.setHasFixedSize(true);

        List<Attraction> hotels = MainActivity.getmCity().getHotels();
        List<Attraction> restaurants = MainActivity.getmCity().getRestaurants();


        ListAdapter hListAdapter = new ListAdapter(hotels);
        hotelList.setAdapter(hListAdapter);
        ListAdapter rListAdapter = new ListAdapter(restaurants);
        restaurantList.setAdapter(rListAdapter);

        return rootView;
    }

}
