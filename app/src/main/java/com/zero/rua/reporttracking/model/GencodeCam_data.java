package com.zero.rua.reporttracking.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GencodeCam_data {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("data")
    @Expose
    private List<Integer> data = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

}