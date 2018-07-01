package com.sourcey.materiallogindemo.rest;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class EngieOkHttpClient {

    //TODO::dependency injection needed for this constructor
    public EngieOkHttpClient() {
        this.cookieJar = new CookieJar() {
            private final HashMap<HttpUrl, List<Cookie>> cookieStore = new HashMap<>();
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                CookieManager cookieManager = CookieManager.getInstance();
                if(cookies == null) {
                    cookieManager.removeAllCookie();
                    return;
                }
                for (Cookie cookie : cookies) {
                    cookieManager.setCookie(url.toString(), cookie.toString());
                }
            }
            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                CookieManager cookieManager = CookieManager.getInstance();
                List<Cookie> cookies = new ArrayList<>();
                if (cookieManager.getCookie(url.toString()) != null) {
                    String[] splitCookies = cookieManager.getCookie(url.toString()).split("[,;]");
                    for (int i = 0; i < splitCookies.length; i++) {
                        cookies.add(Cookie.parse(url, splitCookies[i].trim()));
                    }
                }
                return cookies;
            }
        };
        this.client = new OkHttpClient.Builder().cookieJar(this.cookieJar).build();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result;

    public CookieJar getCookieJar() {
        return cookieJar;
    }

    public void setCookieJar(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    CookieJar cookieJar;

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    private OkHttpClient client;

    public int getCallStatusCode() {
        return callStatusCode;
    }

    public void setCallStatusCode(int callStatusCode) {
        this.callStatusCode = callStatusCode;
    }

    private int callStatusCode;

    /**
     * log in the B2C user
     *
     * @param URL
     */
    public void login(String URL, String userName, String password) {
        if (URL.isEmpty()) {
            throw new IllegalArgumentException("URL cannot be empty");
        }if (userName.isEmpty()) {
            throw new IllegalArgumentException("userName cannot be empty");
        }if (password.isEmpty()) {
            throw new IllegalArgumentException("password cannot be empty");
        }
        MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "{\r\n\t\"username\": \"lace.sam@gmail.com\",\r\n\t\"password\": \"8Sapphire7\",\r\n\t\"keepMeLogged\": true,\r\n\t\"segment\": \"residential\"\r\n}");
        RequestBody body = RequestBody.create(mediaType, "{\r\n\t\"username\": \""+userName+"\",\r\n\t\"password\": \""+password+"\",\r\n\t\"keepMeLogged\": true,\r\n\t\"segment\": \"residential\"\r\n}");
        Request request = new Request.Builder()
                //.url("https://www.engie-electrabel.be/api/ebl/cms/users/v1/login")
                .url(URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "8d243907-ea27-4a1b-bc31-4269710e3475")
                .build();
        Response response = null; //TODO::no nulls?
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            Log.i("execute", "you failed dude!" + e);

        }
        setCallStatusCode(response.code());
        setResult(response.message());
        Log.i("getResult()", getResult());
        Log.i("Response", response.toString());
    }

    /**
     * Fetches the access points of a B2C ENGIE-Electrabel customer with a valid online account.
     * I guess the result can be empty if they still have a login but no longer use ENGIE-Electrabel.
     * ; requires that Login method of this instance is called and returns HTTP.200
     * and the IAM cookies required for this call. Otherwise, it will fail.
     *
     * @param URL which is the URL for the access points...should be an enum or equiv
     */
    public void fetchAccessPoints() {
        if (getClient() == null) {
            throw new IllegalArgumentException("HttpClient cannot be null; Successful Login is a pre-requisite.");
        }
        Request request = new Request.Builder()
                .url("https://www.engie-electrabel.be/api/ebl/b2c/private/customer/accessPoints?filter=DEFAULT")
                .get()
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "8f2bc885-ee52-4798-a862-1198e2bf2cbc")
                .build();

        //TODO::proper MVC needs to get this done properly...
        /*client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    setResult(response.body() == null ? " response.body() was NULL!!!" : response.body().string());
                    Log.i("enqueue::responseBody", getResult());
                    setCallStatusCode(response.code());
                    Log.i("enqueue::statusCodeSet", getCallStatusCode()+"");
                }
            }
        });*/
        Response response = null; //TODO::no nulls?
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            Log.i("execute", "you failed dude!" + e);

        }

        try {
            setResult(response.body() == null ? " response.body() was NULL!!!" : response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("enqueue::responseBody", getResult());
        setCallStatusCode(response.code());
        Log.i("enqueue::statusCodeSet", getCallStatusCode()+"");
    }
}
