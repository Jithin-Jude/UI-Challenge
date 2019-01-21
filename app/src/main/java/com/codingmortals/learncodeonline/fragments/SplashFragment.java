package com.codingmortals.learncodeonline.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingmortals.learncodeonline.R;
import com.codingmortals.learncodeonline.utils.TypeWriterEffect;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment{

    TypeWriterEffect twe;
    public SplashFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    getFragmentManager().beginTransaction().replace(R.id.content,new WelcomeFragment(),"welcome").commit();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_splash, container, false);
        twe = v.findViewById(R.id.tv);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        twe.setText("");
        twe.setCharacterDelay(100);
        twe.animateText(getString(R.string.learncodeonline));
    }


}
