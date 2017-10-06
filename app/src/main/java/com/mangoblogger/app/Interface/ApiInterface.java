package com.mangoblogger.app.Interface;



import com.mangoblogger.app.api_model.UxApiModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("/?json=get_posts")
    Call<UxApiModel> getUxTerms(@Query("post_type") String postType, @Query("page") int pageNumber);
}
