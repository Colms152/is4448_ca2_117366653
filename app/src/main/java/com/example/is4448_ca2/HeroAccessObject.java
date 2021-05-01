package com.example.is4448_ca2;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;
import org.json.JSONObject;


public class HeroAccessObject {

    public static final String connURI = "https://gleeson.io/IS4447/HeroAPI/v1/Api.php?apicall=";

    public void selectHeroes(final Handler handler) {
        String getConnURI = connURI + "getheroes";
        HttpHandler_Hero.getHeroes(getConnURI, new VolleyHeroCallback() {
            @Override
            public void onSuccessObjectResponse(JSONObject result) {
                Gson gson = new Gson();
                JsonHeroObject results = gson.fromJson(String.valueOf(result), JsonHeroObject.class);
                Message msg = new Message();
                msg.obj = results.getHeroes();
                handler.sendMessage(msg);
            }
            @Override
            public void onSuccessStringResponse(String result) {

            }
        });
    }

    public void insertHero(HeroObject hero, final Handler handler) throws JsonSyntaxException, JSONException {
        String insertConnURI = connURI + "createhero";
        HttpHandler_Hero.postHero(insertConnURI, hero, new VolleyHeroCallback() {
            @Override
            public void onSuccessObjectResponse(JSONObject result) {

            }

            @Override
            public void onSuccessStringResponse(String result) {
                Gson gson = new Gson();
                JsonHeroObject j = gson.fromJson(result, JsonHeroObject.class);
                Message msg = new Message();
                if (j.getError().equals("true"))
                    msg.obj = true;
                else
                    msg.obj = false;
                handler.sendMessage(msg);
            }
        });
    }

    public void updateHero(HeroObject hero, final Handler handler) throws JsonSyntaxException {
        String updateConnURI = connURI + "updatehero&id=" + hero.getId();
        HttpHandler_Hero.putHero(updateConnURI, hero, new VolleyHeroCallback() {
            @Override
            public void onSuccessObjectResponse(JSONObject result) {

            }

            @Override
            public void onSuccessStringResponse(String result) {
                Gson gson = new Gson();
                JsonHeroObject j = gson.fromJson(result, JsonHeroObject.class);
                Message msg = new Message();
                if (j.getError().equals("true"))
                    msg.obj = true;
                else
                    msg.obj = false;
                handler.sendMessage(msg);
            }
        });
    }

    public void deleteHero(int heroId, final Handler handler) throws JsonSyntaxException {
        String deleteConnURI = connURI + "deletehero&id=" + heroId;
        HttpHandler_Hero.deleteHero(deleteConnURI, new VolleyHeroCallback() {
            @Override
            public void onSuccessObjectResponse(JSONObject result) {

            }

            @Override
            public void onSuccessStringResponse(String result) {
                Gson gson = new Gson();
                JsonHeroObject j = gson.fromJson(result, JsonHeroObject.class);
                Message msg = new Message();
                if (j.getError().equals("true"))
                    msg.obj = true;
                else
                    msg.obj = false;
                handler.sendMessage(msg);
            }
        });
    }
}
