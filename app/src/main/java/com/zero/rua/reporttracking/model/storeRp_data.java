package com.zero.rua.reporttracking.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class storeRp_data {

    @SerializedName("storeId")
    @Expose
    private String storeId;
    @SerializedName("storeName")
    @Expose
    private String storeName;
    @SerializedName("adress")
    @Expose
    private String adress;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("deposit")
    @Expose
    private String deposit;
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
    @SerializedName("installShan")
    @Expose
    private Integer installShan;
    @SerializedName("installShanMM")
    @Expose
    private Integer installShanMM;
    @SerializedName("installShanOfDay")
    @Expose
    private Integer installShanOfDay;
    @SerializedName("totalPerFull")
    @Expose
    private Integer totalPerFull;
    @SerializedName("totalPerFullOfMonth")
    @Expose
    private Integer totalPerFullOfMonth;
    @SerializedName("totalPerFullOfDay")
    @Expose
    private Integer totalPerFullOfDay;

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
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

    public Integer getInstallShan() {
        return installShan;
    }

    public void setInstallShan(Integer installShan) {
        this.installShan = installShan;
    }

    public Integer getInstallShanMM() {
        return installShanMM;
    }

    public void setInstallShanMM(Integer installShanMM) {
        this.installShanMM = installShanMM;
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

    public Integer getTotalPerFullOfDay() {
        return totalPerFullOfDay;
    }

    public void setTotalPerFullOfDay(Integer totalPerFullOfDay) {
        this.totalPerFullOfDay = totalPerFullOfDay;
    }
}