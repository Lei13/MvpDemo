package com.lei.base.util;

import android.widget.Toast;

import com.lei.base.BaseApplication;

/**
 * @author LeiYan
 * @describe
 * @date 2017/11/15
 * @contact email:907238552@qq.com
 */

public class ToastUtils {
    private static Toast sToast;

    static {
        sToast = Toast.makeText(BaseApplication.getApplication(), "", Toast.LENGTH_SHORT);
    }

    public static void show(String s) {
        sToast.setText(s);
        sToast.show();
    }

    public static void show(int resId) {
        sToast.setText(resId);
        sToast.show();
    }


}
