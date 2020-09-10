package com.kamala.aadproj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;
import com.kamala.aadproj.adapters.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Button mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwitch=findViewById(R.id.buttonFill);

        tabLayout= findViewById(R.id.tabUp);
        viewPager = findViewById(R.id.myPager);
        MyPagerAdapter adpt =new MyPagerAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adpt);

        tabLayout.setupWithViewPager(viewPager);


    }




    public void openForm(View view) {
        Intent i = new Intent(this,Form.class);
        startActivity(i);
    }



}