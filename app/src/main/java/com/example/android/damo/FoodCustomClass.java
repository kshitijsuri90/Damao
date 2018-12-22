package com.example.android.damo;

public class FoodCustomClass {
    private String mRestaurant;
    private String mDetails;
    private String mRating;
    private int mImageid;
    private Location location;
    private String big_description;

    public Location getLocation() {
        return location;
    }

    public String getBig_description() {
        return big_description;
    }

    FoodCustomClass(String mRestaurantName, String mDetails, int mImageid, String ratings, Location location, String description) {
        this.mRestaurant = mRestaurantName;
        this.mDetails = mDetails;
        this.mImageid = mImageid;
        this.mRating = ratings;
        this.location = location;
        this.big_description = description;

    }

    public String getmRestaurant() {
        return mRestaurant;
    }

    public String getmDetails() {
        return mDetails;
    }

    public String getmRating() {
        return mRating;
    }

    public int getmImageid() {
        return mImageid;
    }
}
