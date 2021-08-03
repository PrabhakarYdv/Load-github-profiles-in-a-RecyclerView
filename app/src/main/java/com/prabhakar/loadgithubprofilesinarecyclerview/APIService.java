package com.prabhakar.loadgithubprofilesinarecyclerview;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
    @GET("users/{user}/repos")
    Call<ArrayList<ResponseModel>> getProfile(@Path("user")String user);
}
