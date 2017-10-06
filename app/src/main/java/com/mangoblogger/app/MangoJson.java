package com.mangoblogger.app;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.mangoblogger.app.Interface.ApiInterface;
import com.mangoblogger.app.api_model.AttachmentModel;
import com.mangoblogger.app.api_model.UXPostsModel;
import com.mangoblogger.app.api_model.UxApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*  this class is entry point for wp rest api */

/**
 *  I am using retrofit and what ever library you used it does'nt make large difference so model will be same
 * */

public class MangoJson extends AppCompatActivity {

     RecyclerView recyclerView;
    MangoJsonAdapter jsonAdapter;
     Retrofit retrofit;
    private final String BASE_URL = "https://www.mangoblogger.com";
    ApiInterface apiInterface;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mango_json);

        image = (ImageView) findViewById(R.id.image);
        recyclerView = (RecyclerView) findViewById(R.id.mango_json_recyclerview);
        recyclerView.addItemDecoration(new GridSpacing(5));
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface = retrofit.create(ApiInterface.class);
        apiInterface.getUxTerms("ux_term",1).enqueue(new Callback<UxApiModel>() {
            @Override
            public void onResponse(Call<UxApiModel> call, Response<UxApiModel> response) {
               List<UXPostsModel> uxPostsModelList =  response.body().getPosts();
                if (uxPostsModelList != null) {
                    jsonAdapter = new MangoJsonAdapter(getApplicationContext(), uxPostsModelList);
                    recyclerView.setAdapter(jsonAdapter);

                }


            }

            @Override
            public void onFailure(Call<UxApiModel> call, Throwable t) {
                Log.e("My TAG", "there is something error"+t.getMessage());
            }
        });
    }

   /**
    * Grid spacng in recyclerview to make a proper distance between items
    * */
    class GridSpacing extends RecyclerView.ItemDecoration {
        int spacing;
        int span;

        public GridSpacing(int spacing) {
            this.spacing = spacing;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = spacing-span;
            outRect.right = spacing-span;
            outRect.top = spacing;
            outRect.bottom=spacing;
        }
    }
}
