package com.example.is4448_ca2;

import android.os.Parcel;
import android.os.Parcelable;


public class HeroObject implements Parcelable {
    private int id;
    private String name;
    private String realname;
    private float rating;
    private String teamaffiliation;

    public HeroObject(String name, String realname, float rating, String teamaffiliation) {
        this.name = name;
        this.realname = realname;
        this.rating = rating;
        this.teamaffiliation = teamaffiliation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realname;
    }

    public void setRealName(String realName) {
        this.realname = realName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTeam() {
        return teamaffiliation;
    }

    public void setTeam(String team) {
        this.teamaffiliation = team;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(realname);
        dest.writeFloat(rating);
        dest.writeString(teamaffiliation);
    }

    protected HeroObject(Parcel in) {
        id = in.readInt();
        name = in.readString();
        realname = in.readString();
        rating = in.readFloat();
        teamaffiliation = in.readString();
    }

    public static final Creator<HeroObject> CREATOR = new Creator<HeroObject>() {
        @Override
        public HeroObject createFromParcel(Parcel in) {
            return new HeroObject(in);
        }

        @Override
        public HeroObject[] newArray(int size) {
            return new HeroObject[size];
        }
    };
}
