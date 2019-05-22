package com.zero.rua.reporttracking.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zero.rua.reporttracking.Adapter.StoreAdapter;
import com.zero.rua.reporttracking.R;
import com.zero.rua.reporttracking.Service.APIService;
import com.zero.rua.reporttracking.Service.BaseCallBack;
import com.zero.rua.reporttracking.chart.StoreChartActivity;
import com.zero.rua.reporttracking.model.storeRp;
import com.zero.rua.reporttracking.model.storeRp_data;

import java.util.List;

public class Fragment_Store extends Fragment {
    StoreAdapter storeAdapter;
    ListView listView;
    TextView txt;

//    TextView txt_name_store, txt_install_total, txt_total_full3p, txt_full3p_month, txt_rev_month, txt_deposit;

    public Fragment_Store() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        txt_name_store = view.findViewById(R.id.txt_name_store);
//        txt_install_total = view.findViewById(R.id.txt_install_total);
//        txt_total_full3p = view.findViewById(R.id.txt_total_full3p);
//        txt_full3p_month = view.findViewById(R.id.txt_full3p_month);
//        txt_rev_month = view.findViewById(R.id.txt_rev_month);
//        txt_deposit = view.findViewById(R.id.txt_deposit);

        txt = view.findViewById(R.id.txt_frag_store_chart);
        txt.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), StoreChartActivity.class);
            startActivity(intent);
        });

        listView = view.findViewById(R.id.listView_store);

        getRpStore();
    }

    @SuppressLint("InflateParams")
    public void getRpStore() {
        APIService.getService().getRpStore("appstore_mm_agen").enqueue(new BaseCallBack<storeRp>() {
            @Override
            public void onSuccess(storeRp result) {
                String s = new Gson().toJson(result);
                Log.d("check_get_success", "report_store: " + s);

                List<storeRp_data> storeRps = result.getData();
                storeAdapter = new StoreAdapter(getActivity(), storeRps);
                listView.setAdapter(storeAdapter);

                listView.setOnItemClickListener((parent, view, position, id) -> {

                    String name_store = storeRps.get(position).getStoreName();
                    String install_total = storeRps.get(position).getInstallTotal().toString();
                    String month = storeRps.get(position).getInstallofMonth().toString();
                    String install_shan_total = storeRps.get(position).getInstallShan().toString();
                    String total_full3p = storeRps.get(position).getTotalPerFull().toString();
                    String full3p_month = storeRps.get(position).getTotalPerFullOfMonth().toString();
                    String day = storeRps.get(position).getTotalPerFullOfDay().toString();
                    String install_shan_day = storeRps.get(position).getInstallShanOfDay().toString();
                    String install_shan_month = storeRps.get(position).getInstallShanMM().toString();
                    String rev = storeRps.get(position).getRevenue();
                    String deposit = storeRps.get(position).getDeposit();
                    String adress = storeRps.get(position).getAdress();
                    String phone = storeRps.get(position).getPhoneNumber();

                    View view1 = getLayoutInflater().inflate(R.layout.dialog_info, null);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

                    TextView txt_name_store = view1.findViewById(R.id.txt_dialog_name_store);
                    TextView txt_dialog_install_total = view1.findViewById(R.id.txt_dialog_install_total);
                    TextView txt_dialog_month = view1.findViewById(R.id.txt_dialog_month);
                    TextView txt_dialog_install_shan_total = view1.findViewById(R.id.txt_dialog_install_shan_total);
                    TextView txt_dialog_total_full3p = view1.findViewById(R.id.txt_dialog_total_full3p);
                    TextView txt_dialog_full3p_month = view1.findViewById(R.id.txt_dialog_full3p_month);
                    TextView txt_dialog_day = view1.findViewById(R.id.txt_dialog_day);
                    TextView txt_dialog_install_shan_day = view1.findViewById(R.id.txt_dialog_install_shan_day);
                    TextView txt_dialog_install_shan_month = view1.findViewById(R.id.txt_dialog_install_shan_month);
                    TextView txt_dialog_rev = view1.findViewById(R.id.txt_dialog_rev);
                    TextView txt_dialog_deposit = view1.findViewById(R.id.txt_dialog_deposit);
                    TextView txt_dialog_adress = view1.findViewById(R.id.txt_dialog_adress);
                    TextView txt_dialog_phone = view1.findViewById(R.id.txt_dialog_phone);

                    txt_name_store.setText(name_store);
                    txt_dialog_install_total.setText(install_total);
                    txt_dialog_month.setText(month);
                    txt_dialog_install_shan_total.setText(install_shan_total);
                    txt_dialog_total_full3p.setText(total_full3p);
                    txt_dialog_full3p_month.setText(full3p_month);
                    txt_dialog_day.setText(day);
                    txt_dialog_install_shan_day.setText(install_shan_day);
                    txt_dialog_install_shan_month.setText(install_shan_month);
                    txt_dialog_rev.setText(rev);
                    txt_dialog_deposit.setText(deposit);
                    txt_dialog_adress.setText(adress);
                    txt_dialog_phone.setText(phone);

                    builder.setNegativeButton("Close", (dialog, which) -> dialog.dismiss())
                            .setView(view1);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                });

//                String name_store = result.getData().get(0).getStoreName();
//                txt_name_store.setText(name_store);
//
//                String install_total = result.getData().get(0).getInstallTotal().toString();
//                txt_install_total.setText(install_total);
//
//                String total_full3p = result.getData().get(0).getTotalPerFull().toString();
//                txt_total_full3p.setText(total_full3p);
//
//                String full3p_month = result.getData().get(0).getTotalPerFullOfMonth().toString();
//                txt_full3p_month.setText(full3p_month);
//
//                String rev_month = result.getData().get(0).getRevenue();
//                txt_rev_month.setText(rev_month);
//
//                String deposit = result.getData().get(0).getDeposit();
//                txt_deposit.setText(deposit);
            }

            @Override
            public void onFail(String s) {
                Log.e("check_get_fail", "rpstore: " + s);
            }
        });
    }
}
