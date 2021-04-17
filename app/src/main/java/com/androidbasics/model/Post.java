package com.androidbasics.model;

import com.google.gson.annotations.SerializedName;

//      Logging Retrofit Request & Response with HTTP Interceptor & Serialise Nulls

public class Post {

    private int userId;
//    private int id;
        private Integer id;                     // Used When It May null By Gson
    private String title;
    @SerializedName("body")       // To Give Custom Name In POJO
    private String text;


    public Post(int userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public int getId() {
//        return id;
//    }
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

