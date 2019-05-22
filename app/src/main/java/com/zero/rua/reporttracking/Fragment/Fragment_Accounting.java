package com.zero.rua.reporttracking.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zero.rua.reporttracking.MainActivity;
import com.zero.rua.reporttracking.R;
import com.zero.rua.reporttracking.Service.APIService;
import com.zero.rua.reporttracking.Service.BaseCallBack;
import com.zero.rua.reporttracking.model.AccountRp;

public class Fragment_Accounting extends Fragment {

    TextView txt_name_store_acc, txt_level, txt_total, txt_total_month, txt_rev, txt_time;
    Spinner spinner;
    Button btn_submit;

    public Fragment_Accounting() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinner = view.findViewById(R.id.spinner_report_account);
        btn_submit = view.findViewById(R.id.btn_submit);

        txt_name_store_acc = view.findViewById(R.id.txt_name_store_acc);
        txt_level = view.findViewById(R.id.txt_level);
        txt_total = view.findViewById(R.id.txt_total);
        txt_total_month= view.findViewById(R.id.txt_total_month);
        txt_rev = view.findViewById(R.id.txt_rev);
        txt_time = view.findViewById(R.id.txt_time);

        load_spinner();
        getRpAccount("04-2019");

        btn_submit.setOnClickListener(v -> {
            String time = spinner.getSelectedItem().toString();
            getRpAccount(time);
        });
    }

    public void load_spinner() {
        ArrayAdapter<String> adapter_category = new ArrayAdapter<>(getActivity(),
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
                    Toast.makeText(getActivity(), "No data", Toast.LENGTH_SHORT).show();
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
}
