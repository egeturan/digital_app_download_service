package com.example.demo.components;

public class Req_update {
    int editor_id;

    public int getEditor_id() {
        return editor_id;
    }

    public void setEditor_id(int editor_id) {
        this.editor_id = editor_id;
    }

    public int getDev_id() {
        return dev_id;
    }

    public void setDev_id(int dev_id) {
        this.dev_id = dev_id;
    }

    public int getApp_id() {
        return app_id;
    }

    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }

    public int getApprovement() {
        return approvement;
    }

    public void setApprovement(int approvement) {
        this.approvement = approvement;
    }

    int dev_id;
    int app_id;
    int approvement;
}
