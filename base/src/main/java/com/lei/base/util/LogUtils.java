package com.lei.base.util;

import android.util.Log;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/17
 * @contact email:907238552@qq.com
 */

public class LogUtils {
    public static String TAG = "LOG_TAG";

    public static void e(String... s) {
        String logContent = "";
        for (String str : s) {
            logContent += str + "\n";
        }
        Log.e(TAG, logContent);
    }
}
