package com.example.is4448_ca2;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class CovidAccessObject {
    public static final String connURI = "https://api.covid19api.com/";
    private ErrorCallback errorCallback;

    public CovidAccessObject(ErrorCallback errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void selectCountryStats(String country, final Handler handler) throws JsonSyntaxException {
        String getConnURI = connURI + "live/country/" + country;
        CovidHttpHandler.getStats(getConnURI, new VolleyCovidCallback() {
            @Override
            public void onSuccessResponse(JSONArray result) {
                Gson gson = new Gson();
                Type userListType = new TypeToken<ArrayList<CountryStats>>() {}.getType();
                ArrayList<CountryStats> covidStatsList = gson.fromJson(String.valueOf(result), userListType);
                Message msg = new Message();
                msg.obj = covidStatsList;
                handler.sendMessage(msg);
            }

            @Override
            public void onSuccessResponse(JSONObject result) {

            }

            @Override
            public void onErrorResponse(String error) {
                errorCallback.onDataAccessError(error);
            }
        });
    }

}
