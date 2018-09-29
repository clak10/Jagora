package com.kimandclak.tourguideapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * A class representing a place of interest in a mCity
 */
public class Attraction implements Parcelable {

    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel in) {
            return new Attraction(in);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };
    private String mName;
    private int mDisplayPic;
    private String mDescription;
    private ArrayList<Integer> mPhotos;
    private float mRating;
    private boolean mShowRating;

    /**
     * Public constructors
     *
     * @param name        the name of the place
     * @param displayPic  resource Id of the image used as man display
     * @param description a short write up about the place
     * @param photos      a list of resource Id for photos of the place
     */
    public Attraction(String name, int displayPic, String description, ArrayList<Integer> photos) {
        mName = name;
        mDisplayPic = displayPic;
        mDescription = description;
        mPhotos = photos;
        mRating = 0;
        mShowRating = false;
    }

    /**
     * Public constructors for Attraction with rating
     *
     * @param name
     * @param displayPic
     * @param description
     * @param rating
     */
    public Attraction(String name, int displayPic, String description, float rating) {
        mName = name;
        mDisplayPic = displayPic;
        mDescription = description;
        mPhotos = null;
        mRating = rating;
        mShowRating = true;
    }

    protected Attraction(Parcel in) {
        mName = in.readString();
        mDisplayPic = in.readInt();
        mDescription = in.readString();
        mRating = in.readFloat();
        mShowRating = in.readByte() != 0;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mName);
        parcel.writeInt(mDisplayPic);
        parcel.writeString(mDescription);
        parcel.writeFloat(mRating);
        parcel.writeByte((byte) (mShowRating ? 1 : 0));
    }
}
