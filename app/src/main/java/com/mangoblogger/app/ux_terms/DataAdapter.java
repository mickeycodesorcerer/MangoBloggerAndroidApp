package com.mangoblogger.app.ux_terms;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mangoblogger.app.AnimationUtils;
import com.mangoblogger.app.BlogModel;
import com.mangoblogger.app.CircleTranform;
import com.mangoblogger.app.R;

import java.util.ArrayList;
import java.util.List;


public class FirebaseDataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> posts;


    public DataAdapter(ArrayList<AndroidVersion> posts) {
        this.posts = posts;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.tv_name.setText(Jsoup.parse(posts.get(i).getcontent()).text());


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name;
        public ViewHolder(View view) {
            super(view);

            tv_name = (TextView)view.findViewById(R.id.text);


        }
    }

}