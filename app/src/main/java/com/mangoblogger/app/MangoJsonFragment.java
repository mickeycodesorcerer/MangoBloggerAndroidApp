package com.mangoblogger.app;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mangoblogger.app.Interface.ApiInterface;
import com.mangoblogger.app.api_model.UXPostsModel;
import com.mangoblogger.app.api_model.UxApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MangoJsonFragment extends Fragment {


    RecyclerView recyclerView;
    MangoJsonAdapter jsonAdapter;
    Retrofit retrofit;
    private final String BASE_URL = "https://www.mangoblogger.com";
    ApiInterface apiInterface;
    ImageView image;

    public static MangoJsonFragment newInstance() {
        MangoJsonFragment mangoJson = new MangoJsonFragment();
        return mangoJson;
    }

    public MangoJsonFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mango_json, container, false);

        //image = (ImageView) view.findViewById(R.id.image);
        recyclerView = (RecyclerView) view.findViewById(R.id.mango_json_recyclerview);
        recyclerView.addItemDecoration(new GridSpacing(5));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
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
                    jsonAdapter = new MangoJsonAdapter(getActivity(), uxPostsModelList);
                    recyclerView.setAdapter(jsonAdapter);

                }


            }

            @Override
            public void onFailure(Call<UxApiModel> call, Throwable t) {
                Log.e("My TAG", "there is something error"+t.getMessage());
            }
        });
        return view;
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
