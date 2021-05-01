package com.example.is4448_ca2;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

public class CovidHttpHandler {

    public static void getStats(String url, final VolleyCovidCallback callback) {
        JsonArrayRequest req = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                callback.onSuccessResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onErrorResponse(error.getMessage());
                VolleyLog.e("Error: ", error.getMessage());
            }
        });
        // add the request object to the queue to be executed
        MyApplicationController.getInstance().addToRequestQueue(req);
    }


}
