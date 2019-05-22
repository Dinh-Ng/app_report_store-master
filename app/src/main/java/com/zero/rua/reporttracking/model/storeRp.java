package com.zero.rua.reporttracking.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class storeRp {

    @SerializedName("data")
    @Expose
    private List<storeRp_data> data = null;
    @SerializedName("listStore")
    @Expose
    private List<String> listStore = null;
    @SerializedName("totalInstall")
    @Expose
    private Integer totalInstall;
    @SerializedName("totalInstallInMonth")
    @Expose
    private Integer totalInstallInMonth;
    @SerializedName("totalInstallInDay")
    @Expose
    private Integer totalInstallInDay;
    @SerializedName("listVersionStore")
    @Expose
    private List<String> listVersionStore = null;

    public List<storeRp_data> getData() {
        return data;
    }

    public void setData(List<storeRp_data> data) {
        this.data = data;
    }

    public List<String> getListStore() {
        return listStore;
    }

    public void setListStore(List<String> listStore) {
        this.listStore = listStore;
    }

    public Integer getTotalInstall() {
        return totalInstall;
    }

    public void setTotalInstall(Integer totalInstall) {
        this.totalInstall = totalInstall;
    }

    public Integer getTotalInstallInMonth() {
        return totalInstallInMonth;
    }

    public void setTotalInstallInMonth(Integer totalInstallInMonth) {
        this.totalInstallInMonth = totalInstallInMonth;
    }

    public Integer getTotalInstallInDay() {
        return totalInstallInDay;
    }

    public void setTotalInstallInDay(Integer totalInstallInDay) {
        this.totalInstallInDay = totalInstallInDay;
    }

    public List<String> getListVersionStore() {
        return listVersionStore;
    }

    public void setListVersionStore(List<String> listVersionStore) {
        this.listVersionStore = listVersionStore;
    }

}