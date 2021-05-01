package com.example.is4448_ca2;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class HttpHandler_Hero {

    public static void getHeroes(String url, final VolleyHeroCallback callback) {
        JsonObjectRequest req = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        callback.onSuccessObjectResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });
        // add the request object to the queue to be executed
        MyApplicationController.getInstance().addToRequestQueue(req);
    }

    public static void postHero(String url, final HeroObject hero, final VolleyHeroCallback callback) {
        StringRequest jsonObjRequest = new StringRequest(

                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccessStringResponse(response);
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("volley", "Error: " + error.getMessage());
                        error.printStackTrace();
                    }
                }) {

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", hero.getName());
                params.put("realname", hero.getRealName());
                params.put("rating", String.valueOf(hero.getRating()));
                params.put("teamaffiliation", hero.getTeam());
                return params;
            }

        };

        MyApplicationController.getInstance().addToRequestQueue(jsonObjRequest);
    }

    public static void putHero(String url, final HeroObject hero, final VolleyHeroCallback callback) {
        StringRequest jsonObjRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccessStringResponse(response);
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("volley", "Error: " + error.getMessage());
                        error.printStackTrace();
                    }
                }) {

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", String.valueOf(hero.getId()));
                params.put("name", hero.getName());
                params.put("realname", hero.getRealName());
                params.put("rating", String.valueOf(hero.getRating()));
                params.put("teamaffiliation", hero.getTeam());
                return params;
            }
        };
        MyApplicationController.getInstance().addToRequestQueue(jsonObjRequest);
    }

    public static void deleteHero(String url,final VolleyHeroCallback callback) {
        StringRequest jsonObjRequest = new StringRequest(
                Request.Method.DELETE,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccessStringResponse(response);
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d("volley", "Error: " + error.getMessage());
                        error.printStackTrace();
                    }
                }) {
        };
        MyApplicationController.getInstance().addToRequestQueue(jsonObjRequest);
    }
}
