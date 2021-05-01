package com.example.is4448_ca2;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StatSummary implements Parcelable {
    private String ID;
    private String Country;
    private String CountryCode;
    private String Slug;
    private long NewConfirmed ;
    private long TotalConfirmed;
    private long NewDeaths;
    private long TotalDeaths;
    private long NewRecovered;
    private long TotalRecovered;
    private Date Date;
    private Premium Premium;

    public String getID() {
        return ID;
    }

    public String getCountry() {
        return Country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public String getSlug() {
        return Slug;
    }

    public long getNewConfirmed() {
        return NewConfirmed;
    }

    public long getTotalConfirmed() {
        return TotalConfirmed;
    }

    public long getNewDeaths() {
        return NewDeaths;
    }

    public long getTotalDeaths() {
        return TotalDeaths;
    }

    public long getNewRecovered() {
        return NewRecovered;
    }

    public long getTotalRecovered() {
        return TotalRecovered;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public Premium getPremium() {
        return Premium;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ID);
        dest.writeString(Country);
        dest.writeString(CountryCode);
        dest.writeString(Slug);
        dest.writeLong(NewConfirmed);
        dest.writeLong(TotalConfirmed);
        dest.writeLong(NewDeaths);
        dest.writeLong(TotalDeaths);
        dest.writeLong(NewRecovered);
        dest.writeLong(TotalRecovered);
        dest.writeString(Date.toString());
    }

    protected StatSummary(Parcel in) throws ParseException {
        ID = in.readString();
        Country = in.readString();
        CountryCode = in.readString();
        Slug = in.readString();
        NewConfirmed = in.readLong();
        TotalConfirmed = in.readLong();
        NewDeaths = in.readLong();
        TotalDeaths = in.readLong();
        NewRecovered = in.readLong();
        TotalRecovered = in.readLong();
        Date = new SimpleDateFormat("dd/MM/yyyy").parse(in.readString());
    }

    public static final Creator<StatSummary> CREATOR = new Creator<StatSummary>() {
        @Override
        public StatSummary createFromParcel(Parcel source) {
            try {
                return new StatSummary(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public StatSummary[] newArray(int size) {
            return new StatSummary[0];
        }
    };

    public class Premium implements Parcelable{
        protected Premium(Parcel in) {
        }

        public final Creator<Premium> CREATOR = new Creator<Premium>() {
            @Override
            public Premium createFromParcel(Parcel in) {
                return new Premium(in);
            }

            @Override
            public Premium[] newArray(int size) {
                return new Premium[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
        }
    }
}
