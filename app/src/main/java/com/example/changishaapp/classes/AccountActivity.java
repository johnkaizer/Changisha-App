package com.example.changishaapp.classes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.changishaapp.Adapter.ViewPagerAdapter;
import com.example.changishaapp.R;
import com.example.changishaapp.fragment1;
import com.example.changishaapp.fragment2;
import com.example.changishaapp.fragment3;
import com.google.android.material.tabs.TabLayout;

public class AccountActivity extends AppCompatActivity {
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        viewPager = findViewById(R.id.View_pager1);
        tabLayout = findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.add(new fragment1(), "DONATION");
        viewPagerAdapter.add(new fragment2(), "HISTORY");
        viewPagerAdapter.add(new fragment3(), "SETTINGS");
        viewPager.setAdapter(viewPagerAdapter);
    }
}