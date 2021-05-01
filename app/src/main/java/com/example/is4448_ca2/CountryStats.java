package com.example.is4448_ca2;

import java.util.Date;

public class CountryStats {
    private String ID;
    private String Country;
    private String CountryCode;
    private String Province;
    private String City;
    private String CityCode;
    private float Lat;
    private float Lon;
    private long Confirmed;
    private long Deaths;
    private long Recovered;
    private long Active;
    private Date Date;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public float getLat() {
        return Lat;
    }

    public void setLat(float lat) {
        Lat = lat;
    }

    public float getLon() {
        return Lon;
    }

    public void setLon(float lon) {
        Lon = lon;
    }

    public long getConfirmed() {
        return Confirmed;
    }

    public void setConfirmed(long confirmed) {
        Confirmed = confirmed;
    }

    public long getDeaths() {
        return Deaths;
    }

    public void setDeaths(long deaths) {
        Deaths = deaths;
    }

    public long getRecovered() {
        return Recovered;
    }

    public void setRecovered(long recovered) {
        Recovered = recovered;
    }

    public long getActive() {
        return Active;
    }

    public void setActive(long active) {
        Active = active;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }
}
