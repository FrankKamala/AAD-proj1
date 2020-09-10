package com.kamala.aadproj.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kamala.aadproj.AFragment;
import com.kamala.aadproj.FragmentSkill;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public MyPagerAdapter(@NonNull Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new AFragment();
        } else
            return new FragmentSkill();

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {

            return "Hours Leaders";
        } else

        return "Skill Leaders";
    }
}
