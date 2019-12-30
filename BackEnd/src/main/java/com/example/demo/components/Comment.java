package com.example.demo.components;

public class Comment {
    int comment_id;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }


    int user_id;
    int app_id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String text;

}
