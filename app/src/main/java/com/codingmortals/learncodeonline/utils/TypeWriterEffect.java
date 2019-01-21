package com.codingmortals.learncodeonline.utils;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

/**
 * Created by had on 20-01-2019.
 */

public class TypeWriterEffect extends android.support.v7.widget.AppCompatTextView {
    private CharSequence mText;
    private int mIndex;
    private long mDelay = 150; // in ms
    private Handler mHandler = new Handler();
    public TypeWriterEffect(Context context) {
        super(context);
    }

    public TypeWriterEffect(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void animateText(CharSequence txt) {
        mText = txt;
        mIndex = 0;
        setText("");
        mHandler.removeCallbacks(characterAdder);
        mHandler.postDelayed(characterAdder, mDelay);

    }

    public void setCharacterDelay(long m) {
        mDelay = m;
    }

    private Runnable characterAdder = new Runnable() {
        @Override
        public void run() {
            setText(mText.subSequence(0, mIndex++));
            if (mIndex<=mText.length())
                mHandler.postDelayed(characterAdder,mDelay);

        }
    };
}
