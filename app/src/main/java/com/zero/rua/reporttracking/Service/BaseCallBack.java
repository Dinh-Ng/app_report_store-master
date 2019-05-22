package com.zero.rua.reporttracking.Service;

import android.support.annotation.NonNull;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseCallBack <T> implements Callback<T> {
    @Override
    public void onResponse(@NonNull Call<T> call,@NonNull Response<T> response) {
        Log.e("tungts__", call.request().url().url().toString());
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            String s = "Have error occur";
            onFail(s);
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call,@NonNull Throwable t) {
        Log.e("tungts", "fail " + t.getLocalizedMessage());

        String s = "Have error occur";
        onFail(s);
    }

    public abstract void onSuccess(T result);

    public abstract void onFail(String s);
}