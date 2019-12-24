package com.chinalwb.are;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * All Rights Reserved.
 *
 * @author Wenbin Liu
 */
public class Util {

    /**
     * @param s
     */
    public static void log(String s) {
        Log.d("CAKE", s);
    }

    /**
     * Returns the line number of current cursor.
     *
     * @param editText
     * @return
     */
    public static int getCurrentCursorLine(EditText editText) {
        int selectionStart = Selection.getSelectionStart(editText.getText());
        Layout layout = editText.getLayout();

        if (null == layout) {
            return -1;
        }
        if (selectionStart != -1) {
            return layout.getLineForOffset(selectionStart);
        }

        return -1;
    }

    /**
     * Returns the line start position of the current line (which cursor is focusing now).
     *
     * @param editText
     * @return
     */
    public static int getThisLineStart(EditText editText, int currentLine) {
        Layout layout = editText.getLayout();
        int start = 0;
        if (currentLine > 0) {
            start = layout.getLineStart(currentLine);
            if (start > 0) {
                String text = editText.getText().toString();
                char lastChar = text.charAt(start - 1);
                while (lastChar != '\n') {
                    if (currentLine > 0) {
                        currentLine--;
                        start = layout.getLineStart(currentLine);
                        if (start > 1) {
                            start--;
                            lastChar = text.charAt(start);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return start;
    }

    /**
     * Returns the line end position of the current line (which cursor is focusing now).
     *
     * @param editText
     * @return
     */
    public static int getThisLineEnd(EditText editText, int currentLine) {
        Layout layout = editText.getLayout();
        if (-1 != currentLine) {
            return layout.getLineEnd(currentLine);
        }
        return -1;
    }

    /**
     * Gets the pixels by the given number of dp.
     *
     * @param context
     * @param dp
     * @return
     */
    public static int getPixelByDp(Context context, int dp) {
        int pixels = dp;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        pixels = (int) (displayMetrics.density * dp + 0.5);
        return pixels;
    }

    /**
     * Returns the screen width and height.
     *
     * @param context
     * @return
     */
    public static int[] getScreenWidthAndHeight(Context context) {
        Point outSize = new Point();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        display.getSize(outSize);

        int[] widthAndHeight = new int[2];
        widthAndHeight[0] = outSize.x;
        widthAndHeight[1] = outSize.y;
        return widthAndHeight;
    }

    public static Bitmap scaleBitmapToFitWidth(Bitmap bitmap, int maxWidth) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int newWidth = maxWidth;
        int newHeight = maxWidth * h / w;
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) newWidth / w);
        float scaleHeight = ((float) newHeight / h);
        if (w < maxWidth * 0.2) {
            return bitmap;
        }
        matrix.postScale(scaleWidth, scaleHeight);
        return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
    }
}
