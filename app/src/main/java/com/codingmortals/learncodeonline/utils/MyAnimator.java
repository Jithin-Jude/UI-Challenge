package com.codingmortals.learncodeonline.utils;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by had on 21-01-2019.
 */

public class MyAnimator {

    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int BOTTOM= 3;

    public static void Animate(ArrayList<View> arrayList, int direction) {
        int i=0;
        for (View view:arrayList) {
            switch (direction) {
                case LEFT:
                view.setTranslationX(-1000);
                view.animate().translationX(0).setDuration(200).setStartDelay(i * 100);
                break;
                case RIGHT:
                    view.setTranslationX(1000);
                    view.animate().translationX(0).setDuration(200).setStartDelay(i * 100);
                    break;
                case BOTTOM:
                    view.setTranslationY(1000);
                    view.animate().translationY(0).setDuration(250).setStartDelay(i * 100);
                    break;
                case UP:
                    view.setTranslationY(-1000);
                    view.animate().translationY(0).setDuration(250).setStartDelay(i * 100);
                    break;

            }
            i+=2;
        }
    }
}
