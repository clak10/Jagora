package com.kimandclak.tourguideapp.model;

import java.util.ArrayList;

public class Attraction {

    private String mName;
    private int mDisplayPic;
    private String mDescription;
    private ArrayList<Integer> mPhotos;
    private float mRating;
    private boolean mShowRating;

    public Attraction(String name, int displayPic, String description, ArrayList<Integer> photos) {
        mName = name;
        mDisplayPic = displayPic;
        mDescription = description;
        mPhotos = photos;
        mRating = 0;
        mShowRating = false;
    }

    public Attraction(String name, int displayPic, String description, ArrayList<Integer> photos, float rating) {
        mName = name;
        mDisplayPic = displayPic;
        mDescription = description;
        mPhotos = photos;
        mRating = rating;
        mShowRating = true;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getDisplayPic() {
        return mDisplayPic;
    }

    public void setDisplayPic(int displayPic) {
        this.mDisplayPic = displayPic;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public ArrayList<Integer> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(ArrayList<Integer> mPhotos) {
        this.mPhotos = mPhotos;
    }

    public float getRating() {
        return mRating;
    }

    public void setRating(float rating) {
        this.mRating = rating;
    }

    public boolean isShowRating() {
        return mShowRating;
    }

    public void setShowRating(boolean showRating) {
        this.mShowRating = showRating;
    }
}
