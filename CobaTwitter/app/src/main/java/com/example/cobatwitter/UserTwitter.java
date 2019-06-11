package com.example.cobatwitter;

import android.os.Parcel;
import android.os.Parcelable;

public class UserTwitter implements Parcelable {
    private String userName, photo, tweet;

    public String getUserName() {
        return userName;
    }

    public UserTwitter(){

    }
    public UserTwitter(String userName, String photo, String tweet) {
        this.userName = userName;
        this.photo = photo;
        this.tweet = tweet;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    protected UserTwitter(Parcel in) {
        userName = in.readString();
        photo = in.readString();
        tweet = in.readString();
    }

    public static final Creator<UserTwitter> CREATOR = new Creator<UserTwitter>() {
        @Override
        public UserTwitter createFromParcel(Parcel in) {
            return new UserTwitter(in);
        }

        @Override
        public UserTwitter[] newArray(int size) {
            return new UserTwitter[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(photo);
        dest.writeString(tweet);
    }
}
