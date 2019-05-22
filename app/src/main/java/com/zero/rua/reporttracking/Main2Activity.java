package com.zero.rua.reporttracking;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zero.rua.reporttracking.Adapter.MainViewPaperAdapter;
import com.zero.rua.reporttracking.Fragment.Fragment_Accounting;
import com.zero.rua.reporttracking.Fragment.Fragment_Store;

public class Main2Activity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setId();
        init();
    }

    private void init() {
        MainViewPaperAdapter mainViewPaperAdapter = new
                MainViewPaperAdapter(getSupportFragmentManager());
        mainViewPaperAdapter.addFragment(new Fragment_Store(), getResources().getString(R.string.report_store));
        mainViewPaperAdapter.addFragment(new Fragment_Accounting(), getResources().getString(R.string.report_accounting));
        viewPager.setAdapter(mainViewPaperAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setId() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPaper);
    }
}
