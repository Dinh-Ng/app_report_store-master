package com.zero.rua.reporttracking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountRp_data {

    @SerializedName("storeId")
    @Expose
    private String storeId;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("revenue")
    @Expose
    private String revenue;
    @SerializedName("installTotal")
    @Expose
    private Integer installTotal;
    @SerializedName("installofMonth")
    @Expose
    private Integer installofMonth;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("installShan")
    @Expose
    private Integer installShan;
    @SerializedName("installShanOfMonth")
    @Expose
    private Integer installShanOfMonth;
    @SerializedName("installShanOfDay")
    @Expose
    private Integer installShanOfDay;
    @SerializedName("totalPerFull")
    @Expose
    private Integer totalPerFull;
    @SerializedName("totalPerFullOfMonth")
    @Expose
    private Integer totalPerFullOfMonth;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public Integer getInstallTotal() {
        return installTotal;
    }

    public void setInstallTotal(Integer installTotal) {
        this.installTotal = installTotal;
    }

    public Integer getInstallofMonth() {
        return installofMonth;
    }

    public void setInstallofMonth(Integer installofMonth) {
        this.installofMonth = installofMonth;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getInstallShan() {
        return installShan;
    }

    public void setInstallShan(Integer installShan) {
        this.installShan = installShan;
    }

    public Integer getInstallShanOfMonth() {
        return installShanOfMonth;
    }

    public void setInstallShanOfMonth(Integer installShanOfMonth) {
        this.installShanOfMonth = installShanOfMonth;
    }

    public Integer getInstallShanOfDay() {
        return installShanOfDay;
    }

    public void setInstallShanOfDay(Integer installShanOfDay) {
        this.installShanOfDay = installShanOfDay;
    }

    public Integer getTotalPerFull() {
        return totalPerFull;
    }

    public void setTotalPerFull(Integer totalPerFull) {
        this.totalPerFull = totalPerFull;
    }

    public Integer getTotalPerFullOfMonth() {
        return totalPerFullOfMonth;
    }

    public void setTotalPerFullOfMonth(Integer totalPerFullOfMonth) {
        this.totalPerFullOfMonth = totalPerFullOfMonth;
    }

}