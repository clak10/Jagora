package com.kimandclak.tourguideapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a mCity.
 */
public class City {

    private String mName;
    private int mDisplayPic;
    private String mDescription;
    private double[] mLocation;
    private List<Attraction> mHighlights;
    private List<Attraction> mHotels;
    private List<Attraction> mRestaurants;
    private ArrayList<Integer> mPhotos;


    /**
     * Public constructors
     *
     * @param name        the name of the mCity.
     * @param displayPic  resource Id of the image used as main display.
     * @param description a short write up about the mCity.
     * @param location    an array contain Longitude and Latitude.
     * @param highlights  a list of major attractions in the mCity.
     * @param hotels      a list of some top hotels in the mCity.
     * @param restaurants a list of some of the top restaurants  in the mCity.
     */
    public City(String name, int displayPic, String description, double[] location, List<Attraction> highlights, List<Attraction> hotels, List<Attraction> restaurants) {
        mName = name;
        mDisplayPic = displayPic;
        mDescription = description;
        mHighlights = highlights;
        mHotels = hotels;
        mRestaurants = restaurants;
        mLocation = location;
        mPhotos = new ArrayList<>();
        addPhotos(highlights);
    }

    private void addPhotos(List<Attraction> highlights) {
        for (Attraction e : highlights) {
            mPhotos.addAll(e.getPhotos());
        }
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double[] getLocation() {
        return mLocation;
    }

    public void setLocation(double[] location) {
        this.mLocation = location;
    }

    public int getDisplayPicId() {
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

    public List<Attraction> getHotels() {
        return mHotels;
    }

    public void setHotels(List<Attraction> hotels) {
        this.mHotels = hotels;
    }

    public List<Attraction> getRestaurants() {
        return mRestaurants;
    }

    public void setRestaurant(List<Attraction> restaurants) {
        this.mRestaurants = restaurants;
    }

    public void setPhotos(ArrayList<Integer> photos) {
        this.mPhotos = photos;
    }
}
