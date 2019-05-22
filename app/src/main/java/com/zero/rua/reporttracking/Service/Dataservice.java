package com.zero.rua.reporttracking.Service;

import com.zero.rua.reporttracking.model.AccountRp;
import com.zero.rua.reporttracking.model.GencodeCam;
import com.zero.rua.reporttracking.model.login;
import com.zero.rua.reporttracking.model.storeRp;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Dataservice {

    @POST("api/login")
    @FormUrlEncoded
    Call<login> postLogin(@Field("email") String email,
                          @Field("password") String password);

    @GET("/api/rpStore/{alias}")
    Call<storeRp> getRpStore(@Path("alias") String alias);

    @POST("/api/accountingStore/{alias}")
    @FormUrlEncoded
    Call<AccountRp> getRpAccount(@Path("alias") String alias,
                                 @Field("month") String month);

    @GET("/api/rp_gencode/rp_daily/{alias}")
    Call<GencodeCam> getRpStore_cam(@Path("alias") String alias);
}
