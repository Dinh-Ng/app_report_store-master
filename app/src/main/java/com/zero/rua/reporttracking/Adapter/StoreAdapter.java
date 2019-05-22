package com.zero.rua.reporttracking.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zero.rua.reporttracking.R;
import com.zero.rua.reporttracking.model.storeRp_data;

import java.util.List;

public class StoreAdapter extends BaseAdapter {

    private Context context;
    private List<storeRp_data> array_store;
    private LayoutInflater layoutInflater;

    public StoreAdapter(Context context, List<storeRp_data> array_store) {
        this.context = context;
        this.array_store = array_store;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return array_store.size();
    }

    @Override
    public Object getItem(int position) {
        return array_store.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_store, null);
            holder = new ViewHolder();
            holder.txt_name_store = view.findViewById(R.id.txt_name_store);
            holder.txt_install_total = view.findViewById(R.id.txt_install_total);
            holder.txt_total_full3p = view.findViewById(R.id.txt_total_full3p);
            holder.txt_full3p_month = view.findViewById(R.id.txt_full3p_month);
            holder.txt_rev_month = view.findViewById(R.id.txt_rev_month);
            holder.txt_deposit = view.findViewById(R.id.txt_deposit);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        storeRp_data storeRp = array_store.get(position);

        holder.txt_name_store.setText(storeRp.getStoreName());

        String install_total = storeRp.getInstallTotal().toString();
        holder.txt_install_total.setText(install_total);

        String total_full3p = storeRp.getTotalPerFull().toString();
        holder.txt_total_full3p.setText(total_full3p);

        String full3p_month = storeRp.getTotalPerFullOfMonth().toString();
        holder.txt_full3p_month.setText(full3p_month);
        holder.txt_rev_month.setText(storeRp.getRevenue());
        holder.txt_deposit.setText(storeRp.getDeposit());
        return view;
    }
    private static class ViewHolder {

        TextView txt_name_store, txt_install_total, txt_total_full3p, txt_full3p_month, txt_rev_month, txt_deposit;
    }
}
