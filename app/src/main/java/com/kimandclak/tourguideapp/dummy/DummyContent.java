package com.kimandclak.tourguideapp.dummy;

import android.content.Context;

import com.kimandclak.tourguideapp.R;
import com.kimandclak.tourguideapp.model.Attraction;
import com.kimandclak.tourguideapp.model.City;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyContent {

    public static City createData(Context context) {
        List<Attraction> attractions = Arrays.asList(new Attraction(context.getString(R.string.pleasure_park),
                        R.drawable.ppk_cover, context.getString(R.string.pleasure_park_description),
                        new ArrayList<>(Arrays.asList(R.drawable.ppk01, R.drawable.ppk02, R.drawable.ppk03, R.drawable.ppk04, R.drawable.ppk05))),
                new Attraction(context.getString(R.string.isaac_boro_park),
                        R.drawable.ibp_cover, context.getString(R.string.isaac_boro_decription),
                        new ArrayList<>(Arrays.asList(R.drawable.ibp01, R.drawable.ibp02, R.drawable.ibp03))),
                new Attraction(context.getString(R.string.port_harcourt_zoo),
                        R.drawable.pz_cover, context.getString(R.string.ph_zoo_description),
                        new ArrayList<>(Arrays.asList(R.drawable.pz01, R.drawable.pz02, R.drawable.pz03, R.drawable.pz04, R.drawable.pz05))),
                new Attraction(context.getString(R.string.port_harcourt_mall),
                        R.drawable.phm01, context.getString(R.string.ph_mall_decription),
                        new ArrayList<>(Arrays.asList(R.drawable.phm01, R.drawable.phm02, R.drawable.phm03))));

        List<Attraction> hotels = Arrays.asList(new Attraction(context.getString(R.string.novotel),
                        R.drawable.hotel01, context.getString(R.string.novotel_details),
                        4.2f),
                new Attraction(context.getString(R.string.le_meridien),
                        R.drawable.hotel02, context.getString(R.string.le_meridien_details),
                        4.2f),
                new Attraction(context.getString(R.string.hotel_presidential),
                        R.drawable.hotel03, context.getString(R.string.hotel_presidential_details),
                        4.2f),
                new Attraction(context.getString(R.string.golden_tulip_phc),
                        R.drawable.hotel03, context.getString(R.string.golden_tulip_phc_details),
                        3.9f));

        List<Attraction> restaurants = Arrays.asList(new Attraction(context.getString(R.string.asia_town),
                R.drawable.res01, context.getString(R.string.asia_town_details),
                4.2f), new Attraction(context.getString(R.string.charcoal_and_spice_phc),
                R.drawable.res02, context.getString(R.string.charcoal_and_spice),
                4.0f), new Attraction(context.getString(R.string.jevinik),
                R.drawable.res03, context.getString(R.string.jevinik_details),
                4.2f));

        return new City(context.getString(R.string.port_harcourt), R.drawable.ph_cover,
                context.getString(R.string.description_of_PHC), new double[]{4.77742, 7.0134}, attractions, hotels, restaurants);
    }
}
