package com.mangoblogger.app.api_model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UxApiModel {

    @SerializedName("count")
    private int count;

    @SerializedName("count_total")
    private int count_total;

    @SerializedName("pages")
    private  int pages;

    @SerializedName("posts")
    private List<UXPostsModel> posts;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_total() {
        return count_total;
    }

    public void setCount_total(int count_total) {
        this.count_total = count_total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<UXPostsModel> getPosts() {
        return posts;
    }

    public void setPosts(List<UXPostsModel> posts) {
        this.posts = posts;
    }
}
