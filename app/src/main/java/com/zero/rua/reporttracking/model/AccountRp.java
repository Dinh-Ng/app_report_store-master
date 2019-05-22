package com.zero.rua.reporttracking.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountRp {

    @SerializedName("data")
    @Expose
    private List<AccountRp_data> data = null;
    @SerializedName("listStore")
    @Expose
    private List<String> listStore = null;
    @SerializedName("totalAllInMonth")
    @Expose
    private Integer totalAllInMonth;
    @SerializedName("totalAllShanInMonth")
    @Expose
    private Integer totalAllShanInMonth;
    @SerializedName("totalAllRev")
    @Expose
    private String totalAllRev;

    public List<AccountRp_data> getData() {
        return data;
    }

    public void setData(List<AccountRp_data> data) {
        this.data = data;
    }

    public List<String> getListStore() {
        return listStore;
    }

    public void setListStore(List<String> listStore) {
        this.listStore = listStore;
    }

    public Integer getTotalAllInMonth() {
        return totalAllInMonth;
    }

    public void setTotalAllInMonth(Integer totalAllInMonth) {
        this.totalAllInMonth = totalAllInMonth;
    }

    public Integer getTotalAllShanInMonth() {
        return totalAllShanInMonth;
    }

    public void setTotalAllShanInMonth(Integer totalAllShanInMonth) {
        this.totalAllShanInMonth = totalAllShanInMonth;
    }

    public String getTotalAllRev() {
        return totalAllRev;
    }

    public void setTotalAllRev(String totalAllRev) {
        this.totalAllRev = totalAllRev;
    }

}