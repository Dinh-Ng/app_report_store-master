package com.zero.rua.reporttracking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zero.rua.reporttracking.Service.APIService;
import com.zero.rua.reporttracking.Service.BaseCallBack;
import com.zero.rua.reporttracking.model.login;
import com.zero.rua.reporttracking.model.storeRp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

public class Login extends AppCompatActivity {
    EditText edt_user, edt_pass;
    Button btn_login;
    Spinner spinner;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");
        setId();
        load_spinner();

        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setTitle("Login...");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        btn_login.setOnClickListener(v -> {
            String str_user = edt_user.getText().toString();
            String str_pass = edt_pass.getText().toString();

//            txt_status.setVisibility(View.INVISIBLE);
//            try {
//                postRequest(str_user, str_pass);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            txt_status.setVisibility(View.VISIBLE);

            progressDialog.show();

            int a = spinner.getSelectedItemPosition();

            switch (a) {
                case 0:
                    login_cam(str_user, str_pass);
                    break;
                case 1:
                    login(str_user, str_pass);
                    break;
            }


        });
    }

    public void load_spinner() {
        ArrayAdapter<String> adapter_category = new ArrayAdapter<>(Login.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.array_rp));
        adapter_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter_category);
    }

    public void login_cam(String user, String pass) {
        APIService.getService_cam().postLogin(user, pass).enqueue(new BaseCallBack<login>() {
            @Override
            public void onSuccess(login result) {
                progressDialog.dismiss();
                String s = new Gson().toJson(result);
                Log.d("check_success", "login_status: " + s);
                Intent intent = new Intent(Login.this, CamChartActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFail(String s) {
                progressDialog.dismiss();
                Log.e("check_fail", "camGame: " + s);
            }
        });
    }

    public void login(String user, String pass) {
        APIService.getService().postLogin(user, pass).enqueue(new BaseCallBack<login>() {
            @Override
            public void onSuccess(login result) {
                //Only log
                progressDialog.dismiss();
                String s = new Gson().toJson(result);
                Log.d("check_success", "login_status: " + s);

                Intent intent = new Intent(Login.this, Main2Activity.class);
                startActivity(intent);
            }

            @Override
            public void onFail(String s) {
                progressDialog.dismiss();
                Log.e("check_fail", "rpstore: " + s);
            }

            @Override
            public void onResponse(@NonNull retrofit2.Call<login> call, @NonNull retrofit2.Response<login> response) {
                super.onResponse(call, response);
                Log.d("check_response", response.toString());
            }
        });
    }

    public void setId() {
        edt_user = findViewById(R.id.edt_username);
        edt_pass = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        spinner = findViewById(R.id.spinner_country);
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
