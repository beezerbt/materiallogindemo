package com.sourcey.materiallogindemo.rest;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.entity.StringEntity;

public class EngieRest {
    private final String BASE_URL = "https://msw-acc.engie-electrabel.be";

    private AsyncHttpClient client;
    private Context context;

    public EngieRest(Context context) {
        this.context = context;
        PersistentCookieStore myCookieStore = new PersistentCookieStore(context);
        this.client = new AsyncHttpClient();
        client.setCookieStore(myCookieStore);
    }

    public void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public void login(String username, String password, AsyncHttpResponseHandler responseHandler) {
        JSONObject jsonParams = new JSONObject();
        StringEntity entity = null;
        try {
            jsonParams.put("username", username);
            jsonParams.put("password", password);
            jsonParams.put("keepMeLogged", true);
            jsonParams.put("segment", "residential");
            entity = new StringEntity(jsonParams.toString());
        } catch (JSONException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(entity);
        client.post(context, getAbsoluteUrl("/api/ebl/cms/users/v1/login"), entity, "application/json",
                responseHandler);
    }

    private String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}