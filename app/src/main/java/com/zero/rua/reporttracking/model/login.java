package com.zero.rua.reporttracking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class login {

    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
