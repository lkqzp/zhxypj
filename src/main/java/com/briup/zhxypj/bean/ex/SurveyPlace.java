package com.briup.zhxypj.bean.ex;


import java.io.Serializable;


public class SurveyPlace implements Serializable {
    private  String clname;
    private  String tname;
    private  String date;
    private  String coname;

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }
}