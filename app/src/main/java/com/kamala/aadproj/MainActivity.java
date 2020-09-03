package com.kamala.aadproj;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout= findViewById(R.id.tabUp);
        viewPager = findViewById(R.id.myPager);


        ArrayList<String> marray = new ArrayList<>();

        marray.add("Top Hours");
        marray.add("Top Skill");


//        vp

        prepareViewPager(viewPager,marray);
    }

    private void prepareViewPager(ViewPager viewPager,ArrayList<String>marray) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());
    }

    private class MainAdapter  extends FragmentPagerAdapter {

        ArrayList<String> mArrayList= new ArrayList<>();
        List<Fragment> fragList  = new ArrayList<>();

        public void addFragment(Fragment frag,String title){
            mArrayList.add(title);
            fragList.add(frag);
        }

        public MainAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragList.get(position);
        }

        @Override
        public int getCount() {
            return fragList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mArrayList.get(position);
        }
    }
}