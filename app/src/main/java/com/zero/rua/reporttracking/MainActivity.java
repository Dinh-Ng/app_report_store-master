package com.zero.rua.reporttracking;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zero.rua.reporttracking.Service.APIService;
import com.zero.rua.reporttracking.Service.BaseCallBack;
import com.zero.rua.reporttracking.model.AccountRp;
import com.zero.rua.reporttracking.model.storeRp;

public class MainActivity extends AppCompatActivity {
    TextView txt_name_store, txt_install_total, txt_total_full3p, txt_full3p_month, txt_rev_month, txt_deposit;
    TextView txt_name_store_acc, txt_level, txt_total, txt_total_month, txt_rev, txt_time;
    Spinner spinner;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setId();
        load_spinner();
        getRpStore();
        getRpAccount("04-2019");
        btn_submit.setOnClickListener(v -> {
            String time = spinner.getSelectedItem().toString();
            getRpAccount(time);
        });
    }

    public void load_spinner() {
        ArrayAdapter<String> adapter_category = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.array_month));
        adapter_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter_category);
    }

    public void getRpAccount(String time) {
        APIService.getService().getRpAccount("appstore_mm_agen", time).enqueue(new BaseCallBack<AccountRp>() {
            @Override
            public void onSuccess(AccountRp result) {
                String s = new Gson().toJson(result);
                Log.d("check_get_acc_success", s);

                String data = result.getData().toString();
                Log.d("data_get", data);
                if (data.equals("[]")) {
                    Toast.makeText(MainActivity.this, "No data", Toast.LENGTH_SHORT).show();
                } else {
                    String name_store_acc = result.getData().get(0).getStoreName();
                    txt_name_store_acc.setText(name_store_acc);

                    String level = result.getData().get(0).getLevel().toString();
                    txt_level.setText(level);

                    String total = result.getData().get(0).getTotalPerFull().toString();
                    txt_total.setText(total);

                    String total_month = result.getData().get(0).getTotalPerFullOfMonth().toString();
                    txt_total_month.setText(total_month);

                    String rev = result.getData().get(0).getRevenue();
                    txt_rev.setText(rev);

                    String time = result.getData().get(0).getTime();
                    txt_time.setText(time);
                }


            }

            @Override
            public void onFail(String s) {
                Log.e("check_get_acc_fail", s);
            }
        });
    }

    public void getRpStore() {
        APIService.getService().getRpStore("appstore_mm_agen").enqueue(new BaseCallBack<storeRp>() {
            @Override
            public void onSuccess(storeRp result) {
                String s = new Gson().toJson(result);
                Log.d("check_get_success", "report_store: " + s);

                String name_store = result.getData().get(0).getStoreName();
                txt_name_store.setText(name_store);

                String install_total = result.getData().get(0).getTotalPerFull().toString();
                txt_install_total.setText(install_total);

                String install_month = result.getData().get(0).getTotalPerFullOfMonth().toString();
                txt_total_full3p.setText(install_month);

                String install_day = result.getData().get(0).getTotalPerFullOfDay().toString();
                txt_full3p_month.setText(install_day);

                String rev_month = result.getData().get(0).getRevenue();
                txt_rev_month.setText(rev_month);

                String deposit = result.getData().get(0).getDeposit();
                txt_deposit.setText(deposit);
            }

            @Override
            public void onFail(String s) {
                Log.e("check_get_fail", "rpstore: " + s);
            }
        });
    }

    public void setId() {
        txt_name_store = findViewById(R.id.txt_name_store);
        txt_install_total = findViewById(R.id.txt_install_total);
        txt_total_full3p = findViewById(R.id.txt_total_full3p);
        txt_full3p_month = findViewById(R.id.txt_full3p_month);
        txt_rev_month = findViewById(R.id.txt_rev_month);
        txt_deposit = findViewById(R.id.txt_deposit);

        spinner = findViewById(R.id.spinner_report_account);
        btn_submit = findViewById(R.id.btn_submit);

        txt_name_store_acc = findViewById(R.id.txt_name_store_acc);
        txt_level = findViewById(R.id.txt_level);
        txt_total = findViewById(R.id.txt_total);
        txt_total_month= findViewById(R.id.txt_total_month);
        txt_rev = findViewById(R.id.txt_rev);
        txt_time = findViewById(R.id.txt_time);
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
