package com.sourcey.materiallogindemo.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.sourcey.materiallogindemo.response.BitBucketGETReposResponse;
import com.sourcey.materiallogindemo.service.BitBucketService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class BitBucketRepository {

    private BitBucketService webservice;

    public BitBucketRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shahrik:Blog7402__@api.bitbucket.org")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        webservice = retrofit.create(BitBucketService.class);
    }

    public LiveData<BitBucketGETReposResponse> getUser() {
        // This is not an optimal implementation, we'll fix it below
        final MutableLiveData<BitBucketGETReposResponse> data = new MutableLiveData<>();
        webservice.listRepos().enqueue(new Callback<BitBucketGETReposResponse>() {
            @Override
            public void onResponse(Call<BitBucketGETReposResponse> call, Response<BitBucketGETReposResponse> response) {
                data.setValue(response.body());
                Log.i("SUFFS>>>>>>onResponse", response.message());
            }

            @Override
            public void onFailure(Call<BitBucketGETReposResponse> call, Throwable t) {
                Log.i("SUFFS>>>>>>onFailure", t.getMessage());
            }
        });
        Log.i("SUFFS>>>>>>onFailure", data==null?"null":data.getValue()==null?"null":data.getValue().toString());
        return data;
    }
}
