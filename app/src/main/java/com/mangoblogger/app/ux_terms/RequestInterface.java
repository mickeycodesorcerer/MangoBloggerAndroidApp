package com.shreyanshvit.json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * Created by SJ on 28/09/2017.
 */

public interface RequestInterface {

    @GET("?json=get_posts&post_type=ux_term&page=4")
    Call<JSONResponse> getJSON();
}