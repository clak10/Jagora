package com.kimandclak.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kimandclak.tourguideapp.model.Attraction;
import com.kimandclak.tourguideapp.model.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AttractionsInfoActivity extends AppCompatActivity {

    int[] photoIds = {R.id.photo1, R.id.photo2, R.id.photo5, R.id.photo3, R.id.photo4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        City city = MainActivity.getmCity();

        Attraction attraction = getIntent().getParcelableExtra("Attraction");

        setTitle(attraction.getName());

        AppCompatImageView dp = findViewById(R.id.main_display_pic);
        dp.setImageResource(attraction.getDisplayPic());

        AppCompatImageView mapButton = findViewById(R.id.map_image);
        mapButton.setOnClickListener(e -> {
            String s = "geo:" + city.getLocation()[0] + ", " + city.getLocation()[1] + "?q=" + attraction.getName();
            Uri gmmIntentUri = Uri.parse(s);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        });

        AppCompatTextView description = findViewById(R.id.att_desc);
        description.setText(attraction.getDescription());
        //Make the photo display order random
        ArrayList<Integer> m = getIntent().getIntegerArrayListExtra("Photos");
        ArrayList<Integer> myData = new ArrayList<>(m);
        Collections.shuffle(myData);

        HashMap<AppCompatImageView, Integer> photos = new HashMap<>();
        for (int i = 0; i < photoIds.length; i++) {
            AppCompatImageView photo = findViewById(photoIds[i]);
            if (i < myData.size()) {
                photo.setImageResource(myData.get(i));

                //Ensures ImageView has reference to prevent garbage collection
                photos.put(photo, myData.get(i));

                photo.setOnClickListener(e -> {
                    Intent intent = new Intent(this, ImageEnlargeViewActivity.class);
                    intent.putExtra("Title", attraction.getName());
                    intent.putExtra("Image_ID", photos.get(photo));
                    startActivity(intent);
                });
            } else
                photo.setVisibility(View.GONE);
        }
    }

}
