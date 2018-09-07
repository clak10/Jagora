package com.kimandclak.tourguideapp.dummy;

import com.kimandclak.tourguideapp.R;
import com.kimandclak.tourguideapp.model.Attraction;
import com.kimandclak.tourguideapp.model.City;

import java.util.ArrayList;
import java.util.List;

public class DummyContent {

    public static City createData() {
        List<Integer> photoIds = new ArrayList();
        photoIds.add(R.drawable.place_holder);
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction("Plesure Park", R.drawable.place_holder, "RatingBar is used to get the rating from the app user. " +
                "A user can simply touch, drag or click on the stars to set the rating value. " +
                "The value of rating always returns a floating point number which may be 1.0, 2.5, 4.5 etc", photoIds));

        return new City("Port Harcourt", R.drawable.place_holder, "This is Port Harcourt", attractions, photoIds);
    }
}
