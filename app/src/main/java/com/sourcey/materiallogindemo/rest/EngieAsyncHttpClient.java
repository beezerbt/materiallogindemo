package com.sourcey.materiallogindemo.rest;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.MySSLSocketFactory;
import com.loopj.android.http.PersistentCookieStore;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpStatus;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;

public class EngieAsyncHttpClient {

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private String response;

    public int getSetCallStatusCode() {
        return setCallStatusCode;
    }

    public void setSetCallStatusCode(int setCallStatusCode) {
        this.setCallStatusCode = setCallStatusCode;
    }

    private int setCallStatusCode;

    public void login(Context applicationContext) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.setBasicAuth("lace.sam@gmail.com", "8Sapphire7");
        client.setSSLSocketFactory(MySSLSocketFactory.getFixedSocketFactory());
        PersistentCookieStore myCookieStore = new PersistentCookieStore(applicationContext);
        client.setCookieStore(myCookieStore);
        client.setLoggingEnabled(true);

        JSONObject jsonParams = new JSONObject();
        /* StringEntity entity = null;*/
        try {
            jsonParams.put("username", "lace.sam@gmail.com");
            jsonParams.put("password", "8Sapphire7");
            jsonParams.put("keepMeLogged", true);
            jsonParams.put("segment", "residential");
        } catch (JSONException /*| UnsupportedEncodingException*/ e) {
            e.printStackTrace();
        }

        ByteArrayEntity entity = null;
        try {
            entity = new ByteArrayEntity(jsonParams.toString().getBytes("UTF-8"));
            entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            entity.setContentType(new BasicHeader("Cache-Control", "no-cache"));
            entity.setContentType(new BasicHeader("Postman-Token", "335487f5-d5f5-41ce-bf07-254a55dcddaa"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.i("entity::ContentType", entity.getContentType().toString());
        Scanner s = new Scanner( entity.getContent()).useDelimiter("\\A");
        String result = s.hasNext() ? s.next() : "";
        Log.i("entity::Body", result);

        client.put(applicationContext, "https://www.engie-electrabel.be/api/ebl/cms/users/v1/login", entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                Log.i("onStart::headers", Arrays.deepToString(this.getRequestHeaders()));
                Log.i("onStart::URI", this.getRequestURI().toString());
                Log.i("onStart::Charset", this.getCharset().toString());
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] response) {
                Log.i("AsyncHttpClient", "called when response HTTP status is 200 OK");
                String decodedDataUsingUTF8=null;
                if(statusCode == HttpStatus.SC_OK) {
                    try {
                        decodedDataUsingUTF8 = new String(response, "UTF-8");
                        setResponse(decodedDataUsingUTF8);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        Log.e("onSuccess", "decodedDataUsingUTF8 failure");
                    }
                }
                setSetCallStatusCode(statusCode);
                Log.i("onSuccess", "responseL["+decodedDataUsingUTF8+"]");

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                Log.i("AsyncHttpClient", "called when response HTTP status is \"4XX\" (eg. 401, 403, 404)");
            }

            @Override
            public void onRetry(int retryNo) {
                Log.i("AsyncHttpClient", "called when request is retried");
            }
        });
    }
}
