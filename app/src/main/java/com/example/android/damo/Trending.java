package com.example.android.damo;

public class Trending {
    private String mName;
    private String mInfo;
    private int mImage;
    private String mRating;
    private Location location;
    private String mDetails;

    public Location getLocation() {
        return location;
    }

    public String getmDetails() {
        return mDetails;
    }

    Trending(String mName, String mInfo, int mImage, String mRating, Location location, String details) {
        this.mName = mName;
        this.mInfo = mInfo;
        this.mImage = mImage;
        this.mRating = mRating;
        this.location = location;
        this.mDetails = details;

    }

    public String getmRating() {
        return mRating;
    }

    public String getmName() {
        return mName;
    }

    public String getmInfo() {
        return mInfo;
    }

    public int getmImage() {
        return mImage;
    }
}
