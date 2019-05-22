package com.zero.rua.reporttracking.chart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.zero.rua.reporttracking.R;
import com.zero.rua.reporttracking.Service.APIService;
import com.zero.rua.reporttracking.Service.BaseCallBack;
import com.zero.rua.reporttracking.model.storeRp;
import com.zero.rua.reporttracking.model.storeRp_data;

import java.util.ArrayList;
import java.util.List;

public class StoreChartActivity extends AppCompatActivity {
    List<storeRp_data> list_storeRp_data;

    PieChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_chart);

        mChart = findViewById(R.id.chart_pie_store);


        mChart.setRotationEnabled(true);
        mChart.setDescription(new Description());
        mChart.setHoleRadius(35f);
        mChart.setTransparentCircleAlpha(0);
        mChart.setCenterText("PieChart");
        mChart.setCenterTextSize(20);
        mChart.setDrawEntryLabels(true);
        mChart.animateY(2000);

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        getRpStore(mChart);

    }


    public void getRpStore(PieChart pieChart) {
        APIService.getService().getRpStore("appstore_mm_agen").enqueue(new BaseCallBack<storeRp>() {
            @Override
            public void onSuccess(storeRp result) {
                list_storeRp_data = result.getData();

                ArrayList<PieEntry> yEntry = new ArrayList<>();

                for (int i = 0; i < 5; i++) {
                    int s = list_storeRp_data.get(i).getInstallTotal();
                    yEntry.add(new PieEntry(s, i));
                }

                PieDataSet pieDataSet = new PieDataSet(yEntry, "Install Total");

                ArrayList<Integer> colors = new ArrayList<>();

                for (int c : ColorTemplate.VORDIPLOM_COLORS)
                    colors.add(c);

                for (int c : ColorTemplate.JOYFUL_COLORS)
                    colors.add(c);

                for (int c : ColorTemplate.COLORFUL_COLORS)
                    colors.add(c);

                for (int c : ColorTemplate.LIBERTY_COLORS)
                    colors.add(c);

                for (int c : ColorTemplate.PASTEL_COLORS)
                    colors.add(c);

                pieDataSet.setColors(colors);

                PieData data = new PieData(pieDataSet);
                data.setValueFormatter(new PercentFormatter(pieChart));
                data.setValueTextSize(11f);
                data.setValueTextColor(Color.WHITE);
                pieChart.setData(data);
            }

            @Override
            public void onFail(String s) {

            }
        });
    }
}
