package com.chinalwb.are.strategies;

import android.content.Context;
import android.text.style.URLSpan;

/**
 * Created by wliu on 30/06/2018.
 */

public interface AreClickStrategy {
    /**
     * Do your actions upon span clicking {@link android.text.style.URLSpan}
     *
     * @param context
     * @param urlSpan
     * @return handled return true; or else return false
     */
    boolean onClickUrl(Context context, URLSpan urlSpan);
}
