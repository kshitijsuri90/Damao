package com.example.android.damo;

public class Comment {
    private String mComment;
    private String mRating;

    public String getmComment() {
        return mComment;
    }

    public String getmRating() {
        return mRating;
    }

    Comment(String mComment, String mRating) {

        this.mComment = mComment;
        this.mRating = mRating;
    }
}
