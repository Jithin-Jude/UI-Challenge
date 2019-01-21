package com.codingmortals.learncodeonline.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.codingmortals.learncodeonline.fragments.SignInFragment;
import com.codingmortals.learncodeonline.fragments.SignUpFragment;

/**
 * Created by had on 20-01-2019.
 */

public class MyPageAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 2;

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show SignInFragment
                return SignInFragment.newInstance();
            case 1: // Fragment # 1 - This will show SignUpFragment
                return SignUpFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}