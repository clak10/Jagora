package com.kimandclak.tourguideapp.model;

import java.util.List;

public class City {

    private String mName;
    private int mDisplayPic;
    private String mDescription;
    private List<Attraction> mHighlights;
    private List<Integer> mPhotos;

    public City(String name, int displayPic, String description, List<Attraction> highlights, List<Integer> photos) {
        mName = name;
        mDisplayPic = displayPic;
        mDescription = description;
        mHighlights = mHighlights;
        mPhotos = photos;
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

    public List<Integer> getPhotos() {
        return mPhotos;
    }

    public void setPhotos(List<Integer> photos) {
        this.mPhotos = photos;
    }
}
