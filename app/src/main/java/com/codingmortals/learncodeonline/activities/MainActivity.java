package com.codingmortals.learncodeonline.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.codingmortals.learncodeonline.adapters.MyPageAdapter;
import com.codingmortals.learncodeonline.R;
public class MainActivity extends AppCompatActivity {
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // get initial Fragment
        final int iniFrag = getIntent().getIntExtra(getString(R.string.SETINITFRAGMENT), 0);

        //set up viewpager
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(iniFrag);
    }

}
