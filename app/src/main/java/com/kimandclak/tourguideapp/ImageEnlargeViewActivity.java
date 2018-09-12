package com.kimandclak.tourguideapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;

public class ImageEnlargeViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        setTitle(R.string.title_activity_attractions_info);

        int imageId = getIntent().getIntExtra("Image_ID", 0);
        AppCompatImageView image = findViewById(R.id.large_photo);
        image.setImageResource(imageId);
    }
}
