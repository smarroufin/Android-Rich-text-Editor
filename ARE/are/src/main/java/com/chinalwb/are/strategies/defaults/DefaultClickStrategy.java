package com.chinalwb.are.strategies.defaults;

import android.content.Context;
import android.text.style.URLSpan;

import com.chinalwb.are.strategies.AreClickStrategy;

/**
 * Created by wliu on 30/06/2018.
 */

public class DefaultClickStrategy implements AreClickStrategy {
    @Override
    public boolean onClickUrl(Context context, URLSpan urlSpan) {
        // Use default behavior
        return false;
    }
}
