package com.zero.rua.reporttracking.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GencodeCam {

    @SerializedName("xValue")
    @Expose
    private List<String> xValue = null;
    @SerializedName("yValue")
    @Expose
    private List<GencodeCam_data> yValue = null;

    public List<String> getXValue() {
        return xValue;
    }

    public void setXValue(List<String> xValue) {
        this.xValue = xValue;
    }

    public List<GencodeCam_data> getYValue() {
        return yValue;
    }

    public void setYValue(List<GencodeCam_data> yValue) {
        this.yValue = yValue;
    }

}