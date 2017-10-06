package com.mangoblogger.app;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mangoblogger.app.api_model.AttachmentModel;
import com.mangoblogger.app.api_model.UXPostsModel;


import java.util.List;

/*
*  As you know this adapter class for recyclerview and all methods and variables namw ill explain everything
* */
public class MangoJsonAdapter extends RecyclerView.Adapter<MangoJsonAdapter.MyHolderView> {
    private Context context;
    private List<UXPostsModel> list;
    int prevPosition=0;

    public MangoJsonAdapter(Context context, List<UXPostsModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_mango,parent,false);
        return new MyHolderView(view);
    }

    @Override
    public void onBindViewHolder(MyHolderView holder, int position) {

        UXPostsModel album=list.get(position);
        holder.t1.setText(album.getTitle());
        holder.t2.setText(album.getExcerpt());
        List<AttachmentModel> attacmentsModelList = album.getAttacments();
        if ( !attacmentsModelList.isEmpty()) {
            AttachmentModel model = attacmentsModelList.get(0);
            if (model != null)
                Glide.with(context).load(model.getUrl()).animate(R.anim.scale).into(holder.i);

            if(position  >  prevPosition){
                AnimationUils.animate(holder,true);
            }

            else{
                AnimationUils.animate(holder,false);
            }
            prevPosition=position;

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyHolderView extends RecyclerView.ViewHolder {
        TextView t1, t2;
        ImageView i;
        Typeface typeface1,typeface2;

        public MyHolderView(View itemView) {
            super(itemView);

            typeface1= Typeface.createFromAsset(itemView.getContext().getAssets(),"fontj.ttf");
            typeface2= Typeface.createFromAsset(itemView.getContext().getAssets(),"fontc.ttf");
            t1 = (TextView) itemView.findViewById(R.id.mango_title);
            t2 = (TextView) itemView.findViewById(R.id.mango_description);
            i = (ImageView) itemView.findViewById(R.id.bg_image);
            this.t1.setTypeface(typeface1);
            this.t2.setTypeface(typeface2);


        }


    }

}

