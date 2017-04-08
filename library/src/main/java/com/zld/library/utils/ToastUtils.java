package com.zld.library.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lingdong on 2017/4/8.
 */

public class ToastUtils {

    public static void shortToast(Context context, String text) {
        if (context == null || text == null) return;
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(Context context, String text){
        if (context == null || text == null) return;
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
