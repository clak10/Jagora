package com.kimandclak.tourguideapp.model;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String mName;
    private int mDisplayPic;
    private String mDescription;
    private List<Attraction> mHighlights;
    private ArrayList<Integer> mPhotos;

    public City(String name, int displayPic, String description, List<Attraction> highlights, ArrayList<Integer> photos) {
        mName = name;
        mDisplayPic = displayPic;
        mDescription = description;
        mHighlights = highlights;

        mPhotos = photos;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getDisplayPic() {
        return mDisplayPic;
    }

    public void setDisplayPic(int mdisplayPic) {
        this.mDisplayPic = mdisplayPic;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public List<Attraction> getHighlights() {
        return mHighlights;
    }

    public void setHighlights(List<Attraction> highlights) {
        this.mHighlights = highlights;
    }

    public ArrayList<Integer> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(ArrayList<Integer> photos) {
        this.mPhotos = photos;
    }
}
