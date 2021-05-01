package com.example.is4448_ca2;

import org.json.JSONArray;
import org.json.JSONObject;

public interface VolleyCovidCallback {
    void onSuccessResponse(JSONArray result);
    void onSuccessResponse(JSONObject result);
    void onErrorResponse(String error);
}
