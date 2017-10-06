package com.mangoblogger.app.api_model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UXPostsModel {

    @SerializedName("id")
    private int id;

    @SerializedName("title_plain")
    private String title_plain;

    @SerializedName("title")
    private String title;

    @SerializedName("slug")
    private String slug;

    @SerializedName("url")
    private String url;

    @SerializedName("content")
    private String content;

    @SerializedName("excerpt")
    private String excerpt;

    @SerializedName("date")
    private String date;

    @SerializedName("modified")
    private String modified_date;

    @SerializedName("author")
    private AuthorModel author;

    @SerializedName("attachments")
    private List<AttachmentModel> attacments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle_plain() {
        return title_plain;
    }

    public void setTitle_plain(String title_plain) {
        this.title_plain = title_plain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getModified_date() {
        return modified_date;
    }

    public void setModified_date(String modified_date) {
        this.modified_date = modified_date;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public List<AttachmentModel> getAttacments() {
        return attacments;
    }

    public void setAttacments(List<AttachmentModel> attacments) {
        this.attacments = attacments;
    }
}
