package com.example.demo.components;

public class Apply {



    String sid;
    String cid;

    public Apply(){
        this.cid = "";
        this.sid = "";
    }

    public Apply(String cid, String sid){
        this.cid = cid;
        this.sid = sid;
    }


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

}
