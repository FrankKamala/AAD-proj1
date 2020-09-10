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
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


        ArrayList<String> marray = new ArrayList<>();

        marray.add("Top Hours");
        marray.add("Top Skill");


//        vp

        prepareViewPager(viewPager,marray);

        tabLayout.setupWithViewPager(viewPager);
    }


    private void prepareViewPager(ViewPager viewPager,ArrayList<String>marray) {
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager());

        AFragment fragment = new AFragment();
        for (int i=0;i<marray.size();i++){
            Bundle b =new Bundle();
            b.putString("title",marray.get(i));
            fragment.setArguments(b);


            adapter.addFragment(fragment,marray.get(i));
            fragment=new AFragment();
        }
        viewPager.setAdapter(adapter);
    }

    public void openForm(View view) {
        Intent i = new Intent(this,Form.class);
        startActivity(i);
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