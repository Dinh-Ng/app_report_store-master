package com.zero.rua.reporttracking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.zero.rua.reporttracking.Service.APIService;
import com.zero.rua.reporttracking.Service.BaseCallBack;
import com.zero.rua.reporttracking.model.GencodeCam;

import java.util.ArrayList;
import java.util.List;

public class CamChartActivity extends AppCompatActivity {
    private LineChart chart;

    Switch switch1, switch2, switch3, switch4, switch5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_chart);

        chart = findViewById(R.id.chart_cam);
        switch1 = findViewById(R.id.switch_1);
        switch2 = findViewById(R.id.switch_2);
        switch3 = findViewById(R.id.switch_3);
        switch4 = findViewById(R.id.switch_4);
        switch5 = findViewById(R.id.switch_5);


        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });

        chart.setTouchEnabled(true);

        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);
        chart.setDrawBorders(false);

        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setDrawAxisLine(false);
        chart.getAxisRight().setDrawGridLines(false);
//        chart.getXAxis().setDrawAxisLine(false);
//        chart.getXAxis().setDrawGridLines(false);

        XAxis xAxis;
        {   // // X-Axis Style // //
            xAxis = chart.getXAxis();

            // vertical grid lines
            xAxis.enableGridDashedLine(10f, 10f, 0f);
        }

//        YAxis yAxis;
//        {   // // Y-Axis Style // //
//            yAxis = chart.getAxisLeft();
//
//            // disable dual axis (only use LEFT axis)
//            chart.getAxisRight().setEnabled(false);
//
//            // horizontal grid lines
//            yAxis.enableGridDashedLine(10f, 10f, 0f);
//
//            // axis range
//            yAxis.setAxisMaximum(200f);
//            yAxis.setAxisMinimum(-50f);
//        }

        xAxis.setDrawLimitLinesBehindData(true);
//        yAxis.setDrawLimitLinesBehindData(true);


        // enable touch gestures
        chart.setTouchEnabled(true);

        // enable scaling and dragging
        chart.setDragEnabled(true);
        chart.setScaleEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        chart.setPinchZoom(false);
        chart.animateX(2000);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        getData();
    }

    private final int[] colors = new int[]{
            ColorTemplate.VORDIPLOM_COLORS[0],
            ColorTemplate.VORDIPLOM_COLORS[1],
            ColorTemplate.VORDIPLOM_COLORS[2],
            ColorTemplate.VORDIPLOM_COLORS[3],
            ColorTemplate.VORDIPLOM_COLORS[4]
    };

    public void getData() {
        APIService.getService_cam().getRpStore_cam("gencode_cam").enqueue(new BaseCallBack<GencodeCam>() {
            @Override
            public void onSuccess(GencodeCam result) {
//                List<String> list_date = result.getXValue();


                int g = result.getYValue().size();

                Log.d("array_new_code", g + "");

                ArrayList<Boolean> check = new ArrayList<>();
                boolean check1 = switch1.isChecked();
                boolean check2 = switch2.isChecked();
                boolean check3 = switch3.isChecked();
                boolean check4 = switch4.isChecked();
                boolean check5 = switch5.isChecked();

                check.add(check1);
                check.add(check2);
                check.add(check3);
                check.add(check4);
                check.add(check5);

//                String s = result.getYValue().get(1).getName();
//                int a = array_new_code.get(1);
//
//                ArrayList<Entry> list_new_code = new ArrayList<>();
//
//                Log.d("array_new_code", array_new_code.toString() +"");
//                for (int i = 0; i < list_date.size(); i++) {
////                    int h = Integer.parseInt(list_date.get(i));
//                    list_new_code.add(new Entry(i, array_new_code.get(i)));
//                }
//
//                Log.d("count_list", list_new_code.size() + "");
//
//                LineDataSet d1 = new LineDataSet(list_new_code, "New DataSet ");
//                d1.setLineWidth(2.5f);
//                d1.setCircleRadius(4.5f);
//                d1.setHighLightColor(Color.rgb(244, 117, 117));
//                d1.setDrawValues(false);
//
//
//                sets.add(d1);
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();

                for (int i = 0; i < g; i++) {
                    ArrayList<Entry> values = new ArrayList<>();

                    List<Integer> array_new_code = result.getYValue().get(i).getData();

                    for (int j = 0; j < array_new_code.size(); j++) { //j < 7
//                    int h = Integer.parseInt(list_date.get(i));
                        values.add(new Entry(j + 1, array_new_code.get(j)));
                    }


                    String str_name = result.getYValue().get(i).getName();

                    LineDataSet d = new LineDataSet(values, "" + str_name);
                    d.setLineWidth(2.5f);
                    d.setCircleRadius(4f);

                    int color = colors[i % colors.length];
                    d.setColor(color);
                    d.setCircleColor(color);

                    if (check.get(i)) {
                        dataSets.add(d);
                    }

                }

//                ((LineDataSet) dataSets.get(0)).enableDashedLine(10, 10, 0);
//                ((LineDataSet) dataSets.get(0)).setColors(ColorTemplate.VORDIPLOM_COLORS);
//                ((LineDataSet) dataSets.get(0)).setCircleColors(ColorTemplate.VORDIPLOM_COLORS);

                LineData data = new LineData(dataSets);
                chart.setData(data);
                chart.invalidate();
            }

            @Override
            public void onFail(String s) {

            }
        });
    }

    public void onClick_Switch(View view) {
        getData();
    }
}
