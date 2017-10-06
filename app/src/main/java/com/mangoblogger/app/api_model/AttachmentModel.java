package com.mangoblogger.app.api_model;

import com.google.gson.annotations.SerializedName;


public class AttachmentModel {

    @SerializedName("url")
    private String url;

    @SerializedName("title")
    private String title;

    @SerializedName("id")
    private int id;

    @SerializedName("mime_type")
    private String mime_type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }
}
