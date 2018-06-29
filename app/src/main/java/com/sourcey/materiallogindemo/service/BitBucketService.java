package com.sourcey.materiallogindemo.service;

import com.sourcey.materiallogindemo.response.BitBucketGETReposResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface BitBucketService  {
    @Headers("Accept: application/json")
    @GET("/2.0/repositories/shahrik")
    Call<BitBucketGETReposResponse> listRepos();
}